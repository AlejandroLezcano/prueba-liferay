/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.taglib.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.LogUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.servlet.DirectRequestDispatcherFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.TagDynamicIdFactory;
import com.liferay.portal.kernel.servlet.taglib.TagDynamicIdFactoryRegistry;
import com.liferay.portal.kernel.servlet.taglib.TagDynamicIncludeUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CustomJspRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.FileAvailabilityUtil;
import com.liferay.taglib.servlet.PipingServletResponse;

import java.io.IOException;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 * @author Eduardo Lundgren
 * @author Raymond Augé
 */
public class IncludeTag extends AttributesTagSupport {

	@Override
	public int doEndTag() throws JspException {
		try {
			String page = getPage();

			if (Validator.isNull(page)) {
				page = getEndPage();
			}

			callSetAttributes();

			if (themeResourceExists(page)) {
				doIncludeTheme(page);

				return EVAL_PAGE;
			}

			if (!FileAvailabilityUtil.isAvailable(servletContext, page)) {
				logUnavailablePage(page);

				return processEndTag();
			}

			doInclude(page, false);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
		finally {
			doClearTag();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			String page = getStartPage();

			callSetAttributes();

			if (themeResourceExists(page)) {
				doIncludeTheme(page);

				return EVAL_BODY_INCLUDE;
			}

			if (!FileAvailabilityUtil.isAvailable(servletContext, page)) {
				logUnavailablePage(page);

				return processStartTag();
			}

			doInclude(page, true);

			return EVAL_BODY_INCLUDE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
	}

	public void runTag() throws JspException {
		doStartTag();
		doEndTag();
	}

	public void setPage(String page) {
		_page = page;
	}

	public void setPortletId(String portletId) {
		if (Validator.isNotNull(portletId)) {
			String rootPortletId = PortletIdCodec.decodePortletName(portletId);

			PortletBag portletBag = PortletBagPool.get(rootPortletId);

			servletContext = portletBag.getServletContext();
		}
	}

	public void setStrict(boolean strict) {
		_strict = strict;
	}

	public void setUseCustomPage(boolean useCustomPage) {
		_useCustomPage = useCustomPage;
	}

	protected void callSetAttributes() {
		HttpServletRequest httpServletRequest = getOriginalServletRequest();

		if (isCleanUpSetAttributes()) {
			if (_setAttributeNames == null) {
				_setAttributeNames = new HashSet<>();
			}
			else {
				_setAttributeNames.clear();
			}

			_trackedRequest = new TrackedServletRequest(
				httpServletRequest, _setAttributeNames);

			httpServletRequest = _trackedRequest;
		}

		Class<? extends IncludeTag> clazz = getClass();

		httpServletRequest.setAttribute(clazz.getName(), this);

		setNamespacedAttribute(
			httpServletRequest, "bodyContent", getBodyContentWrapper());
		setNamespacedAttribute(
			httpServletRequest, "dynamicAttributes", getDynamicAttributes());

		setAttributes(httpServletRequest);
	}

	protected void cleanUp() {
	}

	protected void cleanUpSetAttributes() {
		if (isCleanUpSetAttributes()) {
			for (String name : _setAttributeNames) {
				_trackedRequest.removeAttribute(name);
			}

			_setAttributeNames.clear();

			_trackedRequest = null;
		}
	}

	protected void doClearTag() {
		clearDynamicAttributes();
		clearParams();
		clearProperties();

		cleanUpSetAttributes();

		if (!ServerDetector.isResin()) {
			setPage(null);
			setUseCustomPage(true);

			cleanUp();
		}
	}

	protected void doInclude(
			String page, boolean dynamicIncludeAscendingPriority)
		throws JspException {

		try {
			include(page, dynamicIncludeAscendingPriority);
		}
		catch (Exception e) {
			String currentURL = (String)request.getAttribute(
				WebKeys.CURRENT_URL);

			String message = StringBundler.concat(
				"Current URL ", currentURL, " generates exception: ",
				e.getMessage());

			LogUtil.log(_log, e, message);

			if (e instanceof JspException) {
				throw (JspException)e;
			}
		}
	}

	protected void doIncludeTheme(String page) throws Exception {
		HttpServletResponse httpServletResponse =
			(HttpServletResponse)pageContext.getResponse();

		Theme theme = (Theme)request.getAttribute(WebKeys.THEME);

		ThemeUtil.include(
			servletContext, request, httpServletResponse, page, theme);
	}

	protected Object getBodyContentWrapper() {
		final BodyContent bodyContent = getBodyContent();

		if (bodyContent == null) {
			return null;
		}

		return new Object() {

			@Override
			public String toString() {
				return bodyContent.getString();
			}

		};
	}

	protected String getCustomPage(
		ServletContext servletContext, HttpServletRequest httpServletRequest,
		String page) {

		if (Validator.isNull(page)) {
			return null;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (themeDisplay == null) {
			return null;
		}

		Group group = themeDisplay.getScopeGroup();

		if (group.isStagingGroup() && !group.isStagedRemotely()) {
			group = group.getLiveGroup();
		}

		UnicodeProperties typeSettingsProperties =
			group.getTypeSettingsProperties();

		String customJspServletContextName = typeSettingsProperties.getProperty(
			"customJspServletContextName");

		if (Validator.isNull(customJspServletContextName)) {
			return null;
		}

		if (customJspServletContextName.contains("/../")) {
			_log.error(
				"Illegal directory traversal in " +
					customJspServletContextName);

			return null;
		}

		String customPage = CustomJspRegistryUtil.getCustomJspFileName(
			customJspServletContextName, page);

		if (FileAvailabilityUtil.isAvailable(servletContext, customPage)) {
			return customPage;
		}

		return null;
	}

	protected String getEndPage() {
		return null;
	}

	protected HttpServletRequest getOriginalServletRequest() {
		return (HttpServletRequest)pageContext.getRequest();
	}

	protected String getPage() {
		return _page;
	}

	protected String getStartPage() {
		return null;
	}

	protected void include(String page, boolean doStartTag) throws Exception {
		HttpServletResponse httpServletResponse = null;

		Class<?> clazz = getClass();

		String tagClassName = clazz.getName();

		String tagDynamicId = null;

		String tagPointPrefix = null;

		if (doStartTag) {
			tagPointPrefix = "doStartTag#";
		}
		else {
			tagPointPrefix = "doEndTag#";
		}

		TagDynamicIdFactory tagDynamicIdFactory =
			TagDynamicIdFactoryRegistry.getTagDynamicIdFactory(tagClassName);

		if (tagDynamicIdFactory != null) {
			httpServletResponse =
				PipingServletResponse.createPipingServletResponse(pageContext);

			tagDynamicId = tagDynamicIdFactory.getTagDynamicId(
				request, httpServletResponse, this);

			TagDynamicIncludeUtil.include(
				request, httpServletResponse, tagClassName, tagDynamicId,
				tagPointPrefix + "before", doStartTag);
		}

		if (_useCustomPage) {
			String customPage = getCustomPage(servletContext, request, page);

			if (Validator.isNotNull(customPage)) {
				page = customPage;
			}
		}

		if (_THEME_JSP_OVERRIDE_ENABLED) {
			request.setAttribute(
				WebKeys.SERVLET_CONTEXT_INCLUDE_FILTER_STRICT, _strict);
		}

		includePage(
			page,
			PipingServletResponse.createPipingServletResponse(pageContext));

		if (_THEME_JSP_OVERRIDE_ENABLED) {
			request.removeAttribute(
				WebKeys.SERVLET_CONTEXT_INCLUDE_FILTER_STRICT);
		}

		if (tagDynamicIdFactory != null) {
			TagDynamicIncludeUtil.include(
				request, httpServletResponse, tagClassName, tagDynamicId,
				tagPointPrefix + "after", doStartTag);
		}
	}

	protected void includePage(
			String page, HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		RequestDispatcher requestDispatcher =
			DirectRequestDispatcherFactoryUtil.getRequestDispatcher(
				servletContext, page);

		requestDispatcher.include(request, httpServletResponse);
	}

	protected boolean isCleanUpSetAttributes() {
		return _CLEAN_UP_SET_ATTRIBUTES;
	}

	protected boolean isPortalPage(String page) {
		if (page.startsWith("/html/taglib/") &&
			(page.endsWith("/end.jsp") || page.endsWith("/page.jsp") ||
			 page.endsWith("/start.jsp"))) {

			return true;
		}

		return false;
	}

	protected boolean isUseCustomPage() {
		return _useCustomPage;
	}

	protected void logUnavailablePage(String page) {
		if ((page == null) || !_log.isDebugEnabled()) {
			return;
		}

		StringBundler sb = new StringBundler(8);

		sb.append("Unable to find ");
		sb.append(page);
		sb.append(" in the context ");

		String contextPath = PortalUtil.getPathContext(
			servletContext.getContextPath());

		if (contextPath.equals(StringPool.BLANK)) {
			contextPath = StringPool.SLASH;
		}

		sb.append(contextPath);

		sb.append(".");

		boolean portalContext = false;

		String portalContextPath = PortalUtil.getPathContext();

		if (portalContextPath.equals(StringPool.BLANK)) {
			portalContextPath = StringPool.SLASH;
		}

		if (contextPath.equals(portalContextPath)) {
			portalContext = true;
		}

		if (isPortalPage(page)) {
			if (portalContext) {
				return;
			}

			sb.append(" You must not use a taglib from a module and set the ");
			sb.append("attribute \"servletContext\". Inline the content ");
			sb.append("directly where the taglib is invoked.");
		}
		else if (portalContext) {
			Class<?> clazz = getClass();

			if (clazz.equals(IncludeTag.class)) {
				sb.append(" You must set the attribute \"servletContext\" ");
				sb.append("with the value \"<%= application %>\" when ");
				sb.append("invoking a taglib from a module.");
			}
			else {
				sb.append(" You must not use a taglib from a module and set ");
				sb.append("the attribute \"file\". Inline the content ");
				sb.append("directly where the taglib is invoked.");
			}
		}

		_log.debug(sb.toString());
	}

	protected int processEndTag() throws Exception {
		return EVAL_PAGE;
	}

	protected int processStartTag() throws Exception {
		return EVAL_BODY_INCLUDE;
	}

	protected void setAttributes(HttpServletRequest httpServletRequest) {
	}

	protected boolean themeResourceExists(String page) throws Exception {
		if ((page == null) || !_THEME_JSP_OVERRIDE_ENABLED || _strict) {
			return false;
		}

		Theme theme = (Theme)request.getAttribute(WebKeys.THEME);

		if (theme == null) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			if (themeDisplay != null) {
				theme = themeDisplay.getTheme();
			}
		}

		if (theme == null) {
			return false;
		}

		String portletId = ThemeUtil.getPortletId(request);

		boolean exists = theme.resourceExists(servletContext, portletId, page);

		if (_log.isDebugEnabled() && exists) {
			String resourcePath = theme.getResourcePath(
				servletContext, null, page);

			_log.debug(resourcePath);
		}

		return exists;
	}

	private static final boolean _CLEAN_UP_SET_ATTRIBUTES = false;

	private static final boolean _THEME_JSP_OVERRIDE_ENABLED =
		GetterUtil.getBoolean(
			PropsUtil.get(PropsKeys.THEME_JSP_OVERRIDE_ENABLED));

	private static final Log _log = LogFactoryUtil.getLog(IncludeTag.class);

	private String _page;
	private Set<String> _setAttributeNames;
	private boolean _strict;
	private TrackedServletRequest _trackedRequest;
	private boolean _useCustomPage = true;

	private static class TrackedServletRequest
		extends HttpServletRequestWrapper {

		@Override
		public void setAttribute(String name, Object obj) {
			_setAttributeNames.add(name);

			super.setAttribute(name, obj);
		}

		private TrackedServletRequest(
			HttpServletRequest httpServletRequest,
			Set<String> setAttributeNames) {

			super(httpServletRequest);

			_setAttributeNames = setAttributeNames;
		}

		private final Set<String> _setAttributeNames;

	}

}
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

package com.liferay.dynamic.data.mapping.model.impl;

import com.liferay.dynamic.data.mapping.model.DDMTemplateLink;
import com.liferay.dynamic.data.mapping.model.DDMTemplateLinkModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the DDMTemplateLink service. Represents a row in the &quot;DDMTemplateLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DDMTemplateLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMTemplateLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMTemplateLinkImpl
 * @generated
 */
@ProviderType
public class DDMTemplateLinkModelImpl
	extends BaseModelImpl<DDMTemplateLink> implements DDMTemplateLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ddm template link model instance should use the <code>DDMTemplateLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "DDMTemplateLink";

	public static final Object[][] TABLE_COLUMNS = {
		{"templateLinkId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"templateId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("templateLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("templateId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DDMTemplateLink (templateLinkId LONG not null primary key,companyId LONG,classNameId LONG,classPK LONG,templateId LONG)";

	public static final String TABLE_SQL_DROP = "drop table DDMTemplateLink";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ddmTemplateLink.templateLinkId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DDMTemplateLink.templateLinkId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.dynamic.data.mapping.model.DDMTemplateLink"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.dynamic.data.mapping.model.DDMTemplateLink"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.dynamic.data.mapping.model.DDMTemplateLink"),
		true);

	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	public static final long TEMPLATEID_COLUMN_BITMASK = 4L;

	public static final long TEMPLATELINKID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.dynamic.data.mapping.model.DDMTemplateLink"));

	public DDMTemplateLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _templateLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplateLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templateLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DDMTemplateLink.class;
	}

	@Override
	public String getModelClassName() {
		return DDMTemplateLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DDMTemplateLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DDMTemplateLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMTemplateLink, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DDMTemplateLink)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DDMTemplateLink, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DDMTemplateLink, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DDMTemplateLink)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DDMTemplateLink, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DDMTemplateLink, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DDMTemplateLink>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DDMTemplateLink.class.getClassLoader(), DDMTemplateLink.class,
			ModelWrapper.class);

		try {
			Constructor<DDMTemplateLink> constructor =
				(Constructor<DDMTemplateLink>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<DDMTemplateLink, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DDMTemplateLink, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DDMTemplateLink, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DDMTemplateLink, Object>>();
		Map<String, BiConsumer<DDMTemplateLink, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DDMTemplateLink, ?>>();

		attributeGetterFunctions.put(
			"templateLinkId", DDMTemplateLink::getTemplateLinkId);
		attributeSetterBiConsumers.put(
			"templateLinkId",
			(BiConsumer<DDMTemplateLink, Long>)
				DDMTemplateLink::setTemplateLinkId);
		attributeGetterFunctions.put(
			"companyId", DDMTemplateLink::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DDMTemplateLink, Long>)DDMTemplateLink::setCompanyId);
		attributeGetterFunctions.put(
			"classNameId", DDMTemplateLink::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<DDMTemplateLink, Long>)DDMTemplateLink::setClassNameId);
		attributeGetterFunctions.put("classPK", DDMTemplateLink::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<DDMTemplateLink, Long>)DDMTemplateLink::setClassPK);
		attributeGetterFunctions.put(
			"templateId", DDMTemplateLink::getTemplateId);
		attributeSetterBiConsumers.put(
			"templateId",
			(BiConsumer<DDMTemplateLink, Long>)DDMTemplateLink::setTemplateId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getTemplateLinkId() {
		return _templateLinkId;
	}

	@Override
	public void setTemplateLinkId(long templateLinkId) {
		_templateLinkId = templateLinkId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_columnBitmask |= TEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalTemplateId) {
			_setOriginalTemplateId = true;

			_originalTemplateId = _templateId;
		}

		_templateId = templateId;
	}

	public long getOriginalTemplateId() {
		return _originalTemplateId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DDMTemplateLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DDMTemplateLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DDMTemplateLinkImpl ddmTemplateLinkImpl = new DDMTemplateLinkImpl();

		ddmTemplateLinkImpl.setTemplateLinkId(getTemplateLinkId());
		ddmTemplateLinkImpl.setCompanyId(getCompanyId());
		ddmTemplateLinkImpl.setClassNameId(getClassNameId());
		ddmTemplateLinkImpl.setClassPK(getClassPK());
		ddmTemplateLinkImpl.setTemplateId(getTemplateId());

		ddmTemplateLinkImpl.resetOriginalValues();

		return ddmTemplateLinkImpl;
	}

	@Override
	public int compareTo(DDMTemplateLink ddmTemplateLink) {
		long primaryKey = ddmTemplateLink.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DDMTemplateLink)) {
			return false;
		}

		DDMTemplateLink ddmTemplateLink = (DDMTemplateLink)obj;

		long primaryKey = ddmTemplateLink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DDMTemplateLinkModelImpl ddmTemplateLinkModelImpl = this;

		ddmTemplateLinkModelImpl._originalClassNameId =
			ddmTemplateLinkModelImpl._classNameId;

		ddmTemplateLinkModelImpl._setOriginalClassNameId = false;

		ddmTemplateLinkModelImpl._originalClassPK =
			ddmTemplateLinkModelImpl._classPK;

		ddmTemplateLinkModelImpl._setOriginalClassPK = false;

		ddmTemplateLinkModelImpl._originalTemplateId =
			ddmTemplateLinkModelImpl._templateId;

		ddmTemplateLinkModelImpl._setOriginalTemplateId = false;

		ddmTemplateLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DDMTemplateLink> toCacheModel() {
		DDMTemplateLinkCacheModel ddmTemplateLinkCacheModel =
			new DDMTemplateLinkCacheModel();

		ddmTemplateLinkCacheModel.templateLinkId = getTemplateLinkId();

		ddmTemplateLinkCacheModel.companyId = getCompanyId();

		ddmTemplateLinkCacheModel.classNameId = getClassNameId();

		ddmTemplateLinkCacheModel.classPK = getClassPK();

		ddmTemplateLinkCacheModel.templateId = getTemplateId();

		return ddmTemplateLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DDMTemplateLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DDMTemplateLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMTemplateLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DDMTemplateLink)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DDMTemplateLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DDMTemplateLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMTemplateLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DDMTemplateLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, DDMTemplateLink>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _templateLinkId;
	private long _companyId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _templateId;
	private long _originalTemplateId;
	private boolean _setOriginalTemplateId;
	private long _columnBitmask;
	private DDMTemplateLink _escapedModel;

}
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

package com.liferay.knowledge.base.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.knowledge.base.model.KBFolder;
import com.liferay.knowledge.base.model.KBFolderModel;
import com.liferay.knowledge.base.model.KBFolderSoap;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the KBFolder service. Represents a row in the &quot;KBFolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>KBFolderModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KBFolderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBFolderImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class KBFolderModelImpl
	extends BaseModelImpl<KBFolder> implements KBFolderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kb folder model instance should use the <code>KBFolder</code> interface instead.
	 */
	public static final String TABLE_NAME = "KBFolder";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"kbFolderId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"parentKBFolderId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"urlTitle", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kbFolderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("parentKBFolderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("urlTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table KBFolder (uuid_ VARCHAR(75) null,kbFolderId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentKBFolderId LONG,name VARCHAR(75) null,urlTitle VARCHAR(75) null,description STRING null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table KBFolder";

	public static final String ORDER_BY_JPQL =
		" ORDER BY kbFolder.kbFolderId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY KBFolder.kbFolderId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.knowledge.base.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.knowledge.base.model.KBFolder"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.knowledge.base.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.knowledge.base.model.KBFolder"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.knowledge.base.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.knowledge.base.model.KBFolder"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long PARENTKBFOLDERID_COLUMN_BITMASK = 8L;

	public static final long URLTITLE_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long KBFOLDERID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static KBFolder toModel(KBFolderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		KBFolder model = new KBFolderImpl();

		model.setUuid(soapModel.getUuid());
		model.setKbFolderId(soapModel.getKbFolderId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setParentKBFolderId(soapModel.getParentKBFolderId());
		model.setName(soapModel.getName());
		model.setUrlTitle(soapModel.getUrlTitle());
		model.setDescription(soapModel.getDescription());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<KBFolder> toModels(KBFolderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<KBFolder> models = new ArrayList<KBFolder>(soapModels.length);

		for (KBFolderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.knowledge.base.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.knowledge.base.model.KBFolder"));

	public KBFolderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kbFolderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKbFolderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kbFolderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KBFolder.class;
	}

	@Override
	public String getModelClassName() {
		return KBFolder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KBFolder, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KBFolder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KBFolder, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((KBFolder)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KBFolder, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KBFolder, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(KBFolder)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<KBFolder, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KBFolder, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, KBFolder>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			KBFolder.class.getClassLoader(), KBFolder.class,
			ModelWrapper.class);

		try {
			Constructor<KBFolder> constructor =
				(Constructor<KBFolder>)proxyClass.getConstructor(
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

	private static final Map<String, Function<KBFolder, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<KBFolder, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<KBFolder, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<KBFolder, Object>>();
		Map<String, BiConsumer<KBFolder, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<KBFolder, ?>>();

		attributeGetterFunctions.put("uuid", KBFolder::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<KBFolder, String>)KBFolder::setUuid);
		attributeGetterFunctions.put("kbFolderId", KBFolder::getKbFolderId);
		attributeSetterBiConsumers.put(
			"kbFolderId", (BiConsumer<KBFolder, Long>)KBFolder::setKbFolderId);
		attributeGetterFunctions.put("groupId", KBFolder::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<KBFolder, Long>)KBFolder::setGroupId);
		attributeGetterFunctions.put("companyId", KBFolder::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<KBFolder, Long>)KBFolder::setCompanyId);
		attributeGetterFunctions.put("userId", KBFolder::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<KBFolder, Long>)KBFolder::setUserId);
		attributeGetterFunctions.put("userName", KBFolder::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<KBFolder, String>)KBFolder::setUserName);
		attributeGetterFunctions.put("createDate", KBFolder::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<KBFolder, Date>)KBFolder::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", KBFolder::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<KBFolder, Date>)KBFolder::setModifiedDate);
		attributeGetterFunctions.put(
			"parentKBFolderId", KBFolder::getParentKBFolderId);
		attributeSetterBiConsumers.put(
			"parentKBFolderId",
			(BiConsumer<KBFolder, Long>)KBFolder::setParentKBFolderId);
		attributeGetterFunctions.put("name", KBFolder::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<KBFolder, String>)KBFolder::setName);
		attributeGetterFunctions.put("urlTitle", KBFolder::getUrlTitle);
		attributeSetterBiConsumers.put(
			"urlTitle", (BiConsumer<KBFolder, String>)KBFolder::setUrlTitle);
		attributeGetterFunctions.put("description", KBFolder::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<KBFolder, String>)KBFolder::setDescription);
		attributeGetterFunctions.put(
			"lastPublishDate", KBFolder::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<KBFolder, Date>)KBFolder::setLastPublishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getKbFolderId() {
		return _kbFolderId;
	}

	@Override
	public void setKbFolderId(long kbFolderId) {
		_kbFolderId = kbFolderId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getParentKBFolderId() {
		return _parentKBFolderId;
	}

	@Override
	public void setParentKBFolderId(long parentKBFolderId) {
		_columnBitmask |= PARENTKBFOLDERID_COLUMN_BITMASK;

		if (!_setOriginalParentKBFolderId) {
			_setOriginalParentKBFolderId = true;

			_originalParentKBFolderId = _parentKBFolderId;
		}

		_parentKBFolderId = parentKBFolderId;
	}

	public long getOriginalParentKBFolderId() {
		return _originalParentKBFolderId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getUrlTitle() {
		if (_urlTitle == null) {
			return "";
		}
		else {
			return _urlTitle;
		}
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_columnBitmask |= URLTITLE_COLUMN_BITMASK;

		if (_originalUrlTitle == null) {
			_originalUrlTitle = _urlTitle;
		}

		_urlTitle = urlTitle;
	}

	public String getOriginalUrlTitle() {
		return GetterUtil.getString(_originalUrlTitle);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(KBFolder.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), KBFolder.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KBFolder toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KBFolderImpl kbFolderImpl = new KBFolderImpl();

		kbFolderImpl.setUuid(getUuid());
		kbFolderImpl.setKbFolderId(getKbFolderId());
		kbFolderImpl.setGroupId(getGroupId());
		kbFolderImpl.setCompanyId(getCompanyId());
		kbFolderImpl.setUserId(getUserId());
		kbFolderImpl.setUserName(getUserName());
		kbFolderImpl.setCreateDate(getCreateDate());
		kbFolderImpl.setModifiedDate(getModifiedDate());
		kbFolderImpl.setParentKBFolderId(getParentKBFolderId());
		kbFolderImpl.setName(getName());
		kbFolderImpl.setUrlTitle(getUrlTitle());
		kbFolderImpl.setDescription(getDescription());
		kbFolderImpl.setLastPublishDate(getLastPublishDate());

		kbFolderImpl.resetOriginalValues();

		return kbFolderImpl;
	}

	@Override
	public int compareTo(KBFolder kbFolder) {
		long primaryKey = kbFolder.getPrimaryKey();

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

		if (!(obj instanceof KBFolder)) {
			return false;
		}

		KBFolder kbFolder = (KBFolder)obj;

		long primaryKey = kbFolder.getPrimaryKey();

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
		KBFolderModelImpl kbFolderModelImpl = this;

		kbFolderModelImpl._originalUuid = kbFolderModelImpl._uuid;

		kbFolderModelImpl._originalGroupId = kbFolderModelImpl._groupId;

		kbFolderModelImpl._setOriginalGroupId = false;

		kbFolderModelImpl._originalCompanyId = kbFolderModelImpl._companyId;

		kbFolderModelImpl._setOriginalCompanyId = false;

		kbFolderModelImpl._setModifiedDate = false;

		kbFolderModelImpl._originalParentKBFolderId =
			kbFolderModelImpl._parentKBFolderId;

		kbFolderModelImpl._setOriginalParentKBFolderId = false;

		kbFolderModelImpl._originalName = kbFolderModelImpl._name;

		kbFolderModelImpl._originalUrlTitle = kbFolderModelImpl._urlTitle;

		kbFolderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KBFolder> toCacheModel() {
		KBFolderCacheModel kbFolderCacheModel = new KBFolderCacheModel();

		kbFolderCacheModel.uuid = getUuid();

		String uuid = kbFolderCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			kbFolderCacheModel.uuid = null;
		}

		kbFolderCacheModel.kbFolderId = getKbFolderId();

		kbFolderCacheModel.groupId = getGroupId();

		kbFolderCacheModel.companyId = getCompanyId();

		kbFolderCacheModel.userId = getUserId();

		kbFolderCacheModel.userName = getUserName();

		String userName = kbFolderCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kbFolderCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kbFolderCacheModel.createDate = createDate.getTime();
		}
		else {
			kbFolderCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kbFolderCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kbFolderCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kbFolderCacheModel.parentKBFolderId = getParentKBFolderId();

		kbFolderCacheModel.name = getName();

		String name = kbFolderCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kbFolderCacheModel.name = null;
		}

		kbFolderCacheModel.urlTitle = getUrlTitle();

		String urlTitle = kbFolderCacheModel.urlTitle;

		if ((urlTitle != null) && (urlTitle.length() == 0)) {
			kbFolderCacheModel.urlTitle = null;
		}

		kbFolderCacheModel.description = getDescription();

		String description = kbFolderCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kbFolderCacheModel.description = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			kbFolderCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			kbFolderCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return kbFolderCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KBFolder, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<KBFolder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KBFolder, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((KBFolder)this));
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
		Map<String, Function<KBFolder, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KBFolder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KBFolder, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((KBFolder)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, KBFolder>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _uuid;
	private String _originalUuid;
	private long _kbFolderId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _parentKBFolderId;
	private long _originalParentKBFolderId;
	private boolean _setOriginalParentKBFolderId;
	private String _name;
	private String _originalName;
	private String _urlTitle;
	private String _originalUrlTitle;
	private String _description;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private KBFolder _escapedModel;

}
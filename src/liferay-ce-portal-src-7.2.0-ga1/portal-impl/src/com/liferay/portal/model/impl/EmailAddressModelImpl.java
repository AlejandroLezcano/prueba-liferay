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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.EmailAddressModel;
import com.liferay.portal.kernel.model.EmailAddressSoap;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the EmailAddress service. Represents a row in the &quot;EmailAddress&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>EmailAddressModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmailAddressImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailAddressImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EmailAddressModelImpl
	extends BaseModelImpl<EmailAddress> implements EmailAddressModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a email address model instance should use the <code>EmailAddress</code> interface instead.
	 */
	public static final String TABLE_NAME = "EmailAddress";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"emailAddressId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"address", Types.VARCHAR}, {"typeId", Types.BIGINT},
		{"primary_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emailAddressId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("primary_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EmailAddress (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,emailAddressId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,address VARCHAR(254) null,typeId LONG,primary_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table EmailAddress";

	public static final String ORDER_BY_JPQL =
		" ORDER BY emailAddress.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EmailAddress.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.EmailAddress"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.EmailAddress"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.EmailAddress"),
		true);

	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	public static final long PRIMARY_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long CREATEDATE_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EmailAddress toModel(EmailAddressSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmailAddress model = new EmailAddressImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setEmailAddressId(soapModel.getEmailAddressId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setAddress(soapModel.getAddress());
		model.setTypeId(soapModel.getTypeId());
		model.setPrimary(soapModel.isPrimary());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EmailAddress> toModels(EmailAddressSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EmailAddress> models = new ArrayList<EmailAddress>(
			soapModels.length);

		for (EmailAddressSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.EmailAddress"));

	public EmailAddressModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _emailAddressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmailAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emailAddressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmailAddress.class;
	}

	@Override
	public String getModelClassName() {
		return EmailAddress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmailAddress, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmailAddress, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmailAddress, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmailAddress)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmailAddress, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmailAddress, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmailAddress)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmailAddress, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmailAddress, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmailAddress>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmailAddress.class.getClassLoader(), EmailAddress.class,
			ModelWrapper.class);

		try {
			Constructor<EmailAddress> constructor =
				(Constructor<EmailAddress>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmailAddress, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmailAddress, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmailAddress, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<EmailAddress, Object>>();
		Map<String, BiConsumer<EmailAddress, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EmailAddress, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", EmailAddress::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<EmailAddress, Long>)EmailAddress::setMvccVersion);
		attributeGetterFunctions.put("uuid", EmailAddress::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<EmailAddress, String>)EmailAddress::setUuid);
		attributeGetterFunctions.put(
			"emailAddressId", EmailAddress::getEmailAddressId);
		attributeSetterBiConsumers.put(
			"emailAddressId",
			(BiConsumer<EmailAddress, Long>)EmailAddress::setEmailAddressId);
		attributeGetterFunctions.put("companyId", EmailAddress::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmailAddress, Long>)EmailAddress::setCompanyId);
		attributeGetterFunctions.put("userId", EmailAddress::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<EmailAddress, Long>)EmailAddress::setUserId);
		attributeGetterFunctions.put("userName", EmailAddress::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmailAddress, String>)EmailAddress::setUserName);
		attributeGetterFunctions.put("createDate", EmailAddress::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmailAddress, Date>)EmailAddress::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmailAddress::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmailAddress, Date>)EmailAddress::setModifiedDate);
		attributeGetterFunctions.put(
			"classNameId", EmailAddress::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<EmailAddress, Long>)EmailAddress::setClassNameId);
		attributeGetterFunctions.put("classPK", EmailAddress::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<EmailAddress, Long>)EmailAddress::setClassPK);
		attributeGetterFunctions.put("address", EmailAddress::getAddress);
		attributeSetterBiConsumers.put(
			"address",
			(BiConsumer<EmailAddress, String>)EmailAddress::setAddress);
		attributeGetterFunctions.put("typeId", EmailAddress::getTypeId);
		attributeSetterBiConsumers.put(
			"typeId", (BiConsumer<EmailAddress, Long>)EmailAddress::setTypeId);
		attributeGetterFunctions.put("primary", EmailAddress::getPrimary);
		attributeSetterBiConsumers.put(
			"primary",
			(BiConsumer<EmailAddress, Boolean>)EmailAddress::setPrimary);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
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
	public long getEmailAddressId() {
		return _emailAddressId;
	}

	@Override
	public void setEmailAddressId(long emailAddressId) {
		_emailAddressId = emailAddressId;
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
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
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
		_columnBitmask = -1L;

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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	@JSON
	@Override
	public boolean getPrimary() {
		return _primary;
	}

	@JSON
	@Override
	public boolean isPrimary() {
		return _primary;
	}

	@Override
	public void setPrimary(boolean primary) {
		_columnBitmask |= PRIMARY_COLUMN_BITMASK;

		if (!_setOriginalPrimary) {
			_setOriginalPrimary = true;

			_originalPrimary = _primary;
		}

		_primary = primary;
	}

	public boolean getOriginalPrimary() {
		return _originalPrimary;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(EmailAddress.class.getName()),
			getClassNameId());
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), EmailAddress.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmailAddress toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmailAddressImpl emailAddressImpl = new EmailAddressImpl();

		emailAddressImpl.setMvccVersion(getMvccVersion());
		emailAddressImpl.setUuid(getUuid());
		emailAddressImpl.setEmailAddressId(getEmailAddressId());
		emailAddressImpl.setCompanyId(getCompanyId());
		emailAddressImpl.setUserId(getUserId());
		emailAddressImpl.setUserName(getUserName());
		emailAddressImpl.setCreateDate(getCreateDate());
		emailAddressImpl.setModifiedDate(getModifiedDate());
		emailAddressImpl.setClassNameId(getClassNameId());
		emailAddressImpl.setClassPK(getClassPK());
		emailAddressImpl.setAddress(getAddress());
		emailAddressImpl.setTypeId(getTypeId());
		emailAddressImpl.setPrimary(isPrimary());

		emailAddressImpl.resetOriginalValues();

		return emailAddressImpl;
	}

	@Override
	public int compareTo(EmailAddress emailAddress) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), emailAddress.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailAddress)) {
			return false;
		}

		EmailAddress emailAddress = (EmailAddress)obj;

		long primaryKey = emailAddress.getPrimaryKey();

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
		EmailAddressModelImpl emailAddressModelImpl = this;

		emailAddressModelImpl._originalUuid = emailAddressModelImpl._uuid;

		emailAddressModelImpl._originalCompanyId =
			emailAddressModelImpl._companyId;

		emailAddressModelImpl._setOriginalCompanyId = false;

		emailAddressModelImpl._originalUserId = emailAddressModelImpl._userId;

		emailAddressModelImpl._setOriginalUserId = false;

		emailAddressModelImpl._setModifiedDate = false;

		emailAddressModelImpl._originalClassNameId =
			emailAddressModelImpl._classNameId;

		emailAddressModelImpl._setOriginalClassNameId = false;

		emailAddressModelImpl._originalClassPK = emailAddressModelImpl._classPK;

		emailAddressModelImpl._setOriginalClassPK = false;

		emailAddressModelImpl._originalPrimary = emailAddressModelImpl._primary;

		emailAddressModelImpl._setOriginalPrimary = false;

		emailAddressModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EmailAddress> toCacheModel() {
		EmailAddressCacheModel emailAddressCacheModel =
			new EmailAddressCacheModel();

		emailAddressCacheModel.mvccVersion = getMvccVersion();

		emailAddressCacheModel.uuid = getUuid();

		String uuid = emailAddressCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			emailAddressCacheModel.uuid = null;
		}

		emailAddressCacheModel.emailAddressId = getEmailAddressId();

		emailAddressCacheModel.companyId = getCompanyId();

		emailAddressCacheModel.userId = getUserId();

		emailAddressCacheModel.userName = getUserName();

		String userName = emailAddressCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			emailAddressCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			emailAddressCacheModel.createDate = createDate.getTime();
		}
		else {
			emailAddressCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			emailAddressCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			emailAddressCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		emailAddressCacheModel.classNameId = getClassNameId();

		emailAddressCacheModel.classPK = getClassPK();

		emailAddressCacheModel.address = getAddress();

		String address = emailAddressCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			emailAddressCacheModel.address = null;
		}

		emailAddressCacheModel.typeId = getTypeId();

		emailAddressCacheModel.primary = isPrimary();

		return emailAddressCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmailAddress, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmailAddress, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmailAddress, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmailAddress)this));
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
		Map<String, Function<EmailAddress, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmailAddress, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmailAddress, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmailAddress)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, EmailAddress>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _emailAddressId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _address;
	private long _typeId;
	private boolean _primary;
	private boolean _originalPrimary;
	private boolean _setOriginalPrimary;
	private long _columnBitmask;
	private EmailAddress _escapedModel;

}
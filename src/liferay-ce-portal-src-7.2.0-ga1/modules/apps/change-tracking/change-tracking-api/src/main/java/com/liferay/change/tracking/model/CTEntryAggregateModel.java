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

package com.liferay.change.tracking.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CTEntryAggregate service. Represents a row in the &quot;CTEntryAggregate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.change.tracking.model.impl.CTEntryAggregateModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.change.tracking.model.impl.CTEntryAggregateImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEntryAggregate
 * @generated
 */
@ProviderType
public interface CTEntryAggregateModel
	extends AuditedModel, BaseModel<CTEntryAggregate>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ct entry aggregate model instance should use the {@link CTEntryAggregate} interface instead.
	 */

	/**
	 * Returns the primary key of this ct entry aggregate.
	 *
	 * @return the primary key of this ct entry aggregate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ct entry aggregate.
	 *
	 * @param primaryKey the primary key of this ct entry aggregate
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ct entry aggregate ID of this ct entry aggregate.
	 *
	 * @return the ct entry aggregate ID of this ct entry aggregate
	 */
	public long getCtEntryAggregateId();

	/**
	 * Sets the ct entry aggregate ID of this ct entry aggregate.
	 *
	 * @param ctEntryAggregateId the ct entry aggregate ID of this ct entry aggregate
	 */
	public void setCtEntryAggregateId(long ctEntryAggregateId);

	/**
	 * Returns the company ID of this ct entry aggregate.
	 *
	 * @return the company ID of this ct entry aggregate
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ct entry aggregate.
	 *
	 * @param companyId the company ID of this ct entry aggregate
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ct entry aggregate.
	 *
	 * @return the user ID of this ct entry aggregate
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ct entry aggregate.
	 *
	 * @param userId the user ID of this ct entry aggregate
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ct entry aggregate.
	 *
	 * @return the user uuid of this ct entry aggregate
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ct entry aggregate.
	 *
	 * @param userUuid the user uuid of this ct entry aggregate
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ct entry aggregate.
	 *
	 * @return the user name of this ct entry aggregate
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ct entry aggregate.
	 *
	 * @param userName the user name of this ct entry aggregate
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ct entry aggregate.
	 *
	 * @return the create date of this ct entry aggregate
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ct entry aggregate.
	 *
	 * @param createDate the create date of this ct entry aggregate
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ct entry aggregate.
	 *
	 * @return the modified date of this ct entry aggregate
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ct entry aggregate.
	 *
	 * @param modifiedDate the modified date of this ct entry aggregate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the owner ct entry ID of this ct entry aggregate.
	 *
	 * @return the owner ct entry ID of this ct entry aggregate
	 */
	public long getOwnerCTEntryId();

	/**
	 * Sets the owner ct entry ID of this ct entry aggregate.
	 *
	 * @param ownerCTEntryId the owner ct entry ID of this ct entry aggregate
	 */
	public void setOwnerCTEntryId(long ownerCTEntryId);

	/**
	 * Returns the status of this ct entry aggregate.
	 *
	 * @return the status of this ct entry aggregate
	 */
	public int getStatus();

	/**
	 * Sets the status of this ct entry aggregate.
	 *
	 * @param status the status of this ct entry aggregate
	 */
	public void setStatus(int status);

}
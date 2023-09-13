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

package com.liferay.message.boards.model;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MBStatsUser service. Represents a row in the &quot;MBStatsUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.message.boards.model.impl.MBStatsUserModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.message.boards.model.impl.MBStatsUserImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBStatsUser
 * @generated
 */
@ProviderType
public interface MBStatsUserModel extends BaseModel<MBStatsUser>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message boards stats user model instance should use the {@link MBStatsUser} interface instead.
	 */

	/**
	 * Returns the primary key of this message boards stats user.
	 *
	 * @return the primary key of this message boards stats user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message boards stats user.
	 *
	 * @param primaryKey the primary key of this message boards stats user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the stats user ID of this message boards stats user.
	 *
	 * @return the stats user ID of this message boards stats user
	 */
	public long getStatsUserId();

	/**
	 * Sets the stats user ID of this message boards stats user.
	 *
	 * @param statsUserId the stats user ID of this message boards stats user
	 */
	public void setStatsUserId(long statsUserId);

	/**
	 * Returns the stats user uuid of this message boards stats user.
	 *
	 * @return the stats user uuid of this message boards stats user
	 */
	public String getStatsUserUuid();

	/**
	 * Sets the stats user uuid of this message boards stats user.
	 *
	 * @param statsUserUuid the stats user uuid of this message boards stats user
	 */
	public void setStatsUserUuid(String statsUserUuid);

	/**
	 * Returns the group ID of this message boards stats user.
	 *
	 * @return the group ID of this message boards stats user
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this message boards stats user.
	 *
	 * @param groupId the group ID of this message boards stats user
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this message boards stats user.
	 *
	 * @return the company ID of this message boards stats user
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this message boards stats user.
	 *
	 * @param companyId the company ID of this message boards stats user
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this message boards stats user.
	 *
	 * @return the user ID of this message boards stats user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this message boards stats user.
	 *
	 * @param userId the user ID of this message boards stats user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this message boards stats user.
	 *
	 * @return the user uuid of this message boards stats user
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this message boards stats user.
	 *
	 * @param userUuid the user uuid of this message boards stats user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the message count of this message boards stats user.
	 *
	 * @return the message count of this message boards stats user
	 */
	public int getMessageCount();

	/**
	 * Sets the message count of this message boards stats user.
	 *
	 * @param messageCount the message count of this message boards stats user
	 */
	public void setMessageCount(int messageCount);

	/**
	 * Returns the last post date of this message boards stats user.
	 *
	 * @return the last post date of this message boards stats user
	 */
	public Date getLastPostDate();

	/**
	 * Sets the last post date of this message boards stats user.
	 *
	 * @param lastPostDate the last post date of this message boards stats user
	 */
	public void setLastPostDate(Date lastPostDate);

}
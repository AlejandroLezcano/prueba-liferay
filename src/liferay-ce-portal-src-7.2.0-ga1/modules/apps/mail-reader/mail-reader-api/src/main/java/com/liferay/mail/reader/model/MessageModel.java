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

package com.liferay.mail.reader.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Message service. Represents a row in the &quot;Mail_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.mail.reader.model.impl.MessageModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.mail.reader.model.impl.MessageImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @generated
 */
@ProviderType
public interface MessageModel
	extends AuditedModel, BaseModel<Message>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message model instance should use the {@link Message} interface instead.
	 */

	/**
	 * Returns the primary key of this message.
	 *
	 * @return the primary key of this message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message.
	 *
	 * @param primaryKey the primary key of this message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the message ID of this message.
	 *
	 * @return the message ID of this message
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this message.
	 *
	 * @param messageId the message ID of this message
	 */
	public void setMessageId(long messageId);

	/**
	 * Returns the company ID of this message.
	 *
	 * @return the company ID of this message
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this message.
	 *
	 * @param companyId the company ID of this message
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this message.
	 *
	 * @return the user ID of this message
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this message.
	 *
	 * @param userId the user ID of this message
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this message.
	 *
	 * @return the user uuid of this message
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this message.
	 *
	 * @param userUuid the user uuid of this message
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this message.
	 *
	 * @return the user name of this message
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this message.
	 *
	 * @param userName the user name of this message
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this message.
	 *
	 * @return the create date of this message
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this message.
	 *
	 * @param createDate the create date of this message
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this message.
	 *
	 * @return the modified date of this message
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this message.
	 *
	 * @param modifiedDate the modified date of this message
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the account ID of this message.
	 *
	 * @return the account ID of this message
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this message.
	 *
	 * @param accountId the account ID of this message
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the folder ID of this message.
	 *
	 * @return the folder ID of this message
	 */
	public long getFolderId();

	/**
	 * Sets the folder ID of this message.
	 *
	 * @param folderId the folder ID of this message
	 */
	public void setFolderId(long folderId);

	/**
	 * Returns the sender of this message.
	 *
	 * @return the sender of this message
	 */
	@AutoEscape
	public String getSender();

	/**
	 * Sets the sender of this message.
	 *
	 * @param sender the sender of this message
	 */
	public void setSender(String sender);

	/**
	 * Returns the to of this message.
	 *
	 * @return the to of this message
	 */
	@AutoEscape
	public String getTo();

	/**
	 * Sets the to of this message.
	 *
	 * @param to the to of this message
	 */
	public void setTo(String to);

	/**
	 * Returns the cc of this message.
	 *
	 * @return the cc of this message
	 */
	@AutoEscape
	public String getCc();

	/**
	 * Sets the cc of this message.
	 *
	 * @param cc the cc of this message
	 */
	public void setCc(String cc);

	/**
	 * Returns the bcc of this message.
	 *
	 * @return the bcc of this message
	 */
	@AutoEscape
	public String getBcc();

	/**
	 * Sets the bcc of this message.
	 *
	 * @param bcc the bcc of this message
	 */
	public void setBcc(String bcc);

	/**
	 * Returns the sent date of this message.
	 *
	 * @return the sent date of this message
	 */
	public Date getSentDate();

	/**
	 * Sets the sent date of this message.
	 *
	 * @param sentDate the sent date of this message
	 */
	public void setSentDate(Date sentDate);

	/**
	 * Returns the subject of this message.
	 *
	 * @return the subject of this message
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this message.
	 *
	 * @param subject the subject of this message
	 */
	public void setSubject(String subject);

	/**
	 * Returns the preview of this message.
	 *
	 * @return the preview of this message
	 */
	@AutoEscape
	public String getPreview();

	/**
	 * Sets the preview of this message.
	 *
	 * @param preview the preview of this message
	 */
	public void setPreview(String preview);

	/**
	 * Returns the body of this message.
	 *
	 * @return the body of this message
	 */
	@AutoEscape
	public String getBody();

	/**
	 * Sets the body of this message.
	 *
	 * @param body the body of this message
	 */
	public void setBody(String body);

	/**
	 * Returns the flags of this message.
	 *
	 * @return the flags of this message
	 */
	@AutoEscape
	public String getFlags();

	/**
	 * Sets the flags of this message.
	 *
	 * @param flags the flags of this message
	 */
	public void setFlags(String flags);

	/**
	 * Returns the size of this message.
	 *
	 * @return the size of this message
	 */
	public long getSize();

	/**
	 * Sets the size of this message.
	 *
	 * @param size the size of this message
	 */
	public void setSize(long size);

	/**
	 * Returns the remote message ID of this message.
	 *
	 * @return the remote message ID of this message
	 */
	public long getRemoteMessageId();

	/**
	 * Sets the remote message ID of this message.
	 *
	 * @param remoteMessageId the remote message ID of this message
	 */
	public void setRemoteMessageId(long remoteMessageId);

	/**
	 * Returns the content type of this message.
	 *
	 * @return the content type of this message
	 */
	@AutoEscape
	public String getContentType();

	/**
	 * Sets the content type of this message.
	 *
	 * @param contentType the content type of this message
	 */
	public void setContentType(String contentType);

}
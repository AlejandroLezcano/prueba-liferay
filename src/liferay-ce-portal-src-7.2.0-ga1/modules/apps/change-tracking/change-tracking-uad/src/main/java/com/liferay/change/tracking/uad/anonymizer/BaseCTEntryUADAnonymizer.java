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

package com.liferay.change.tracking.uad.anonymizer;

import com.liferay.change.tracking.model.CTEntry;
import com.liferay.change.tracking.service.CTEntryLocalService;
import com.liferay.change.tracking.uad.constants.CTUADConstants;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the ct entry UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link CTEntryUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseCTEntryUADAnonymizer
	extends DynamicQueryUADAnonymizer<CTEntry> {

	@Override
	public void autoAnonymize(CTEntry ctEntry, long userId, User anonymousUser)
		throws PortalException {

		if (ctEntry.getUserId() == userId) {
			ctEntry.setUserId(anonymousUser.getUserId());
			ctEntry.setUserName(anonymousUser.getFullName());
		}

		ctEntryLocalService.updateCTEntry(ctEntry);
	}

	@Override
	public void delete(CTEntry ctEntry) throws PortalException {
		ctEntryLocalService.deleteCTEntry(ctEntry);
	}

	@Override
	public Class<CTEntry> getTypeClass() {
		return CTEntry.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return ctEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return CTUADConstants.USER_ID_FIELD_NAMES_CT_ENTRY;
	}

	@Reference
	protected CTEntryLocalService ctEntryLocalService;

}
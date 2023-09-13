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

package com.liferay.document.library.uad.anonymizer;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.document.library.uad.constants.DLUADConstants;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the document library folder UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link DLFolderUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseDLFolderUADAnonymizer
	extends DynamicQueryUADAnonymizer<DLFolder> {

	@Override
	public void autoAnonymize(
			DLFolder dlFolder, long userId, User anonymousUser)
		throws PortalException {

		if (dlFolder.getUserId() == userId) {
			dlFolder.setUserId(anonymousUser.getUserId());
			dlFolder.setUserName(anonymousUser.getFullName());
		}

		if (dlFolder.getStatusByUserId() == userId) {
			dlFolder.setStatusByUserId(anonymousUser.getUserId());
			dlFolder.setStatusByUserName(anonymousUser.getFullName());
		}

		dlFolderLocalService.updateDLFolder(dlFolder);
	}

	@Override
	public void delete(DLFolder dlFolder) throws PortalException {
		dlFolderLocalService.deleteFolder(dlFolder);
	}

	@Override
	public Class<DLFolder> getTypeClass() {
		return DLFolder.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return dlFolderLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return DLUADConstants.USER_ID_FIELD_NAMES_DL_FOLDER;
	}

	@Reference
	protected DLFolderLocalService dlFolderLocalService;

}
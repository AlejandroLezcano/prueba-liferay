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

package com.liferay.portal.uad.anonymizer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RepositoryLocalService;
import com.liferay.portal.uad.constants.PortalUADConstants;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the repository UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link RepositoryUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseRepositoryUADAnonymizer
	extends DynamicQueryUADAnonymizer<Repository> {

	@Override
	public void autoAnonymize(
			Repository repository, long userId, User anonymousUser)
		throws PortalException {

		if (repository.getUserId() == userId) {
			repository.setUserId(anonymousUser.getUserId());
			repository.setUserName(anonymousUser.getFullName());
		}

		repositoryLocalService.updateRepository(repository);
	}

	@Override
	public void delete(Repository repository) throws PortalException {
		repositoryLocalService.deleteRepository(repository);
	}

	@Override
	public Class<Repository> getTypeClass() {
		return Repository.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return repositoryLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return PortalUADConstants.USER_ID_FIELD_NAMES_REPOSITORY;
	}

	@Reference
	protected RepositoryLocalService repositoryLocalService;

}
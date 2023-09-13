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

package com.liferay.portal.kernel.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence utility for the layout set service. This utility wraps <code>com.liferay.portal.service.persistence.impl.LayoutSetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetPersistence
 * @generated
 */
@ProviderType
public class LayoutSetUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LayoutSet layoutSet) {
		getPersistence().clearCache(layoutSet);
	}

	/**
	 * @see BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, LayoutSet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LayoutSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LayoutSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LayoutSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LayoutSet update(LayoutSet layoutSet) {
		return getPersistence().update(layoutSet);
	}

	/**
	 * @see BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LayoutSet update(
		LayoutSet layoutSet, ServiceContext serviceContext) {

		return getPersistence().update(layoutSet, serviceContext);
	}

	/**
	 * Returns all the layout sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching layout sets
	 */
	public static List<LayoutSet> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the layout sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of matching layout sets
	 */
	public static List<LayoutSet> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first layout set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByGroupId_First(
			long groupId, OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first layout set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByGroupId_First(
		long groupId, OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByGroupId_Last(
			long groupId, OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByGroupId_Last(
		long groupId, OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the layout sets before and after the current layout set in the ordered set where groupId = &#63;.
	 *
	 * @param layoutSetId the primary key of the current layout set
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet[] findByGroupId_PrevAndNext(
			long layoutSetId, long groupId,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByGroupId_PrevAndNext(
			layoutSetId, groupId, orderByComparator);
	}

	/**
	 * Removes all the layout sets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of layout sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching layout sets
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the layout sets where groupId = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @return the matching layout sets
	 */
	public static List<LayoutSet> findByGroupId_Head(
		long groupId, boolean head) {

		return getPersistence().findByGroupId_Head(groupId, head);
	}

	/**
	 * Returns a range of all the layout sets where groupId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of matching layout sets
	 */
	public static List<LayoutSet> findByGroupId_Head(
		long groupId, boolean head, int start, int end) {

		return getPersistence().findByGroupId_Head(groupId, head, start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets where groupId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByGroupId_Head(
		long groupId, boolean head, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findByGroupId_Head(
			groupId, head, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets where groupId = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByGroupId_Head(
		long groupId, boolean head, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGroupId_Head(
			groupId, head, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first layout set in the ordered set where groupId = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByGroupId_Head_First(
			long groupId, boolean head,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByGroupId_Head_First(
			groupId, head, orderByComparator);
	}

	/**
	 * Returns the first layout set in the ordered set where groupId = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByGroupId_Head_First(
		long groupId, boolean head,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByGroupId_Head_First(
			groupId, head, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where groupId = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByGroupId_Head_Last(
			long groupId, boolean head,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByGroupId_Head_Last(
			groupId, head, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where groupId = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByGroupId_Head_Last(
		long groupId, boolean head,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByGroupId_Head_Last(
			groupId, head, orderByComparator);
	}

	/**
	 * Returns the layout sets before and after the current layout set in the ordered set where groupId = &#63; and head = &#63;.
	 *
	 * @param layoutSetId the primary key of the current layout set
	 * @param groupId the group ID
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet[] findByGroupId_Head_PrevAndNext(
			long layoutSetId, long groupId, boolean head,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByGroupId_Head_PrevAndNext(
			layoutSetId, groupId, head, orderByComparator);
	}

	/**
	 * Removes all the layout sets where groupId = &#63; and head = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 */
	public static void removeByGroupId_Head(long groupId, boolean head) {
		getPersistence().removeByGroupId_Head(groupId, head);
	}

	/**
	 * Returns the number of layout sets where groupId = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param head the head
	 * @return the number of matching layout sets
	 */
	public static int countByGroupId_Head(long groupId, boolean head) {
		return getPersistence().countByGroupId_Head(groupId, head);
	}

	/**
	 * Returns all the layout sets where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @return the matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid(
		String layoutSetPrototypeUuid) {

		return getPersistence().findByLayoutSetPrototypeUuid(
			layoutSetPrototypeUuid);
	}

	/**
	 * Returns a range of all the layout sets where layoutSetPrototypeUuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid(
		String layoutSetPrototypeUuid, int start, int end) {

		return getPersistence().findByLayoutSetPrototypeUuid(
			layoutSetPrototypeUuid, start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets where layoutSetPrototypeUuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid(
		String layoutSetPrototypeUuid, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findByLayoutSetPrototypeUuid(
			layoutSetPrototypeUuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets where layoutSetPrototypeUuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid(
		String layoutSetPrototypeUuid, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByLayoutSetPrototypeUuid(
			layoutSetPrototypeUuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first layout set in the ordered set where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByLayoutSetPrototypeUuid_First(
			String layoutSetPrototypeUuid,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByLayoutSetPrototypeUuid_First(
			layoutSetPrototypeUuid, orderByComparator);
	}

	/**
	 * Returns the first layout set in the ordered set where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByLayoutSetPrototypeUuid_First(
		String layoutSetPrototypeUuid,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByLayoutSetPrototypeUuid_First(
			layoutSetPrototypeUuid, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByLayoutSetPrototypeUuid_Last(
			String layoutSetPrototypeUuid,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByLayoutSetPrototypeUuid_Last(
			layoutSetPrototypeUuid, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByLayoutSetPrototypeUuid_Last(
		String layoutSetPrototypeUuid,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByLayoutSetPrototypeUuid_Last(
			layoutSetPrototypeUuid, orderByComparator);
	}

	/**
	 * Returns the layout sets before and after the current layout set in the ordered set where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetId the primary key of the current layout set
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet[] findByLayoutSetPrototypeUuid_PrevAndNext(
			long layoutSetId, String layoutSetPrototypeUuid,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByLayoutSetPrototypeUuid_PrevAndNext(
			layoutSetId, layoutSetPrototypeUuid, orderByComparator);
	}

	/**
	 * Removes all the layout sets where layoutSetPrototypeUuid = &#63; from the database.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 */
	public static void removeByLayoutSetPrototypeUuid(
		String layoutSetPrototypeUuid) {

		getPersistence().removeByLayoutSetPrototypeUuid(layoutSetPrototypeUuid);
	}

	/**
	 * Returns the number of layout sets where layoutSetPrototypeUuid = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @return the number of matching layout sets
	 */
	public static int countByLayoutSetPrototypeUuid(
		String layoutSetPrototypeUuid) {

		return getPersistence().countByLayoutSetPrototypeUuid(
			layoutSetPrototypeUuid);
	}

	/**
	 * Returns all the layout sets where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @return the matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid_Head(
		String layoutSetPrototypeUuid, boolean head) {

		return getPersistence().findByLayoutSetPrototypeUuid_Head(
			layoutSetPrototypeUuid, head);
	}

	/**
	 * Returns a range of all the layout sets where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid_Head(
		String layoutSetPrototypeUuid, boolean head, int start, int end) {

		return getPersistence().findByLayoutSetPrototypeUuid_Head(
			layoutSetPrototypeUuid, head, start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid_Head(
		String layoutSetPrototypeUuid, boolean head, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findByLayoutSetPrototypeUuid_Head(
			layoutSetPrototypeUuid, head, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByLayoutSetPrototypeUuid_Head(
		String layoutSetPrototypeUuid, boolean head, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByLayoutSetPrototypeUuid_Head(
			layoutSetPrototypeUuid, head, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first layout set in the ordered set where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByLayoutSetPrototypeUuid_Head_First(
			String layoutSetPrototypeUuid, boolean head,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByLayoutSetPrototypeUuid_Head_First(
			layoutSetPrototypeUuid, head, orderByComparator);
	}

	/**
	 * Returns the first layout set in the ordered set where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByLayoutSetPrototypeUuid_Head_First(
		String layoutSetPrototypeUuid, boolean head,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByLayoutSetPrototypeUuid_Head_First(
			layoutSetPrototypeUuid, head, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByLayoutSetPrototypeUuid_Head_Last(
			String layoutSetPrototypeUuid, boolean head,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByLayoutSetPrototypeUuid_Head_Last(
			layoutSetPrototypeUuid, head, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByLayoutSetPrototypeUuid_Head_Last(
		String layoutSetPrototypeUuid, boolean head,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByLayoutSetPrototypeUuid_Head_Last(
			layoutSetPrototypeUuid, head, orderByComparator);
	}

	/**
	 * Returns the layout sets before and after the current layout set in the ordered set where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetId the primary key of the current layout set
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet[] findByLayoutSetPrototypeUuid_Head_PrevAndNext(
			long layoutSetId, String layoutSetPrototypeUuid, boolean head,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByLayoutSetPrototypeUuid_Head_PrevAndNext(
			layoutSetId, layoutSetPrototypeUuid, head, orderByComparator);
	}

	/**
	 * Removes all the layout sets where layoutSetPrototypeUuid = &#63; and head = &#63; from the database.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 */
	public static void removeByLayoutSetPrototypeUuid_Head(
		String layoutSetPrototypeUuid, boolean head) {

		getPersistence().removeByLayoutSetPrototypeUuid_Head(
			layoutSetPrototypeUuid, head);
	}

	/**
	 * Returns the number of layout sets where layoutSetPrototypeUuid = &#63; and head = &#63;.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid
	 * @param head the head
	 * @return the number of matching layout sets
	 */
	public static int countByLayoutSetPrototypeUuid_Head(
		String layoutSetPrototypeUuid, boolean head) {

		return getPersistence().countByLayoutSetPrototypeUuid_Head(
			layoutSetPrototypeUuid, head);
	}

	/**
	 * Returns all the layout sets where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @return the matching layout sets
	 */
	public static List<LayoutSet> findByG_P(
		long groupId, boolean privateLayout) {

		return getPersistence().findByG_P(groupId, privateLayout);
	}

	/**
	 * Returns a range of all the layout sets where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of matching layout sets
	 */
	public static List<LayoutSet> findByG_P(
		long groupId, boolean privateLayout, int start, int end) {

		return getPersistence().findByG_P(groupId, privateLayout, start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByG_P(
		long groupId, boolean privateLayout, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findByG_P(
			groupId, privateLayout, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets where groupId = &#63; and privateLayout = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByG_P(
		long groupId, boolean privateLayout, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByG_P(
			groupId, privateLayout, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first layout set in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByG_P_First(
			long groupId, boolean privateLayout,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByG_P_First(
			groupId, privateLayout, orderByComparator);
	}

	/**
	 * Returns the first layout set in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByG_P_First(
		long groupId, boolean privateLayout,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByG_P_First(
			groupId, privateLayout, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByG_P_Last(
			long groupId, boolean privateLayout,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByG_P_Last(
			groupId, privateLayout, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByG_P_Last(
		long groupId, boolean privateLayout,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByG_P_Last(
			groupId, privateLayout, orderByComparator);
	}

	/**
	 * Returns the layout sets before and after the current layout set in the ordered set where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param layoutSetId the primary key of the current layout set
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet[] findByG_P_PrevAndNext(
			long layoutSetId, long groupId, boolean privateLayout,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByG_P_PrevAndNext(
			layoutSetId, groupId, privateLayout, orderByComparator);
	}

	/**
	 * Removes all the layout sets where groupId = &#63; and privateLayout = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 */
	public static void removeByG_P(long groupId, boolean privateLayout) {
		getPersistence().removeByG_P(groupId, privateLayout);
	}

	/**
	 * Returns the number of layout sets where groupId = &#63; and privateLayout = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @return the number of matching layout sets
	 */
	public static int countByG_P(long groupId, boolean privateLayout) {
		return getPersistence().countByG_P(groupId, privateLayout);
	}

	/**
	 * Returns the layout set where groupId = &#63; and privateLayout = &#63; and head = &#63; or throws a <code>NoSuchLayoutSetException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param head the head
	 * @return the matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByG_P_Head(
			long groupId, boolean privateLayout, boolean head)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByG_P_Head(groupId, privateLayout, head);
	}

	/**
	 * Returns the layout set where groupId = &#63; and privateLayout = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param head the head
	 * @return the matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByG_P_Head(
		long groupId, boolean privateLayout, boolean head) {

		return getPersistence().fetchByG_P_Head(groupId, privateLayout, head);
	}

	/**
	 * Returns the layout set where groupId = &#63; and privateLayout = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param head the head
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByG_P_Head(
		long groupId, boolean privateLayout, boolean head,
		boolean retrieveFromCache) {

		return getPersistence().fetchByG_P_Head(
			groupId, privateLayout, head, retrieveFromCache);
	}

	/**
	 * Removes the layout set where groupId = &#63; and privateLayout = &#63; and head = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param head the head
	 * @return the layout set that was removed
	 */
	public static LayoutSet removeByG_P_Head(
			long groupId, boolean privateLayout, boolean head)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().removeByG_P_Head(groupId, privateLayout, head);
	}

	/**
	 * Returns the number of layout sets where groupId = &#63; and privateLayout = &#63; and head = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayout the private layout
	 * @param head the head
	 * @return the number of matching layout sets
	 */
	public static int countByG_P_Head(
		long groupId, boolean privateLayout, boolean head) {

		return getPersistence().countByG_P_Head(groupId, privateLayout, head);
	}

	/**
	 * Returns all the layout sets where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @return the matching layout sets
	 */
	public static List<LayoutSet> findByP_L(
		boolean privateLayout, long logoId) {

		return getPersistence().findByP_L(privateLayout, logoId);
	}

	/**
	 * Returns a range of all the layout sets where privateLayout = &#63; and logoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of matching layout sets
	 */
	public static List<LayoutSet> findByP_L(
		boolean privateLayout, long logoId, int start, int end) {

		return getPersistence().findByP_L(privateLayout, logoId, start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets where privateLayout = &#63; and logoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByP_L(
		boolean privateLayout, long logoId, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findByP_L(
			privateLayout, logoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets where privateLayout = &#63; and logoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching layout sets
	 */
	public static List<LayoutSet> findByP_L(
		boolean privateLayout, long logoId, int start, int end,
		OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByP_L(
			privateLayout, logoId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first layout set in the ordered set where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByP_L_First(
			boolean privateLayout, long logoId,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByP_L_First(
			privateLayout, logoId, orderByComparator);
	}

	/**
	 * Returns the first layout set in the ordered set where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByP_L_First(
		boolean privateLayout, long logoId,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByP_L_First(
			privateLayout, logoId, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByP_L_Last(
			boolean privateLayout, long logoId,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByP_L_Last(
			privateLayout, logoId, orderByComparator);
	}

	/**
	 * Returns the last layout set in the ordered set where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByP_L_Last(
		boolean privateLayout, long logoId,
		OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().fetchByP_L_Last(
			privateLayout, logoId, orderByComparator);
	}

	/**
	 * Returns the layout sets before and after the current layout set in the ordered set where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param layoutSetId the primary key of the current layout set
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet[] findByP_L_PrevAndNext(
			long layoutSetId, boolean privateLayout, long logoId,
			OrderByComparator<LayoutSet> orderByComparator)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByP_L_PrevAndNext(
			layoutSetId, privateLayout, logoId, orderByComparator);
	}

	/**
	 * Removes all the layout sets where privateLayout = &#63; and logoId = &#63; from the database.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 */
	public static void removeByP_L(boolean privateLayout, long logoId) {
		getPersistence().removeByP_L(privateLayout, logoId);
	}

	/**
	 * Returns the number of layout sets where privateLayout = &#63; and logoId = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @return the number of matching layout sets
	 */
	public static int countByP_L(boolean privateLayout, long logoId) {
		return getPersistence().countByP_L(privateLayout, logoId);
	}

	/**
	 * Returns the layout set where privateLayout = &#63; and logoId = &#63; and head = &#63; or throws a <code>NoSuchLayoutSetException</code> if it could not be found.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param head the head
	 * @return the matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByP_L_Head(
			boolean privateLayout, long logoId, boolean head)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByP_L_Head(privateLayout, logoId, head);
	}

	/**
	 * Returns the layout set where privateLayout = &#63; and logoId = &#63; and head = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param head the head
	 * @return the matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByP_L_Head(
		boolean privateLayout, long logoId, boolean head) {

		return getPersistence().fetchByP_L_Head(privateLayout, logoId, head);
	}

	/**
	 * Returns the layout set where privateLayout = &#63; and logoId = &#63; and head = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param head the head
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByP_L_Head(
		boolean privateLayout, long logoId, boolean head,
		boolean retrieveFromCache) {

		return getPersistence().fetchByP_L_Head(
			privateLayout, logoId, head, retrieveFromCache);
	}

	/**
	 * Removes the layout set where privateLayout = &#63; and logoId = &#63; and head = &#63; from the database.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param head the head
	 * @return the layout set that was removed
	 */
	public static LayoutSet removeByP_L_Head(
			boolean privateLayout, long logoId, boolean head)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().removeByP_L_Head(privateLayout, logoId, head);
	}

	/**
	 * Returns the number of layout sets where privateLayout = &#63; and logoId = &#63; and head = &#63;.
	 *
	 * @param privateLayout the private layout
	 * @param logoId the logo ID
	 * @param head the head
	 * @return the number of matching layout sets
	 */
	public static int countByP_L_Head(
		boolean privateLayout, long logoId, boolean head) {

		return getPersistence().countByP_L_Head(privateLayout, logoId, head);
	}

	/**
	 * Returns the layout set where headId = &#63; or throws a <code>NoSuchLayoutSetException</code> if it could not be found.
	 *
	 * @param headId the head ID
	 * @return the matching layout set
	 * @throws NoSuchLayoutSetException if a matching layout set could not be found
	 */
	public static LayoutSet findByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByHeadId(headId);
	}

	/**
	 * Returns the layout set where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headId the head ID
	 * @return the matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByHeadId(long headId) {
		return getPersistence().fetchByHeadId(headId);
	}

	/**
	 * Returns the layout set where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headId the head ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching layout set, or <code>null</code> if a matching layout set could not be found
	 */
	public static LayoutSet fetchByHeadId(
		long headId, boolean retrieveFromCache) {

		return getPersistence().fetchByHeadId(headId, retrieveFromCache);
	}

	/**
	 * Removes the layout set where headId = &#63; from the database.
	 *
	 * @param headId the head ID
	 * @return the layout set that was removed
	 */
	public static LayoutSet removeByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().removeByHeadId(headId);
	}

	/**
	 * Returns the number of layout sets where headId = &#63;.
	 *
	 * @param headId the head ID
	 * @return the number of matching layout sets
	 */
	public static int countByHeadId(long headId) {
		return getPersistence().countByHeadId(headId);
	}

	/**
	 * Caches the layout set in the entity cache if it is enabled.
	 *
	 * @param layoutSet the layout set
	 */
	public static void cacheResult(LayoutSet layoutSet) {
		getPersistence().cacheResult(layoutSet);
	}

	/**
	 * Caches the layout sets in the entity cache if it is enabled.
	 *
	 * @param layoutSets the layout sets
	 */
	public static void cacheResult(List<LayoutSet> layoutSets) {
		getPersistence().cacheResult(layoutSets);
	}

	/**
	 * Creates a new layout set with the primary key. Does not add the layout set to the database.
	 *
	 * @param layoutSetId the primary key for the new layout set
	 * @return the new layout set
	 */
	public static LayoutSet create(long layoutSetId) {
		return getPersistence().create(layoutSetId);
	}

	/**
	 * Removes the layout set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param layoutSetId the primary key of the layout set
	 * @return the layout set that was removed
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet remove(long layoutSetId)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().remove(layoutSetId);
	}

	public static LayoutSet updateImpl(LayoutSet layoutSet) {
		return getPersistence().updateImpl(layoutSet);
	}

	/**
	 * Returns the layout set with the primary key or throws a <code>NoSuchLayoutSetException</code> if it could not be found.
	 *
	 * @param layoutSetId the primary key of the layout set
	 * @return the layout set
	 * @throws NoSuchLayoutSetException if a layout set with the primary key could not be found
	 */
	public static LayoutSet findByPrimaryKey(long layoutSetId)
		throws com.liferay.portal.kernel.exception.NoSuchLayoutSetException {

		return getPersistence().findByPrimaryKey(layoutSetId);
	}

	/**
	 * Returns the layout set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param layoutSetId the primary key of the layout set
	 * @return the layout set, or <code>null</code> if a layout set with the primary key could not be found
	 */
	public static LayoutSet fetchByPrimaryKey(long layoutSetId) {
		return getPersistence().fetchByPrimaryKey(layoutSetId);
	}

	/**
	 * Returns all the layout sets.
	 *
	 * @return the layout sets
	 */
	public static List<LayoutSet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the layout sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @return the range of layout sets
	 */
	public static List<LayoutSet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the layout sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of layout sets
	 */
	public static List<LayoutSet> findAll(
		int start, int end, OrderByComparator<LayoutSet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the layout sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LayoutSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of layout sets
	 * @param end the upper bound of the range of layout sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of layout sets
	 */
	public static List<LayoutSet> findAll(
		int start, int end, OrderByComparator<LayoutSet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the layout sets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of layout sets.
	 *
	 * @return the number of layout sets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LayoutSetPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LayoutSetPersistence)PortalBeanLocatorUtil.locate(
				LayoutSetPersistence.class.getName());
		}

		return _persistence;
	}

	private static LayoutSetPersistence _persistence;

}
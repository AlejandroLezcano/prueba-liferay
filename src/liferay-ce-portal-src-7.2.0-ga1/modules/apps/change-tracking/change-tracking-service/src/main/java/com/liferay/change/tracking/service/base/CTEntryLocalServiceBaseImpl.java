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

package com.liferay.change.tracking.service.base;

import com.liferay.change.tracking.model.CTEntry;
import com.liferay.change.tracking.service.CTEntryLocalService;
import com.liferay.change.tracking.service.persistence.CTCollectionPersistence;
import com.liferay.change.tracking.service.persistence.CTEntryAggregateFinder;
import com.liferay.change.tracking.service.persistence.CTEntryAggregatePersistence;
import com.liferay.change.tracking.service.persistence.CTEntryFinder;
import com.liferay.change.tracking.service.persistence.CTEntryPersistence;
import com.liferay.change.tracking.service.persistence.CTProcessFinder;
import com.liferay.change.tracking.service.persistence.CTProcessPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the ct entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.change.tracking.service.impl.CTEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.change.tracking.service.impl.CTEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class CTEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CTEntryLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CTEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.change.tracking.service.CTEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ct entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntry the ct entry
	 * @return the ct entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CTEntry addCTEntry(CTEntry ctEntry) {
		ctEntry.setNew(true);

		return ctEntryPersistence.update(ctEntry);
	}

	/**
	 * Creates a new ct entry with the primary key. Does not add the ct entry to the database.
	 *
	 * @param ctEntryId the primary key for the new ct entry
	 * @return the new ct entry
	 */
	@Override
	@Transactional(enabled = false)
	public CTEntry createCTEntry(long ctEntryId) {
		return ctEntryPersistence.create(ctEntryId);
	}

	/**
	 * Deletes the ct entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntryId the primary key of the ct entry
	 * @return the ct entry that was removed
	 * @throws PortalException if a ct entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CTEntry deleteCTEntry(long ctEntryId) throws PortalException {
		return ctEntryPersistence.remove(ctEntryId);
	}

	/**
	 * Deletes the ct entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntry the ct entry
	 * @return the ct entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CTEntry deleteCTEntry(CTEntry ctEntry) {
		return ctEntryPersistence.remove(ctEntry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CTEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ctEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.change.tracking.model.impl.CTEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return ctEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.change.tracking.model.impl.CTEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return ctEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ctEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return ctEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CTEntry fetchCTEntry(long ctEntryId) {
		return ctEntryPersistence.fetchByPrimaryKey(ctEntryId);
	}

	/**
	 * Returns the ct entry with the primary key.
	 *
	 * @param ctEntryId the primary key of the ct entry
	 * @return the ct entry
	 * @throws PortalException if a ct entry with the primary key could not be found
	 */
	@Override
	public CTEntry getCTEntry(long ctEntryId) throws PortalException {
		return ctEntryPersistence.findByPrimaryKey(ctEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ctEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CTEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ctEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ctEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CTEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("ctEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ctEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CTEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ctEntryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ctEntryLocalService.deleteCTEntry((CTEntry)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ctEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ct entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.change.tracking.model.impl.CTEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ct entries
	 * @param end the upper bound of the range of ct entries (not inclusive)
	 * @return the range of ct entries
	 */
	@Override
	public List<CTEntry> getCTEntries(int start, int end) {
		return ctEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ct entries.
	 *
	 * @return the number of ct entries
	 */
	@Override
	public int getCTEntriesCount() {
		return ctEntryPersistence.countAll();
	}

	/**
	 * Updates the ct entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntry the ct entry
	 * @return the ct entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CTEntry updateCTEntry(CTEntry ctEntry) {
		return ctEntryPersistence.update(ctEntry);
	}

	/**
	 */
	@Override
	public void addCTEntryAggregateCTEntry(
		long ctEntryAggregateId, long ctEntryId) {

		ctEntryAggregatePersistence.addCTEntry(ctEntryAggregateId, ctEntryId);
	}

	/**
	 */
	@Override
	public void addCTEntryAggregateCTEntry(
		long ctEntryAggregateId, CTEntry ctEntry) {

		ctEntryAggregatePersistence.addCTEntry(ctEntryAggregateId, ctEntry);
	}

	/**
	 */
	@Override
	public void addCTEntryAggregateCTEntries(
		long ctEntryAggregateId, long[] ctEntryIds) {

		ctEntryAggregatePersistence.addCTEntries(
			ctEntryAggregateId, ctEntryIds);
	}

	/**
	 */
	@Override
	public void addCTEntryAggregateCTEntries(
		long ctEntryAggregateId, List<CTEntry> ctEntries) {

		ctEntryAggregatePersistence.addCTEntries(ctEntryAggregateId, ctEntries);
	}

	/**
	 */
	@Override
	public void clearCTEntryAggregateCTEntries(long ctEntryAggregateId) {
		ctEntryAggregatePersistence.clearCTEntries(ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public void deleteCTEntryAggregateCTEntry(
		long ctEntryAggregateId, long ctEntryId) {

		ctEntryAggregatePersistence.removeCTEntry(
			ctEntryAggregateId, ctEntryId);
	}

	/**
	 */
	@Override
	public void deleteCTEntryAggregateCTEntry(
		long ctEntryAggregateId, CTEntry ctEntry) {

		ctEntryAggregatePersistence.removeCTEntry(ctEntryAggregateId, ctEntry);
	}

	/**
	 */
	@Override
	public void deleteCTEntryAggregateCTEntries(
		long ctEntryAggregateId, long[] ctEntryIds) {

		ctEntryAggregatePersistence.removeCTEntries(
			ctEntryAggregateId, ctEntryIds);
	}

	/**
	 */
	@Override
	public void deleteCTEntryAggregateCTEntries(
		long ctEntryAggregateId, List<CTEntry> ctEntries) {

		ctEntryAggregatePersistence.removeCTEntries(
			ctEntryAggregateId, ctEntries);
	}

	/**
	 * Returns the ctEntryAggregateIds of the ct entry aggregates associated with the ct entry.
	 *
	 * @param ctEntryId the ctEntryId of the ct entry
	 * @return long[] the ctEntryAggregateIds of ct entry aggregates associated with the ct entry
	 */
	@Override
	public long[] getCTEntryAggregatePrimaryKeys(long ctEntryId) {
		return ctEntryPersistence.getCTEntryAggregatePrimaryKeys(ctEntryId);
	}

	/**
	 */
	@Override
	public List<CTEntry> getCTEntryAggregateCTEntries(long ctEntryAggregateId) {
		return ctEntryPersistence.getCTEntryAggregateCTEntries(
			ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public List<CTEntry> getCTEntryAggregateCTEntries(
		long ctEntryAggregateId, int start, int end) {

		return ctEntryPersistence.getCTEntryAggregateCTEntries(
			ctEntryAggregateId, start, end);
	}

	/**
	 */
	@Override
	public List<CTEntry> getCTEntryAggregateCTEntries(
		long ctEntryAggregateId, int start, int end,
		OrderByComparator<CTEntry> orderByComparator) {

		return ctEntryPersistence.getCTEntryAggregateCTEntries(
			ctEntryAggregateId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getCTEntryAggregateCTEntriesCount(long ctEntryAggregateId) {
		return ctEntryAggregatePersistence.getCTEntriesSize(ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public boolean hasCTEntryAggregateCTEntry(
		long ctEntryAggregateId, long ctEntryId) {

		return ctEntryAggregatePersistence.containsCTEntry(
			ctEntryAggregateId, ctEntryId);
	}

	/**
	 */
	@Override
	public boolean hasCTEntryAggregateCTEntries(long ctEntryAggregateId) {
		return ctEntryAggregatePersistence.containsCTEntries(
			ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public void setCTEntryAggregateCTEntries(
		long ctEntryAggregateId, long[] ctEntryIds) {

		ctEntryAggregatePersistence.setCTEntries(
			ctEntryAggregateId, ctEntryIds);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntry(long ctCollectionId, long ctEntryId) {
		ctCollectionPersistence.addCTEntry(ctCollectionId, ctEntryId);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntry(long ctCollectionId, CTEntry ctEntry) {
		ctCollectionPersistence.addCTEntry(ctCollectionId, ctEntry);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntries(
		long ctCollectionId, long[] ctEntryIds) {

		ctCollectionPersistence.addCTEntries(ctCollectionId, ctEntryIds);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntries(
		long ctCollectionId, List<CTEntry> ctEntries) {

		ctCollectionPersistence.addCTEntries(ctCollectionId, ctEntries);
	}

	/**
	 */
	@Override
	public void clearCTCollectionCTEntries(long ctCollectionId) {
		ctCollectionPersistence.clearCTEntries(ctCollectionId);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntry(long ctCollectionId, long ctEntryId) {
		ctCollectionPersistence.removeCTEntry(ctCollectionId, ctEntryId);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntry(
		long ctCollectionId, CTEntry ctEntry) {

		ctCollectionPersistence.removeCTEntry(ctCollectionId, ctEntry);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntries(
		long ctCollectionId, long[] ctEntryIds) {

		ctCollectionPersistence.removeCTEntries(ctCollectionId, ctEntryIds);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntries(
		long ctCollectionId, List<CTEntry> ctEntries) {

		ctCollectionPersistence.removeCTEntries(ctCollectionId, ctEntries);
	}

	/**
	 * Returns the ctCollectionIds of the ct collections associated with the ct entry.
	 *
	 * @param ctEntryId the ctEntryId of the ct entry
	 * @return long[] the ctCollectionIds of ct collections associated with the ct entry
	 */
	@Override
	public long[] getCTCollectionPrimaryKeys(long ctEntryId) {
		return ctEntryPersistence.getCTCollectionPrimaryKeys(ctEntryId);
	}

	/**
	 */
	@Override
	public List<CTEntry> getCTCollectionCTEntries(long ctCollectionId) {
		return ctEntryPersistence.getCTCollectionCTEntries(ctCollectionId);
	}

	/**
	 */
	@Override
	public List<CTEntry> getCTCollectionCTEntries(
		long ctCollectionId, int start, int end) {

		return ctEntryPersistence.getCTCollectionCTEntries(
			ctCollectionId, start, end);
	}

	/**
	 */
	@Override
	public List<CTEntry> getCTCollectionCTEntries(
		long ctCollectionId, int start, int end,
		OrderByComparator<CTEntry> orderByComparator) {

		return ctEntryPersistence.getCTCollectionCTEntries(
			ctCollectionId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getCTCollectionCTEntriesCount(long ctCollectionId) {
		return ctCollectionPersistence.getCTEntriesSize(ctCollectionId);
	}

	/**
	 */
	@Override
	public boolean hasCTCollectionCTEntry(long ctCollectionId, long ctEntryId) {
		return ctCollectionPersistence.containsCTEntry(
			ctCollectionId, ctEntryId);
	}

	/**
	 */
	@Override
	public boolean hasCTCollectionCTEntries(long ctCollectionId) {
		return ctCollectionPersistence.containsCTEntries(ctCollectionId);
	}

	/**
	 */
	@Override
	public void setCTCollectionCTEntries(
		long ctCollectionId, long[] ctEntryIds) {

		ctCollectionPersistence.setCTEntries(ctCollectionId, ctEntryIds);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CTEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ctEntryLocalService = (CTEntryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CTEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CTEntry.class;
	}

	protected String getModelClassName() {
		return CTEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ctEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected CTCollectionPersistence ctCollectionPersistence;

	protected CTEntryLocalService ctEntryLocalService;

	@Reference
	protected CTEntryPersistence ctEntryPersistence;

	@Reference
	protected CTEntryFinder ctEntryFinder;

	@Reference
	protected CTEntryAggregatePersistence ctEntryAggregatePersistence;

	@Reference
	protected CTEntryAggregateFinder ctEntryAggregateFinder;

	@Reference
	protected CTProcessPersistence ctProcessPersistence;

	@Reference
	protected CTProcessFinder ctProcessFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}
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

import com.liferay.change.tracking.model.CTEntryAggregate;
import com.liferay.change.tracking.service.CTEntryAggregateLocalService;
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
 * Provides the base implementation for the ct entry aggregate local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.change.tracking.service.impl.CTEntryAggregateLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.change.tracking.service.impl.CTEntryAggregateLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class CTEntryAggregateLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CTEntryAggregateLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CTEntryAggregateLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.change.tracking.service.CTEntryAggregateLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ct entry aggregate to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntryAggregate the ct entry aggregate
	 * @return the ct entry aggregate that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CTEntryAggregate addCTEntryAggregate(
		CTEntryAggregate ctEntryAggregate) {

		ctEntryAggregate.setNew(true);

		return ctEntryAggregatePersistence.update(ctEntryAggregate);
	}

	/**
	 * Creates a new ct entry aggregate with the primary key. Does not add the ct entry aggregate to the database.
	 *
	 * @param ctEntryAggregateId the primary key for the new ct entry aggregate
	 * @return the new ct entry aggregate
	 */
	@Override
	@Transactional(enabled = false)
	public CTEntryAggregate createCTEntryAggregate(long ctEntryAggregateId) {
		return ctEntryAggregatePersistence.create(ctEntryAggregateId);
	}

	/**
	 * Deletes the ct entry aggregate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntryAggregateId the primary key of the ct entry aggregate
	 * @return the ct entry aggregate that was removed
	 * @throws PortalException if a ct entry aggregate with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CTEntryAggregate deleteCTEntryAggregate(long ctEntryAggregateId)
		throws PortalException {

		return ctEntryAggregatePersistence.remove(ctEntryAggregateId);
	}

	/**
	 * Deletes the ct entry aggregate from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntryAggregate the ct entry aggregate
	 * @return the ct entry aggregate that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CTEntryAggregate deleteCTEntryAggregate(
		CTEntryAggregate ctEntryAggregate) {

		return ctEntryAggregatePersistence.remove(ctEntryAggregate);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CTEntryAggregate.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ctEntryAggregatePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.change.tracking.model.impl.CTEntryAggregateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return ctEntryAggregatePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.change.tracking.model.impl.CTEntryAggregateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return ctEntryAggregatePersistence.findWithDynamicQuery(
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
		return ctEntryAggregatePersistence.countWithDynamicQuery(dynamicQuery);
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

		return ctEntryAggregatePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CTEntryAggregate fetchCTEntryAggregate(long ctEntryAggregateId) {
		return ctEntryAggregatePersistence.fetchByPrimaryKey(
			ctEntryAggregateId);
	}

	/**
	 * Returns the ct entry aggregate with the primary key.
	 *
	 * @param ctEntryAggregateId the primary key of the ct entry aggregate
	 * @return the ct entry aggregate
	 * @throws PortalException if a ct entry aggregate with the primary key could not be found
	 */
	@Override
	public CTEntryAggregate getCTEntryAggregate(long ctEntryAggregateId)
		throws PortalException {

		return ctEntryAggregatePersistence.findByPrimaryKey(ctEntryAggregateId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			ctEntryAggregateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CTEntryAggregate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ctEntryAggregateId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ctEntryAggregateLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CTEntryAggregate.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"ctEntryAggregateId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			ctEntryAggregateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CTEntryAggregate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ctEntryAggregateId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ctEntryAggregateLocalService.deleteCTEntryAggregate(
			(CTEntryAggregate)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ctEntryAggregatePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ct entry aggregates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.change.tracking.model.impl.CTEntryAggregateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ct entry aggregates
	 * @param end the upper bound of the range of ct entry aggregates (not inclusive)
	 * @return the range of ct entry aggregates
	 */
	@Override
	public List<CTEntryAggregate> getCTEntryAggregates(int start, int end) {
		return ctEntryAggregatePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ct entry aggregates.
	 *
	 * @return the number of ct entry aggregates
	 */
	@Override
	public int getCTEntryAggregatesCount() {
		return ctEntryAggregatePersistence.countAll();
	}

	/**
	 * Updates the ct entry aggregate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ctEntryAggregate the ct entry aggregate
	 * @return the ct entry aggregate that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CTEntryAggregate updateCTEntryAggregate(
		CTEntryAggregate ctEntryAggregate) {

		return ctEntryAggregatePersistence.update(ctEntryAggregate);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntryAggregate(
		long ctCollectionId, long ctEntryAggregateId) {

		ctCollectionPersistence.addCTEntryAggregate(
			ctCollectionId, ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntryAggregate(
		long ctCollectionId, CTEntryAggregate ctEntryAggregate) {

		ctCollectionPersistence.addCTEntryAggregate(
			ctCollectionId, ctEntryAggregate);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntryAggregates(
		long ctCollectionId, long[] ctEntryAggregateIds) {

		ctCollectionPersistence.addCTEntryAggregates(
			ctCollectionId, ctEntryAggregateIds);
	}

	/**
	 */
	@Override
	public void addCTCollectionCTEntryAggregates(
		long ctCollectionId, List<CTEntryAggregate> ctEntryAggregates) {

		ctCollectionPersistence.addCTEntryAggregates(
			ctCollectionId, ctEntryAggregates);
	}

	/**
	 */
	@Override
	public void clearCTCollectionCTEntryAggregates(long ctCollectionId) {
		ctCollectionPersistence.clearCTEntryAggregates(ctCollectionId);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntryAggregate(
		long ctCollectionId, long ctEntryAggregateId) {

		ctCollectionPersistence.removeCTEntryAggregate(
			ctCollectionId, ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntryAggregate(
		long ctCollectionId, CTEntryAggregate ctEntryAggregate) {

		ctCollectionPersistence.removeCTEntryAggregate(
			ctCollectionId, ctEntryAggregate);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntryAggregates(
		long ctCollectionId, long[] ctEntryAggregateIds) {

		ctCollectionPersistence.removeCTEntryAggregates(
			ctCollectionId, ctEntryAggregateIds);
	}

	/**
	 */
	@Override
	public void deleteCTCollectionCTEntryAggregates(
		long ctCollectionId, List<CTEntryAggregate> ctEntryAggregates) {

		ctCollectionPersistence.removeCTEntryAggregates(
			ctCollectionId, ctEntryAggregates);
	}

	/**
	 * Returns the ctCollectionIds of the ct collections associated with the ct entry aggregate.
	 *
	 * @param ctEntryAggregateId the ctEntryAggregateId of the ct entry aggregate
	 * @return long[] the ctCollectionIds of ct collections associated with the ct entry aggregate
	 */
	@Override
	public long[] getCTCollectionPrimaryKeys(long ctEntryAggregateId) {
		return ctEntryAggregatePersistence.getCTCollectionPrimaryKeys(
			ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public List<CTEntryAggregate> getCTCollectionCTEntryAggregates(
		long ctCollectionId) {

		return ctEntryAggregatePersistence.getCTCollectionCTEntryAggregates(
			ctCollectionId);
	}

	/**
	 */
	@Override
	public List<CTEntryAggregate> getCTCollectionCTEntryAggregates(
		long ctCollectionId, int start, int end) {

		return ctEntryAggregatePersistence.getCTCollectionCTEntryAggregates(
			ctCollectionId, start, end);
	}

	/**
	 */
	@Override
	public List<CTEntryAggregate> getCTCollectionCTEntryAggregates(
		long ctCollectionId, int start, int end,
		OrderByComparator<CTEntryAggregate> orderByComparator) {

		return ctEntryAggregatePersistence.getCTCollectionCTEntryAggregates(
			ctCollectionId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getCTCollectionCTEntryAggregatesCount(long ctCollectionId) {
		return ctCollectionPersistence.getCTEntryAggregatesSize(ctCollectionId);
	}

	/**
	 */
	@Override
	public boolean hasCTCollectionCTEntryAggregate(
		long ctCollectionId, long ctEntryAggregateId) {

		return ctCollectionPersistence.containsCTEntryAggregate(
			ctCollectionId, ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public boolean hasCTCollectionCTEntryAggregates(long ctCollectionId) {
		return ctCollectionPersistence.containsCTEntryAggregates(
			ctCollectionId);
	}

	/**
	 */
	@Override
	public void setCTCollectionCTEntryAggregates(
		long ctCollectionId, long[] ctEntryAggregateIds) {

		ctCollectionPersistence.setCTEntryAggregates(
			ctCollectionId, ctEntryAggregateIds);
	}

	/**
	 */
	@Override
	public void addCTEntryCTEntryAggregate(
		long ctEntryId, long ctEntryAggregateId) {

		ctEntryPersistence.addCTEntryAggregate(ctEntryId, ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public void addCTEntryCTEntryAggregate(
		long ctEntryId, CTEntryAggregate ctEntryAggregate) {

		ctEntryPersistence.addCTEntryAggregate(ctEntryId, ctEntryAggregate);
	}

	/**
	 */
	@Override
	public void addCTEntryCTEntryAggregates(
		long ctEntryId, long[] ctEntryAggregateIds) {

		ctEntryPersistence.addCTEntryAggregates(ctEntryId, ctEntryAggregateIds);
	}

	/**
	 */
	@Override
	public void addCTEntryCTEntryAggregates(
		long ctEntryId, List<CTEntryAggregate> ctEntryAggregates) {

		ctEntryPersistence.addCTEntryAggregates(ctEntryId, ctEntryAggregates);
	}

	/**
	 */
	@Override
	public void clearCTEntryCTEntryAggregates(long ctEntryId) {
		ctEntryPersistence.clearCTEntryAggregates(ctEntryId);
	}

	/**
	 */
	@Override
	public void deleteCTEntryCTEntryAggregate(
		long ctEntryId, long ctEntryAggregateId) {

		ctEntryPersistence.removeCTEntryAggregate(
			ctEntryId, ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public void deleteCTEntryCTEntryAggregate(
		long ctEntryId, CTEntryAggregate ctEntryAggregate) {

		ctEntryPersistence.removeCTEntryAggregate(ctEntryId, ctEntryAggregate);
	}

	/**
	 */
	@Override
	public void deleteCTEntryCTEntryAggregates(
		long ctEntryId, long[] ctEntryAggregateIds) {

		ctEntryPersistence.removeCTEntryAggregates(
			ctEntryId, ctEntryAggregateIds);
	}

	/**
	 */
	@Override
	public void deleteCTEntryCTEntryAggregates(
		long ctEntryId, List<CTEntryAggregate> ctEntryAggregates) {

		ctEntryPersistence.removeCTEntryAggregates(
			ctEntryId, ctEntryAggregates);
	}

	/**
	 * Returns the ctEntryIds of the ct entries associated with the ct entry aggregate.
	 *
	 * @param ctEntryAggregateId the ctEntryAggregateId of the ct entry aggregate
	 * @return long[] the ctEntryIds of ct entries associated with the ct entry aggregate
	 */
	@Override
	public long[] getCTEntryPrimaryKeys(long ctEntryAggregateId) {
		return ctEntryAggregatePersistence.getCTEntryPrimaryKeys(
			ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public List<CTEntryAggregate> getCTEntryCTEntryAggregates(long ctEntryId) {
		return ctEntryAggregatePersistence.getCTEntryCTEntryAggregates(
			ctEntryId);
	}

	/**
	 */
	@Override
	public List<CTEntryAggregate> getCTEntryCTEntryAggregates(
		long ctEntryId, int start, int end) {

		return ctEntryAggregatePersistence.getCTEntryCTEntryAggregates(
			ctEntryId, start, end);
	}

	/**
	 */
	@Override
	public List<CTEntryAggregate> getCTEntryCTEntryAggregates(
		long ctEntryId, int start, int end,
		OrderByComparator<CTEntryAggregate> orderByComparator) {

		return ctEntryAggregatePersistence.getCTEntryCTEntryAggregates(
			ctEntryId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getCTEntryCTEntryAggregatesCount(long ctEntryId) {
		return ctEntryPersistence.getCTEntryAggregatesSize(ctEntryId);
	}

	/**
	 */
	@Override
	public boolean hasCTEntryCTEntryAggregate(
		long ctEntryId, long ctEntryAggregateId) {

		return ctEntryPersistence.containsCTEntryAggregate(
			ctEntryId, ctEntryAggregateId);
	}

	/**
	 */
	@Override
	public boolean hasCTEntryCTEntryAggregates(long ctEntryId) {
		return ctEntryPersistence.containsCTEntryAggregates(ctEntryId);
	}

	/**
	 */
	@Override
	public void setCTEntryCTEntryAggregates(
		long ctEntryId, long[] ctEntryAggregateIds) {

		ctEntryPersistence.setCTEntryAggregates(ctEntryId, ctEntryAggregateIds);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CTEntryAggregateLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ctEntryAggregateLocalService = (CTEntryAggregateLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CTEntryAggregateLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CTEntryAggregate.class;
	}

	protected String getModelClassName() {
		return CTEntryAggregate.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ctEntryAggregatePersistence.getDataSource();

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

	@Reference
	protected CTEntryPersistence ctEntryPersistence;

	@Reference
	protected CTEntryFinder ctEntryFinder;

	protected CTEntryAggregateLocalService ctEntryAggregateLocalService;

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
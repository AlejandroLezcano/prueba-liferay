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

package com.liferay.message.boards.comment.internal;

import com.liferay.comment.constants.CommentConstants;
import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.model.MBDiscussion;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBMessageDisplay;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.model.MBTreeWalker;
import com.liferay.message.boards.service.MBDiscussionLocalService;
import com.liferay.message.boards.service.MBMessageLocalService;
import com.liferay.message.boards.service.MBThreadLocalService;
import com.liferay.message.boards.util.comparator.MessageThreadComparator;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.comment.Comment;
import com.liferay.portal.kernel.comment.CommentManager;
import com.liferay.portal.kernel.comment.Discussion;
import com.liferay.portal.kernel.comment.DiscussionComment;
import com.liferay.portal.kernel.comment.DiscussionPermission;
import com.liferay.portal.kernel.comment.DiscussionStagingHandler;
import com.liferay.portal.kernel.comment.DuplicateCommentException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.model.RatingsEntry;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsEntryLocalService;
import com.liferay.ratings.kernel.service.RatingsStatsLocalService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 * @author Alexander Chow
 * @author Raymond Augé
 */
@Component(service = CommentManager.class)
public class MBCommentManagerImpl implements CommentManager {

	@Override
	public long addComment(
			long userId, long groupId, String className, long classPK,
			String body,
			Function<String, ServiceContext> serviceContextFunction)
		throws PortalException {

		MBMessageDisplay messageDisplay =
			_mbMessageLocalService.getDiscussionMessageDisplay(
				userId, groupId, className, classPK,
				WorkflowConstants.STATUS_APPROVED);

		MBThread thread = messageDisplay.getThread();

		List<MBMessage> messages = _mbMessageLocalService.getThreadMessages(
			thread.getThreadId(), WorkflowConstants.STATUS_APPROVED);

		for (MBMessage message : messages) {
			String messageBody = message.getBody();

			if (messageBody.equals(body)) {
				throw new DuplicateCommentException(body);
			}
		}

		ServiceContext serviceContext = serviceContextFunction.apply(
			MBMessage.class.getName());

		MBMessage mbMessage = _mbMessageLocalService.addDiscussionMessage(
			userId, StringPool.BLANK, groupId, className, classPK,
			thread.getThreadId(), thread.getRootMessageId(), StringPool.BLANK,
			body, serviceContext);

		return mbMessage.getMessageId();
	}

	@Override
	public long addComment(
			long userId, long groupId, String className, long classPK,
			String userName, String subject, String body,
			Function<String, ServiceContext> serviceContextFunction)
		throws PortalException {

		MBMessageDisplay mbMessageDisplay =
			_mbMessageLocalService.getDiscussionMessageDisplay(
				userId, groupId, className, classPK,
				WorkflowConstants.STATUS_APPROVED);

		MBThread mbThread = mbMessageDisplay.getThread();

		ServiceContext serviceContext = serviceContextFunction.apply(
			MBMessage.class.getName());

		MBMessage mbMessage = _mbMessageLocalService.addDiscussionMessage(
			userId, userName, groupId, className, classPK,
			mbThread.getThreadId(), mbThread.getRootMessageId(), subject, body,
			serviceContext);

		return mbMessage.getMessageId();
	}

	@Override
	public long addComment(
			long userId, String className, long classPK, String userName,
			long parentCommentId, String subject, String body,
			Function<String, ServiceContext> serviceContextFunction)
		throws PortalException {

		MBMessage parentMessage = _mbMessageLocalService.getMessage(
			parentCommentId);

		ServiceContext serviceContext = serviceContextFunction.apply(
			MBMessage.class.getName());

		MBMessage mbMessage = _mbMessageLocalService.addDiscussionMessage(
			userId, userName, parentMessage.getGroupId(), className, classPK,
			parentMessage.getThreadId(), parentCommentId, subject, body,
			serviceContext);

		return mbMessage.getMessageId();
	}

	@Override
	public void addDiscussion(
			long userId, long groupId, String className, long classPK,
			String userName)
		throws PortalException {

		_mbMessageLocalService.addDiscussionMessage(
			userId, userName, groupId, className, classPK,
			WorkflowConstants.ACTION_PUBLISH);
	}

	@Override
	public void deleteComment(long commentId) throws PortalException {
		_mbMessageLocalService.deleteDiscussionMessage(commentId);
	}

	@Override
	public void deleteDiscussion(String className, long classPK)
		throws PortalException {

		_mbMessageLocalService.deleteDiscussionMessages(className, classPK);
	}

	@Override
	public void deleteGroupComments(long groupId) throws PortalException {
		_mbThreadLocalService.deleteThreads(
			groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID);
	}

	@Override
	public Comment fetchComment(long commentId) {
		MBMessage mbMessage = _mbMessageLocalService.fetchMBMessage(commentId);

		if (mbMessage == null) {
			return null;
		}

		return new MBCommentImpl(mbMessage);
	}

	@Override
	public DiscussionComment fetchDiscussionComment(long userId, long commentId)
		throws PortalException {

		MBMessage mbMessage = _mbMessageLocalService.fetchMBMessage(commentId);

		if (mbMessage == null) {
			return null;
		}

		MBMessageDisplay messageDisplay =
			_mbMessageLocalService.getDiscussionMessageDisplay(
				userId, mbMessage.getGroupId(), mbMessage.getClassName(),
				mbMessage.getClassPK(), WorkflowConstants.STATUS_ANY,
				new MessageThreadComparator());

		return getDiscussionComment(userId, messageDisplay);
	}

	@Override
	public List<Comment> getChildComments(
		long parentCommentId, int status, int start, int end) {

		return Stream.of(
			_mbMessageLocalService.getChildMessages(
				parentCommentId, status, start, end)
		).flatMap(
			List::stream
		).map(
			MBCommentImpl::new
		).collect(
			Collectors.toList()
		);
	}

	@Override
	public int getChildCommentsCount(long parentCommentId, int status) {
		return _mbMessageLocalService.getChildMessagesCount(
			parentCommentId, status);
	}

	@Override
	public int getCommentsCount(String className, long classPK) {
		long classNameId = _portal.getClassNameId(className);

		return _mbMessageLocalService.getDiscussionMessagesCount(
			classNameId, classPK, WorkflowConstants.STATUS_APPROVED);
	}

	@Override
	public Discussion getDiscussion(
			long userId, long groupId, String className, long classPK,
			Function<String, ServiceContext> serviceContextFunction)
		throws PortalException {

		MBMessageDisplay messageDisplay =
			_mbMessageLocalService.getDiscussionMessageDisplay(
				userId, groupId, className, classPK,
				WorkflowConstants.STATUS_ANY, new MessageThreadComparator());

		DiscussionComment rootDiscussionComment = getDiscussionComment(
			userId, messageDisplay);

		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();

		List<MBMessage> messages = treeWalker.getMessages();

		return new MBDiscussionImpl(
			rootDiscussionComment, messageDisplay.isDiscussionMaxComments(),
			messages.size() - 1);
	}

	@Override
	public DiscussionPermission getDiscussionPermission(
		PermissionChecker permissionChecker) {

		return new MBDiscussionPermissionImpl(permissionChecker);
	}

	@Override
	public DiscussionStagingHandler getDiscussionStagingHandler() {
		return new MBDiscussionStagingHandler();
	}

	@Override
	public List<Comment> getRootComments(
			String className, long classPK, int status, int start, int end)
		throws PortalException {

		return Stream.of(
			_mbMessageLocalService.getRootDiscussionMessages(
				className, classPK, status, start, end)
		).flatMap(
			List::stream
		).map(
			MBCommentImpl::new
		).collect(
			Collectors.toList()
		);
	}

	@Override
	public int getRootCommentsCount(
		String className, long classPK, int status) {

		return _mbMessageLocalService.getRootDiscussionMessagesCount(
			className, classPK, status);
	}

	@Override
	public boolean hasDiscussion(String className, long classPK) {
		MBDiscussion discussion = _mbDiscussionLocalService.fetchDiscussion(
			className, classPK);

		if (discussion == null) {
			return false;
		}

		return true;
	}

	@Override
	public void moveDiscussionToTrash(String className, long classPK) {
		List<MBMessage> messages = _mbMessageLocalService.getMessages(
			className, classPK, WorkflowConstants.STATUS_APPROVED);

		for (MBMessage message : messages) {
			message.setStatus(WorkflowConstants.STATUS_IN_TRASH);

			_mbMessageLocalService.updateMBMessage(message);
		}
	}

	@Override
	public void restoreDiscussionFromTrash(String className, long classPK) {
		List<MBMessage> messages = _mbMessageLocalService.getMessages(
			className, classPK, WorkflowConstants.STATUS_IN_TRASH);

		for (MBMessage message : messages) {
			message.setStatus(WorkflowConstants.STATUS_APPROVED);

			_mbMessageLocalService.updateMBMessage(message);
		}
	}

	@Override
	public void subscribeDiscussion(
			long userId, long groupId, String className, long classPK)
		throws PortalException {

		_mbDiscussionLocalService.subscribeDiscussion(
			userId, groupId, className, classPK);
	}

	@Override
	public void unsubscribeDiscussion(
			long userId, String className, long classPK)
		throws PortalException {

		_mbDiscussionLocalService.unsubscribeDiscussion(
			userId, className, classPK);
	}

	@Override
	public long updateComment(
			long userId, String className, long classPK, long commentId,
			String subject, String body,
			Function<String, ServiceContext> serviceContextFunction)
		throws PortalException {

		ServiceContext serviceContext = serviceContextFunction.apply(
			MBMessage.class.getName());

		MBMessage message = _mbMessageLocalService.updateDiscussionMessage(
			userId, commentId, className, classPK, subject, body,
			serviceContext);

		return message.getMessageId();
	}

	protected DiscussionComment getDiscussionComment(
		long userId, MBMessageDisplay messageDisplay) {

		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();

		List<MBMessage> messages = treeWalker.getMessages();

		List<Long> classPKs = new ArrayList<>();

		if (messages.size() > 1) {
			for (MBMessage curMessage : messages) {
				if (!curMessage.isRoot()) {
					classPKs.add(curMessage.getMessageId());
				}
			}
		}

		if (classPKs.isEmpty()) {
			return new MBDiscussionCommentImpl(
				treeWalker.getRoot(), treeWalker, Collections.emptyMap(),
				Collections.emptyMap());
		}

		long[] classPKsArray = ArrayUtil.toLongArray(classPKs);

		Map<Long, RatingsEntry> ratingsEntries = null;
		Map<Long, RatingsStats> ratingsStats =
			_ratingsStatsLocalService.getStats(
				CommentConstants.getDiscussionClassName(), classPKsArray);

		if (ratingsStats.isEmpty()) {
			ratingsEntries = Collections.emptyMap();
		}
		else {
			ratingsEntries = _ratingsEntryLocalService.getEntries(
				userId, CommentConstants.getDiscussionClassName(),
				classPKsArray);
		}

		return new MBDiscussionCommentImpl(
			treeWalker.getRoot(), treeWalker, ratingsEntries, ratingsStats);
	}

	@Reference
	private MBDiscussionLocalService _mbDiscussionLocalService;

	@Reference
	private MBMessageLocalService _mbMessageLocalService;

	@Reference
	private MBThreadLocalService _mbThreadLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private RatingsEntryLocalService _ratingsEntryLocalService;

	@Reference
	private RatingsStatsLocalService _ratingsStatsLocalService;

}
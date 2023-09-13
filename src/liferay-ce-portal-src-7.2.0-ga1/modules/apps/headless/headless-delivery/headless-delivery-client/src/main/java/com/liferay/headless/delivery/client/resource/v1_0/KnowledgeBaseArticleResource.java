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

package com.liferay.headless.delivery.client.resource.v1_0;

import com.liferay.headless.delivery.client.dto.v1_0.KnowledgeBaseArticle;
import com.liferay.headless.delivery.client.http.HttpInvoker;
import com.liferay.headless.delivery.client.pagination.Page;
import com.liferay.headless.delivery.client.pagination.Pagination;
import com.liferay.headless.delivery.client.serdes.v1_0.KnowledgeBaseArticleSerDes;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class KnowledgeBaseArticleResource {

	public static void deleteKnowledgeBaseArticle(Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteKnowledgeBaseArticleHttpResponse(knowledgeBaseArticleId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse
			deleteKnowledgeBaseArticleHttpResponse(Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static KnowledgeBaseArticle getKnowledgeBaseArticle(
			Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getKnowledgeBaseArticleHttpResponse(knowledgeBaseArticleId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return KnowledgeBaseArticleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getKnowledgeBaseArticleHttpResponse(
			Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static KnowledgeBaseArticle patchKnowledgeBaseArticle(
			Long knowledgeBaseArticleId,
			KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			patchKnowledgeBaseArticleHttpResponse(
				knowledgeBaseArticleId, knowledgeBaseArticle);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return KnowledgeBaseArticleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			patchKnowledgeBaseArticleHttpResponse(
				Long knowledgeBaseArticleId,
				KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(knowledgeBaseArticle.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PATCH);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static KnowledgeBaseArticle putKnowledgeBaseArticle(
			Long knowledgeBaseArticleId,
			KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			putKnowledgeBaseArticleHttpResponse(
				knowledgeBaseArticleId, knowledgeBaseArticle);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return KnowledgeBaseArticleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putKnowledgeBaseArticleHttpResponse(
			Long knowledgeBaseArticleId,
			KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(knowledgeBaseArticle.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteKnowledgeBaseArticleMyRating(
			Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			deleteKnowledgeBaseArticleMyRatingHttpResponse(
				knowledgeBaseArticleId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse
			deleteKnowledgeBaseArticleMyRatingHttpResponse(
				Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}/my-rating",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static com.liferay.headless.delivery.client.dto.v1_0.Rating
			getKnowledgeBaseArticleMyRating(Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getKnowledgeBaseArticleMyRatingHttpResponse(knowledgeBaseArticleId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return com.liferay.headless.delivery.client.serdes.v1_0.
				RatingSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			getKnowledgeBaseArticleMyRatingHttpResponse(
				Long knowledgeBaseArticleId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}/my-rating",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static com.liferay.headless.delivery.client.dto.v1_0.Rating
			postKnowledgeBaseArticleMyRating(
				Long knowledgeBaseArticleId,
				com.liferay.headless.delivery.client.dto.v1_0.Rating rating)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			postKnowledgeBaseArticleMyRatingHttpResponse(
				knowledgeBaseArticleId, rating);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return com.liferay.headless.delivery.client.serdes.v1_0.
				RatingSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postKnowledgeBaseArticleMyRatingHttpResponse(
				Long knowledgeBaseArticleId,
				com.liferay.headless.delivery.client.dto.v1_0.Rating rating)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(rating.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}/my-rating",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static com.liferay.headless.delivery.client.dto.v1_0.Rating
			putKnowledgeBaseArticleMyRating(
				Long knowledgeBaseArticleId,
				com.liferay.headless.delivery.client.dto.v1_0.Rating rating)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			putKnowledgeBaseArticleMyRatingHttpResponse(
				knowledgeBaseArticleId, rating);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return com.liferay.headless.delivery.client.serdes.v1_0.
				RatingSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			putKnowledgeBaseArticleMyRatingHttpResponse(
				Long knowledgeBaseArticleId,
				com.liferay.headless.delivery.client.dto.v1_0.Rating rating)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(rating.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{knowledgeBaseArticleId}/my-rating",
			knowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Page<KnowledgeBaseArticle>
			getKnowledgeBaseArticleKnowledgeBaseArticlesPage(
				Long parentKnowledgeBaseArticleId, String search,
				String filterString, Pagination pagination, String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getKnowledgeBaseArticleKnowledgeBaseArticlesPageHttpResponse(
				parentKnowledgeBaseArticleId, search, filterString, pagination,
				sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, KnowledgeBaseArticleSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse
			getKnowledgeBaseArticleKnowledgeBaseArticlesPageHttpResponse(
				Long parentKnowledgeBaseArticleId, String search,
				String filterString, Pagination pagination, String sortString)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (search != null) {
			httpInvoker.parameter("search", String.valueOf(search));
		}

		if (filterString != null) {
			httpInvoker.parameter("filter", filterString);
		}

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		if (sortString != null) {
			httpInvoker.parameter("sort", sortString);
		}

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{parentKnowledgeBaseArticleId}/knowledge-base-articles",
			parentKnowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static KnowledgeBaseArticle
			postKnowledgeBaseArticleKnowledgeBaseArticle(
				Long parentKnowledgeBaseArticleId,
				KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			postKnowledgeBaseArticleKnowledgeBaseArticleHttpResponse(
				parentKnowledgeBaseArticleId, knowledgeBaseArticle);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return KnowledgeBaseArticleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postKnowledgeBaseArticleKnowledgeBaseArticleHttpResponse(
				Long parentKnowledgeBaseArticleId,
				KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(knowledgeBaseArticle.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-articles/{parentKnowledgeBaseArticleId}/knowledge-base-articles",
			parentKnowledgeBaseArticleId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Page<KnowledgeBaseArticle>
			getKnowledgeBaseFolderKnowledgeBaseArticlesPage(
				Long knowledgeBaseFolderId, Boolean flatten, String search,
				String filterString, Pagination pagination, String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getKnowledgeBaseFolderKnowledgeBaseArticlesPageHttpResponse(
				knowledgeBaseFolderId, flatten, search, filterString,
				pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, KnowledgeBaseArticleSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse
			getKnowledgeBaseFolderKnowledgeBaseArticlesPageHttpResponse(
				Long knowledgeBaseFolderId, Boolean flatten, String search,
				String filterString, Pagination pagination, String sortString)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (flatten != null) {
			httpInvoker.parameter("flatten", String.valueOf(flatten));
		}

		if (search != null) {
			httpInvoker.parameter("search", String.valueOf(search));
		}

		if (filterString != null) {
			httpInvoker.parameter("filter", filterString);
		}

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		if (sortString != null) {
			httpInvoker.parameter("sort", sortString);
		}

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-folders/{knowledgeBaseFolderId}/knowledge-base-articles",
			knowledgeBaseFolderId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static KnowledgeBaseArticle
			postKnowledgeBaseFolderKnowledgeBaseArticle(
				Long knowledgeBaseFolderId,
				KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			postKnowledgeBaseFolderKnowledgeBaseArticleHttpResponse(
				knowledgeBaseFolderId, knowledgeBaseArticle);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return KnowledgeBaseArticleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postKnowledgeBaseFolderKnowledgeBaseArticleHttpResponse(
				Long knowledgeBaseFolderId,
				KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(knowledgeBaseArticle.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/knowledge-base-folders/{knowledgeBaseFolderId}/knowledge-base-articles",
			knowledgeBaseFolderId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Page<KnowledgeBaseArticle> getSiteKnowledgeBaseArticlesPage(
			Long siteId, Boolean flatten, String search, String filterString,
			Pagination pagination, String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			getSiteKnowledgeBaseArticlesPageHttpResponse(
				siteId, flatten, search, filterString, pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, KnowledgeBaseArticleSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse
			getSiteKnowledgeBaseArticlesPageHttpResponse(
				Long siteId, Boolean flatten, String search,
				String filterString, Pagination pagination, String sortString)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (flatten != null) {
			httpInvoker.parameter("flatten", String.valueOf(flatten));
		}

		if (search != null) {
			httpInvoker.parameter("search", String.valueOf(search));
		}

		if (filterString != null) {
			httpInvoker.parameter("filter", filterString);
		}

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		if (sortString != null) {
			httpInvoker.parameter("sort", sortString);
		}

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/sites/{siteId}/knowledge-base-articles",
			siteId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static KnowledgeBaseArticle postSiteKnowledgeBaseArticle(
			Long siteId, KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse =
			postSiteKnowledgeBaseArticleHttpResponse(
				siteId, knowledgeBaseArticle);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return KnowledgeBaseArticleSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse
			postSiteKnowledgeBaseArticleHttpResponse(
				Long siteId, KnowledgeBaseArticle knowledgeBaseArticle)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(knowledgeBaseArticle.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/headless-delivery/v1.0/sites/{siteId}/knowledge-base-articles",
			siteId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		KnowledgeBaseArticleResource.class.getName());

}
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

package com.liferay.portal.vulcan.yaml.openapi;

/**
 * @author Peter Shin
 */
public class Info {

	public String getDescription() {
		return _description;
	}

	public String getTitle() {
		return _title;
	}

	public String getVersion() {
		return _version;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setVersion(String version) {
		_version = version;
	}

	private String _description;
	private String _title;
	private String _version;

}
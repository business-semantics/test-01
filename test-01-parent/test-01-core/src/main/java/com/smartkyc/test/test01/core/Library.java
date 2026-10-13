package com.smartkyc.test.test01.core;

import lombok.Value;

/**
 * Maven coordinates of a library.
 */
@Value
public class Library {

	String groupId;
	String artifactId;
	String version;

	public String coordinates() {
		return groupId + ":" + artifactId + ":" + version;
	}
}

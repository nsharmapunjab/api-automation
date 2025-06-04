package com.api.test.framework.bl.testdata;

import com.api.test.framework.common.TestData;

public class ApiTestData extends TestData {

	private String testString;
	private int testInt;

	public ApiTestData() {
		super();
	}

	public ApiTestData(String testString, Integer testInt) {
		this();
		this.testString = testString;
		this.testInt = testInt;
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public int getTestInt() {
		return testInt;
	}

	public void setTestInt(int testInt) {
		this.testInt = testInt;
	}

}

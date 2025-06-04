package com.api.test.framework.testcases;

import org.testng.annotations.Test;

import com.api.test.framework.bl.generators.TestFlowG;
import com.api.test.framework.bl.testdata.ApiTestData;
import com.api.test.framework.common.TestFlow;
import com.api.test.framework.common.TestObject;
import com.api.test.framework.exception.TestException;

public class TestClass {

	@Test
	public void test() throws TestException {

		ApiTestData td = new ApiTestData("testString", 25);

		TestFlow tf = TestFlowG.generateFlow(td);

		TestObject to = new TestObject(tf);

		to.executeTestCase();

	}

}

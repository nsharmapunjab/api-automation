package com.api.test.framework.bl.generators;

import com.api.test.framework.bl.actions.RequestAction;
import com.api.test.framework.bl.testdata.ApiTestData;
import com.api.test.framework.bl.verifs.ResponseVerification;
import com.api.test.framework.common.TestFlow;

public class TestFlowG {

	public static TestFlow generateFlow(ApiTestData td) {

		TestFlow tf = new TestFlow("Sample test flow", td);

		RequestAction ra = new RequestAction(td);

		ResponseVerification rv = new ResponseVerification(td);

		tf.addAction(ra);
		tf.addVerification(rv);

		return tf;
	}

}

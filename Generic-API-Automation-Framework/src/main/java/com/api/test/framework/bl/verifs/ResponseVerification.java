package com.api.test.framework.bl.verifs;

import com.api.test.framework.actionverifs.Verification;
import com.api.test.framework.bl.testdata.ApiTestData;
import com.api.test.framework.constants.TabConstants;
import com.api.test.framework.exception.VerificationException;

public class ResponseVerification extends Verification {

	private ApiTestData td;

	public ResponseVerification(ApiTestData td) {

		this.td = td;
	}

	@Override
	public void execute() throws VerificationException {

		System.out.println(TabConstants.TAB + TabConstants.TAB_VARIFY
				+ "I am in verification of the response");
	}

}

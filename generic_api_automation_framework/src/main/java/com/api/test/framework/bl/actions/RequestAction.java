package com.api.test.framework.bl.actions;

import com.api.test.framework.actionverifs.Action;
import com.api.test.framework.actionverifs.Retriable;
import com.api.test.framework.bl.testdata.ApiTestData;
import com.api.test.framework.constants.TabConstants;
import com.api.test.framework.exception.ActionException;

public class RequestAction extends Action implements Retriable {

	private ApiTestData td;

	public RequestAction(ApiTestData td) {

		this.td = td;
	}

	@Override
	public void execute() throws ActionException {

		System.out.println(TabConstants.TAB + TabConstants.TAB_ACTION
				+ "I am in execute of Request Action");
	}

}

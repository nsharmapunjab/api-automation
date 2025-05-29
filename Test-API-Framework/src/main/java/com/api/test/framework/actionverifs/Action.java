package com.api.test.framework.actionverifs;

import com.api.test.framework.exception.ActionException;

public abstract class Action extends ActionVerification {
	
	public abstract void execute() throws ActionException;

}

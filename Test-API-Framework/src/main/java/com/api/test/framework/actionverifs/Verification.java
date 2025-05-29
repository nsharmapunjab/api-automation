package com.api.test.framework.actionverifs;

import com.api.test.framework.exception.VerificationException;

public abstract class Verification extends ActionVerification {

	public abstract void execute() throws VerificationException;

}

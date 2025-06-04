package com.api.test.framework.actionverifs;

import com.api.test.framework.exception.TestException;

/**
 * 
 * @author Nitin
 *  Nobody should extend this class apart from Action & Verification in this project
 *  Prime motivation is for TestFlow class where we need single parent 
 *  to fix the structure of the flow.
 *  
 *  How can we make surethat nobody extend this class 
 *  apart from the one mentioned in this project
 */

public abstract class ActionVerification {

	public abstract void execute() throws TestException;

}

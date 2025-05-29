package com.api.test.framework.common;

import com.api.test.framework.constants.TestConstants;
import com.api.test.framework.exception.TestException;
import com.api.test.framework.utils.PrintObject;

public class TestObject {

	/*
	 * This is the base TestObject class Any testcase object that we define in
	 * this repo has to extend this class We should extend this class for
	 * defining any TC object. TC Object class is primarily consist of 2 objects
	 * :- a) TestFlow object b) Test Data object : Depending on the project team
	 * should extend TestObject class and encapsulate it
	 * 
	 * 
	 * This class should take of the following cases :-
	 * 
	 * 1. Logging of the Test Object before the execution of TC 2. Will be good
	 * if we can print the groups that this TC belongs too This will be little
	 * challenging as group is defined at the function level And in this
	 * function level we will be defining the Test case object. Do we need to
	 * pass TestNG context object whenever we initialize testcase object in
	 * TestNG 3. Need to log time taken for executing a TC.
	 */

	private TestFlow testFlow;
	private TestData testData;
	private boolean tcPassed; // To see whether TC passed or failed
	private long timeTakenToExecte; // In Seconds

	// TODO : Does it make sense to store the Exception stack trace ?

	public TestObject(TestFlow f) {
		this.testFlow = f;
		this.testData = f.getTestData();
	}

	public void executeTestCase() throws TestException {
		long startTime = System.currentTimeMillis();
		this.testData.getTestObjectLogger().logMessage(
				TestConstants.LOG_STRING + " Starting TC "
						+ TestConstants.LOG_STRING);

		Boolean enableLogTestData = new Boolean(System.getProperty(
				TestConstants.ENABLE_LOG_TEST_DATA, "false"));
		if (true == enableLogTestData) {
			logTestData();
		}

		try {
			this.tcPassed = true;
			this.testFlow.executeTC();
		} catch (Exception ex) {
			this.testData.getTestObjectLogger().logMessage(
					"\t Got Exception " + ex + ", aborting TC");
			this.tcPassed = false;
			throw new TestException("Got Exception : " + ex.getMessage(), ex);
		} finally {

			long endTime = System.currentTimeMillis();
			long totTime = (endTime - startTime) / 1000;

			this.timeTakenToExecte = totTime;

			this.testData.getTestObjectLogger().logMessage(
					TestConstants.LOG_STRING + " Ending TC, took " + totTime
							+ " sec to execute, TC Passed : " + this.tcPassed
							+ " " + TestConstants.LOG_STRING);
		}
	}

	private void logTestData() {
		// Print Test Data Object in Tree format, human readable format
		this.testData.getTestObjectLogger().logMessage("\t  TESTDATA : ");
		String[] tDatas = (PrintObject.print(testData)).split("\n");
		for (String s : tDatas) {
			this.testData.getTestObjectLogger().logMessage("\t " + s);
		}

	}

	/**
	 * @return the testFlow
	 */
	protected final TestFlow getTestFlow() {
		return testFlow;
	}

}

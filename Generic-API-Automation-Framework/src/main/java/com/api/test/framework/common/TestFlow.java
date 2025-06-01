package com.api.test.framework.common;

import java.util.ArrayList;

import com.api.test.framework.actionverifs.Action;
import com.api.test.framework.actionverifs.ActionVerification;
import com.api.test.framework.actionverifs.Retriable;
import com.api.test.framework.actionverifs.Verification;
import com.api.test.framework.exception.SetUpException;
import com.api.test.framework.exception.TestException;

/*
 * Test flow is the ordered list of Actions & Verifications
 * Both Actions & Verifications works on the Object
 * Ideally their should never be the case that ppl need to extend the Test flow class.
 *  
 */

public class TestFlow {

	private String flowName;
	private ArrayList<ActionVerification> actionVerifsList;
	private TestData testData;

	/*
	 * public KomliTestFlow(String flowName) { this.flowName = flowName ;
	 * this.actionVerifsList = new ArrayList<ActionVerification>() ; }
	 */

	public TestFlow(String flowName, TestData testData) {
		this.flowName = flowName;
		this.actionVerifsList = new ArrayList<ActionVerification>();
		this.testData = testData;
	}

	public void addAction(Action a) {
		actionVerifsList.add(a);
	}

	public void addVerification(Verification v) {
		actionVerifsList.add(v);
	}

	public int getTotalSteps() {
		return this.actionVerifsList.size();
	}

	public ActionVerification getActionVerificationStep(int stepNumber) {
		return actionVerifsList.get(stepNumber);
	}

	public TestData getTestData() {
		return this.testData;
	}

	public void executeTC() throws TestException {
		// TODO : Add Implementation
		// Need to iterate over ArrayList
		// and call execute() method
		// Also need to check if Action/VerifcationObject are retriable
		// if yes then need to call execute again as per
		// exponential algo for retry logic.

		if (this.testData == null)
			throw new SetUpException("TestData Object is null for class :"
					+ this.testData.getClass().getName());

		for (int i = 1; i <= this.actionVerifsList.size(); i++) {
			ActionVerification av = this.actionVerifsList.get(i - 1);
			if (av == null) {
				// Need to throw the Exception
				throw new SetUpException("At Step, " + i
						+ " got null Action or verification object");
			}

			if (Retriable.class.isInstance(av)) {
				this.testData.getTestObjectLogger().logMessage(
						"\t Step " + i + " : Retriable "
								+ av.getClass().getName());
				executeActionVerifcationWithRetryLogic(av);
			} else {
				this.testData.getTestObjectLogger().logMessage(
						"\t Step " + i + " : Non Retriable "
								+ av.getClass().getName());
				av.execute();
			}

		} // End of For loop

	}

	private void executeActionVerifcationWithRetryLogic(ActionVerification av)
			throws TestException {

		for (int i = 0; i < this.testData.getRetryCountForRetriableFailure(); i++) {

			boolean gotException = false;
			int sleepTime = (i * 2) * this.testData.getTimeoutBetweenRetries();

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException ex) {
				// Need to think what Exception we can send here...
			}

			try {
				this.testData.getTestObjectLogger().logMessage(
						"\t\t Retry Count " + (i + 1) + " :- ");
				av.execute();
			} catch (TestException ex) {
				if (i == (this.testData.getRetryCountForRetriableFailure() - 1)) {
					throw new TestException("TC failed even after 3 retries");
				}
				gotException = true;
				continue;
			}

			if (!gotException)
				return;

		}

	}

}

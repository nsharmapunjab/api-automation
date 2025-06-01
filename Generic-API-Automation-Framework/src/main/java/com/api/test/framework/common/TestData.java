package com.api.test.framework.common;

import com.api.test.framework.constants.TestConstants;
import com.api.test.framework.logger.ReportNGLogger;
import com.api.test.framework.logger.TLogger;

public class TestData {

	private int retry_count_for_retriable_failure;
	private int time_out_between_retries;
	private TLogger logger;

	public TestData() {
		this.retry_count_for_retriable_failure = TestConstants.NUM_RETIRES_FOR_RETRIABLE_FAILURES;
		this.time_out_between_retries = TestConstants.TIME_WAIT_BETWEEN_RETRIES;
		this.logger = new ReportNGLogger();
	}

	public final int getRetryCountForRetriableFailure() {
		return retry_count_for_retriable_failure;
	}

	public final void setRetryCountForRetriableFailure(
			int retry_count_for_retriable_failure) {
		this.retry_count_for_retriable_failure = retry_count_for_retriable_failure;
	}

	public final int getTimeoutBetweenRetries() {
		return time_out_between_retries;
	}

	public final void setTimeoutBetweenRetries(int time_out_between_retries) {
		this.time_out_between_retries = time_out_between_retries;
	}

	public final TLogger getTestObjectLogger() {
		return logger;
	}

	public final void setTestObjectLogger(TLogger logger) {
		this.logger = logger;
	}

}

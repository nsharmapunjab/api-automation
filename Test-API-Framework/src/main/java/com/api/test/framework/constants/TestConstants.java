package com.api.test.framework.constants;

public class TestConstants {

	// Num of times any verification step will be retried
	// if execute() methods of Action or Verification class fails.
	public static int NUM_RETIRES_FOR_RETRIABLE_FAILURES = 3;

	// Time in milli seconds to retry
	// Retries are exponential back off, i.e.
	// if TIME_WAIT_BETWEEN_RETRIES = 3000 secs
	// 1st retry will happen after 3 secs
	// 2nd retry will happen after 6 secs
	// 3rd retry will happen after 12 secs
	public static int TIME_WAIT_BETWEEN_RETRIES = 3000;

	public static String LOG_STRING = "#######################";

	public static String ENABLE_LOG_TEST_DATA = "enable.log.test.data";

}

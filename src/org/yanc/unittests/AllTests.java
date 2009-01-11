package org.yanc.unittests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for YANC");
		//$JUnit-BEGIN$
		suite.addTestSuite(XMLReaderImplTest.class);
		//$JUnit-END$
		return suite;
	}

}

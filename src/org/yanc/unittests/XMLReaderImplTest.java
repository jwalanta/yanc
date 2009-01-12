package org.yanc.unittests;

import junit.framework.TestCase;

import org.xml.sax.SAXException;
import org.yanc.reader.XMLReaderImpl;

public class XMLReaderImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}


	public void testAddFile() {
		XMLReaderImpl xri = new XMLReaderImpl();
		xri.addFile("testCases/preeti.xml");
		try {
			xri.parse();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		assertEquals ("Preeti",xri.getFontName());
	}

}

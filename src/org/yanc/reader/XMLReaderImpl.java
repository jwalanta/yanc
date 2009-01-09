package org.yanc.reader;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Extends the DefaultHandler for reading the XML files and gets all the values
 * 
 * @author pgautam
 * 
 */
public class XMLReaderImpl extends DefaultHandler implements YancXMLReader {

	private String FILENAME = null;
	private XMLReader xr;

	@Override
	public void parse() throws SAXException {
		assert !FILENAME.equals(null); /* make sure filename is assigned */
		init();
		try {
			xr.parse(new InputSource(FILENAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addFile(String filename) {
		FILENAME = 
	}

	private void init() throws SAXException {
		xr = XMLReaderFactory.createXMLReader();
		XMLReaderImpl handler = new XMLReaderImpl();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
	}

}

package org.yanc.reader;

import java.io.IOException;

import org.xml.sax.Attributes;
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
	/*
	 * This is the way I learned to do it. Looks fairly stupid but has worked so far.
	 */
	private boolean inFont2Unicode=false, 
	inUnicode2Font=false,inCharacter=false,
	inTranslation=false, inVariation=false;
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
		FILENAME = filename;
		/* I want to load the filename using properties from a specific location
		 * example: example /settings directory that holds the xml files. */
	}

	private void init() throws SAXException {
		xr = XMLReaderFactory.createXMLReader();
		XMLReaderImpl handler = new XMLReaderImpl();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
	}

	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, name);
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		if (localName.equals("unicode2Font")){
			inUnicode2Font = true;
		}else if (localName.equals("Font2Unicode")){
			inFont2Unicode = true;
		}
		
		super.startElement(uri, localName, name, attributes);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	
	
}

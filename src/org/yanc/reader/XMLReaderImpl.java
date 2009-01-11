package org.yanc.reader;

import java.io.IOException;
import java.util.HashMap;

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
	private String DeveloperName;
	/*
	 * This is the way I learned to do it. Looks fairly stupid but has worked so far.
	 */
	private boolean inFont2Unicode=false, 
	inUnicode2Font=false,inCharacter=false,
	inTranslation=false, inVariation=false,
	inDeveloper = false;
	private String currentCharacter=null;
	private HashMap<String, String> Font2UnicodeMap, Unicode2FontMap; 
	
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
		
		if (localName.equals("unicode2font")){
			inUnicode2Font = false;
		}else if (localName.equals("font2unicode")){
			inFont2Unicode = false;
		} else if (localName.equals("character")){
			inCharacter = false;
			currentCharacter = null;
		} else if (localName.equals("translation")){
			inTranslation = false;
		} else if (localName.equals("variation")){
			inVariation = false;
		} else if (localName.equals("developer")){
			inDeveloper = false;
		} else throw new SAXException("Unknown tag");

	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException  {
		if (localName.equals("unicode2font")){
			inUnicode2Font = true;
		}else if (localName.equals("font2unicode")){
			inFont2Unicode = true;
		} else if (localName.equals("character")){
			inCharacter = true;
			currentCharacter = attributes.getValue("code");
		} else if (localName.equals("translation")){
			inTranslation = true;
		} else if (localName.equals("variation")){
			inVariation = true;
		} else if (localName.equals("developer")){
			inDeveloper = true;
		} else throw new SAXException("Unknown tag");
		
		
	}

	@Override
	public void endDocument() throws SAXException {
		
		super.endDocument();
	}

	@Override
	public void startDocument() throws SAXException {
		
		super.startDocument();
	}
	
	//This method wont work .. FontMap needs to be some sort of linked list 
	// of some sort so that new items are added to the end of it.
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String parsedString = new String(ch, start,length);
		if (this.inFont2Unicode){
			if (this.inTranslation && this.inCharacter)
				Font2UnicodeMap.put(currentCharacter, parsedString);
		}else if (this.inUnicode2Font){
			if (this.inCharacter && (this.inTranslation || this.inVariation))
				Unicode2FontMap.put(currentCharacter, parsedString);
		} else if (this.inDeveloper){
			setDeveloperName(parsedString);
		}
		
	}

	public void setDeveloperName(String developerName) {
		DeveloperName = developerName;
	}

	public String getDeveloperName() {
		return DeveloperName;
	}
	
	
}

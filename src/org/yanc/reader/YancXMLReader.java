package org.yanc.reader;

import org.xml.sax.SAXException;

/**
 * YancXMLReader is the main interface for getting items from the xml files.
 * @author pgautam
 *
 */
public interface YancXMLReader {
	 /* For adding a file */
	public void addFile(String filename);
	public void parse() throws SAXException;
}

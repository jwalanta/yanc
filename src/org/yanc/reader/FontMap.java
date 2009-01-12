package org.yanc.reader;

import java.util.List;

/**
 * The idea here is that FontMap will be used to store all the 
 * Unicode/Font conversion stuff for each of the fonts
 * @author pgautam
 *
 */
public interface FontMap {
	public void setUnicode(String str,String unicode);
	public void setFont(String str,String font);
	/* gets the List of unicode texts/variations of the string */
	public List<String> getUnicode(String str);
	public List<String> getFont(String str);
}

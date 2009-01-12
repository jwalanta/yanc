package org.yanc.reader;

import java.util.List;

/**
 * The idea here is that FontMap will be used to store all the 
 * Unicode/Font conversion stuff for each of the fonts
 * @author pgautam
 *
 */
public interface FontMap {
	public void setUnicode(String str);
	public void setFont(String str);
	public void getUnicode(String str);
	public List<String> getFont(String str);
}

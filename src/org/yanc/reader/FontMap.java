package org.yanc.reader;

import java.util.Map;

public interface FontMap {
	public Map<String,String> getMap(String fontName);
	public String toUnicode();
	public String toFont();
}

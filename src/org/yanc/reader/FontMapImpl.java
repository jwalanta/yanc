package org.yanc.reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FontMapImpl implements FontMap {
	public Map<String, LinkedList<String>> fontToUnicodeMap, unicodeToFontMap;
	
	public FontMapImpl(){
		
	}
	
	@Override
	public List<String> getFont(String str) {
		List<String> result = unicodeToFontMap.get(str);
		return result;
		
	}

	@Override
	public void getUnicode(String str) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFont(String str) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUnicode(String str) {
		// TODO Auto-generated method stub

	}

}

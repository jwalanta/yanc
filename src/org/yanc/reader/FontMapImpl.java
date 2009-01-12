package org.yanc.reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//TODO Do some error checking here. Seriously!
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
	public List<String> getUnicode(String str) {
		List<String> result = fontToUnicodeMap.get(str);
		return result;

	}

	@Override
	public void setFont(String str, String font) {
		LinkedList<String> variations;
		variations = fontToUnicodeMap.get(str);
		if (variations.equals(null))
			variations = new LinkedList();
		fontToUnicodeMap.put(str,variations);
	}

	@Override
	public void setUnicode(String str, String unicode) {
		LinkedList<String> variations;
		variations = unicodeToFontMap.get(str);
		if (variations.equals(null))
			variations = new LinkedList();
		unicodeToFontMap.put(str,variations);
	}

}

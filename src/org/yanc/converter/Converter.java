package org.yanc.converter;
/**
 * Has all the programming logic like where to put what character given a set of strings
 * @author pgautam
 *
 */
public interface Converter {
	public String convertToUnicode(String text);
	public String convertToText(String text);
}

package com.wangfj.core.utils;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.converters.basic.DateConverter;

public class XStreamDateConverter extends DateConverter {

	public XStreamDateConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(boolean lenient) {
		super(lenient);
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(String defaultEraFormat, String defaultFormat,
			String[] acceptableFormats, Locale locale, TimeZone timeZone,
			boolean lenient) {
		super(defaultEraFormat, defaultFormat, acceptableFormats, locale,
				timeZone, lenient);
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(String defaultFormat,
			String[] acceptableFormats, boolean lenient) {
		super(defaultFormat, acceptableFormats, lenient);
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(String defaultFormat,
			String[] acceptableFormats, TimeZone timeZone, boolean lenient) {
		super(defaultFormat, acceptableFormats, timeZone, lenient);
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(String defaultFormat,
			String[] acceptableFormats, TimeZone timeZone) {
		super(defaultFormat, acceptableFormats, timeZone);
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(String defaultFormat, String[] acceptableFormats) {
		super(defaultFormat, acceptableFormats);
		// TODO Auto-generated constructor stub
	}

	public XStreamDateConverter(TimeZone timeZone) {
		super(timeZone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object fromString(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		return super.fromString(str);
	}

}

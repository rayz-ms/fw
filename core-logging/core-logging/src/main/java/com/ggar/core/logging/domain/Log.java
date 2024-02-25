package com.ggar.core.logging.domain;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Locale;

public interface Log<T extends LogId<I>, I> {

	T logId();
	LogLevel level();
	String message();
	Charset charset();
	Locale locale();
	Collection<StackTraceElement> stacktrace();

}

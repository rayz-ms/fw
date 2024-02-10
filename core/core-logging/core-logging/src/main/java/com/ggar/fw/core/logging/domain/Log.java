package com.ggar.fw.core.logging.domain;

import org.immutables.value.Value;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Value.Immutable
public interface Log {

	LogId logId();
	String message();
	Charset charset();
	Locale locale();
	Collection<StackTraceElement> stacktrace();

}

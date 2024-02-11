package com.ggar.core.logging.domain;

import org.immutables.value.Value;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Value.Immutable
public interface Log {

	LogId logId();
	String message();
	Charset charset();
	Locale locale();
	Optional<Collection<StackTraceElement>> stacktrace();

}
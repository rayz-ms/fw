package com.ggar.core.logging.domain;

import org.immutables.value.Value;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;

public interface LogRequest<T extends LogId<?>> {

	Optional<Charset> charset();
	Optional<Locale > locale();

}

package com.ggar.core.logging.domain;

import org.immutables.value.Value;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;

@Value.Immutable
@Value.Style(allMandatoryParameters = true)
public interface LogRequest extends LogId {

	@Value.Parameter(order = 5, value = false)
	Optional<Charset> charset();

	@Value.Parameter(order = 6, value = false)
	Optional<Locale > locale();

}

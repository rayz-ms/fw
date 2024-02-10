package com.ggar.fw.core.logging.domain;

import org.immutables.value.Value;

import java.nio.charset.Charset;
import java.util.Locale;

@Value.Immutable
public interface LogRequest extends LogId {

	Charset charset();
	Locale locale();

}

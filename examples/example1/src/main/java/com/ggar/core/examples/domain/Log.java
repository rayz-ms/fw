package com.ggar.core.examples.domain;

import com.ggar.core.logging.domain.LogLevel;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Locale;

@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@Getter
@Setter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@Accessors(fluent = true)
public class Log implements com.ggar.core.logging.domain.Log<LogId, Long> {

	LogId logId;
	LogLevel level;
	String message;
	Charset charset;
	Locale locale;
	Collection<StackTraceElement> stacktrace;

}

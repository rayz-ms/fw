package com.ggar.core.examples.domain;

import com.ggar.core.logging.domain.LogLevel;
import com.ggar.core.logging.domain.LogRequest;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.nio.charset.Charset;
import java.util.Locale;

@Builder(toBuilder = true)
@Getter
@Setter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@Accessors(fluent = true)
public class Request implements LogRequest<LogId, Long> {

	LogId logId;
	Charset charset;
	Locale locale;
	LogLevel level;

}

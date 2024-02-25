package com.ggar.core.logging.domain;

import java.nio.charset.Charset;
import java.util.Locale;

public interface LogRequest<I extends LogId<ID>, ID> {

	I logId();
	Charset charset();
	Locale locale();

}

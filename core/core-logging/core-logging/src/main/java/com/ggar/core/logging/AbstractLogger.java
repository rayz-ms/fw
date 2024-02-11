package com.ggar.core.logging;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogRequest;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import com.ggar.core.logging.service.Logger;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class AbstractLogger implements Logger {

	protected FindByLogMessagePort findByLogMessagePort;

	public AbstractLogger(FindByLogMessagePort findByLogMessagePort) {
		this.findByLogMessagePort = findByLogMessagePort;
	}

	@Override
	public Optional<Log> apply(LogRequest logRequest, List<Function<Log, Log>> postprocessors) {
		return this.findByLogMessagePort
			.apply(logRequest)
			.map(log -> postprocessors.stream().reduce(Function.identity(), Function::andThen).apply(log));
	}
}

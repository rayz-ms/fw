package com.ggar.core.logging;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;
import com.ggar.core.logging.processor.LogProcessor;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import com.ggar.core.logging.service.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.StreamSupport;

public class BaseLogger<T extends LogRequest<I, ID>, L extends Log<I, ID>, I extends LogId<ID>, ID> implements Logger<T,L,I,ID> {

	protected List<LogProcessor<L,I,ID>> logProcessors;
	protected FindByLogMessagePort<T, L, I, ID> findByLogMessagePort;

	public BaseLogger(List<LogProcessor<L,I,ID>> logProcessors, FindByLogMessagePort<T, L, I, ID> findByLogMessagePort) {
		this.logProcessors = logProcessors;
		this.findByLogMessagePort = findByLogMessagePort;
	}

	@Override
	public Optional<L> apply(T logRequest) {
		Optional<L> log = this.findByLogMessagePort.process(logRequest);

		log.ifPresent(l -> this.logProcessors.forEach(processor -> processor.process(l)));

		return log;
	}

}

package com.ggar.core.examples;

import com.ggar.core.examples.domain.Log;
import com.ggar.core.examples.domain.LogId;
import com.ggar.core.examples.domain.Request;
import com.ggar.core.logging.BaseLogger;
import com.ggar.core.logging.processor.LogProcessor;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Logger extends BaseLogger<Request, Log, LogId, Long> {
	public Logger(List<LogProcessor<Log, LogId, Long>> logProcessors, FindByLogMessagePort<Request, Log, LogId, Long> findByLogMessagePort) {
		super(logProcessors, findByLogMessagePort);
	}
}

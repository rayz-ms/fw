package com.ggar.core.logging.processor;

import com.ggar.core.logging.AbstractLogger;
import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogRequest;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import org.slf4j.Logger;
import org.slf4j.simple.SimpleLoggerFactory;

import java.util.ArrayList;
import java.util.Optional;

public class Slf4jLogger extends AbstractLogger implements ProcessSingleLogMessage<LogRequest, Void>  {

	public Slf4jLogger(FindByLogMessagePort findByLogMessagePort) {
		super(findByLogMessagePort);
	}

	@Override
	public Void process(LogRequest logRequest) {
		StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
		String callerClassName = stackTraceElements[1].getClassName();
		Logger logger = new SimpleLoggerFactory().getLogger(callerClassName);

		Optional<Log> optional = this.apply(logRequest, new ArrayList<>());
		if (optional.isPresent()) {
			Log log = optional.get(); // orElse error message
			switch (LogLevels.valueOf(log.logLevel().get())) {
//				case E -> logger.error(String.format("%s-%s-%s: %s", log.logId().application().get(), log.logId().subsystem().get(), log.logId().id(), log.message()));
//				case W -> logger.warn(String.format("%s-%s-%s: %s", log.logId().application().get(), log.logId().subsystem().get(), log.logId().id(), log.message()));
				default -> logger.error(String.format("%s not supported", log.logLevel()));
			}
		}

		return null;
	}
}

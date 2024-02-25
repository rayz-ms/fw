package com.ggar.core.examples.adapter;

import com.ggar.core.examples.domain.Log;
import com.ggar.core.examples.domain.LogId;
import com.ggar.core.logging.processor.LogLevels;
import com.ggar.core.logging.processor.LogProcessor;
import org.slf4j.Logger;
import org.slf4j.simple.SimpleLoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Slf4jLogProcessor implements LogProcessor<Log, LogId, Long> {

	public void process(Log log) {
		StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
		String callerClassName = stackTraceElements[1].getClassName();
		Logger logger = new SimpleLoggerFactory().getLogger(callerClassName);

		switch (LogLevels.valueOf(log.level().get())) {
			case E -> logger.error(String.format("%s-%s-%s: %s", log.logId().application().get(), log.logId().system().get(), log.logId().id(), log.message()));
			case W -> logger.warn(String.format("%s-%s-%s: %s", log.logId().application().get(), log.logId().system().get(), log.logId().id(), log.message()));
			default -> logger.error(String.format("%s not supported", log.level()));
		}
	}
}

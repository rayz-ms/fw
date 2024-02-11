package com.ggar.core.logging.domain;

import org.immutables.value.Value;

@Value.Immutable()
public interface LogId {

	@Value.Parameter(order = 1)
	Application application();
	@Value.Parameter(order = 2)
	Subsystem subsystem();
	@Value.Parameter(order = 3)
	LogLevel logLevel();
	@Value.Parameter(order = 4)
	Long id();

}

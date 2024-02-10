package com.ggar.fw.core.logging.domain;

import org.immutables.value.Value;

import java.util.logging.Logger;

@Value.Immutable()
public interface LogId {

	Application application();
	Subsystem subsystem();
	LogLevel logLevel();
	Long id();

}

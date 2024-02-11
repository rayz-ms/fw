package com.ggar.core.logging.processor;

import com.ggar.core.logging.domain.LogLevel;

public enum LogLevels implements LogLevel {

	E,
	W;

	@Override
	public String get() {
		return name();
	}
}

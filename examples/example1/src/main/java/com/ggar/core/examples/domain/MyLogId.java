package com.ggar.core.examples.domain;

import com.ggar.core.logging.domain.LogId;
import org.immutables.value.Value;

import java.util.logging.Level;

@Value.Immutable
public interface MyLogId extends LogId<Long> {

	Application application();
	System system();
	Level level();

}

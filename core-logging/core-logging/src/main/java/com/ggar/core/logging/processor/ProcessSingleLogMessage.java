package com.ggar.core.logging.processor;

import com.ggar.core.logging.domain.LogRequest;

import java.util.function.Function;

public interface ProcessSingleLogMessage<T extends LogRequest, R> {

	R process(T logRequest);

}

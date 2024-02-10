package com.ggar.fw.core.logging.processor;

import com.ggar.fw.core.logging.domain.LogRequest;

import java.util.function.Function;

public interface ProcessSingleLogMessage<T extends LogRequest, R> extends Function<T, R> {

}

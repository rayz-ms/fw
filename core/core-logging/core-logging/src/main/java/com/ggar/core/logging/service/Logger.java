package com.ggar.core.logging.service;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogRequest;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface Logger extends BiFunction<LogRequest, List<Function<Log, Log>>, Optional<Log>> {

}

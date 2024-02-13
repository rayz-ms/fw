package com.ggar.core.logging.repository;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;

import java.util.Optional;
import java.util.function.Function;

public interface FindByLogMessagePort<T extends LogId<I>, I> extends Function<LogRequest<T>, Optional<Log<T>>> {

}
package com.ggar.core.logging.repository;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogRequest;

import java.util.Optional;
import java.util.function.Function;

public interface FindByLogMessagePort extends Function<LogRequest, Optional<Log>> {

}
package com.ggar.core.logging.repository;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;

import java.util.Map;
import java.util.function.Function;

public interface FindAllByLogMessagesPort extends Function<Iterable<LogRequest>, Map<LogId, Log>> {

}

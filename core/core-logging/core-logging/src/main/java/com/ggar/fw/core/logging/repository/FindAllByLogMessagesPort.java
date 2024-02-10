package com.ggar.fw.core.logging.repository;

import com.ggar.fw.core.logging.domain.Log;
import com.ggar.fw.core.logging.domain.LogId;
import com.ggar.fw.core.logging.domain.LogRequest;

import java.util.Map;
import java.util.function.Function;

public interface FindAllByLogMessagesPort extends Function<Iterable<LogRequest>, Map<LogId, Log>> {

}

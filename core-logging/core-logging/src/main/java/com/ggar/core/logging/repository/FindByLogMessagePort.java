package com.ggar.core.logging.repository;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;

import java.util.Optional;

public interface FindByLogMessagePort<T extends LogRequest<I,ID>, L extends Log<I, ID>, I extends LogId<ID>, ID> {
	Optional<L> process(T request);
}
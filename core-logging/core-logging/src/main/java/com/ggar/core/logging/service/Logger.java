package com.ggar.core.logging.service;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;

import java.util.Optional;
import java.util.function.Function;

public interface Logger<T extends LogRequest<I, ID>, L extends Log<I, ID>, I extends LogId<ID>, ID> extends Function<T, Optional<L>>{

}

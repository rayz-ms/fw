package com.ggar.core.examples.domain;

import com.ggar.core.logging.domain.LogRequest;
import org.immutables.value.Value;

@Value.Immutable
public interface Request extends LogRequest<MyLogId> {



}

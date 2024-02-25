package com.ggar.core.logging.processor;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;

public interface LogProcessor<L extends Log<I, ID>, I extends LogId<ID>, ID> {

	 void process(L log);

}

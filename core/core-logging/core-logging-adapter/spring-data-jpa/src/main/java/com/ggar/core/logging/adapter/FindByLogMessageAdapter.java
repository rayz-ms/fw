package com.ggar.core.logging.adapter;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogRequest;
import com.ggar.core.logging.repository.FindByLogMessagePort;

import java.util.Optional;

public class FindByLogMessageAdapter implements FindByLogMessagePort {

	@Override
	public Optional<Log> apply(LogRequest logRequest) {
		return Optional.empty();
	}

}

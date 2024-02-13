package com.ggar.core.logging.adapter;

import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class FindByLogMessageAdapter<T extends LogId<I>, I> implements FindByLogMessagePort<T, I> {

	protected final JpaRepository<T, I> repository;

	protected FindByLogMessageAdapter(JpaRepository<T, I> repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Log<T>> apply(LogRequest<T> logId) {
		return Optional.empty();
	}

}

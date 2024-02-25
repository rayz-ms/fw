package com.ggar.core.logging.adapter;

import com.ggar.core.logging.adapter.domain.LogEntity;
import com.ggar.core.logging.domain.Log;
import com.ggar.core.logging.domain.LogId;
import com.ggar.core.logging.domain.LogRequest;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class FindByLogMessageAdapter<T extends LogRequest<I,ID>, L extends Log<I, ID>, I extends LogId<ID>, ID> implements FindByLogMessagePort{

	protected final JpaRepository<? extends LogEntity<ID>, I> repository;

	protected FindByLogMessageAdapter(JpaRepository<? extends LogEntity<ID>, I> repository) {
		this.repository = repository;
	}

}

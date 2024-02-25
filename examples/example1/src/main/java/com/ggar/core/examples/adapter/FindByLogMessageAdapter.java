package com.ggar.core.examples.adapter;

import com.ggar.core.examples.domain.Log;
import com.ggar.core.examples.domain.LogId;
import com.ggar.core.examples.domain.Request;
import com.ggar.core.examples.entity.ApplicationEntity;
import com.ggar.core.examples.entity.LogEntity;
import com.ggar.core.examples.entity.LogMapper;
import com.ggar.core.examples.entity.SystemEntity;
import com.ggar.core.examples.repository.ApplicationRepository;
import com.ggar.core.examples.repository.LogRepository;
import com.ggar.core.examples.repository.SystemRepository;
import com.ggar.core.logging.repository.FindByLogMessagePort;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FindByLogMessageAdapter implements FindByLogMessagePort<Request, Log, LogId, Long> {

	LogRepository logRepository;
	ApplicationRepository applicationRepository;
	SystemRepository systemRepository;
	LogMapper logMapper;

	@Override
	public Optional<Log> process(Request request) {
		ApplicationEntity application = this.applicationRepository.findByNameEqualsIgnoreCase(request.logId().application().get())
			.orElseThrow(NullPointerException::new);
		SystemEntity system = this.systemRepository.findByNameEqualsIgnoreCase(request.logId().system().get())
			.orElseThrow(NullPointerException::new);
		Optional<LogEntity> result = this.logRepository.findByIdAndApplicationAndSystemAndLevelEqualsIgnoreCase(request.logId().id(), application, system, request.level().get());
		return result.map(e -> this.logMapper.toDomain(e, request.charset(), request.locale()));
	}
}

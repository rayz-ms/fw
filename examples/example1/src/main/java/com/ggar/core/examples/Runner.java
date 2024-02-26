package com.ggar.core.examples;

import com.ggar.core.examples.domain.Application;
import com.ggar.core.examples.domain.System;
import com.ggar.core.examples.domain.*;
import com.ggar.core.examples.entity.*;
import com.ggar.core.examples.repository.ApplicationRepository;
import com.ggar.core.examples.repository.LogRepository;
import com.ggar.core.examples.repository.SystemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Component
public class Runner implements CommandLineRunner {

	private final ApplicationRepository applicationRepository;
	private final SystemRepository systemRepository;
	private final LogRepository logRepository;
	private final Logger logger;
	private final LogMapper logMapper;

	public Runner(ApplicationRepository applicationRepository, SystemRepository systemRepository, LogRepository logRepository, Logger logger, LogMapper logMapper) {
		this.applicationRepository = applicationRepository;
		this.systemRepository = systemRepository;
		this.logRepository = logRepository;
		this.logger = logger;
		this.logMapper = logMapper;
	}

	@Override
	public void run(String... args) {
		ApplicationEntity application = this.applicationRepository.findByNameEqualsIgnoreCase("app1")
			.orElseGet(() -> this.applicationRepository.save(new ApplicationEntity().withName("app1")));
		SystemEntity system = this.systemRepository.findByNameEqualsIgnoreCase("system1")
			.orElseGet(() -> this.systemRepository.save(new SystemEntity().withName("system1")));

		LogEntity entity = this.logRepository.findByIdAndApplicationAndSystemAndLevelEqualsIgnoreCase(1L, application, system, "E")
			.orElseGet(() -> this.logRepository.save(new LogEntity()
				.withApplication(application)
				.withSystem(system)
				.withLevel("E")
				.withTranslation(TranslationEntity.builder()
						.charset(StandardCharsets.UTF_8.name())
						.locale(Locale.forLanguageTag("es-ES"))
						.message("Hola que ase")
						.build()
				)
				.withTranslation(TranslationEntity.builder()
					.charset(StandardCharsets.UTF_8.name())
					.locale(Locale.forLanguageTag("en-UK"))
					.message("hey there")
					.build())
			));
		Log log1 = this.logMapper.toDomain(entity, StandardCharsets.UTF_8, Locale.forLanguageTag("es-ES"));
		Log log2 = this.logMapper.toDomain(entity, StandardCharsets.UTF_8, Locale.forLanguageTag("en-UK"));
		logger.apply(Request.of(LogId.of(log1.logId().id(), log1.logId().application(), log1.logId().system()), log1.charset(), log1.locale(), log1.level()));
		logger.apply(Request.of(LogId.of(log2.logId().id(), log2.logId().application(), log2.logId().system()), log2.charset(), log2.locale(), log2.level()));
		// add apply with mnemonic
	}
}

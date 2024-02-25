package com.ggar.core.examples;

import com.ggar.core.examples.domain.Application;
import com.ggar.core.examples.domain.System;
import com.ggar.core.examples.domain.*;
import com.ggar.core.examples.entity.*;
import com.ggar.core.examples.repository.LogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Locale;

@Component
public class Runner implements CommandLineRunner {

	private final JpaRepository<ApplicationEntity, Long> applicationRepository;
	private final JpaRepository<SystemEntity, Long> systemRepository;
	private final LogRepository logRepository;
	private final Logger logger;
	private final LogMapper logMapper;

	public Runner(JpaRepository<ApplicationEntity, Long> applicationRepository, JpaRepository<SystemEntity, Long> systemRepository, LogRepository logRepository, Logger logger, LogMapper logMapper) {
		this.applicationRepository = applicationRepository;
		this.systemRepository = systemRepository;
		this.logRepository = logRepository;
		this.logger = logger;
		this.logMapper = logMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationEntity application = this.applicationRepository.saveAndFlush(new ApplicationEntity().withName("app1"));
		SystemEntity system = this.systemRepository.saveAndFlush(new SystemEntity().withName("system1"));

		LogEntity entity = this.logRepository.save(LogEntity.builder()
			.id(0L)
			.application(application)
			.system(system)
			.level("E")
			.translations(new HashSet<>(){{
				add(TranslationEntity.builder()
					.charset(StandardCharsets.UTF_8.name())
					.locale(Locale.forLanguageTag("es-ES"))
					.message("Hola que ase")
					.build()
				);
				add(TranslationEntity.builder()
					.charset(StandardCharsets.UTF_8.name())
					.locale(Locale.forLanguageTag("en-UK"))
					.message("hey there")
					.build()
				);
			}})
			.build()
		);
		Log log1 = this.logMapper.toDomain(entity, StandardCharsets.UTF_8, Locale.forLanguageTag("es-ES"));
		Log log2 = this.logMapper.toDomain(entity, StandardCharsets.UTF_8, Locale.forLanguageTag("en-UK"));
		logger.apply(Request.of(LogId.of(1L, new Application("app1"), new System("system1")), StandardCharsets.UTF_8, Locale.forLanguageTag("es-ES"), () -> "E"));
		logger.apply(Request.of(LogId.of(1L, new Application("app1"), new System("system1")), StandardCharsets.UTF_8, Locale.forLanguageTag("en-UK"), () -> "E"));

//		for (TranslationEntity entity : this.logRepository.findAll()) {
//			System.out.println(entity);
//		}

	}
}

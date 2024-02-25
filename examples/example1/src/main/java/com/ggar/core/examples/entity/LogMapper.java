package com.ggar.core.examples.entity;

import com.ggar.core.examples.domain.Application;
import com.ggar.core.examples.domain.Log;
import com.ggar.core.examples.domain.LogId;
import com.ggar.core.examples.domain.System;
import org.mapstruct.*;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface LogMapper {

	@Mapping(target = "logId", expression = "java(logId(entity))")
	@Mapping(target = "level", expression = "java(entity::level)")
	@Mapping(target = "charset", source = "charset")
	@Mapping(target = "message", expression = "java(setMessage(entity.translations(), charset, locale))")
	@Mapping(target = "stacktrace", ignore = true)
	Log toDomain(LogEntity entity, Charset charset, Locale locale);

	default String setMessage(Set<TranslationEntity> translations, Charset charset, Locale locale) {
		return translations.stream()
			.filter(e -> e.getLocale().equals(locale))
			.map(TranslationEntity::getMessage)
			.findAny()
			.orElseThrow(NullPointerException::new);
	}

	@Mapping(target = "application", expression = "java(application(entity.application()))")
	@Mapping(target = "system", expression = "java(system(entity.system()))")
	@Mapping(target = "id", expression = "java(entity.id())")
	LogId logId(LogEntity entity);

	default Application application(ApplicationEntity entity) {
		return new Application(entity.name());
	}

	default System system(SystemEntity entity) {
		return new System(entity.name());
	}
}

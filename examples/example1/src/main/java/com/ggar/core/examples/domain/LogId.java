package com.ggar.core.examples.domain;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@Getter
@Builder(toBuilder = true)
@Accessors(fluent = true)
@Setter
@EqualsAndHashCode
@ToString
public class LogId implements com.ggar.core.logging.domain.LogId<Long>, Serializable {

	Long id;
	Application application;
	System system;

}

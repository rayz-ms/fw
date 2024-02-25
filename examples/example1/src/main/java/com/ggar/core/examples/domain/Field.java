package com.ggar.core.examples.domain;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@With
@EqualsAndHashCode
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Setter
public class Field<T> {

	@Getter
	@Accessors(fluent = true)
	T get;

}

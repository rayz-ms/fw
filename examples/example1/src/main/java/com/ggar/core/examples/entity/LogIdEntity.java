package com.ggar.core.examples.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@With
@Accessors(fluent = true)
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogIdEntity implements Serializable {

	Long id;
	ApplicationEntity application;
	SystemEntity system;

}

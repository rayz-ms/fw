package com.ggar.core.examples.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "log")
@Table
@AllArgsConstructor
@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class LogEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@OneToOne(cascade = CascadeType.ALL)
	ApplicationEntity application;

	@OneToOne(cascade = CascadeType.ALL)
	SystemEntity system;

	@Column(length = 1)
	String level;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ToString.Exclude
	Set<TranslationEntity> translations;

}
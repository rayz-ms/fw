package com.ggar.core.examples.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "log")
@Table
@AllArgsConstructor
@With
@NoArgsConstructor(force = true)
@Setter
@Getter
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class LogEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@OneToOne(cascade = CascadeType.MERGE)
	ApplicationEntity application;

	@OneToOne(cascade = CascadeType.MERGE)
	SystemEntity system;

	@Column(length = 1)
	String level;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ToString.Exclude
	Set<TranslationEntity> translations = new HashSet<>();

	public LogEntity withTranslations(TranslationEntity... translations) {
		this.translations.clear();
		this.translations.addAll(Arrays.asList(translations));
		return this;
	}

	public LogEntity withTranslation(TranslationEntity translation) {
		this.translations.add(translation);
		return this;
	}
}
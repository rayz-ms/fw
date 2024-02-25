package com.ggar.core.examples.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import java.util.Locale;
import java.util.Objects;

@Entity(name = "translation")
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class TranslationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String message;
	String charset;
	Locale locale;

	@Version
	Long version;

}

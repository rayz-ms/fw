package com.ggar.core.examples.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity(name = "system")
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@With
@Accessors(fluent = true)
public class SystemEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false, length = 25, unique = true)
	String name;

}

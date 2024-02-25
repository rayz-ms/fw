package com.ggar.core.examples.repository;

import com.ggar.core.examples.entity.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemRepository extends JpaRepository<SystemEntity, Long> {

	Optional<SystemEntity> findByNameEqualsIgnoreCase(String name);

}

package com.ggar.core.examples.repository;

import com.ggar.core.examples.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

	Optional<ApplicationEntity> findByNameEqualsIgnoreCase(String name);

}

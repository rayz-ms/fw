package com.ggar.core.examples.repository;

import com.ggar.core.examples.entity.ApplicationEntity;
import com.ggar.core.examples.entity.LogEntity;
import com.ggar.core.examples.entity.LogIdEntity;
import com.ggar.core.examples.entity.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, LogIdEntity> {

	Optional<LogEntity> findByIdAndApplicationAndSystemAndLevelEqualsIgnoreCase(Long id, ApplicationEntity application, SystemEntity system, String level);

}

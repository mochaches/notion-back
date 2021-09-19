package io.github.renestel.notion.persistence.repository;

import io.github.renestel.notion.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

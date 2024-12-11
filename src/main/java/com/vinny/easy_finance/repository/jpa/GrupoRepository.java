package com.vinny.easy_finance.repository.jpa;

import com.vinny.easy_finance.repository.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrupoRepository extends JpaRepository<GrupoEntity, UUID> {
}

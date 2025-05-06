package com.api_java.ms_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_java.ms_task.model.Lembretes;

@Repository
public interface LembretesRepository extends JpaRepository<Lembretes, Integer> {
}
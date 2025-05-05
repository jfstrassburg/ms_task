package com.api_java.ms_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_java.ms_task.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    // Aqui você pode adicionar métodos personalizados, se necessário.
    // Por exemplo, você pode adicionar métodos para buscar tarefas por status, prioridade, etc.

}

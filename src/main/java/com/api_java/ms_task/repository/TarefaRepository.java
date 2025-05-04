package com.api_java.ms_task.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.api_java.ms_task.model.Tarefa;
import com.api_java.ms_task.model.exception.ResourcerNotFoundException;

@Repository
public class TarefaRepository {
    //Simulando um banco de dados em memória
    // Cria uma lista para armazenar as tarefas
    // e um id para controlar o último id atribuído.
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private Integer ultimoId = 0;

    /**
     * Metodo obterTodos os registros
     * @return Lista de todas as tarefas
     */
    public List<Tarefa> obterTodos() {
        return tarefas;
    }

    /**
     * Metodo que retorna o produto pelo id
     * @param id do produto que será retornado
     * @return Retorna o produto caso exista
     */
    public Optional<Tarefa> obterPorId(Integer id) {
        return tarefas
                .stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst();
        }

    /**
     * Metodo que adiciona a tarefa na lista
     * @param tarefa que será adicionada
     * @return Retorna tarefa adicionada
     */
    public Tarefa adicionar(Tarefa tarefa) {
        ultimoId++;
        tarefa.setId(ultimoId);
        tarefas.add(tarefa);
        return tarefa;
    }

    /**
     * Metodo para deletar tarefa
     * @param tarefa que será deletada
     * @param id que será deletado
     */    

    public void deletar(Integer id) {
        tarefas.removeIf(tarefa -> tarefa.getId() == id);       
    }

    /**
     * Metodo para atualizar tarefa
     * @param tarefa que será atualizada
     * @return Retorna tarefa atualizada
     * @throws RuntimeException caso a tarefa não seja encontrada
     */
    public Tarefa atualizar(Tarefa tarefa) {
        Optional<Tarefa> tarefaEncontrado = obterPorId(tarefa.getId());

        if(tarefaEncontrado.isEmpty()) {
            throw new ResourcerNotFoundException("Tarefa não encontrada.");
        }
         
        deletar(tarefa.getId());

        tarefas.add(tarefa);
        
        return tarefa;
    }
}

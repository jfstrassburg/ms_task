package com.api_java.ms_task.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_java.ms_task.model.Tarefa;
import com.api_java.ms_task.model.exception.ResourcerNotFoundException;
import com.api_java.ms_task.repository.TarefaRepository;
import com.api_java.ms_task.shared.TarefaDTO;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaDTO> obterTodos() {
        //Retorna uma lista de tarefas DTOs
        // Converte a lista de tarefas para uma lista de TarefaDTO usando ModelMapper
        List<Tarefa> tarefas = tarefaRepository.findAll();

        return tarefas.stream()
                .map(tarefa -> new ModelMapper().map(tarefa, TarefaDTO.class))
                .collect(Collectors.toList());
    }   

    public Optional<TarefaDTO> obterPorId(Integer id) {
        //Obtendo Optinal de produto pelo id.
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        //Se não encontrar, lança exception.
        if(tarefa.isEmpty()) {
            throw new ResourcerNotFoundException("Tarefa com id:"+ id + "não encontrado");
        }
        //Convertendo p meu Optinal de produti em um produtoDto.
        TarefaDTO dto = new ModelMapper().map(tarefa.get(), TarefaDTO.class);

        //Criando e retornadno um optinal de produtoDto.
        return Optional.of(dto);

    }

    public TarefaDTO adicionar(TarefaDTO tarefaDto) {
        //Remvendo o id para conseguir fazer a cadastro
        tarefaDto.setId(null); 

        //Criar uma objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();
        
        //Converter a nossa TarefaDTO em uma tarefa
        Tarefa tarefa = mapper.map(tarefaDto, Tarefa.class);

        //Salvar a Tarefa no banco
        tarefa = tarefaRepository.save(tarefa);

        tarefaDto.setId(tarefa.getId());

        //Retorna a TarefaDTO atualizada
        return tarefaDto;
    }   

    public void deletar(Integer id) {
        //Verificar se a tarefa existe
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        //Se não encontrar, lança exception.
        if(tarefa.isEmpty()) {
            throw new ResourcerNotFoundException("Não foi possivel encontrar a Tarefa com id:"+ id);
        }

        tarefaRepository.deleteById(id);
    }

    public TarefaDTO atualizar(Integer id, TarefaDTO tarefaDto) {
        // Passar o id para tarefaDto
        tarefaDto.setId(id);

        // Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        //Converter a TarefaDTO em uma Tarefa
        Tarefa tarefa = mapper.map(tarefaDto, Tarefa.class);

        // Atualizar a tarefa no banco de dados
        tarefa = tarefaRepository.save(tarefa);

        //Retorna a tarefa atualizada
        return tarefaDto;
        
    }


}

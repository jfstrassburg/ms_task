package com.api_java.ms_task.service;

import com.api_java.ms_task.dto.LembretesDTO;
import com.api_java.ms_task.model.Lembretes;
import com.api_java.ms_task.repository.LembretesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LembretesService {

    @Autowired
    private LembretesRepository repository;

    public Lembretes criarLembrete(LembretesDTO dto) {
        Lembretes lembrete = new Lembretes();
        lembrete.setNome(dto.getNome());
        lembrete.setDescricao(dto.getDescricao());
        lembrete.setData(dto.getData());
        lembrete.setHora(dto.getHora());
        lembrete.setLocalizacao(dto.getLocalizacao());
        return repository.save(lembrete);
    }

    public List<Lembretes> listarLembretes() {
        return repository.findAll();
    }

    public Optional<Lembretes> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public boolean atualizarLembrete(Integer id, LembretesDTO dto) {
        Optional<Lembretes> optionalLembrete = repository.findById(id);
        if (optionalLembrete.isPresent()) {
            Lembretes lembrete = optionalLembrete.get();
            lembrete.setNome(dto.getNome());
            lembrete.setDescricao(dto.getDescricao());
            lembrete.setData(dto.getData());
            lembrete.setHora(dto.getHora());
            lembrete.setLocalizacao(dto.getLocalizacao());
            repository.save(lembrete);
            return true;
        }
        return false;
    }

    public boolean deletarLembrete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
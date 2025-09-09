package br.com.anthony.apitarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anthony.apitarefas.domain.Tarefa;
import br.com.anthony.apitarefas.exception.NotFoundException;
import br.com.anthony.apitarefas.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isEmpty()) {
            throw new NotFoundException("Tarefa não encontrada");
        }
        return tarefa.get();
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = buscarPorId(id);
        
        tarefaExistente.setNome(tarefaAtualizada.getNome());
        tarefaExistente.setDataEntrega(tarefaAtualizada.getDataEntrega());
        tarefaExistente.setResponsavel(tarefaAtualizada.getResponsavel());
        
        return tarefaRepository.save(tarefaExistente);
    }

    public void excluirTarefa(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefaRepository.delete(tarefa);
    }
}

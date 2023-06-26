package com.BibliotecaUnialfa.painelDeControle.service;

import com.BibliotecaUnialfa.painelDeControle.model.Aluno;
import com.BibliotecaUnialfa.painelDeControle.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public void salvar(Aluno aluno) {
        repository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
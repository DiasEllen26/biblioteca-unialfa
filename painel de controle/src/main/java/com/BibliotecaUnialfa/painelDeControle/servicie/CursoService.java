package com.BibliotecaUnialfa.painelDeControle.service;

import com.BibliotecaUnialfa.painelDeControle.model.Curso;
import com.BibliotecaUnialfa.painelDeControle.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public void salvar(Curso curso) {
        repository.save(curso);
    }

    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
package com.BibliotecaUnialfa.painelDeControle.servicie;


import com.BibliotecaUnialfa.painelDeControle.model.Editora;
import com.BibliotecaUnialfa.painelDeControle.repository.EditoraRepository;
import com.BibliotecaUnialfa.painelDeControle.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraServicie {
    @Autowired
    private EditoraRepository repository;
    public void salvar(Editora editora){repository.save(editora);}
    public List<Editora> listarTodos(){return  repository.findAll();}
    public Editora buscarPorId(Long id){return repository.findById(id).get();}
    public void deletarPorId(Long id){repository.deleteById(id);}
}

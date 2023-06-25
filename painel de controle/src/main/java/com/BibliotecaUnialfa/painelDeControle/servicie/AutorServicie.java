package com.BibliotecaUnialfa.painelDeControle.servicie;

import com.BibliotecaUnialfa.painelDeControle.model.Autor;
import com.BibliotecaUnialfa.painelDeControle.model.Livro;
import com.BibliotecaUnialfa.painelDeControle.repository.AutorRepository;
import com.BibliotecaUnialfa.painelDeControle.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServicie {

    @Autowired
    private AutorRepository repository;
    public void salvar(Autor autor){repository.save(autor);}
    public List<Autor> listarTodos(){return  repository.findAll();}
    public Autor buscarPorId(Long id){return repository.findById(id).get();}
    public void deletarPorId(Long id){repository.deleteById(id);}
}

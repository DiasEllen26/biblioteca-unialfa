package com.BibliotecaUnialfa.painelDeControle.servicie;

import com.BibliotecaUnialfa.painelDeControle.model.Livro;
import com.BibliotecaUnialfa.painelDeControle.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServicie {
    @Autowired
    private LivroRepository repository;

    public void salvar(Livro livro){repository.save(livro);}
    public List<Livro> listarTodos(){return  repository.findAll();}
    public List<Livro> pesquisarLivros(String termo) {
        return repository.findByTituloContainingIgnoreCase(termo);
    }

    public Livro buscarPorId(Long id){return repository.findById(id).get();}
    public void deletarPorId(Long id){repository.deleteById(id);}
}

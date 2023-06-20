package com.BibliotecaUnialfa.painelDeControle.repository;

import com.BibliotecaUnialfa.painelDeControle.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

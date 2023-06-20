package com.BibliotecaUnialfa.painelDeControle.repository;

import com.BibliotecaUnialfa.painelDeControle.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

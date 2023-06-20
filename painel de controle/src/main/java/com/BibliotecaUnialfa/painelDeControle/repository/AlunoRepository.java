package com.BibliotecaUnialfa.painelDeControle.repository;

import com.BibliotecaUnialfa.painelDeControle.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

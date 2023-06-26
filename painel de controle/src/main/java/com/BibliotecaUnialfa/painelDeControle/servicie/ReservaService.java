package com.BibliotecaUnialfa.painelDeControle.service;

import com.BibliotecaUnialfa.painelDeControle.model.Aluno;
import com.BibliotecaUnialfa.painelDeControle.model.Livro;
import com.BibliotecaUnialfa.painelDeControle.model.Reserva;
import com.BibliotecaUnialfa.painelDeControle.repository.AlunoRepository;
import com.BibliotecaUnialfa.painelDeControle.repository.LivroRepository;
import com.BibliotecaUnialfa.painelDeControle.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;


    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void salvar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id).get();
    }

    public void deletarPorId(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }
}
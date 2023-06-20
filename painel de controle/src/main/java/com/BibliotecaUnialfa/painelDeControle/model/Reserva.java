package com.BibliotecaUnialfa.painelDeControle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno alunoId;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livroId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataFim")
    private LocalDate dataFim;
    @Column(name = "observacao")
    private String observacao;

}

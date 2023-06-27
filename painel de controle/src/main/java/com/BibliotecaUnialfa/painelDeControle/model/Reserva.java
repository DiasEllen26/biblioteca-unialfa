package com.BibliotecaUnialfa.painelDeControle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "o aluno é obrigatório!")
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno alunoId;
    @NotNull(message = "O livro é obrigatório!")
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livroId;
    @NotNull(message = "A data de início não pode ser nula")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataInicio")
    private LocalDate dataInicio;
    @NotNull(message = "A data de fim não pode ser nula")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataFim")
    private LocalDate dataFim;
    @Size(max = 255, message = "A observação deve ter no máximo 255 caracteres")
    @Column(name = "observacao")
    private String observacao;

}

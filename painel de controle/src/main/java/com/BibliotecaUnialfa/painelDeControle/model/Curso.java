package com.BibliotecaUnialfa.painelDeControle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank(message = "O nome é obrigatorio")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    @Column(name = "nome")
    private String nome;
    @NotBlank(message = "O coordenador é obrigatorio")
    @Size(max = 255, message = "O coordenador deve ter no máximo 255 caracteres")
    @Column(name = "coordenador")
    private String coordenador;
    @NotBlank(message = "A duração é obrigatorio")
    @Size(max = 2, message = "O duração deve ter no máximo 2 caracteres")
    @Column(name = "duracao")
    private String duracao;

}

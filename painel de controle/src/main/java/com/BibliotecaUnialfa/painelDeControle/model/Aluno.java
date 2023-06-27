package com.BibliotecaUnialfa.painelDeControle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull(message = "O RA é obrigatório")
    @Column(name = "ra")
    private Integer ra;
    @NotBlank(message = "O nome é obrigatorio")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    @Column(name = "nome")
    private String nome;
    @NotBlank(message = "O endereço é obrigatorio")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres")
    @Column(name = "endereco")
    private String endereco;
    @NotBlank(message = "A cidade é obrigatorio")
    @Size(max = 255, message = "A cidade deve ter no máximo 255 caracteres")
    @Column(name = "cidade")
    private String cidade;
    @NotBlank(message = "O UF é obrigatorio")
    @Size(max = 2, message = "O UF deve ter no máximo 2 caracteres")
    @Column(name = "uf")
    private String uf;
    @NotBlank(message = "O telefone é obrigatorio")
    @Size(max = 11, message = "O telefone deve ter no máximo 11 caracteres")
    @Column(name = "telefone")
    private String telefone;
    @NotNull( message = "O curso é obrigatório")
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso cursoId;
}

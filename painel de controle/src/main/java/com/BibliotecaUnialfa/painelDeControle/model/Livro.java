package com.BibliotecaUnialfa.painelDeControle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "O titulo é obrigatorio")
    @Size(max = 255, message = "O titulo deve ter no máximo 255 caracteres")
    @Column(name = "titulo")
    private String titulo;
    @NotBlank(message = "O subTitulo é obrigatorio")
    @Size(max = 255, message = "O sub-titulo deve ter no máximo 255 caracteres")
    @Column(name = "subTitulo")
    private String subTitulo;
    @NotBlank(message = "o isbn é obrigatorio")
    @Size(max = 255, message = "O IBSN deve ter no máximo 255 caracteres")
    @Column(name = "ibsn")
    private String ibsn;
    @NotNull(message = "O Autor é obrigatório!")
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autorId;
    @NotNull(message = "A editora é obrigatório")
    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editoraId;
    @NotBlank(message = "O local é obrigatório")
    @Size(max = 255, message = "O local deve ter no máximo 255 caracteres")
    @Column(name = "local")
    private String local;
    @Column(name = "imagem_url")
    private String imagemUrl;
    @NotNull(message = "O campo ano é obrigatório")
    @Digits(integer = 4, fraction = 0, message = "O ano deve ter 4 dígitos")
    @Column(name = "ano")
    private Integer ano;
    @NotBlank(message = "O genêro é obrigatório")
    @Size(max = 255, message = "O genêro deve ter no máximo 255 caracteres")
    @Column(name = "genero")
    private String genero;

}

package com.BibliotecaUnialfa.painelDeControle.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "subTitulo")
    private String subTitulo;
    @Column(name = "isbn")
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autorId;
    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editoraId;
    @Column(name = "local")
    private String local;
    @Column(name = "ano")
    private Integer ano;
}

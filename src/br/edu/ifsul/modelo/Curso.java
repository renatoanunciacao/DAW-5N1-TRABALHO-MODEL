/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotNull(message = "A sigla não pode ser nula")
    @NotBlank(message = "A sigla não pode ser em branca")
    @Length(max = 5, message = "A sigla não pode ter mais do que {max} caracteres")
    @Column(name = "sigla", length = 5, nullable = false)
    private String sigla;

    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;

    @NotNull(message = "O ativo não pode ser nulo")
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @NotNull(message = "A data não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio_atividades", nullable = false)
    private Calendar iniciAtividades;
    
    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getIniciAtividades() {
        return iniciAtividades;
    }

    public void setIniciAtividades(Calendar iniciAtividades) {
        this.iniciAtividades = iniciAtividades;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renato
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O nome não pode ser em branco")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais do que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Email(message = "Informe um e-mail válido")
    @NotNull(message = "O e-mail não pode ser nulo")
    @NotBlank(message = "O e-mail não pode ser em branco")
    @Length(max = 50, message = "O e-mail não pode ter mais do que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;

    @ManyToMany
    @JoinTable(name = "alunosdadisciplina", joinColumns
            = @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false))
    private List<Disciplina> disciplinadoaluno = new ArrayList<>();
    
//    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
//    private Nota nota;

    public Aluno() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public List<Disciplina> getDisciplinadoaluno() {
        return disciplinadoaluno;
    }

    public void setDisciplinadoaluno(List<Disciplina> disciplinadoaluno) {
        this.disciplinadoaluno = disciplinadoaluno;
    }

//    public Nota getNota() {
//        return nota;
//    }
//
//    public void setNota(Nota nota) {
//        this.nota = nota;
//    }

   
}

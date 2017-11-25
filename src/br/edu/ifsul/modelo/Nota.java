/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Min(value = 0, message = "A nota 1 não pode ser menor do que {value}")
    @Column(name = "nota1", columnDefinition = "decimal(12,2)")
    private Double nota1;
    
    @Min(value = 0, message = "A nota 2 não pode ser menor do que {value}")
    @Column(name = "nota2", columnDefinition = "decimal(12,2)")
    private Double nota2;
    
    @Column(name = "media", columnDefinition = "decimal(12,2)")
    private Double media;

    @NotNull(message = "O aluno não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_aluno_id")
    private Aluno aluno;

    @NotNull(message = "A disciplina não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_disciplina_id")
    private Disciplina disciplina;

    public Nota() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

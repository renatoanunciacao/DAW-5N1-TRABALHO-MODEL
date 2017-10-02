/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais do que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "A carga horária não pode ser nula")
    @Min(value = 0, message = "A carga horária não pode ser menor do que {value}")
    @Column(name = "carga_horaria", columnDefinition = "decimal(12,2)", nullable = false)
    private Double cargaHoraria;
   
    @Column(name = "conhecimentos_minimos", columnDefinition = "text")
    private String conhecimentosMinimos;
    
    @ManyToMany
    @JoinTable(name = "alunosdadisciplina", joinColumns = 
            @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "aluno", referencedColumnName =  "id", nullable = false))
    private List<Aluno> alunosdadisciplina = new ArrayList<>();
    
   @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas;
   
   @NotNull(message = "O curso não pode ser nulo")
   @ManyToOne
   @JoinColumn(name = "curso", referencedColumnName = "id", nullable = true)
   @ForeignKey(name = "fk_curso_id")
   private Curso curso;
    

    
    public Disciplina(){
        
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    public List<Aluno> getAlunosdadisciplina() {
        return alunosdadisciplina;
    }

    public void setAlunosdadisciplina(List<Aluno> alunosdadisciplina) {
        this.alunosdadisciplina = alunosdadisciplina;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



  
}

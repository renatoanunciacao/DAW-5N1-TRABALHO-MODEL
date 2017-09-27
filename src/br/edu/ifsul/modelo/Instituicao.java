/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "instituicao")
public class Instituicao implements Serializable{
    
    @Id @SequenceGenerator(name = "seq_instituicao", sequenceName = "seq_instituicao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_instituicao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais do {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O ano de fundação não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "ano_fundacao", nullable = false)
    private Calendar anoFundacao;
    
    
   

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

    public Calendar getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(Calendar anoFundacao) {
        this.anoFundacao = anoFundacao;
    }


    
    
}

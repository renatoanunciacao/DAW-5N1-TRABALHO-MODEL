/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato
 */
public class PersistirProfessor {

    EntityManagerFactory emf;
    EntityManager em;

    public PersistirProfessor() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-TRABALHO-2017-2-PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Professor p = new Professor();
            p.setNome("Jorge Bavaresco");
            p.setEmail("jorge.bavaresco@ifsul.edu.br");
            p.setNascimento(Calendar.getInstance());
            p.setTitulacao("Mestrado");
            p.setTopicosInteresse("Java Web, Java Desktop, Orientação a objetos");
            Especialidade e = new Especialidade();
            e.setNome("Java Web");

            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();

            p.setEspecialidade(e);

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }
        Assert.assertEquals(false, exception);
    }

}

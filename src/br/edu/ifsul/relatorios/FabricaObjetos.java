/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.relatorios;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Renato
 */
public class FabricaObjetos {

    public static List<Curso> carregaCursos() {
        List<Curso> lista = new ArrayList<>();
        Curso c = new Curso();
        Instituicao i = new Instituicao();
        Disciplina d = new Disciplina();
        
        i.setNome("IFSUL");
        i.setAnoFundacao(Calendar.getInstance());
         
        c.setNome("Tecnologia em Sistemas para internet");
        c.setSigla("TSPI");
        c.setDescricao("Formar profissionais qualificados ... ");
        c.setAtivo(true);
        c.setIniciAtividades(Calendar.getInstance());
        c.setInstituicao(i);
        
        d.setNome("Algoritmos I");
        d.setDescricao("bla bla bla");
        d.setCargaHoraria(120.00);
        d.setConhecimentosMinimos("Estudar e vontade de aprender ... ");
        d.setCurso(c);
          
        c.adicionarDisciplina(d);
        lista.add(c);

        return lista;
    }
}

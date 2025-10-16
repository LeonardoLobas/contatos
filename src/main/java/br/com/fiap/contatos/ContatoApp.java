package br.com.fiap.contatos;

import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;


import java.time.LocalDate;

public class ContatoApp {

    public static void main(String[] args) {
        EntityManager em = Conexao.getEntityManager();
        //cadastrar(em);
        //atualizar(em);
        //remover(em);
        //consultar(em, 1L);
        consultarTodos(em);
        em.close();
        Conexao.EMF.close();
    }

    public static void cadastrar(EntityManager em) {
        Contato contato = new Contato();
        contato.setNome("Eduardo Silva");
        contato.setEmail("eduardo@gmail.com");
        contato.setDataNascimento(LocalDate.of(2000, 11, 10));
        ContatoDao contatoDao = new ContatoDao(em);
        contatoDao.salvar(contato);
    }

    public static void atualizar(EntityManager em) {
        Contato contato = new Contato();

            contato.setId(3L);
            contato.setNome("Eduardo Silva");
            contato.setEmail("eduardosilva@gmail.com");
            contato.setDataNascimento(LocalDate.of(2000, 11, 10));
            ContatoDao contatoDao = new ContatoDao(em);
            contatoDao.atualizar(contato);

    }

    public static void remover(EntityManager em) {
        Contato contato = new Contato();
        contato.setId(3L);
        ContatoDao contatoDao = new ContatoDao(em);
        contatoDao.excluir(contato);
    }

    public static void consultar(EntityManager em, Long id) {

        ContatoDao contatoDao = new ContatoDao(em);
        contatoDao.consultar(id);
    }

    public static void consultarTodos(EntityManager em) {
        ContatoDao contatoDao = new ContatoDao(em);
        contatoDao.consultarTodos().forEach(System.out::println);
    }
}

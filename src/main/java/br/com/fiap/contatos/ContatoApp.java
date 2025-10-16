package br.com.fiap.contatos;

import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.dao.TipoContatoDao;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;


import java.time.LocalDate;

public class ContatoApp {

    public static void main(String[] args) {
        EntityManager em = Conexao.getEntityManager();
        cadastrarTipoContato(em);
        cadastrar(em);
        //atualizar(em);
        //remover(em);
        //consultar(em, 1L);
       // consultarTodos(em);
        em.close();
        Conexao.EMF.close();
    }

    public static void cadastrarTipoContato(EntityManager em) {
        TipoContato tipoFamilia = new TipoContato();
        tipoFamilia.setDescricao("Família");

        TipoContato tipoAmigo = new TipoContato();
        tipoAmigo.setDescricao("Amigo");

        TipoContato tipoTrabalho = new TipoContato();
        tipoTrabalho.setDescricao("Trabalho");

        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);
        tipoContatoDao.salvar(tipoFamilia);
        tipoContatoDao.salvar(tipoAmigo);
        tipoContatoDao.salvar(tipoTrabalho);

        System.out.println("Tipos de contato cadastrados com sucesso!");
    }

    public static void cadastrar(EntityManager em) {
        // Buscar o tipo de contato Amigo pela descrição ou usar o ID retornado
        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);
        TipoContato tipoAmigo = tipoContatoDao.buscarPorId(1L);

        if (tipoAmigo == null) {
            System.out.println("Tipo de contato não encontrado! Execute cadastrarTipoContato primeiro.");
            return;
        }

        Contato contato = new Contato();
        contato.setNome("Jean Silva");
        contato.setEmail("jean@gmail.com");
        contato.setDataNascimento(LocalDate.of(2000, 11, 10));
        contato.setTipoContato(tipoAmigo);

        ContatoDao contatoDao = new ContatoDao(em);
        contatoDao.salvar(contato);
        System.out.println("Contato cadastrado com sucesso!");
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

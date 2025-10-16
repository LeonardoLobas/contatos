package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Contato contato) {
        em.getTransaction().begin();
        em.persist(contato);
        em.getTransaction().commit();
    }

    public  void atualizar(Contato contato) {
        em.getTransaction().begin();
        em.merge(contato);
        em.getTransaction().commit();
    }

    public void excluir(Contato contato) {

        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.getTransaction().begin();
        em.remove(contatoExcluir);
        em.getTransaction().commit();
    }

    public void consultar(Long id) {
        Contato contatoConsultar = em.find(Contato.class, id);
        if (contatoConsultar == null) {
            System.out.println("Contato n��o encontrado");
            return;
        }
        System.out.println(contatoConsultar.toString());
    }
}

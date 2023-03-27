package br.com.coutrim.apostas.dao;

import br.com.coutrim.apostas.model.Apostas;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Model
public class ApostasDAO extends Apostas {

    @PersistenceContext
    private EntityManager entityManager;

    public ApostasDAO() {
        super(Apostas.class);
    }

    public List<Long> buscarApostas() {
        Query query = entityManager.createQuery("select a from Apostas a");
        return query.getResultList();

    }

    public Apostas buscarAposta(Long id) {
        Query query = entityManager.createQuery("SELECT a FROM Apostas a WHERE a.id = :id");
        query.setParameter("id", id);
        return entityManager.find(Apostas.class, id);
    }

    public Object criarAposta(Apostas apostas) {
        entityManager.persist(apostas);
        return apostas;
    }

    public Apostas atualizarAposta(Apostas aposta){
        return entityManager.merge(aposta);
    }

    public Apostas removerAposta(Long id, Apostas aposta){
         entityManager.createQuery("DELETE Apostas a WHERE a.id =:id").setParameter("id", id).executeUpdate();
        return aposta;
    }
}

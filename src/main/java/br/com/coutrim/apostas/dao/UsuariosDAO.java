package br.com.coutrim.apostas.dao;

import br.com.coutrim.apostas.model.Apostas;
import br.com.coutrim.apostas.model.Usuarios;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Model
@Transactional
public class UsuariosDAO extends Usuarios {
    @PersistenceContext
    private EntityManager entityManager;

    public UsuariosDAO() {
        super(Usuarios.class);
    }

    public List<Long> buscarUsuarios() {
        Query query = entityManager.createQuery("SELECT u  FROM Usuarios u");
        return query.getResultList();
    }

    public Usuarios buscarPorId(Long id) {
        Query query = entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.id = :id");
        query.setParameter("id", id);
        return entityManager.find(Usuarios.class, id);
    }

    public Object criarUsuario(Usuarios usuarios) {
        entityManager.persist(usuarios);
        return usuarios;
    }

    public Usuarios atualizarUsuario(Usuarios usuario) {
        entityManager.merge(usuario);
        return usuario;
    }

    public Usuarios removerUsuario(Long id, Usuarios usuario) {
        entityManager.createQuery("DELETE Usuarios u WHERE u.id =:id").setParameter("id", id).executeUpdate();
        return usuario;
    }


}

package com.masbytes.login.persistencia;

import com.masbytes.login.logica.Rol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class RolJpaController implements Serializable {
    
    public RolJpaController(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public RolJpaController() {
        emf = Persistence.createEntityManagerFactory("loginPU");
    }
    
    public void create(Rol rol) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Rol findRol(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }
    
    public void edit(Rol rol) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroy(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId();
            } catch (Exception e) {
                throw new RuntimeException("The rol with id " + id + " no longer exists.", e);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para obtener todos los roles
    public List<Rol> findRolEntities() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r", Rol.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}

package br.com.davi.sistema.util;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class UtilDAO<T> {

    private final Class<T> entityClass;
    
    public UtilDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEm();
    
    public void create(T entity) {
        getEm().persist(entity);
    }
    
    public void edit(T entity) {
        getEm().merge(entity);
    }
    
    public void remove(T entity) {
        getEm().remove(getEm().merge(entity));
    }
    
    public T find(Object id) {
        return getEm().find(entityClass, id);
    }
    
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEm().createQuery(cq).getResultList();
    }
    
}
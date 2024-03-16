package persistence.entity.entitymanager;

import persistence.entity.common.EntityId;

public interface EntityManager {

    <T> T find(Class<T> clazz, EntityId id);

    <T> T getReference(Class<T> clazz, EntityId id);

    void persist(Object entity);

    void merge(Object entity);

    void remove(Object entity);
}

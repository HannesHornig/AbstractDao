package dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

public abstract class AbstractDao<T> implements GenericDao<T> {

	private Class<T> classType;
	private EntityManager entityManager;
	private final static String PERSISTENCE_UNIT = "hibernateTest";

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
		this.classType = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]);
	}

	public void insert(T element) {

		entityManager.getTransaction().begin();
		entityManager.persist(element);
		entityManager.getTransaction().commit();

	}

	public T find(int primaryKey) {

		T element;
		entityManager.getTransaction().begin();
		element = entityManager.find(classType, primaryKey);
		entityManager.getTransaction().commit();
		return element;

	}

	public void delete(T element) {
		entityManager.getTransaction().begin();
		entityManager.remove(element);
		entityManager.getTransaction().commit();

	}

	public int deleteTableContent() {

		entityManager.getTransaction().begin();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<T> delete = criteriaBuilder.createCriteriaDelete(classType);
		delete.from(classType);
		int numberOfDeletedFirmen = entityManager.createQuery(delete).executeUpdate();
		entityManager.getTransaction().commit();
		return numberOfDeletedFirmen;

	}

}

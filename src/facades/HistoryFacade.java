/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.History;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tools.EntityManagerSingleton;

/**
 *
 * @author Melnikov
 */
public class HistoryFacade extends AbstractFacade<History>{
  private EntityManager em;

    public HistoryFacade() {
        super(History.class);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
//        this.em = emf.createEntityManager();
        EntityManagerSingleton entityManagerSingleton = EntityManagerSingleton.getInstance();
        this.em = entityManagerSingleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<History> findAllReadingBooks() {
//        return em.createQuery("SELECT history FROM History history WHERE history.dateBack = null").getResultList();
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<History> criteriaQuery = criteriaBuilder.createQuery(History.class);
        Root<History> root = criteriaQuery.from(History.class);
        // Создаем предикат для проверки наличия значения null
        Predicate predicate = criteriaBuilder.isNull(root.get("dateBack"));
        // Добавляем предикат в CriteriaQuery
        criteriaQuery.where(predicate);
        // Выполняем запрос и возвращаем результат
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}

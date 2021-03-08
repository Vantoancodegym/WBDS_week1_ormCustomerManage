package service;

import model.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
public class CustomerService implements ICustomer{
    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private SessionFactory sessionFactory;
//    private SessionFactory sessionFactory;


    public CustomerService(){}
    @Override
    public List<Customer> findAll() {
//        String queryStr="SELECT c FROM Customer AS c";
//        Session session = this.sessionFactory.openSession();
//        List<Customer> result = session.createQuery(queryStr, Customer.class).getResultList();
//        return result;
        String queryStr="SELECT c FROM Customer AS c";
        TypedQuery<Customer> query= entityManager.createQuery(queryStr,Customer.class);
        return query.getResultList();

    }

    @Override
    public Customer findById(int id) {
        String queryStr="SELECT c FROM Customer AS c WHERE c.id= :id";
//        Session session = this.sessionFactory.openSession();
        TypedQuery<Customer> query= entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id",id);
        Customer result=query.getSingleResult();
        return result;
    }

    @Override
    public Customer update(Customer customer) {
//        Session session=null;
//        Transaction transaction=null;
//        try {
//            session= sessionFactory.openSession();
//            transaction=session.beginTransaction();
//            session.update(customer);
//            transaction.commit();
//            return customer;
//        }catch (Exception e){
//            e.printStackTrace();
//            if (transaction!=null) transaction.rollback();
//        }finally {
//            if (session!=null) session.close();
//
//        }
        entityManager.merge(customer);
        return null;
    }

    @Override
    public Customer save(Customer customer) {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(customer);
//            transaction.commit();
//            return customer;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
        entityManager.persist(customer);
        return null;
    }

    @Override
    public void remove(int id) {
        Customer customer=findById(id);
//        Session session = this.sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.delete(customer);
//        tx.commit();
//        session.close();
//        String queryStr="DELETE FROM Customer AS c WHERE c.id= :id";
//        TypedQuery<Customer> query= entityManager.createQuery(queryStr,Customer.class);
//        query.setParameter("id",id);
//        query.getSingleResult();
        entityManager.remove(customer);

    }
}

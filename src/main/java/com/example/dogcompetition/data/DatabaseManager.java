package com.example.dogcompetition.data;
import com.example.dogcompetition.nousage.Course;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static SessionFactory factory;

    public DatabaseManager() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(Handler.class)
                    .addAnnotatedClass(Dog.class)
                    .addAnnotatedClass(Result.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Course.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void save(Object item) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void saveList(List <Object> items){

        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            for ( var item: items
                 ) {
             session.save(item);
            }
            tx.commit();
        } catch (HibernateException exception) {
            if(tx !=null){
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

   public List<Dog> getDogs(){
        var session = factory.openSession();
       var query = "FROM Dog D ORDER BY D.level asc, D.size DESC";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public Dog getById(int id) {
        var session = factory.openSession();

        try {
            return session.get(Dog.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public Result getResultById(int id) {
        var session = factory.openSession();

        try {
            return session.get(Result.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public List<Result> getResults() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Result").list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public List<Result> getSortedResults() {
        var session = factory.openSession();
        var query = "FROM Result R ORDER BY R.totalFaults asc, R.time asc";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public List<Result> getSortedResultsForA0() {
        var session = factory.openSession();
        var query = "FROM Result R  where R.dog.level like'A0' ORDER BY R.totalFaults asc, R.time asc";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public List<Result> getSortedResultsForA1() {
        var session = factory.openSession();
        var query = "FROM Result R  where R.dog.level like'A1' ORDER BY R.totalFaults asc, R.time asc";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public List<Result> getSortedResultsForA2() {
        var session = factory.openSession();
        var query = "FROM Result R  where R.dog.level like'A2' ORDER BY R.totalFaults asc, R.time asc";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public List<Result> getSortedResultsForA3() {
        var session = factory.openSession();
        var query = "FROM Result R  where R.dog.level like'A3' ORDER BY R.totalFaults asc, R.time asc";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    public void update(Object item) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void updateResult(Result result) {
        if(result.getId() == 0) {
            return;
        }
        update(result);
    }

    public User login(String email, String password) {
        var session = factory.openSession();

        try {
            String hql = "FROM User U WHERE U.email = :email and U.password = MD5(:pwd)";
            Query query1 = session.createQuery(hql);

            query1.setParameter("email", email);
            query1.setParameter("pwd", password);

            var results = query1.list();

            if (results.size() > 0) {
                return (User) results.get(0);
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return null;
    }

    public void delete(Object obj) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }
}

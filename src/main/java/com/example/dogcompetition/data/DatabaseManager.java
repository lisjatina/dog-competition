package com.example.dogcompetition.data;
import com.example.dogcompetition.dto.ParticipantDto;
import com.example.dogcompetition.dto.RegistrationDto;
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
                    .addAnnotatedClass(Breed.class)
                    .addAnnotatedClass(Result.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void save(List <Object> items){

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

    public List<Breed> getBreeds(){
       var session = factory.openSession();

            try {
                return session.createQuery("FROM Breed").list();
            } catch (HibernateException exception) {
                System.err.println(exception);
            } finally {
                session.close();
            }
            return new ArrayList<>();
        }

    public List<Dog> getDogs(){
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Dog").list();
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

    public List<Result> getResults() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Result ").list();
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
            Query query = session.createQuery(hql);

            query.setParameter("email", email);
            query.setParameter("pwd", password);

            var results = query.list();

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

    // just an example how to map
//    public List<Plant> getYourPlants(int id){
//        var myGarden = getGarden().stream().
//                filter(g-> (g.getUserId().equals(id))).collect(Collectors.toList());
//
//        var myPlants = myGarden.stream()
//                .map(p -> new Plant(
//                        p.getPlant().getId(),
//                        p.getPlant().getImageId(),
//                        p.getPlant().getScienceName(),
//                        p.getPlant().getName(),
//                        p.getPlant().getDescription(),
//                        p.getPlant().getMoisture(),
//                        p.getPlant().getSunlight(),
//                        p.getPlant().getWatering(),
//                        p.getPlant().getPetToxic(),
//                        p.getPlant().getType(),
//                        p.getPlant().getBloom(),
//                        p.getPlant().getHumidity()))
//                .collect(Collectors.toList());
//
//        return myPlants;
//    }


// TODO: 4/10/2021
//    public void startCompetition(ParticipantDto participantDto, Integer length, Double speed){
//        List <ParticipantDto> currentParticipants = getParticipants();
//        course = new Course(length, speed);
//        var standardTime = course.calculateStandardTime(); // надо записать значение в базу и отобразить в html
//        var maxTime = course.calculateMaxTime(); // надо записать значение в базу и отобразить в html
//        course.calculateResult(participantDto); // надо записать значение в базу и отобразить в html
//    }


}

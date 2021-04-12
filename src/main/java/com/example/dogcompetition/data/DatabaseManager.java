package com.example.dogcompetition.data;
import com.example.dogcompetition.dto.ParticipantDto;
import com.example.dogcompetition.dto.RegistrationDto;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

// TODO: 4/10/2021
//    public void startCompetition(ParticipantDto participantDto, Integer length, Double speed){
//        List <ParticipantDto> currentParticipants = getParticipants();
//        course = new Course(length, speed);
//        var standardTime = course.calculateStandardTime(); // надо записать значение в базу и отобразить в html
//        var maxTime = course.calculateMaxTime(); // надо записать значение в базу и отобразить в html
//        course.calculateResult(participantDto); // надо записать значение в базу и отобразить в html
//    }


}

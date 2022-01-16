package com.sda.weather;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@RequiredArgsConstructor
public class WeatherRepository {

    private final SessionFactory sessionFactory;

    public Weather save(Weather weather) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(weather);
        transaction.commit();
        session.close();
        return weather;
    }

    public Weather findById(Long id) {
        Session session = sessionFactory.openSession();
        Weather weather = session.get(Weather.class, id);
        session.close();
        return weather;
    }

    public List<Weather> findAll() {
        Session session = sessionFactory.openSession();
        List<Weather> weathers = session.createQuery("FROM Weather", Weather.class).list();
        session.close();
        return weathers;
    }

}

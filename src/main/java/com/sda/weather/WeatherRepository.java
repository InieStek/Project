package com.sda.weather;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class WeatherRepository {

    private final SessionFactory sessionFactory;

    public Localization save(Localization localization) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(localization);
        transaction.commit();
        session.close();
        return localization;
    }
}

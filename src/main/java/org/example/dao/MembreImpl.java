package org.example.dao;

import org.example.config.SessionFactoryProvider;
import org.example.entities.Membre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MembreImpl implements IMembre{
    SessionFactory sessionFactory= SessionFactoryProvider.provideSessionFactory();
    Session session=sessionFactory.openSession();
    Transaction transaction=session.beginTransaction();
    @Override
    public void save(Membre membre) {
        membre.setUsename(membre.getUsename());
        session.save(membre);
//        transaction.commit();
//        sessionFactory.close();
    }

    @Override
    public Membre getMembreByUsername(String username) {
        Long key = Long.valueOf(1);
        Membre membre = session.find(Membre.class, key);
        System.out.println(membre);
        transaction.commit();
        sessionFactory.close();
        return membre;
    }
}

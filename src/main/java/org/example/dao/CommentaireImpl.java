package org.example.dao;

import org.example.config.SessionFactoryProvider;
import org.example.entities.Commentaire;
import org.example.entities.Membre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class CommentaireImpl implements ICommentaire{
    SessionFactory sessionFactory= SessionFactoryProvider.provideSessionFactory();
    Session session=sessionFactory.openSession();
    Transaction transaction=session.beginTransaction();
    @Override
    public void save(Commentaire commentaire,String username) {
        MembreImpl membre=new MembreImpl();
        Membre membreToComment=membre.getMembreByUsername(username);
        commentaire.setMembre(membreToComment);
        session.save(commentaire);
        transaction.commit();
        sessionFactory.close();
    }
}

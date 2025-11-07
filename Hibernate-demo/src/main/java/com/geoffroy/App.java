package com.geoffroy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Alien a1 = new Alien();
        a1.setAid(102);
        a1.setAname("Igor");
        a1.setTech("Cloud");
        // configure database (one factory per app)
        Configuration config = new Configuration();
        config.addAnnotatedClass(com.geoffroy.Alien.class);
        config.configure();
        SessionFactory factory = config.buildSessionFactory();

        // do a session every time you want to do a request
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        session.merge(a1);
        transaction.commit();
    }
}

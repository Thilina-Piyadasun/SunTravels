package it.codegen.suntravel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by thilinap on 4/11/2017.
 */

public class SingletonSessionFactory {

    static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();;

    private SingletonSessionFactory(){}

    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }

}

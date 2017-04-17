package com.cgn.reservation.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;

/**
 * Created by acer on 4/10/2017.
 */
public class DBConnection {

    public static void main(String args[]){
        try{

            SessionFactory sf=new Configuration().configure().buildSessionFactory();
            Session session=sf.openSession();
            session.beginTransaction();
            byte no1=1;
           // RoomEntity rb = (RoomEntity) session.get(RoomEntity.class, no1); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.

           // System.out.println(rb);
            CountryEntity countryEntity=new CountryEntity();
            byte no=3;
            countryEntity.setId(no);
            countryEntity.setName(" SRI LANKA ");
            session.save(countryEntity);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.out.println(e);}
        }
}
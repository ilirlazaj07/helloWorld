/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.guitar.helloworld.util;

/**
 *
 * @author ILAZAJ
 */
import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")

//Implementazione Singleton secondo Bill Pugh
public class Risorsa implements Serializable {

    private static final long serialVersionUID = 3214096628548109043L;

    private static final SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();

    private Risorsa() {
    }

    private static class HelperRisorsa {

        private static final Risorsa ISTANZA = new Risorsa();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static SessionFactory getIstanza() {
        return HelperRisorsa.ISTANZA.sessionFactory;
    }

    private Object readResolve() {
        return HelperRisorsa.ISTANZA;
    }

}


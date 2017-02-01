package it.guitar.helloworld.ws.daos;

import it.guitar.helloworld.entities.Corso;
import it.guitar.helloworld.util.Risorsa;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ILAZAJ
 */
public class CorsoDAO {
    
    public static Response inserisciCorso(Corso corso) {
        Response response = Response.status(201).entity("[\"esito: inserito\"]").build();;
        Session session = Risorsa.getIstanza().openSession();
        Transaction transazione = null;
        try {
            transazione = session.beginTransaction();
            session.save(corso);
            transazione.commit();
        } catch (HibernateException e) {
            if (transazione != null) {
                transazione.rollback();
            }
            e.printStackTrace();
            response = Response.status(500).entity("[\"esito: non inserito\"]").build();
        } finally {
            session.close();
        }
        return response;
    }
    
    public static Response cancellaCorso(int id) {
        Response response = Response.status(201).entity("[\"esito: cancellato\"]").build();;
        Session session = Risorsa.getIstanza().openSession();
        Transaction transazione = null;
        try {
            transazione = session.beginTransaction();
            Corso corso = (Corso) session.get(Corso.class, id);
            session.delete(corso);
            transazione.commit();
        } catch (HibernateException e) {
            if (transazione != null) {
                transazione.rollback();
            }
            e.printStackTrace();
            response = Response.status(500).entity("[\"esito: non cancellato\"]").build();
        } finally {
            session.close();
        }
        return response;
    }
    
    public static List<Corso> tuttiCorsi() {
        Session session = Risorsa.getIstanza().openSession();
        Transaction transazione = null;
        List<Corso> corsi = new ArrayList<Corso>();
        
        try {
            transazione = session.beginTransaction();
            Query query = session.getNamedQuery("Corso.findAll");
            corsi = query.list();
            transazione.commit();
        } catch (HibernateException e) {
            if (transazione != null) {
                transazione.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return corsi;
    }
    
    public static Response modificaCorso(Corso corsoIn) {
        Response response = Response.status(200).entity("[\"esito: modificato\"]").build();;
        Session session = Risorsa.getIstanza().openSession();
        Transaction transazione = null;
        
        try {
            transazione = session.beginTransaction();
            Corso corso = (Corso) session.get(Corso.class, corsoIn.getId());
            corso.setDettaglio(corsoIn.getDettaglio());
            corso.setNome(corsoIn.getNome());
            session.update(corso);
            transazione.commit();
        } catch (HibernateException e) {
            if (transazione != null) {
                transazione.rollback();
            }
            e.printStackTrace();
            response = Response.status(500).entity("[\"esito: non modificato\"]").build();
        } finally {
            session.close();
        }
        
        return response;
    }
    
}

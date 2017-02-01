/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.guitar.helloworld.ws.service;

import it.guitar.helloworld.entities.Corso;
import it.guitar.helloworld.ws.daos.CorsoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ILAZAJ
 */
@Path("/corsi")
public class CorsiService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Corso> all() {
        return CorsoDAO.tuttiCorsi();
    }

    @DELETE
    @Path("/cancella/{id}")
    public Response cancella(@PathParam("id") int id) {
        return CorsoDAO.cancellaCorso(id);
    }

    @POST
    @Path("/inserisci")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserisci(Corso corso) {
        return CorsoDAO.inserisciCorso(corso);
    }

}

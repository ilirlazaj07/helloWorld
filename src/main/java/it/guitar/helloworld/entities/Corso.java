/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.guitar.helloworld.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ILAZAJ
 */
@Entity
@Table(name = "corso", catalog = "guitarstudio", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corso.findAll", query = "SELECT c FROM Corso c"),
    @NamedQuery(name = "Corso.findById", query = "SELECT c FROM Corso c WHERE c.id = :id"),
    @NamedQuery(name = "Corso.findByNome", query = "SELECT c FROM Corso c WHERE c.nome = :nome"),
    @NamedQuery(name = "Corso.findByDettaglio", query = "SELECT c FROM Corso c WHERE c.dettaglio = :dettaglio")})
public class Corso implements Serializable {
    private static final long serialVersionUID = 156452525258L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "dettaglio")
    private String dettaglio;

    public Corso() {
    }

    public Corso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDettaglio() {
        return dettaglio;
    }

    public void setDettaglio(String dettaglio) {
        this.dettaglio = dettaglio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Corso)) {
            return false;
        }
        Corso other = (Corso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.guitar.helloworld.entities.Corso[ id=" + id + " ]";
    }
    
}

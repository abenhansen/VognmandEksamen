package vognmand.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Opgave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firma;
    private String kontaktPerson;
    private int kundeTlf;
    private String email;;
    private int prioritet;
    @ManyToMany
    @JoinColumn(name = "id")
   private List<Bruger> brugere;


    public Opgave(String firma, String kontaktPerson, int kundeTlf, String email, int prioritet, List<Bruger> brugere) {
        this.firma = firma;
        this.kontaktPerson = kontaktPerson;
        this.kundeTlf = kundeTlf;
        this.email = email;
        this.prioritet = prioritet;
        this.brugere = brugere;
    }

    public Opgave() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getKontaktPerson() {
        return kontaktPerson;
    }

    public void setKontaktPerson(String kontaktPerson) {
        this.kontaktPerson = kontaktPerson;
    }

    public int getKundeTlf() {
        return kundeTlf;
    }

    public void setKundeTlf(int kundeTlf) {
        this.kundeTlf = kundeTlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrioritet() {
        return prioritet;
    }

    public void setPrioritet(int prioritet) {
        this.prioritet = prioritet;
    }

    public List<Bruger> getBrugere() {
        return brugere;
    }

    public void setBrugere(List<Bruger> brugere) {
        this.brugere = brugere;
    }
}

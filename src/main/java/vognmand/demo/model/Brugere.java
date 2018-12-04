package vognmand.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brugere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brugernavn;
    private String password;
    private int aktiv;
    private String rolle;

    public Brugere(String brugernavn, String password, int aktiv, String rolle) {
        this.brugernavn = brugernavn;
        this.password = password;
        this.aktiv = aktiv;
        this.rolle = rolle;
    }

    public Brugere (){

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAktiv() {
        return aktiv;
    }

    public void setAktiv(int aktiv) {
        this.aktiv = aktiv;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}

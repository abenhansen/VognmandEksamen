package vognmand.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bruger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brugernavn;
    private String password;
    private int aktiv;
    private String rolle;
    private String navn;
    private String email;
    private int nummer;

    public Bruger(String brugernavn, String password, int aktiv, String rolle, String navn, String email, int nummer) {
        this.brugernavn = brugernavn;
        this.password = password;
        this.aktiv = aktiv;
        this.rolle = rolle;
        this.navn = navn;
        this.email = email;
        this.nummer = nummer;
    }

    public Bruger () {


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

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return navn;
    }
}

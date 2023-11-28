package cz.oauh.test20231113;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SkladovaPolozka {
    private String skladovaPolozka;
    private int mnozstvi;
    private double hmotnost;
    private BigDecimal cena;
    private boolean dostupnost;
    private LocalDate datum = LocalDate.now();

    public SkladovaPolozka(String skladovaPolozka, BigDecimal cena)  {
        this.skladovaPolozka = skladovaPolozka;
        this.cena = cena;
    }

    public SkladovaPolozka(String skladovaPolozka, int mnozstvi, BigDecimal cena) {
        this.skladovaPolozka = skladovaPolozka;
        this.mnozstvi = mnozstvi;
        this.cena = cena;
    }

    public SkladovaPolozka(String skladovaPolozka, int mnozstvi, double hmotnost, BigDecimal cena) {
        this.skladovaPolozka = skladovaPolozka;
        this.mnozstvi = mnozstvi;
        this.hmotnost = hmotnost;
        this.cena = cena;
    }

    public SkladovaPolozka(String skladovaPolozka, int mnozstvi, double hmotnost, BigDecimal cena, boolean dostupnost) {
        this.skladovaPolozka = skladovaPolozka;
        this.mnozstvi = mnozstvi;
        this.hmotnost = hmotnost;
        this.cena = cena;
        this.dostupnost = dostupnost;
    }

    public SkladovaPolozka(String skladovaPolozka, int mnozstvi, double hmotnost, BigDecimal cena, boolean dostupnost, LocalDate datum) {
        this.skladovaPolozka = skladovaPolozka;
        this.mnozstvi = mnozstvi;
        this.hmotnost = hmotnost;
        this.cena = cena;
        this.dostupnost = dostupnost;
        this.datum = datum;
    }

    public SkladovaPolozka(String skladovaPolozka, int mnozstvi, BigDecimal cena, boolean dostupnost) {
        this.skladovaPolozka = skladovaPolozka;
        this.mnozstvi = mnozstvi;
        this.cena = cena;
        this.dostupnost = dostupnost;
    }

    public SkladovaPolozka(String skladovaPolozka, int mnozstvi, BigDecimal cena, boolean dostupnost, LocalDate datum) {
        this.skladovaPolozka = skladovaPolozka;
        this.mnozstvi = mnozstvi;
        this.cena = cena;
        this.dostupnost = dostupnost;
        this.datum = datum;
    }

    public String getSkladovaPolozka() {
        return skladovaPolozka;
    }

    public void setSkladovaPolozka(String skladovaPolozka) {
        this.skladovaPolozka = skladovaPolozka;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(int mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    public double getHmotnost() {
        return hmotnost;
    }

    public void setHmotnost(double hmotnost) {
        this.hmotnost = hmotnost;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}

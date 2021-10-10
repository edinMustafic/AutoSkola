package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Termin {
    private int id;
    private String kanidatJmbg;
    private String instruktorJmbg;
    private Timestamp vrijemePocetka;
    private Timestamp vrijemeZavrsetka;
    private int tip;
    private String lokacija;
    private byte prevoz;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "KanidatJMBG")
    public String getKanidatJmbg() {
        return kanidatJmbg;
    }

    public void setKanidatJmbg(String kanidatJmbg) {
        this.kanidatJmbg = kanidatJmbg;
    }

    @Basic
    @Column(name = "InstruktorJMBG")
    public String getInstruktorJmbg() {
        return instruktorJmbg;
    }

    public void setInstruktorJmbg(String instruktorJmbg) {
        this.instruktorJmbg = instruktorJmbg;
    }

    @Basic
    @Column(name = "VrijemePocetka")
    public Timestamp getVrijemePocetka() {
        return vrijemePocetka;
    }

    public void setVrijemePocetka(Timestamp vrijemePocetka) {
        this.vrijemePocetka = vrijemePocetka;
    }

    @Basic
    @Column(name = "VrijemeZavrsetka")
    public Timestamp getVrijemeZavrsetka() {
        return vrijemeZavrsetka;
    }

    public void setVrijemeZavrsetka(Timestamp vrijemeZavrsetka) {
        this.vrijemeZavrsetka = vrijemeZavrsetka;
    }

    @Basic
    @Column(name = "Tip")
    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    @Basic
    @Column(name = "Lokacija")
    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    @Basic
    @Column(name = "Prevoz")
    public byte getPrevoz() {
        return prevoz;
    }

    public void setPrevoz(byte prevoz) {
        this.prevoz = prevoz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Termin termin = (Termin) o;

        if (id != termin.id) return false;
        if (tip != termin.tip) return false;
        if (prevoz != termin.prevoz) return false;
        if (kanidatJmbg != null ? !kanidatJmbg.equals(termin.kanidatJmbg) : termin.kanidatJmbg != null) return false;
        if (instruktorJmbg != null ? !instruktorJmbg.equals(termin.instruktorJmbg) : termin.instruktorJmbg != null)
            return false;
        if (vrijemePocetka != null ? !vrijemePocetka.equals(termin.vrijemePocetka) : termin.vrijemePocetka != null)
            return false;
        if (vrijemeZavrsetka != null ? !vrijemeZavrsetka.equals(termin.vrijemeZavrsetka) : termin.vrijemeZavrsetka != null)
            return false;
        if (lokacija != null ? !lokacija.equals(termin.lokacija) : termin.lokacija != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (kanidatJmbg != null ? kanidatJmbg.hashCode() : 0);
        result = 31 * result + (instruktorJmbg != null ? instruktorJmbg.hashCode() : 0);
        result = 31 * result + (vrijemePocetka != null ? vrijemePocetka.hashCode() : 0);
        result = 31 * result + (vrijemeZavrsetka != null ? vrijemeZavrsetka.hashCode() : 0);
        result = 31 * result + tip;
        result = 31 * result + (lokacija != null ? lokacija.hashCode() : 0);
        result = 31 * result + (int) prevoz;
        return result;
    }
}

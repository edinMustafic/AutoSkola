package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

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
        if (!Objects.equals(kanidatJmbg, termin.kanidatJmbg)) return false;
        if (!Objects.equals(instruktorJmbg, termin.instruktorJmbg))
            return false;
        if (!Objects.equals(vrijemePocetka, termin.vrijemePocetka))
            return false;
        if (!Objects.equals(vrijemeZavrsetka, termin.vrijemeZavrsetka))
            return false;
        return Objects.equals(lokacija, termin.lokacija);
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

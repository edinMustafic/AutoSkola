package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ObucavaPK.class)
public class Obucava {
    private int jmbgInstruktor;
    private int tipKategorija;

    @Id
    @Column(name = "JMBGInstruktor")
    public int getJmbgInstruktor() {
        return jmbgInstruktor;
    }

    public void setJmbgInstruktor(int jmbgInstruktor) {
        this.jmbgInstruktor = jmbgInstruktor;
    }

    @Id
    @Column(name = "TipKategorija")
    public int getTipKategorija() {
        return tipKategorija;
    }

    public void setTipKategorija(int tipKategorija) {
        this.tipKategorija = tipKategorija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Obucava obucava = (Obucava) o;

        if (jmbgInstruktor != obucava.jmbgInstruktor) return false;
        if (tipKategorija != obucava.tipKategorija) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jmbgInstruktor;
        result = 31 * result + tipKategorija;
        return result;
    }
}

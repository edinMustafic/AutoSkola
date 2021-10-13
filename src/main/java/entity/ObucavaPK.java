package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ObucavaPK implements Serializable {
    private int jmbgInstruktor;
    private int tipKategorija;

    @Column(name = "JMBGInstruktor")
    @Id
    public int getJmbgInstruktor() {
        return jmbgInstruktor;
    }

    public void setJmbgInstruktor(int jmbgInstruktor) {
        this.jmbgInstruktor = jmbgInstruktor;
    }

    @Column(name = "TipKategorija")
    @Id
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

        ObucavaPK obucavaPK = (ObucavaPK) o;

        if (jmbgInstruktor != obucavaPK.jmbgInstruktor) return false;
        return tipKategorija == obucavaPK.tipKategorija;
    }

    @Override
    public int hashCode() {
        int result = jmbgInstruktor;
        result = 31 * result + tipKategorija;
        return result;
    }
}

package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DodatniTroskovi {
    private int id;
    private String naziv;
    private double iznos;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Naziv")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "Iznos")
    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DodatniTroskovi that = (DodatniTroskovi) o;

        if (id != that.id) return false;
        if (Double.compare(that.iznos, iznos) != 0) return false;
        return Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        temp = Double.doubleToLongBits(iznos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

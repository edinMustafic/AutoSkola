package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kategorija {
    private int tip;
    private int brojCasovaTeorija;
    private double cijenaCasaTeorija;
    private int brojCasovaVoznja;
    private double cijenaCasaVoznja;

    @Id
    @Column(name = "Tip")
    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    @Basic
    @Column(name = "BrojCasovaTeorija")
    public int getBrojCasovaTeorija() {
        return brojCasovaTeorija;
    }

    public void setBrojCasovaTeorija(int brojCasovaTeorija) {
        this.brojCasovaTeorija = brojCasovaTeorija;
    }

    @Basic
    @Column(name = "CijenaCasaTeorija")
    public double getCijenaCasaTeorija() {
        return cijenaCasaTeorija;
    }

    public void setCijenaCasaTeorija(double cijenaCasaTeorija) {
        this.cijenaCasaTeorija = cijenaCasaTeorija;
    }

    @Basic
    @Column(name = "BrojCasovaVoznja")
    public int getBrojCasovaVoznja() {
        return brojCasovaVoznja;
    }

    public void setBrojCasovaVoznja(int brojCasovaVoznja) {
        this.brojCasovaVoznja = brojCasovaVoznja;
    }

    @Basic
    @Column(name = "CijenaCasaVoznja")
    public double getCijenaCasaVoznja() {
        return cijenaCasaVoznja;
    }

    public void setCijenaCasaVoznja(double cijenaCasaVoznja) {
        this.cijenaCasaVoznja = cijenaCasaVoznja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kategorija that = (Kategorija) o;

        if (tip != that.tip) return false;
        if (brojCasovaTeorija != that.brojCasovaTeorija) return false;
        if (Double.compare(that.cijenaCasaTeorija, cijenaCasaTeorija) != 0) return false;
        if (brojCasovaVoznja != that.brojCasovaVoznja) return false;
        return Double.compare(that.cijenaCasaVoznja, cijenaCasaVoznja) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tip;
        result = 31 * result + brojCasovaTeorija;
        temp = Double.doubleToLongBits(cijenaCasaTeorija);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + brojCasovaVoznja;
        temp = Double.doubleToLongBits(cijenaCasaVoznja);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Instruktor {
    private String jmbg;
    private String ime;
    private String imeOca;
    private String prezime;
    private Timestamp datumRodjenja;
    private String mjestoRodjenja;
    private String mjestoStanovanja;
    private String adresa;
    private String brojTelefona;
    private String brojLicneKarte;
    private Timestamp zaposlenOd;
    private double plata;
    private Integer brojObucenihKandidata;
    private String slika;

    @Id
    @Column(name = "JMBG")
    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Basic
    @Column(name = "Ime")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "ImeOca")
    public String getImeOca() {
        return imeOca;
    }

    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }

    @Basic
    @Column(name = "Prezime")
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "DatumRodjenja")
    public Timestamp getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Timestamp datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Basic
    @Column(name = "MjestoRodjenja")
    public String getMjestoRodjenja() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
    }

    @Basic
    @Column(name = "MjestoStanovanja")
    public String getMjestoStanovanja() {
        return mjestoStanovanja;
    }

    public void setMjestoStanovanja(String mjestoStanovanja) {
        this.mjestoStanovanja = mjestoStanovanja;
    }

    @Basic
    @Column(name = "Adresa")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "BrojTelefona")
    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Basic
    @Column(name = "BrojLicneKarte")
    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    @Basic
    @Column(name = "ZaposlenOd")
    public Timestamp getZaposlenOd() {
        return zaposlenOd;
    }

    public void setZaposlenOd(Timestamp zaposlenOd) {
        this.zaposlenOd = zaposlenOd;
    }

    @Basic
    @Column(name = "Plata")
    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    @Basic
    @Column(name = "BrojObucenihKandidata")
    public Integer getBrojObucenihKandidata() {
        return brojObucenihKandidata;
    }

    public void setBrojObucenihKandidata(Integer brojObucenihKandidata) {
        this.brojObucenihKandidata = brojObucenihKandidata;
    }

    @Basic
    @Column(name = "Slika")
    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruktor that = (Instruktor) o;

        if (Double.compare(that.plata, plata) != 0) return false;
        if (jmbg != null ? !jmbg.equals(that.jmbg) : that.jmbg != null) return false;
        if (ime != null ? !ime.equals(that.ime) : that.ime != null) return false;
        if (imeOca != null ? !imeOca.equals(that.imeOca) : that.imeOca != null) return false;
        if (prezime != null ? !prezime.equals(that.prezime) : that.prezime != null) return false;
        if (datumRodjenja != null ? !datumRodjenja.equals(that.datumRodjenja) : that.datumRodjenja != null)
            return false;
        if (mjestoRodjenja != null ? !mjestoRodjenja.equals(that.mjestoRodjenja) : that.mjestoRodjenja != null)
            return false;
        if (mjestoStanovanja != null ? !mjestoStanovanja.equals(that.mjestoStanovanja) : that.mjestoStanovanja != null)
            return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;
        if (brojTelefona != null ? !brojTelefona.equals(that.brojTelefona) : that.brojTelefona != null) return false;
        if (brojLicneKarte != null ? !brojLicneKarte.equals(that.brojLicneKarte) : that.brojLicneKarte != null)
            return false;
        if (zaposlenOd != null ? !zaposlenOd.equals(that.zaposlenOd) : that.zaposlenOd != null) return false;
        if (brojObucenihKandidata != null ? !brojObucenihKandidata.equals(that.brojObucenihKandidata) : that.brojObucenihKandidata != null)
            return false;
        if (slika != null ? !slika.equals(that.slika) : that.slika != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = jmbg != null ? jmbg.hashCode() : 0;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (imeOca != null ? imeOca.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (datumRodjenja != null ? datumRodjenja.hashCode() : 0);
        result = 31 * result + (mjestoRodjenja != null ? mjestoRodjenja.hashCode() : 0);
        result = 31 * result + (mjestoStanovanja != null ? mjestoStanovanja.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (brojTelefona != null ? brojTelefona.hashCode() : 0);
        result = 31 * result + (brojLicneKarte != null ? brojLicneKarte.hashCode() : 0);
        result = 31 * result + (zaposlenOd != null ? zaposlenOd.hashCode() : 0);
        temp = Double.doubleToLongBits(plata);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (brojObucenihKandidata != null ? brojObucenihKandidata.hashCode() : 0);
        result = 31 * result + (slika != null ? slika.hashCode() : 0);
        return result;
    }
}

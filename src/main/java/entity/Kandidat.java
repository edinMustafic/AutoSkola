package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Kandidat {
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
    private Integer brojKnjiziceKandidata;
    private Integer brojFiskalnogRacuna;
    private String brojLjekarskogUvjerenja;
    private String ustanovaLjekarsko;
    private Timestamp datumIzdavanjaLjekarskog;
    private String brojPotvrdePropisi;
    private Timestamp datumPotvrdePropisi;
    private String brojPotvrdePrvaPomoc;
    private Timestamp datumPotvrdePrvaPomoc;
    private String brojPotvrdeVoznja;
    private Timestamp datumPotvrdeVoznja;
    private int brojIzlazakaPropisi;
    private int brojIzlazakaPrvaPomoc;
    private int brojIzlazakaVoznja;
    private String grupaZaTeoretskuNastavu;
    private Integer odslusanihCasovaVoznje;
    private Double trebaPlatiti;
    private Double doSadPlatio;
    private String instruktorJmbg;
    private Integer kategorijaTip;

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
    @Column(name = "BrojKnjiziceKandidata")
    public Integer getBrojKnjiziceKandidata() {
        return brojKnjiziceKandidata;
    }

    public void setBrojKnjiziceKandidata(Integer brojKnjiziceKandidata) {
        this.brojKnjiziceKandidata = brojKnjiziceKandidata;
    }

    @Basic
    @Column(name = "BrojFiskalnogRacuna")
    public Integer getBrojFiskalnogRacuna() {
        return brojFiskalnogRacuna;
    }

    public void setBrojFiskalnogRacuna(Integer brojFiskalnogRacuna) {
        this.brojFiskalnogRacuna = brojFiskalnogRacuna;
    }

    @Basic
    @Column(name = "BrojLjekarskogUvjerenja")
    public String getBrojLjekarskogUvjerenja() {
        return brojLjekarskogUvjerenja;
    }

    public void setBrojLjekarskogUvjerenja(String brojLjekarskogUvjerenja) {
        this.brojLjekarskogUvjerenja = brojLjekarskogUvjerenja;
    }

    @Basic
    @Column(name = "UstanovaLjekarsko")
    public String getUstanovaLjekarsko() {
        return ustanovaLjekarsko;
    }

    public void setUstanovaLjekarsko(String ustanovaLjekarsko) {
        this.ustanovaLjekarsko = ustanovaLjekarsko;
    }

    @Basic
    @Column(name = "DatumIzdavanjaLjekarskog")
    public Timestamp getDatumIzdavanjaLjekarskog() {
        return datumIzdavanjaLjekarskog;
    }

    public void setDatumIzdavanjaLjekarskog(Timestamp datumIzdavanjaLjekarskog) {
        this.datumIzdavanjaLjekarskog = datumIzdavanjaLjekarskog;
    }

    @Basic
    @Column(name = "BrojPotvrdePropisi")
    public String getBrojPotvrdePropisi() {
        return brojPotvrdePropisi;
    }

    public void setBrojPotvrdePropisi(String brojPotvrdePropisi) {
        this.brojPotvrdePropisi = brojPotvrdePropisi;
    }

    @Basic
    @Column(name = "DatumPotvrdePropisi")
    public Timestamp getDatumPotvrdePropisi() {
        return datumPotvrdePropisi;
    }

    public void setDatumPotvrdePropisi(Timestamp datumPotvrdePropisi) {
        this.datumPotvrdePropisi = datumPotvrdePropisi;
    }

    @Basic
    @Column(name = "BrojPotvrdePrvaPomoc")
    public String getBrojPotvrdePrvaPomoc() {
        return brojPotvrdePrvaPomoc;
    }

    public void setBrojPotvrdePrvaPomoc(String brojPotvrdePrvaPomoc) {
        this.brojPotvrdePrvaPomoc = brojPotvrdePrvaPomoc;
    }

    @Basic
    @Column(name = "DatumPotvrdePrvaPomoc")
    public Timestamp getDatumPotvrdePrvaPomoc() {
        return datumPotvrdePrvaPomoc;
    }

    public void setDatumPotvrdePrvaPomoc(Timestamp datumPotvrdePrvaPomoc) {
        this.datumPotvrdePrvaPomoc = datumPotvrdePrvaPomoc;
    }

    @Basic
    @Column(name = "BrojPotvrdeVoznja")
    public String getBrojPotvrdeVoznja() {
        return brojPotvrdeVoznja;
    }

    public void setBrojPotvrdeVoznja(String brojPotvrdeVoznja) {
        this.brojPotvrdeVoznja = brojPotvrdeVoznja;
    }

    @Basic
    @Column(name = "DatumPotvrdeVoznja")
    public Timestamp getDatumPotvrdeVoznja() {
        return datumPotvrdeVoznja;
    }

    public void setDatumPotvrdeVoznja(Timestamp datumPotvrdeVoznja) {
        this.datumPotvrdeVoznja = datumPotvrdeVoznja;
    }

    @Basic
    @Column(name = "BrojIzlazakaPropisi")
    public int getBrojIzlazakaPropisi() {
        return brojIzlazakaPropisi;
    }

    public void setBrojIzlazakaPropisi(int brojIzlazakaPropisi) {
        this.brojIzlazakaPropisi = brojIzlazakaPropisi;
    }

    @Basic
    @Column(name = "BrojIzlazakaPrvaPomoc")
    public int getBrojIzlazakaPrvaPomoc() {
        return brojIzlazakaPrvaPomoc;
    }

    public void setBrojIzlazakaPrvaPomoc(int brojIzlazakaPrvaPomoc) {
        this.brojIzlazakaPrvaPomoc = brojIzlazakaPrvaPomoc;
    }

    @Basic
    @Column(name = "BrojIzlazakaVoznja")
    public int getBrojIzlazakaVoznja() {
        return brojIzlazakaVoznja;
    }

    public void setBrojIzlazakaVoznja(int brojIzlazakaVoznja) {
        this.brojIzlazakaVoznja = brojIzlazakaVoznja;
    }

    @Basic
    @Column(name = "GrupaZaTeoretskuNastavu")
    public String getGrupaZaTeoretskuNastavu() {
        return grupaZaTeoretskuNastavu;
    }

    public void setGrupaZaTeoretskuNastavu(String grupaZaTeoretskuNastavu) {
        this.grupaZaTeoretskuNastavu = grupaZaTeoretskuNastavu;
    }

    @Basic
    @Column(name = "OdslusanihCasovaVoznje")
    public Integer getOdslusanihCasovaVoznje() {
        return odslusanihCasovaVoznje;
    }

    public void setOdslusanihCasovaVoznje(Integer odslusanihCasovaVoznje) {
        this.odslusanihCasovaVoznje = odslusanihCasovaVoznje;
    }

    @Basic
    @Column(name = "TrebaPlatiti")
    public Double getTrebaPlatiti() {
        return trebaPlatiti;
    }

    public void setTrebaPlatiti(Double trebaPlatiti) {
        this.trebaPlatiti = trebaPlatiti;
    }

    @Basic
    @Column(name = "DoSadPlatio")
    public Double getDoSadPlatio() {
        return doSadPlatio;
    }

    public void setDoSadPlatio(Double doSadPlatio) {
        this.doSadPlatio = doSadPlatio;
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
    @Column(name = "KategorijaTip")
    public Integer getKategorijaTip() {
        return kategorijaTip;
    }

    public void setKategorijaTip(Integer kategorijaTip) {
        this.kategorijaTip = kategorijaTip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kandidat kandidat = (Kandidat) o;

        if (brojIzlazakaPropisi != kandidat.brojIzlazakaPropisi) return false;
        if (brojIzlazakaPrvaPomoc != kandidat.brojIzlazakaPrvaPomoc) return false;
        if (brojIzlazakaVoznja != kandidat.brojIzlazakaVoznja) return false;
        if (!Objects.equals(jmbg, kandidat.jmbg)) return false;
        if (!Objects.equals(ime, kandidat.ime)) return false;
        if (!Objects.equals(imeOca, kandidat.imeOca)) return false;
        if (!Objects.equals(prezime, kandidat.prezime)) return false;
        if (!Objects.equals(datumRodjenja, kandidat.datumRodjenja))
            return false;
        if (!Objects.equals(mjestoRodjenja, kandidat.mjestoRodjenja))
            return false;
        if (!Objects.equals(mjestoStanovanja, kandidat.mjestoStanovanja))
            return false;
        if (!Objects.equals(adresa, kandidat.adresa)) return false;
        if (!Objects.equals(brojTelefona, kandidat.brojTelefona))
            return false;
        if (!Objects.equals(brojLicneKarte, kandidat.brojLicneKarte))
            return false;
        if (!Objects.equals(brojKnjiziceKandidata, kandidat.brojKnjiziceKandidata))
            return false;
        if (!Objects.equals(brojFiskalnogRacuna, kandidat.brojFiskalnogRacuna))
            return false;
        if (!Objects.equals(brojLjekarskogUvjerenja, kandidat.brojLjekarskogUvjerenja))
            return false;
        if (!Objects.equals(ustanovaLjekarsko, kandidat.ustanovaLjekarsko))
            return false;
        if (!Objects.equals(datumIzdavanjaLjekarskog, kandidat.datumIzdavanjaLjekarskog))
            return false;
        if (!Objects.equals(brojPotvrdePropisi, kandidat.brojPotvrdePropisi))
            return false;
        if (!Objects.equals(datumPotvrdePropisi, kandidat.datumPotvrdePropisi))
            return false;
        if (!Objects.equals(brojPotvrdePrvaPomoc, kandidat.brojPotvrdePrvaPomoc))
            return false;
        if (!Objects.equals(datumPotvrdePrvaPomoc, kandidat.datumPotvrdePrvaPomoc))
            return false;
        if (!Objects.equals(brojPotvrdeVoznja, kandidat.brojPotvrdeVoznja))
            return false;
        if (!Objects.equals(datumPotvrdeVoznja, kandidat.datumPotvrdeVoznja))
            return false;
        if (!Objects.equals(grupaZaTeoretskuNastavu, kandidat.grupaZaTeoretskuNastavu))
            return false;
        if (!Objects.equals(odslusanihCasovaVoznje, kandidat.odslusanihCasovaVoznje))
            return false;
        if (!Objects.equals(trebaPlatiti, kandidat.trebaPlatiti))
            return false;
        if (!Objects.equals(doSadPlatio, kandidat.doSadPlatio))
            return false;
        if (!Objects.equals(instruktorJmbg, kandidat.instruktorJmbg))
            return false;
        return Objects.equals(kategorijaTip, kandidat.kategorijaTip);
    }

    @Override
    public int hashCode() {
        int result = jmbg != null ? jmbg.hashCode() : 0;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (imeOca != null ? imeOca.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (datumRodjenja != null ? datumRodjenja.hashCode() : 0);
        result = 31 * result + (mjestoRodjenja != null ? mjestoRodjenja.hashCode() : 0);
        result = 31 * result + (mjestoStanovanja != null ? mjestoStanovanja.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (brojTelefona != null ? brojTelefona.hashCode() : 0);
        result = 31 * result + (brojLicneKarte != null ? brojLicneKarte.hashCode() : 0);
        result = 31 * result + (brojKnjiziceKandidata != null ? brojKnjiziceKandidata.hashCode() : 0);
        result = 31 * result + (brojFiskalnogRacuna != null ? brojFiskalnogRacuna.hashCode() : 0);
        result = 31 * result + (brojLjekarskogUvjerenja != null ? brojLjekarskogUvjerenja.hashCode() : 0);
        result = 31 * result + (ustanovaLjekarsko != null ? ustanovaLjekarsko.hashCode() : 0);
        result = 31 * result + (datumIzdavanjaLjekarskog != null ? datumIzdavanjaLjekarskog.hashCode() : 0);
        result = 31 * result + (brojPotvrdePropisi != null ? brojPotvrdePropisi.hashCode() : 0);
        result = 31 * result + (datumPotvrdePropisi != null ? datumPotvrdePropisi.hashCode() : 0);
        result = 31 * result + (brojPotvrdePrvaPomoc != null ? brojPotvrdePrvaPomoc.hashCode() : 0);
        result = 31 * result + (datumPotvrdePrvaPomoc != null ? datumPotvrdePrvaPomoc.hashCode() : 0);
        result = 31 * result + (brojPotvrdeVoznja != null ? brojPotvrdeVoznja.hashCode() : 0);
        result = 31 * result + (datumPotvrdeVoznja != null ? datumPotvrdeVoznja.hashCode() : 0);
        result = 31 * result + brojIzlazakaPropisi;
        result = 31 * result + brojIzlazakaPrvaPomoc;
        result = 31 * result + brojIzlazakaVoznja;
        result = 31 * result + (grupaZaTeoretskuNastavu != null ? grupaZaTeoretskuNastavu.hashCode() : 0);
        result = 31 * result + (odslusanihCasovaVoznje != null ? odslusanihCasovaVoznje.hashCode() : 0);
        result = 31 * result + (trebaPlatiti != null ? trebaPlatiti.hashCode() : 0);
        result = 31 * result + (doSadPlatio != null ? doSadPlatio.hashCode() : 0);
        result = 31 * result + (instruktorJmbg != null ? instruktorJmbg.hashCode() : 0);
        result = 31 * result + (kategorijaTip != null ? kategorijaTip.hashCode() : 0);
        return result;
    }
}

import com.itextpdf.text.DocumentException;
import entity.Kandidat;
import entity.Kategorija;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.persistence.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    @FXML
    public Button kandidatiButton;
    @FXML
    public Button dokumentiButton;
    @FXML
    public Button planerButton;
    @FXML
    public AnchorPane kandidatiAnchorPane;
    @FXML
    public AnchorPane dokumentiAnchorPane;
    @FXML
    public AnchorPane planerAnchorPane;
    @FXML
    public AnchorPane kandidatProfileAnchorPane;
    @FXML
    public TextField jmbgTextField;
    @FXML
    public Button searchButton;
    @FXML
    public Label imeImeOcaPrezime;
    @FXML
    public Label jmbg;
    @FXML
    public Label brojLK;
    @FXML
    public Label brojTelefona;
    @FXML
    public Label brojKnjizice;
    @FXML
    public Label datumRodjenja;
    @FXML
    public Label mjestoRodjenja;
    @FXML
    public Label mjestoStanovanja;
    @FXML
    public Label adresa;
    @FXML
    public Label kategorija;
    @FXML
    public Label polozio;
    @FXML
    public Label brojLjekarskog;
    @FXML
    public Label ustanovaLjekarskog;
    @FXML
    public Label datumLjekarskog;
    @FXML
    public Label brojPotvrdePrvaPomoc;
    @FXML
    public Label datumPotvrdePrvaPomoc;
    @FXML
    public Label brojIzlazakaPrvaPomoc;
    @FXML
    public Label grupaPropisi;
    @FXML
    public Label brojIzlazakaPropisi;
    @FXML
    public Label brojPotvrdePropisi;
    @FXML
    public Label datumPotvrdePropisi;
    @FXML
    public Label brojRacunaPropisi;
    @FXML
    public Label odslusanihCasovaVoznja;
    @FXML
    public Label brojIzlazakaVoznja;
    @FXML
    public Label instruktorVoznja;
    @FXML
    public Label brojPotvrdeVoznja;
    @FXML
    public Label datumPotvrdeVoznja;
    @FXML
    public Label brojRacunaVoznja;
    @FXML
    public Label ukupnaCijena;
    @FXML
    public Label platio;
    @FXML
    public Label duguje;
    @FXML
    public Button urediKandidata;
    @FXML
    public Button izbrisiKandidata;
    @FXML
    public Button tabelaButton;

    private Kandidat searchedKandidat;

    public void OnKandidatiButtonPressed()
    {
        kandidatiAnchorPane.setVisible(true);
        dokumentiAnchorPane.setVisible(false);
        planerAnchorPane.setVisible(false);
        kandidatProfileAnchorPane.setVisible(false);
    }
    public void OnDokumentiButtonPressed()
    {
        kandidatiAnchorPane.setVisible(false);
        dokumentiAnchorPane.setVisible(true);
        planerAnchorPane.setVisible(false);
        kandidatProfileAnchorPane.setVisible(false);
    }
    public void OnPlanerButtonPressed()
    {
        kandidatiAnchorPane.setVisible(false);
        dokumentiAnchorPane.setVisible(false);
        planerAnchorPane.setVisible(true);
        kandidatProfileAnchorPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        kandidatiAnchorPane.setVisible(false);
        dokumentiAnchorPane.setVisible(false);
        planerAnchorPane.setVisible(false);
        kandidatProfileAnchorPane.setVisible(false);
    }

    private Kandidat FindCandidate(String jmbg)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<Kandidat> resultList;

        try
        {
            transaction.begin();

            Query q = entityManager.createQuery("SELECT k FROM Kandidat k WHERE k.jmbg = :JMBG");
            q.setParameter("JMBG", jmbg);
            resultList = q.getResultList();

            transaction.commit();
        } finally
        {
            if (transaction.isActive())
            {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        System.out.println(resultList.get(0).getIme());
        return resultList.get(0);
    }

    private Kategorija GetKategorijaForCandidate(Kandidat kandidat)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<Kategorija> resultList;

        try
        {
            transaction.begin();

            Query q = entityManager.createQuery("SELECT k FROM Kategorija k WHERE k.tip = :tip");
            q.setParameter("tip", kandidat.getKategorijaTip());
            resultList = q.getResultList();

            transaction.commit();
        } finally
        {
            if (transaction.isActive())
            {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return resultList.get(0);
    }

    public void OnSearchButtonClicked()
    {
        searchedKandidat = FindCandidate(jmbgTextField.getText());
        ShowKandidatProfile();
    }

    private void ShowKandidatProfile()
    {
        if(searchedKandidat != null)
        {
            imeImeOcaPrezime.setText(searchedKandidat.getIme() + " (" + searchedKandidat.getImeOca() + ") " + searchedKandidat.getPrezime());
            jmbg.setText("JMBG: " + searchedKandidat.getJmbg());
            brojLK.setText("Broj LK: " + searchedKandidat.getBrojLicneKarte());
            brojTelefona.setText("Broj telefona: " + searchedKandidat.getBrojTelefona());
            brojKnjizice.setText("Broj knjizice: " + (searchedKandidat.getBrojKnjiziceKandidata() == null ? "-" : searchedKandidat.getBrojKnjiziceKandidata().toString()));
            datumRodjenja.setText("Datum rodjenja: " + searchedKandidat.getDatumRodjenja().toLocalDateTime().getDayOfMonth() + "." + searchedKandidat.getDatumRodjenja().toLocalDateTime().getMonth().getValue() + "." + searchedKandidat.getDatumRodjenja().toLocalDateTime().getYear() + ".");
            mjestoRodjenja.setText("Mjesto stanovanja: " + (searchedKandidat.getMjestoRodjenja() == null ? "-" : searchedKandidat.getMjestoRodjenja()));
            mjestoStanovanja.setText("Mjesto stanovanja: " + (searchedKandidat.getMjestoStanovanja() == null ? "-" : searchedKandidat.getMjestoStanovanja()));
            adresa.setText("Adresa: " + (searchedKandidat.getAdresa() == null ? "-" : searchedKandidat.getAdresa()));
            if (searchedKandidat.getKategorijaTip() == null)
            {
                kategorija.setText("-");
            }
            else
            {
                switch (searchedKandidat.getKategorijaTip())
                {
                    case 1:
                        kategorija.setText("A");
                        break;
                    case 2:
                        kategorija.setText("B");
                        break;
                    case 3:
                        kategorija.setText("C");
                        break;
                    case 4:
                        kategorija.setText("C1");
                        break;
                    case 5:
                        kategorija.setText("CE");
                        break;
                    case 6:
                        kategorija.setText("C1E");
                        break;
                    case 7:
                        kategorija.setText("BE");
                        break;
                    case 8:
                        kategorija.setText("D");
                        break;
                    case 9:
                        kategorija.setText("DE");
                        break;
                    case 10:
                        kategorija.setText("A1");
                        break;
                    case 11:
                        kategorija.setText("D1");
                        break;
                }
            }
            polozio.setText((searchedKandidat.getBrojPotvrdeVoznja() == null ? "NE" : "DA"));
            brojLjekarskog.setText("Broj: " + (searchedKandidat.getBrojLjekarskogUvjerenja() == null ? "-" : searchedKandidat.getBrojLjekarskogUvjerenja()));
            ustanovaLjekarskog.setText("Ustanova: " + (searchedKandidat.getUstanovaLjekarsko() == null ? "-" : searchedKandidat.getUstanovaLjekarsko()));
            datumLjekarskog.setText("Datum: " + (searchedKandidat.getDatumIzdavanjaLjekarskog() == null ? "-" : (searchedKandidat.getDatumIzdavanjaLjekarskog().toLocalDateTime().getDayOfMonth() + "." + searchedKandidat.getDatumIzdavanjaLjekarskog().toLocalDateTime().getMonth().getValue() + "." + searchedKandidat.getDatumIzdavanjaLjekarskog().toLocalDateTime().getYear() + ".")));
            brojPotvrdePrvaPomoc.setText("Broj potvr: " + (searchedKandidat.getBrojPotvrdePrvaPomoc() == null ? "-" : searchedKandidat.getBrojPotvrdePrvaPomoc()));
            datumPotvrdePrvaPomoc.setText("Datum: " + (searchedKandidat.getDatumPotvrdePrvaPomoc() == null ? "-" : (searchedKandidat.getDatumPotvrdePrvaPomoc().toLocalDateTime().getDayOfMonth() + "." + searchedKandidat.getDatumPotvrdePrvaPomoc().toLocalDateTime().getMonth().getValue() + "." + searchedKandidat.getDatumPotvrdePrvaPomoc().toLocalDateTime().getYear() + ".")));
            brojIzlazakaPrvaPomoc.setText("Broj izlazaka: " + Integer.toString(searchedKandidat.getBrojIzlazakaPrvaPomoc()));
            grupaPropisi.setText("Grupa: " + (searchedKandidat.getGrupaZaTeoretskuNastavu() == null ? "-" : searchedKandidat.getGrupaZaTeoretskuNastavu()));
            brojIzlazakaPropisi.setText("Broj izlazaka: " + Integer.toString(searchedKandidat.getBrojIzlazakaPropisi()));
            brojPotvrdePropisi.setText("Broj potvrde: " + (searchedKandidat.getBrojPotvrdePropisi() == null ? "-" : searchedKandidat.getBrojPotvrdePropisi()));
            datumPotvrdePropisi.setText("Datum potvr: " + (searchedKandidat.getDatumPotvrdePropisi() == null ? "-" : (searchedKandidat.getDatumPotvrdePropisi().toLocalDateTime().getDayOfMonth() + "." + searchedKandidat.getDatumPotvrdePropisi().toLocalDateTime().getMonth().getValue() + "." + searchedKandidat.getDatumPotvrdePropisi().toLocalDateTime().getYear() + ".")));
            brojRacunaPropisi.setText("Broj racuna: " + "-");
            odslusanihCasovaVoznja.setText("Odslusanih casova: " + (searchedKandidat.getOdslusanihCasovaVoznje() == null ? "-" : Integer.toString(searchedKandidat.getOdslusanihCasovaVoznje())));
            brojIzlazakaVoznja.setText("Broj izlazaka: " + Integer.toString(searchedKandidat.getBrojIzlazakaVoznja()));
            instruktorVoznja.setText("Instruktor: " + "napravi ovo");
            brojPotvrdeVoznja.setText("Broj potvrde: " + (searchedKandidat.getBrojPotvrdeVoznja() == null ? "-" : searchedKandidat.getBrojPotvrdeVoznja()));
            datumPotvrdeVoznja.setText("Datum potvrde: " + (searchedKandidat.getDatumPotvrdeVoznja() == null ? "-" : (searchedKandidat.getDatumPotvrdeVoznja().toLocalDateTime().getDayOfMonth() + "." + searchedKandidat.getDatumPotvrdeVoznja().toLocalDateTime().getMonth().getValue() + "." + searchedKandidat.getDatumPotvrdeVoznja().toLocalDateTime().getYear() + ".")));
            brojRacunaVoznja.setText("Broj racuna: " + (searchedKandidat.getBrojFiskalnogRacuna() == null ? "-" : searchedKandidat.getBrojFiskalnogRacuna()));
            CalculatePrices();

            kandidatProfileAnchorPane.setVisible(true);
        }
    }

    private void CalculatePrices()
    {
        Kategorija kat = GetKategorijaForCandidate(searchedKandidat);
        // dodaj i dodatne troskove!!!
        ukupnaCijena.setText("Ukupna cijena: " + (kat == null ? "-" : (kat.getBrojCasovaTeorija()*kat.getCijenaCasaTeorija()+kat.getBrojCasovaVoznja()*kat.getCijenaCasaVoznja())));
        platio.setText("Platio: " + (searchedKandidat.getDoSadPlatio() == null ? "-" : searchedKandidat.getDoSadPlatio()));
        duguje.setText("Duguje " + (kat == null ? "-" : (kat.getBrojCasovaTeorija()*kat.getCijenaCasaTeorija()+kat.getBrojCasovaVoznja()*kat.getCijenaCasaVoznja()) - (searchedKandidat.getDoSadPlatio() == null ? 0 : searchedKandidat.getDoSadPlatio())));
    }

    public void CreateTable() throws DocumentException, FileNotFoundException
    {
        DokumentiController.CreatePDF();
    }


}

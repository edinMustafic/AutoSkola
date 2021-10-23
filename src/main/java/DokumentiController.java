import com.itextpdf.text.*;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Kandidat;
import entity.Kategorija;

import javax.persistence.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class DokumentiController
{
    public static void CreatePDFTable(List<Kandidat> kandidati, String tip, String mjesec, String godina) throws DocumentException, FileNotFoundException
    {
        Document document = new Document(PageSize.A4, 0,0,0,0);
        PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home") + "/Desktop/Tabela_" + tip + "_" +mjesec + "_" + godina + ".pdf"));

        document.open();

        PdfPTable table = new PdfPTable(new float[]{2, 4.2f, 6.5f, 4.2f, 3f, 3.5f, 4f, 2, 2.5f});
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        CreateTableHeader(table, tip, mjesec, godina);
        CreateTableColumns(table);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setPadding(7f);

        for (int i = 0; i < kandidati.size(); i++) {
            table.addCell(Integer.toString(i+1));
            table.addCell((kandidati.get(i).getDatumPotvrdeVoznja().toLocalDateTime().getDayOfMonth() + "." + kandidati.get(i).getDatumPotvrdeVoznja().toLocalDateTime().getMonth().getValue() + "." + kandidati.get(i).getDatumPotvrdeVoznja().toLocalDateTime().getYear() + "."));
            table.addCell(kandidati.get(i).getIme() + " " + kandidati.get(0).getPrezime());
            table.addCell(String.valueOf(kandidati.get(i).getDatumRodjenja().toLocalDateTime().getDayOfMonth() + "." + kandidati.get(i).getDatumRodjenja().toLocalDateTime().getMonth().getValue() + "." + kandidati.get(i).getDatumRodjenja().toLocalDateTime().getYear() + "."));
            Kategorija kat = GetKategorija(kandidati.get(0));
            table.addCell(Integer.toString(kat.getBrojCasovaVoznja()));
            table.addCell(Double.toString(kat.getCijenaCasaVoznja()) + " KM");
            table.addCell(Double.toString(kat.getCijenaCasaVoznja()*kat.getBrojCasovaVoznja()) + " KM");
            table.addCell(GetKategorijaLabel(kandidati.get(0).getKategorijaTip()));
            table.addCell(kandidati.get(i).getBrojFiskalnogRacuna().toString());
        }
        document.add(table);
        document.close();
    }

    private static void CreateTableHeader(PdfPTable table, String tip, String mjesec, String godina)
    {
        PdfPCell cell = new PdfPCell(new Phrase(tip + " - " + mjesec + " " + godina, new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, GrayColor.GRAYWHITE)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10.0f);
        cell.setBackgroundColor(new BaseColor(140, 221, 8));
        table.addCell(cell);
    }

    private static void CreateTableColumns(PdfPTable table)
    {
        Font f = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, GrayColor.BLACK);

        PdfPCell rbCell = new PdfPCell(new Phrase("R.B.", f));
        rbCell.setPadding(5.0f);
        rbCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        rbCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(rbCell);

        PdfPCell datumCell = new PdfPCell(new Phrase("Datum", f));
        datumCell.setPadding(5.0f);
        datumCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        datumCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(datumCell);

        PdfPCell imePrezimeCell = new PdfPCell(new Phrase("Ime i prezime", f));
        imePrezimeCell.setPadding(5.0f);
        imePrezimeCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        imePrezimeCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(imePrezimeCell);

        PdfPCell datumRodCell = new PdfPCell(new Phrase("Datum rodjenja", f));
        datumRodCell.setPadding(5.0f);
        datumRodCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        datumRodCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(datumRodCell);

        PdfPCell brojCasovaCell = new PdfPCell(new Phrase("Broj casova", f));
        brojCasovaCell.setPadding(5.0f);
        brojCasovaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        brojCasovaCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(brojCasovaCell);

        PdfPCell cijenaCasaCell = new PdfPCell(new Phrase("Cijena casa", f));
        cijenaCasaCell.setPadding(5.0f);
        cijenaCasaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cijenaCasaCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(cijenaCasaCell);

        PdfPCell ukupnoCell = new PdfPCell(new Phrase("Ukupno", f));
        ukupnoCell.setPadding(5.0f);
        ukupnoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        ukupnoCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(ukupnoCell);

        PdfPCell kategorijaCell = new PdfPCell(new Phrase("Kat.", f));
        kategorijaCell.setPadding(5.0f);
        kategorijaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        kategorijaCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(kategorijaCell);

        PdfPCell frCell = new PdfPCell(new Phrase("F.R.", f));
        frCell.setPadding(5.0f);
        frCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        frCell.setBackgroundColor(new BaseColor(222, 222, 222));
        table.addCell(frCell);
    }

    private static Kategorija GetKategorija(Kandidat kandidat)
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

    private static String GetKategorijaLabel(int kategorijaTip)
    {
        String katLabel = "";

        switch (kategorijaTip)
        {
            case 1:
                katLabel = "A";
                break;
            case 2:
                katLabel = "B";
                break;
            case 3:
                katLabel = "C";
                break;
            case 4:
                katLabel = "C1";
                break;
            case 5:
                katLabel = "CE";
                break;
            case 6:
                katLabel = "C1E";
                break;
            case 7:
                katLabel = "BE";
                break;
            case 8:
                katLabel = "D";
                break;
            case 9:
                katLabel = "DE";
                break;
            case 10:
                katLabel = "A1";
                break;
            case 11:
                katLabel = "D1";
                break;
        }
        return katLabel;
    }

}

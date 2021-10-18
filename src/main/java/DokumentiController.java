import com.itextpdf.text.*;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.protocol.ResultsetRowsOwner;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DokumentiController
{
    public static void CreateSpreadsheet(String title)
    {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet1 = workbook.createSheet(title);
        Row row1 = sheet1.createRow(0);
        row1.createCell(0).setCellValue("Test1");
        row1.createCell(1).setCellValue("Test2");
        row1.createCell(2).setCellValue("Test3");
        Row row2 = sheet1.createRow(1);
        row1.createCell(0).setCellValue("Test1");
        row1.createCell(1).setCellValue("Test2");
        row1.createCell(2).setCellValue("Test3");
        try
        {
            workbook.write(new FileOutputStream("Test.xlsx"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void CreatePDF() throws DocumentException, FileNotFoundException
    {
        Document document = new Document(PageSize.A4, 0,0,0,0);
        PdfWriter.getInstance(document, new FileOutputStream("/home/edin/Desktop/test.pdf"));

        document.open();

        PdfPTable table = new PdfPTable(new float[]{2, 4, 8, 4, 3f, 2.7f, 3.3f, 2, 2.5f});
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        PdfPCell cell = new PdfPCell(new Phrase("Voznja - Maj 2021", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, GrayColor.GRAYWHITE)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10.0f);
        cell.setBackgroundColor(new BaseColor(140, 221, 8));
        table.addCell(cell);

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

        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setPadding(7f);

        for (int i = 0; i < 100; i++) {
            table.addCell(Integer.toString(i));
            table.addCell("xx.xx.xxxx.");
            table.addCell("nekoIme nekoPrezime" + i);
            table.addCell("xx.xx.xxxx.");
            table.addCell("xx");
            table.addCell("xxKM");
            table.addCell("xxxKM");
            table.addCell("B");
            table.addCell("xxxx");
        }
        document.add(table);
        document.close();

        document.close();

    }


}

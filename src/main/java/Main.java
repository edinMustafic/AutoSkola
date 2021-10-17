import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/logIn.fxml")));
        System.out.println(root);
        stage.setTitle("Log in");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void main(String[] args)
    {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet1 = wb.createSheet("test");
        Row row1 = sheet1.createRow(0);
        row1.createCell(0).setCellValue("Header1");
        row1.createCell(0).setCellValue("Header2");
        row1.createCell(0).setCellValue("Header3");
        try
        {
            wb.write(new FileOutputStream("ExcelSample.xlsx"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();

            /*Admin admin = new Admin();
            admin.setUsername("addD");
            admin.setPassword("aDDD");
            entityManager.persist(admin);*/
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
        launch(args);

    }
}

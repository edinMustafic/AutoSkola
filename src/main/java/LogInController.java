import entity.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LogInController implements Initializable
{
    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordTextField;
    @FXML
    public Button logInButton;

    private List<Admin> admins;

    private void GetAdmins()
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
            transaction.begin();

            Query q = entityManager.createQuery("SELECT a FROM Admin a");
            admins = q.getResultList();
            for(int i = 0; i < admins.size(); i++)
            {
                System.out.println(admins.get(0).getUsername() + " " + admins.get(0).getPassword());
            }


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
    }

    public void LogInButtonPressed() throws IOException
    {
        for (Admin admin : admins)
        {
            if (admin.getUsername().equals(usernameTextField.getText()) && admins.get(0).getPassword().equals(passwordTextField.getText()))
            {
                Stage newStage = new Stage();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("fxml/home.fxml"));
                Parent root = loader.load();
                newStage.setTitle("Home page");
                newStage.setScene(new Scene(root));
                newStage.show();
                System.out.println("Login successful: " + admin.getUsername() + " " + admins.get(0).getPassword());
                Stage currentStage = (Stage)logInButton.getScene().getWindow();
                currentStage.close();
            } else
            {
                System.out.println("Login failed");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        GetAdmins();
    }
}

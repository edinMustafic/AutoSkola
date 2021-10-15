package controllers;

import entity.Admin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.persistence.*;
import java.net.URL;
import java.util.List;
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

    public void LogInButtonPressed()
    {
        for (Admin admin : admins)
        {
            if (admin.getUsername().equals(usernameTextField.getText()) && admins.get(0).getPassword().equals(passwordTextField.getText()))
            {
                System.out.println("Login successful: " + admin.getUsername() + " " + admins.get(0).getPassword());
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

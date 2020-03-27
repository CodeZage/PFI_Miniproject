package BankingApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccountPage extends JFrame
{
    private JPanel createAccountPanel;
    private JTextField accountNameTextField;
    private JPasswordField passwordPasswordField;
    private JButton doneButton;

    public CreateAccountPage(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(createAccountPanel);
        this.pack();

        doneButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Main.accounts.add(new Account(accountNameTextField.getText(), passwordPasswordField.getPassword()));

                if(accountNameTextField.getText().isEmpty() | passwordPasswordField.getPassword().length == 0)
                {
                    JOptionPane.showMessageDialog(CreateAccountPage.this, "One of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else if(!accountNameTextField.getText().isEmpty() | passwordPasswordField.getPassword().length != 0)
                {
                    SignInPage signInPage = new SignInPage("Sign In");
                    CreateAccountPage.this.dispose();
                }
            }
        });
    }
}

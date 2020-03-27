package BankingApplication;

import javax.swing.*;
import java.awt.*;
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

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        doneButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (accountNameTextField.getText().isEmpty() | passwordPasswordField.getPassword().length == 0)
                {
                    JOptionPane.showMessageDialog(CreateAccountPage.this, "One of the fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (!Account.isAccountUnique(accountNameTextField.getText()))
                {
                    JOptionPane.showMessageDialog(CreateAccountPage.this, "Invalid Account Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!accountNameTextField.getText().isEmpty() | passwordPasswordField.getPassword().length != 0 && Account.isAccountUnique(accountNameTextField.getText()))
                {
                    Main.accounts.add(new Account(accountNameTextField.getText(), passwordPasswordField.getPassword()));
                    SignInPage signInPage = new SignInPage("Sign In");
                    CreateAccountPage.this.dispose();
                }
            }
        });
    }
}

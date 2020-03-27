package BankingApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignInPage extends JFrame
{
    private JPanel signInPanel;
    private JButton signInButton;
    private JButton createAccountButton;
    private JTextField accountNameTextField;
    private JPasswordField passwordField;
    private JLabel SignIn;

    public SignInPage(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(signInPanel);
        this.pack();
        this.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        signInButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                char[] input = passwordField.getPassword();

                for (int i = 0; i < Main.accounts.size(); i++)
                {
                    if (Main.accounts.get(i).getAccountName().equals(accountNameTextField.getText()))
                    {
                        if (Arrays.equals(Main.accounts.get(i).getAccountPassword(), input))
                        {
                            Main.currentAccount = Main.accounts.get(i);
                            AccountPage accountPage = new AccountPage("Account " + Main.currentAccount.getAccountName());
                            SignInPage.this.dispose();
                            break;
                        } else
                        {
                            accountNameTextField.setText("");
                            passwordField.setText("");
                            JOptionPane.showMessageDialog(SignInPage.this, "Wrong Password or Username", "Failure", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }

                if (Main.accounts.size() == 0)
                {
                    accountNameTextField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(SignInPage.this, "There are no Accounts", "Failure", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                CreateAccountPage createAccountPage = new CreateAccountPage("Create Account");
                SignInPage.this.dispose();
                createAccountPage.setVisible(true);
            }
        });
    }
}

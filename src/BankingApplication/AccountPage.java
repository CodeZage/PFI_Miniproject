package BankingApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountPage extends JFrame
{
    private JPanel accountPanel;
    private JLabel header;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JLabel balanceLabel;
    private JButton signOutButton;

    AccountPage(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(accountPanel);
        this.pack();
        this.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.header.setText("Welcome " + Main.currentAccount.getAccountName());

        balanceLabel.setText(Double.toString(Main.currentAccount.getBalance()));

        depositButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String depositAmount = JOptionPane.showInputDialog(AccountPage.this, "How much would you like to deposit?", "Deposit", JOptionPane.QUESTION_MESSAGE);

                if (depositAmount != null)
                {
                    Main.currentAccount.deposit(depositAmount);
                    AccountPage.this.balanceLabel.setText(Double.toString(Main.currentAccount.getBalance()));
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String withdrawAmount = JOptionPane.showInputDialog(AccountPage.this, "How much would you like to withdraw?", "Withdraw", JOptionPane.QUESTION_MESSAGE);

                if (withdrawAmount != null)
                {
                    Main.currentAccount.withdraw(withdrawAmount);
                    AccountPage.this.balanceLabel.setText(Double.toString(Main.currentAccount.getBalance()));
                }

            }
        });

        transferButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                TransferPage accountPage = new TransferPage("Transfer " + Main.currentAccount.getAccountName());
                AccountPage.this.dispose();
            }
        });

        signOutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Main.currentAccount = null;
                SignInPage accountPage = new SignInPage("Sign In");
                AccountPage.this.dispose();
            }
        });
    }
}


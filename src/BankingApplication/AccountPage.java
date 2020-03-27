package BankingApplication;

import javax.swing.*;

public class AccountPage extends JFrame
{
    private JPanel accountPanel;
    private JLabel header;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JTextPane balance;

    AccountPage(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(accountPanel);
        this.pack();
    }
}


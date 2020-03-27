package BankingApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPage extends JFrame
{
    private JPanel transferPanel;
    private JLabel transferHeader;
    private JList<Object> userList;
    private JTextField transferAmountField;
    private JLabel transferAmountLabel;
    private JButton cancelButton;
    private JButton transferButton;
    private JLabel usersLabel;
    private JScrollPane scrollPane;

    Object[] allAccounts;

    TransferPage(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(transferPanel);
        this.pack();
        this.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        allAccounts = new Object[Main.accounts.size()];

        for (int i = 0; i < Main.accounts.size(); i++)
        {
            if (Main.accounts.get(i) != Main.currentAccount)
            {
                allAccounts[i] = Main.accounts.get(i);
            }
        }

        userList.setListData(allAccounts);

        transferButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Object selectedAccount = userList.getSelectedValue();
                String moneyToTransfer = transferAmountField.getText();

                Main.currentAccount.transfer(moneyToTransfer, (Account) selectedAccount);

                AccountPage accountPage = new AccountPage("Welcome " + Main.currentAccount.getAccountName());
                TransferPage.this.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                AccountPage accountPage = new AccountPage("Account " + Main.currentAccount.getAccountName());
                TransferPage.this.dispose();
            }
        });
    }
}

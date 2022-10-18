package ui.Home;

import service.BalanceService;
import ui.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Home {
    public JPanel rootPanel;
    private JButton depositMoneyButton;
    private JButton withdrawMoneyButton;
    private JLabel balanceField;

    private final BalanceService balanceService = new BalanceService();
   // private final Login login = new Login();

    public Home() throws SQLException {

        double balance = balanceService.getBalanceByUser(Login.user);
        balanceField.setText(String.valueOf(balance));



        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String balance = JOptionPane.showInputDialog(rootPanel,"balance");
                int response = JOptionPane.showConfirmDialog(rootPanel, "Are you sure you want to deposit money?");
                if (response == JOptionPane.YES_OPTION){
                    balanceService.depositMoney(Login.user, Double.parseDouble(balance));
                }
                else {
                    JOptionPane.showMessageDialog(rootPanel,"deposit has been canceled");
                }
            }
        });




    }
}

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
    private JTextField balanceAmount;
    private JButton addAmount;
    private JButton interestAmount;
    private JButton moneyTransferButton;
    private JButton updateBalanceButton;

    private final BalanceService balanceService = new BalanceService();
   // private final Login login = new Login();

    public Home() throws SQLException {
        double balance = balanceService.getBalanceByUser(Login.user);
        balanceField.setText(String.valueOf(balance));

        //balanceAmount.setText(String.valueOf(balance));


        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                balanceService.depositMoney(Login.user, Double.parseDouble(balanceAmount.getText()));

            }
        });


        addAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = balanceAmount.getText();
                double parse = Double.parseDouble(amount);
                double updatedAmount =  parse += 100;
                balanceAmount.setText(String.valueOf(updatedAmount));
            }
        });


        interestAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = balanceAmount.getText();
                double parse = Double.parseDouble(amount);
                double updateAmount = parse -= 100;
                balanceAmount.setText(String.valueOf(updateAmount));

            }
        });
        updateBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = balanceAmount.getText();
                String username = Login.user;
                try {
                    balanceService.updateBalance(Double.parseDouble(amount), username);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }
}

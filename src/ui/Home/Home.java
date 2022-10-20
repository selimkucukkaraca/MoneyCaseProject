package ui.Home;

import request.CreateOperationHistoryRequest;
import service.BalanceService;
import service.OperationHistoryService;
import ui.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Home {
    public JPanel rootPanel;
    private JButton depositMoneyButton;
    private JLabel balanceField;
    private JTextField balanceAmount;
    private JButton addAmount;
    private JButton interestAmount;
    private JButton moneyTransferButton;
    private JButton updateBalanceButton;

    private final BalanceService balanceService = new BalanceService();
    private final OperationHistoryService operationHistoryService = new OperationHistoryService();
    private String loginUser = Login.user;
   // private final Login login = new Login();

    public Home() throws SQLException {
        double balance = balanceService.getBalanceByUser(loginUser);
        balanceField.setText(String.valueOf(balance));

        balanceAmount.setText(String.valueOf(balance));


        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                balanceService.depositMoney(loginUser, Double.parseDouble(balanceAmount.getText()));

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
                try {
                    balanceService.updateBalance(Double.parseDouble(amount), loginUser);
                    operationHistoryService.saveOperationHistory(new CreateOperationHistoryRequest(Double.parseDouble(amount), loginUser));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }
}

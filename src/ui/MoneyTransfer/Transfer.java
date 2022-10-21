package ui.MoneyTransfer;

import service.BalanceService;
import ui.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Transfer {
    private JTextField toUserName;
    public JPanel rootPanel;
    private JTextField transferAmount;
    private JButton goTransferButton;

    private String loginUser = Login.user;
    private BalanceService balanceService = new BalanceService();


    public Transfer() {
        goTransferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toUser= toUserName.getText();
                double amount = Double.parseDouble(transferAmount.getText());

                try {
                    balanceService.transferMoney(new model.Transfer(loginUser, toUser, amount));

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }
}

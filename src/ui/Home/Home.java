package ui.Home;

import service.BalanceService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    public JPanel rootPanel;
    private JButton depositMoneyButton;
    private JButton withdrawMoneyButton;

    private final BalanceService balanceService = new BalanceService();

    public Home() {
        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String balance = JOptionPane.showInputDialog(rootPanel,"balance");
                int response = JOptionPane.showConfirmDialog(rootPanel, "Are you sure you want to deposit money?");
                if (response == JOptionPane.YES_OPTION){
                    balanceService.depositMoney(Double.parseDouble(balance));
                }
                else {
                    JOptionPane.showMessageDialog(rootPanel,"deposit has been canceled");
                }

            }
        });
    }
}

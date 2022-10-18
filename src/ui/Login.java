package ui;

import model.Log;
import service.LogService;
import service.UserService;
import ui.Home.Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {
    private JTextField nameField;
    private JTextField surnameField;
    private JButton loginButton;
    private JPasswordField passwordField;
    private JPanel rootPanel;
    private JLabel warnLabel;

    private final UserService userService = new UserService();
    private final LogService logService = new LogService();
    public static String user;


    public Login() {
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                int password = Integer.parseInt(passwordField.getText());

                if (userService.login(name,surname,password)){
                    user = name;
                    warnLabel.setText("");
                    JFrame frame = new JFrame();

                    try {
                        frame.setContentPane(new Home().rootPanel);
                        frame.setSize(700,700);
                        frame.setTitle("Home");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.setVisible(true);
                }
                else {
                    warnLabel.setText("Wrong attempt");
                    logService.addLog(new Log(name + " wrong attempt"));
                }
            }
        });
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    surnameField.requestFocus();
                }
            }
        });
        surnameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    passwordField.requestFocus();
                }
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    loginButton.doClick();
                }
            }
        });
    }



    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new Login().rootPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500, 500);
        jFrame.setTitle("Login");
        jFrame.setLocation(300, 300);

    }
}

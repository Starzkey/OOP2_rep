package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NameView extends JPanel {

    //Attributes
    private JButton nameButton;
    private JTextField nameField;
    private JLabel nameLabel;

    //Constructor
    public NameView() {
        init();
    }

    //Methods
    public void init() {
        nameLabel = new JLabel("Bitte geben Sie Ihren Namen ein: ");
        nameField = new JTextField(14);
        nameButton = new JButton("Bestätigen");
        add(nameLabel);
        add(nameField);
        add(nameButton);
    }

    public JTextField getNameField() {
        return nameField;
    }

    //register-Methods
    public void registerNameButtonListener(ActionListener listener) {
        nameButton.addActionListener(listener);
    }

}

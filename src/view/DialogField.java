package view;

import javax.swing.*;

public class DialogField extends JDialog {

    //Attributes
    JOptionPane jOptionPane;
    JFrame frame;
    String question;
    String questionTitle;
    Object[] options;
    int playerAnswer;

    public DialogField(JFrame frame, String question, String questionTitle, Object[] options) {

        this.frame = frame;
        this.questionTitle = questionTitle;
        this.options = options;
        this.question = question;
        init();
    }

    public void init() {

        JDialog d = new JDialog(frame, questionTitle);

        jOptionPane = new JOptionPane();
        d.add(jOptionPane);
        playerAnswer = JOptionPane.showOptionDialog(frame, question, questionTitle, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

    }

    public int getPlayerAnswer() {
        return playerAnswer;
    }

}

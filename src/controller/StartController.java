package controller;

import model.CardLibrary;
import view.HighScoreView;
import view.NameView;
import view.StartView;

import javax.swing.*;

public class StartController {

    //Attributes
    private StartView view;		//Variable von StartView (Panel-Objekt)
    private JFrame frame;
    private CardLibrary cardLibrary;

    //Constructors
    public StartController(StartView view, JFrame frame, CardLibrary cardLibrary) { //Konstruktor
        this.view = view;
        this.frame = frame;
        this.cardLibrary = cardLibrary;

   /*   this.view.registerNewGameListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		onNewGame();
        	}
        }	*/
        	
        this.view.registerNewGameListener(e -> onNewGame());
        this.view.registerHighScoreListener(e -> onHighScore());
    }

    //Methods
    public void onNewGame() {
        NameView nameView = new NameView();	//NameView-Panel-Objekt 
        frame.setContentPane(nameView);
        new NameController(nameView, frame, cardLibrary);
        frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.

    }

    public void onHighScore() {
    	 HighScoreView highScoreView = new HighScoreView();	//NameView-Panel-Objekt 
         frame.setContentPane(highScoreView);
         new HighScoreController(highScoreView, frame);
         frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.

    }
}

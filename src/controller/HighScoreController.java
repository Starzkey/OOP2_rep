package controller;

import javax.swing.JFrame;

import model.CardLibrary;
import view.HighScoreView;
import view.StartView;

public class HighScoreController {
	
    //Attributes
    private HighScoreView view;		//Variable von StartView (Panel-Objekt)
    private JFrame frame;
    private CardLibrary cardLibrary;
    //Constructors
    public HighScoreController(HighScoreView view, JFrame frame) { //Konstruktor
        this.view = view;
        this.frame = frame;

    this.view.registerReturnButtonListener(e -> onToStartView());
    }

    public void onToStartView() {

            StartView startView = new StartView();
            frame.setContentPane(startView);
            new StartController(startView, frame, cardLibrary);
            frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.

    }

    //Methods
  /*public void onStartView() {
    	NameView nameView = new NameView();	//NameView-Panel-Objekt 
        frame.setContentPane(nameView);
        new NameController(nameView, frame);
        frame.setVisible(true); //Immer am Ende der Methode notwendig, damit Ansicht aktualisiert wird und man das neue Panel sieht.
*/

}



package view;

import controller.StartController;
import model.CardLibrary;

import javax.swing.*;
import java.awt.*;

public class CardsOfLegendsFrame extends JFrame{

    private CardLibrary cardLibrary;

    public CardsOfLegendsFrame(CardLibrary cardLibrary) {
        this.cardLibrary = cardLibrary;

        init();
    }

    public void init() {
        JFrame frame = new JFrame("Cards of Legends");	//Top-Level-Fenster: enthält alle anderen
        frame.setSize(1920,1080);							//Größe des Fensters (width, height)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //schließt beim x

        GridLayout layout = new GridLayout();
        setLayout(layout);

        StartView view = new StartView(frame);				//Panel Objekt erstellen

        frame.add(view);								//...dieses dem Frame geaddet
        new StartController(view, frame, cardLibrary);	//neues Objekt der StartController Klasse (Listener)
        frame.setVisible(true);//zeigt das Fenster an
    }
}

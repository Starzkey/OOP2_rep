package main;

import controller.StartController;
import model.Card;
import model.CardLibrary;
import model.Player;
import view.CardsOfLegendsFrame;
import view.StartView;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CardLibrary cardLibrary = new CardLibrary(); //Erstellt CardLibrary, auf welche zukünftig zugegriffen wird
        new CardsOfLegendsFrame(cardLibrary);

    }
}

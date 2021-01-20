package controller;

import model.Card;
import model.Player;
import view.CardView;
import view.DialogField;

import javax.swing.*;

public class CardController {

    private CardView view;
    private JFrame frame;

    public CardController(CardView view, JFrame frame, Player player, Card card) {
        this.view = view;
        this.frame = frame;

        this.view.registerSelectCardListener(e -> onSelectCard(card));
        this.view.registerSellCardListener(e -> onSellCard(player, card));
    }

    private void onSelectCard(Card card) {
        card.setSelected(!card.isSelected());
    }

    private void onSellCard(Player player, Card selectedCard) {
        Object[] options = new Object[]{"Sell the damned card", "Changed my mind"};
        DialogField sellOneAnswer = new DialogField(frame,
                "The vendor looks at you with a hopeful grin. \n"
                        + "Obviously, the card is worth a lot more under the right circumstances. \n"
                        + "Are you sure you want to get rid of it?", "Selling a single card", options);
        int playerAnswer = sellOneAnswer.getPlayerAnswer();

        if (playerAnswer == 0) {
            player.setBalance(player.getBalance() + selectedCard.getValue());
            player.removeCard(selectedCard);
        }
    }
}

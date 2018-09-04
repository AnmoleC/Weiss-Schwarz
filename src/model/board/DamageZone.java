package model.board;

import java.util.ArrayList;

import model.card.Card;
import model.card.Colour;

public class DamageZone extends SearchableZone {
	public static final int cardsPerLevel = 7;
	
	DamageZone() {
		super("Damage", true);
		cards = new ArrayList<Card>();
	}
	
	
	public Card removeFromBottom(){
		Card c = cards.get(0);
		cards.remove(c);
		return c;
	}
	
	boolean hasColour(Colour colour){
		for (Card card : cards) {
			if(card.getColour() == colour && card.isFaceUp())
				return true;
		}
		return false;
	}
	
}

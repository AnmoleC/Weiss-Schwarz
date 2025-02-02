package game.model.ability.action.concrete;

import game.controller.PlayerController;
import game.model.ability.action.TargetedAction;
import game.model.card.Card;
import game.model.exceptions.EmptyLibraryException;

public class PlaceInDamageFromLibrary extends TargetedAction<Card>{

	public PlaceInDamageFromLibrary() {
		super("Place damage from library");
	}

	@Override
	public String failureMessage() {
		return "empty library";
	}

	@Override
	protected void setTargets(PlayerController p1, PlayerController p2) {
		targets.add(p1.getBoard().getLibrary().peek());
	}

	@Override
	protected void executeAction(PlayerController p1, PlayerController p2) {
		Card c = targets.get(0);
		p1.getBoard().getDamageZone().add(c);
		try {
			p1.getBoard().getLibrary().remove(c);
		} catch (EmptyLibraryException e) {
			new Refresh().execute(p1, p2);
		}
		
		p1.log("took 1 damage");
	}

}

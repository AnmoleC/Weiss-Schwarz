package game.model.ability.action.concrete;

import game.controller.PlayerController;
import game.model.ability.action.TargetedAction;
import game.model.card.Card;

public class Refresh extends TargetedAction<Card>{

	public Refresh() {
		super("Refresh");
		setNextAction(new ShuffleLibrary());
	}

	@Override
	public String failureMessage() {
		return "You lost";
	}

	@Override
	protected void setTargets(PlayerController p1, PlayerController p2) {
		targets.addAll(p1.getBoard().getWaitingRoom().getCards());
		if (targets.isEmpty()){
			p1.deckOut();
		}
	}

	@Override
	protected void executeAction(PlayerController p1, PlayerController p2){
		for (Card card : targets) {
			p1.getBoard().getWaitingRoom().remove(card);
			p1.getBoard().getLibrary().add(card);
		}
		p1.log("Refreshed library");
		p1.refresh();
	}

}

package game.model.ability.action.concrete;

import game.controller.PlayerController;
import game.model.ability.action.TargetedAction;
import game.model.ability.action.condition.CanRest;
import game.model.board.Slot;

public class Rest extends TargetedAction<Slot> {

	public Rest() {
		super("Rest");
		addCondition(new CanRest());
	}
	
	public Rest(boolean required){
		super("Rest", required);
		addCondition(new CanRest());
	}

	@Override
	protected void setTargets(PlayerController p1, PlayerController p2) {
		targets.addAll(p1.getBoard().getStage().getSlots());
	}

	@Override
	protected void executeAction(PlayerController p1, PlayerController p2) {
		Slot chosen = p1.getChoice("Choose a character to rest:", targets);
		chosen.rest();
	}

	@Override
	public String failureMessage() {
		return "Could not Rest";
	}


}

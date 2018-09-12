package command;

import controller.PlayerController;
import model.ability.action.DrawToHand;

public class Draw extends Command{

	public Draw( ) {
		super("Draw");
	}

	@Override
	public void execute(PlayerController p1, PlayerController p2)  {
		new DrawToHand().execute(p1, p2);
	}

}

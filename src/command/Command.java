package command;

import model.ability.Activatable;

public abstract class Command implements Activatable{
	
	private final String name;
	
	public Command(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
}

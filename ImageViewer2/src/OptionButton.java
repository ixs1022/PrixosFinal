//COMMAND PATTERN

public class OptionButton {
	
	Command theCommand;
	
	public OptionButton(Command newCommand){
		this.theCommand = newCommand;
	}
	
	
	//The Invoker OptionButton Knows Nothing It doesn't know what device or command is being used
	public void press(){
		theCommand.execute();
	}
	
	public void press(int w, int h){
		theCommand.execute(w, h);
	}
	
	public void press(double deg){
		theCommand.execute(deg);
	}

}

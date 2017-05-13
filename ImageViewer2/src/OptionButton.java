//COMMAND PATTERN
/**
 * Class that executes command depending on button pressed
 * @author Ivan Kovacevic
 *
 */
public class OptionButton {
	// attributes
	Command theCommand;
	
	/**
	 * Constructor for OptionButton
	 * @param newCommand Command
	 */
	public OptionButton(Command newCommand){
		this.theCommand = newCommand;
	}
	
	//The Invoker OptionButton Knows Nothing It doesn't know what device or command is being used
	/**
	 * The following methods execute the command
	 * press(w,h) - resize
	 * press(deg) - rotate
	 */
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

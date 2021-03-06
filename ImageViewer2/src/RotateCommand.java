/**
 * RotateCommand uses dialog box (action sheet) to allow user
 * to input custom degrees to rotate the image or
 * to rotate by standard 90 degrees
 * 
 * @author isabella
 *
 */
public class RotateCommand implements Command {
	
	//attributes
	EditingOptions option;
	
	/**
	 * Constructor for RotateCommand
	 * @param newOption EditingOptions
	 */
	public RotateCommand(EditingOptions newOption){
		this.option = newOption;
	}
	
	/**
	 * Implemented execute methods from Command interface
	 * Only execute(double deg) are used for Rotate
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute(int w, int h) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute(double deg) {
		option.rotate(deg);
		
	}
	
	
}

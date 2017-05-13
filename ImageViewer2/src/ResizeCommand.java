/**
 * ResizeCommand changes the size of the image through user input
 * in dialog box (action sheet)
 * 
 * @author isabella
 *
 */
public class ResizeCommand implements Command {
	//attributes
	EditingOptions option;
	
	/**
	 * Constructor for ResizeCommand
	 * @param newOption EditingOptions
	 */
	public ResizeCommand(EditingOptions newOption){
		this.option = newOption;
	}
	
	/**
	 * Implemented execute methods from Command interface
	 * Only execute(int w, int h) are used for Resize
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute(int w, int h) {
		option.resize(w, h);
		
	}
	@Override
	public void execute(double deg) {
		// TODO Auto-generated method stub
		
	}

}

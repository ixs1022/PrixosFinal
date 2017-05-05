import javax.swing.JOptionPane;

/**
 * ResizeCommand changes the size of the image through user input
 * in dialog box (action sheet)
 * 
 * @author isabella
 *
 */
public class ResizeCommand implements Command {

	@Override
	public void execute() {
		rotate();
		
	}
	
	public int rotate(){
		Integer[] options = {45,
                90,
                180};
		int n = JOptionPane.showOptionDialog(null,
		"How many degrees would you like to rotate the image?",
		"Rotate",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
		
		System.out.println("Choice: " +options[n]);
		
		return options[n];
	}

}

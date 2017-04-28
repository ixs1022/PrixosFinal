import javax.swing.JButton;

/**
 * EditCommands enables edits (resize, crop, rotate, mirror) of an image
 * Makes copy of image to be edited
 * 
 * @author isabella
 *
 */
public class EditCommand implements Command{
	//attributes
	private JButton jbEdit;
	private JButton jbRotate;
	private JButton jbResize;
	private JButton jbMirror;
	private JButton jbCrop;
	
	/**
	 * Constructor
	 * @param jbEdit
	 * @param jbRotate
	 * @param jbResize
	 * @param jbMirror
	 * @param jbCrop
	 */
	public EditCommand(JButton jbEdit, JButton jbRotate, JButton jbResize, JButton jbMirror, JButton jbCrop){
		this.jbEdit = jbEdit;
		this.jbRotate = jbRotate;
		this.jbResize = jbResize;
		this.jbMirror= jbMirror;
		this.jbCrop = jbCrop;
	}
	
	@Override
	public void execute() {
		edit();
	}
	
	/**
	 * Method to perform when edit button is clicked by user
	 */
	public void edit(){
		/* call clone from prototype 
			and view cloned image next to original for editing
		*/
		
		// make action buttons for editing visible
		jbRotate.setVisible(true);
		jbResize.setVisible(true);
		jbMirror.setVisible(true);
		jbCrop.setVisible(true);
		
		jbEdit.setEnabled(false);
	}

}

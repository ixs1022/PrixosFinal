
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * EditCommands enables edits (resize, crop, rotate, mirror) of an image
 * Makes copy of image to be edited
 * 
 * @author isabella
 *
 */
public class EditCommand implements Command{
	/**
	 * 
	 */
	//attributes
	private JPanel jpEditing;
	private JButton jbEdit;
	private JButton jbRotate;
	private JButton jbResize;
	private JButton jbMirror;
	private JButton jbCrop;
	private JButton jbDelete;
	private ImageIcon ic;
	private JFrame jf;
	
	/**
	 * Constructor
	 * @param jbEdit
	 * @param jbRotate
	 * @param jbResize
	 * @param jbMirror
	 * @param jbCrop
	 * @param jbDelete
	 */
	public EditCommand(JFrame jf,ImageIcon ic, JPanel jpEditing, JButton jbEdit, JButton jbRotate, JButton jbResize, JButton jbMirror, JButton jbCrop, JButton jbDelete){
		this.jf = jf;
		this.ic = ic;
		this.jpEditing = jpEditing;
		this.jbEdit = jbEdit;
		this.jbRotate = jbRotate;
		this.jbResize = jbResize;
		this.jbMirror= jbMirror;
		this.jbCrop = jbCrop;
		this.jbDelete = jbDelete;
		
		
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
		/*PrototypeFactory pf = new PrototypeFactory();
		ImageClone img = new ImageClone(ic);
		ImageIcon newImg =  pf.makeCopy(img);
		
		jpEditing.add(new JLabel(newImg));
		jf.add(jpEditing);
		*/
		
		
		// make action buttons for editing visible
		jbRotate.setVisible(true);
		jbResize.setVisible(true);
		jbMirror.setVisible(true);
		jbCrop.setVisible(true);
		jbDelete.setVisible(true);
		
		jbEdit.setEnabled(false);
	}

}

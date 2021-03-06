import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

/**
 * Acts as the controller for the commands
 * This class decides which command to call based on which button is called
 * Using the different command classes 
 * @author isabella
 *
 */
public class CommandHandler implements ActionListener{
	// attributes
	private JButton jbEdit, jbCrop, jbDelete, jbMirror, jbResize, jbRotate;
	private JMenuItem jmiSave;
	private JPanel jpImage;
	private ImageIcon ic;
	private JFrame jf;
	private BufferedImage bi;
	
	
	public CommandHandler(JFrame jf,JButton edit, JButton crop, JButton delete, JButton mirror, JButton resize,
							JButton rotate, JMenuItem save, JPanel jp, ImageIcon icon, BufferedImage bi){
		this.jf = jf;
		jbEdit = edit;
		jbCrop = crop;
		jbDelete = delete;
		jbMirror = mirror;
		jbResize = resize;
		jbRotate = rotate;
		jmiSave = save;
		jpImage = jp;
		ic = icon;
		this.bi = bi;
	}
	
	public CommandHandler(JButton edit, JButton crop, JButton delete, JButton mirror, JButton resize,
			JButton rotate){
		
		jbEdit = edit;
		jbCrop = crop;
		jbDelete = delete;
		jbMirror = mirror;
		jbResize = resize;
		jbRotate = rotate;
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object button =  ae.getSource();
		
		if(button == jbEdit){
			System.out.println("Edit");
			EditCommand ec = new EditCommand(jf, ic, jpImage, jbEdit, jbRotate, jbResize, jbMirror, jbCrop, jbDelete);
			ec.edit();
			/*jbRotate.setVisible(true);
			jbResize.setVisible(true);
			jbMirror.setVisible(true);
			jbCrop.setVisible(true);
			jbDelete.setVisible(true);
			
			jbEdit.setEnabled(false);*/
		}
		else if(button == jbCrop){
			System.out.println("Crop");
		}
		else if(button == jbDelete){
			System.out.println("Delete");
		}
		else if(button == jbMirror){
			System.out.println("Mirror");
		}
		else if(button == jbResize){
			System.out.println("Resize");
			
		}
		else if(button == jbRotate){
			System.out.print("Rotate");
			
			/*Integer[] options = {180,
	                90,
	                45};
			int n = JOptionPane.showOptionDialog(null,
			"How many degrees would you like to rotate the image?",
			"Rotate",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[1]);
			
			System.out.println(": " +options[n]);*/
			RotateCommand rc = new RotateCommand(bi);
			rc.execute();
			
		}
		else if(button == jmiSave){
			System.out.println("Save");
		}
		
	}
}

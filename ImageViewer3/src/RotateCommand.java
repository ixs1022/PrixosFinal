import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private JFrame frame;
	private CustomImage image;
	private DisplayFrame display;
	private ImageEditor editor;
	
	/**
	 * Constructor
	 */
	public RotateCommand(JFrame jf,CustomImage ci){
		frame = jf;
		display = new DisplayFrame(ci);
		editor = new ImageEditor(ci);
		image = ci;
	}
	
	@Override
	public void execute() {
		rotate();
		
	}
	
	/**
	 * Method to be performed when rotate button is clicked by user
	 */
	public void rotate(){
		Integer [] options = {30, 45, 60, 90, 180};
		int deg = JOptionPane.showOptionDialog(null, "How many degrees to rotate: ", "Rotate Image",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, options, options[4]);
		//double rad = deg * Math.PI / 180.0;
		
		
		/*BufferedImage bi = image.getBuffered();
		AffineTransform at = AffineTransform.getRotateInstance(deg, bi.getWidth()/2, bi.getHeight()/2.0);
		BufferedImage newImage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g = newImage.createGraphics();
	    g.transform(at);
	    g.drawImage(newImage, 0, 0, null);
	    g.dispose();
	    image.setImageIcon(new ImageIcon(newImage));
	    image.setBufferedImage(newImage);*/
	    
	    editor.rotate(deg);
	    
	    frame.setVisible(false);
	    //display.saveMemento();
	    display.showFrame(image);
	}

}

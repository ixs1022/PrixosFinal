import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

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
	BufferedImage bi; 
	
	/**
	 * Constructor
	 */
	public RotateCommand(BufferedImage bi){
		this.bi = bi;
	}
	
	@Override
	public void execute() {
		double deg = (double) rotate();
		double radians = deg * Math.PI / 180;
		
		System.out.println("Image width: " +bi.getWidth() +"\tImage height: " +bi.getHeight());
		AffineTransform at = new AffineTransform();
		at.rotate(radians, bi.getWidth()/2, bi.getHeight()/2);
		AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		ato.filter(bi,null);
	}
	
	/**
	 * Method to be performed when rotate button is clicked by user
	 */
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

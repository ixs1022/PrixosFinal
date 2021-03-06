import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Flip, when calls upon, allows user to flip image 
 * either vertically or horizontally to create a mirror image
 * 
 * @author isabella
 *
 */
public class FlipCommand implements Command {
	// attributes
	private CustomImage image;
	private JFrame frame;
	private DisplayFrame display;
	
	/**
	 * Constructor for FlipCommand
	 * @param jf JFrame
	 * @param ci CustomImage
	 */
	public FlipCommand(JFrame jf, CustomImage ci){
		frame = jf;
		image = ci;
		
	}
	
	/**
	 * Method to execute the flip command
	 */
	@Override
	public void execute() {
		flip();
		
	}
	
	/**
	 * Private method with instructions on how to flip image
	 * Called by execute() to be called in event handler
	 */
	private void flip(){
		BufferedImage flipped = image.getBuffered();
		AffineTransform at = new AffineTransform();
		at.concatenate(AffineTransform.getScaleInstance(1, -1));
	    at.concatenate(AffineTransform.getTranslateInstance(0, -flipped.getHeight()));
	    BufferedImage newImage = new BufferedImage(flipped.getWidth(), flipped.getHeight(),BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = newImage.createGraphics();
	    g.transform(at);
	    g.drawImage(flipped, 0, 0, null);
	    g.dispose();
	    
	    image.setImageIcon(new ImageIcon(newImage));
	    image.createBufferedViaImageIcon();
	    
	    frame.setVisible(false);
	    display.saveMemento();
	    display.showFrame(image);
	    
	}

}

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.event.*;

/**
 * This class implements ImageAlbum and represents an image
 * Images can be a part of an album or on its own
 * 
 * @author isabella
 *
 */
public class CustomImage{
	// attributes
	private ImageIcon imageIcon;
	
	/**
	 * Constructor
	 * @param imageIcon
	 */
	public CustomImage(String filename){
		imageIcon = new ImageIcon(filename);
		
	}
	
	public Image getImage(){
		return imageIcon.getImage();
	}
}

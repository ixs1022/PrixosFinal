import javax.swing.ImageIcon;

/**
 * This interface is used to clone an image
 * Called on an image when client wants to edit it
 * 
 * @author isabella
 *
 */
public interface ImagePrototype extends Cloneable {
	
	/**
	 * 
	 */
	public ImageIcon makeCopy();
}

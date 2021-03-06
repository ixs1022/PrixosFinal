import javax.swing.ImageIcon;

/**
 * Factory class that will make copies of ImagePrototype objects
 * @author isabella
 *
 */
public class PrototypeFactory {
	// attributes
	
	/**
	 * Constructor of prototype factory
	 */
	
	/**
	 * Method to make copy of ImagePrototype objects
	 * @param ImagePrototype object
	 * @return new ImagePrototype object
	 */
	public ImageIcon makeCopy(ImagePrototype ipt){
		return (ImageIcon) ipt.makeCopy();
		
	}
}

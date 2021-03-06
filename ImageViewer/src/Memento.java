import javax.swing.ImageIcon;

/**
 * Keeps states of image while being edited
 * Adapted from Derek Banas - https://www.youtube.com/watch?v=jOnxYT8Iaoo
 * 
 * @author isabella
 *
 */
public class Memento {
	// attributes
	private ImageIcon img;
	
	/**
	 * Constructor
	 * @param savedImg
	 */
	public Memento(ImageIcon savedImg){
		img = savedImg;
	}
	
	/**
	 * get saved image
	 * @return
	 */
	public ImageIcon getSavedImg(){
		return img;
	}
}

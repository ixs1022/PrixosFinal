/**
 * Keeps states of image while being edited
 * 
 * @author isabella
 *
 */
public class Memento {
	// attributes
	private CustomImage image;
	
	/**
	 * Constructor
	 * @param savedImg
	 */
	public Memento(CustomImage savedImg){
		image = savedImg;
	}
	
	/**
	 * get saved image
	 * @return image
	 */
	public CustomImage getSavedImg(){
		return image;
	}
}

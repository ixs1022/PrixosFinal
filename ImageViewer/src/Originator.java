import javax.swing.ImageIcon;

/**
 * Creates and saves mementos of the image
 * Adapted from Derek Banas - https://www.youtube.com/watch?v=jOnxYT8Iaoo
 *  
 * @author isabella
 *
 */
public class Originator {
	//attributes
	private ImageIcon img;
	
	/**
	 * Set new version of image
	 * @param newImg
	 */
	public void set(ImageIcon newImg){
		System.out.println("Originator - setting new version of image");
		img = newImg;
	}
	
	/**
	 * create new memento of new version of image
	 * @return Memento
	 */
	public Memento storeInMemento(){
		System.out.println("Originator - saving to memento");
		return new Memento(img);
	}
	
	public ImageIcon restore(Memento m){
		img = m.getSavedImg();
		System.out.println("Orginator - previous version of image");
		return img;
	}
}

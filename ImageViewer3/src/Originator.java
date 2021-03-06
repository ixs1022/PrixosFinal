/**
 * Creates and saves mementos of the image
 * 
 * @author isabella
 *
 */
public class Originator {
	//attributes
	private CustomImage image;
	
	/**
	 * Set new version of image
	 * @param newImg
	 */
	public void set(CustomImage newImg){
		System.out.println("Originator - setting new version of image");
		image = newImg;
	}
	
	/**
	 * create new memento of new version of image
	 * @return Memento
	 */
	public Memento storeInMemento(){
		System.out.println("Originator - saving to memento");
		return new Memento(image);
	}
	
	/**
	 * Method to get previous version of image
	 * @param m Memento
	 * @return image CustomImage
	 */
	public CustomImage restore(Memento m){
		image = m.getSavedImg();
		System.out.println("Orginator - previous version of image");
		return image;
	}
}

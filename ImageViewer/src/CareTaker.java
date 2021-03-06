import java.util.ArrayList;

/**
 * Stores states of the edited image and allows client to undo and redo
 * to other states of the image
 * Adapted from Derek Banas - https://www.youtube.com/watch?v=jOnxYT8Iaoo
 * 
 * @author isabella
 *
 */
public class CareTaker {
	// attributes
	private ArrayList<Memento> savedImages = new ArrayList<Memento>();
	
	/**
	 * method to add memento to ArrayList of Mementos
	 * @param m Memento
	 */
	public void addMemento(Memento m){
		savedImages.add(m);
	}
	
	/**
	 * Method to get memento at specified index
	 * @param i int
	 * @return Memento at specified index
	 */
	public Memento getMemento(int i){
		return savedImages.get(i);
	}
}

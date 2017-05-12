import java.util.ArrayList;

/**
 * Stores states of the edited image and allows client to undo and redo
 * to other states of the image
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
	
	/**
	 * Method to get size of the array list containing mementos
	 * @return int savedImages.getSize()
	 */
	public int getSize(){
		return savedImages.size();
	}
}

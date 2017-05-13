import java.util.ArrayList;
//import java.util.Iterator;

/**
 * This class implements ImageAlbum and represents an Album
 * Images can be added to this Album
 * 
 * @author isabella
 *
 */
public class Album extends ImageAlbum {
	//attributes
	ArrayList<ImageAlbum> images = new ArrayList<ImageAlbum>();
	String albumName;
	
	/**
	 * Constructor for Album
	 * @param albumName String
	 */
	public Album(String albumName){
		this.albumName = albumName;
	}
	
	/**
	 * Accessor to get name of album
	 * @return albumName
	 */
	public String getAlbumName(){
		return albumName;
	}
	
	/**
	 * Method to add ImageAlbum component to arraylist (either image or album)
	 * @param newComponent ImageAlbum
	 */
	public void add(ImageAlbum newComponent){
		images.add(newComponent);
	}
	
	/**
	 * Method to remove component from album
	 * @param component ImageAlbum
	 */
	public void remove(ImageAlbum component){
		images.remove(component);
	}
	
	/**
	 * Accessor for component in album at specified index
	 * @param index int
	 * @return component at index
	 */
	public ImageAlbum getComponent(int index){
		return (ImageAlbum)images.get(index);
	}
	
	/**
	 * Method to display contents of album
	 */
	/*public void displayAlbumContents(){
		Iterator albumIterator = images.iterator();
		
		while(albumIterator.hasNext()){
			
		}
	}*/
	
}

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class implements ImageAlbum and represents an Album
 * Images can be added to this Album
 * 
 * @author isabella
 *
 */
public class Album extends ImageAlbum {
	
	ArrayList<ImageAlbum> images = new ArrayList<ImageAlbum>();
	String albumName;
	
	public Album(String albumName){
		this.albumName = albumName;
	}
	
	public String getAlbumName(){
		return albumName;
	}
	
	public void add(ImageAlbum newComponent){
		images.add(newComponent);
	}
	
	public void remove(ImageAlbum newComponent){
		images.remove(newComponent);
	}
	
	public ImageAlbum getComponent(int index){
		return (ImageAlbum)images.get(index);
	}
	
	/*public void displayAlbumContents(){
		Iterator albumIterator = images.iterator();
		
		while(albumIterator.hasNext()){
			
		}
	}*/
	
}

/**
 * This class is part of the Composite Pattern for creating
 * and distinguishing between Album (directory) and Image (file)
 * 
 * @author isabella
 *
 */
public abstract class ImageAlbum {
	//attributes
	
	public void add(ImageAlbum newComponent){
		throw new UnsupportedOperationException();
	}
	
	public void remove(ImageAlbum newComponent){
		throw new UnsupportedOperationException();
	}
	
	public ImageAlbum getComponent(int index){
		throw new UnsupportedOperationException();
	}
}

//Ivan Kovacevic Command Pattern
/**
 * Interface of editing options available under the command pattern
 * Includes: resize, rotate, save, flip
 * @author Ivan Kovacevic
 *
 */
public interface EditingOptions {
	
	public void resize(int w, int h);
	
	public void rotate(double deg);
	
	public void saveImage();
	
	public void flip();

}

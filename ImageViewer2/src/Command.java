
/**
 * Interface for all of the commands that will be used for the ImageViewer
 * Commands: Resize, Crop, Rotate, Mirror, Edit, Save, Delete
 * 
 * @author isabella
 *
 */
public interface Command {
	
	public void execute();

	public void execute(int w, int h);
	
	public void execute(double deg);
	
}

import java.io.File;

import javax.imageio.ImageIO;

/**
 * SaveCommand, when called, saves the new edited image
 * First time it is called, user can rename image (and add to album of choice)
 * After that, image is saved normally
 * 
 * @author isabella
 *
 */
public class SaveCommand implements Command {
	// attributes
	private CustomImage image;
	
	/**
	 * Constructor for SaveCommand
	 * @param ci CustomImage
	 */
	public SaveCommand(CustomImage ci){
		image = ci;
	}
	
	
	/**
	 * Method to execute save command
	 */
	@Override
	public void execute() {
		save();
		
	}
	
	/**
	 * Private method with instructions on how to save image
	 * Called by execute() to be used in event handler
	 */
	private void save(){
		image.saveImageNew();
		
		String newName = image.getFilename().substring(0, image.getFilename().length()-4);
		
		 try {
			    // Making the directory if it doesn't exist already!
			   File savedDirectory =new File(System.getProperty("user.dir") + "/" + "savedImages");
			   if(!savedDirectory.exists()){
				   
				   savedDirectory.mkdir();
			   }
			    File outputfile = new File(System.getProperty("user.dir") + "/savedImages/" + newName+"Edited.png");
			    ImageIO.write(image.getBuffered(), "PNG", outputfile);
		   }
	      catch(Exception e)
	      {
	         System.out.println(e.getMessage());            
	      }
	}

}

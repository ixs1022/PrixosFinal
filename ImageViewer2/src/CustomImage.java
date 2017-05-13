import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
/**
 * Class to create ImageIcons from BufferedImages from Files of images
 * @author Ivan Kovacevic
 *
 */

public class CustomImage{
	
	//ATTRIBUTES
   ImageIcon icon;
   BufferedImage image = null;
   File file;
   ArrayList<ImageIcon> alImages;
 
   /**
    * Constructor for CustomImage
    * @param file File
    */
   public CustomImage(File file){
	   
      try{
        // icon = new ImageIcon(f.toURL());
         image = ImageIO.read(file);
         //image.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
         this.file = file;
         //this.alImages = alImages;
      }
      catch(Exception e){
    	  System.out.println("ERROR: " + e.getMessage());
      }
   }// End of MadeImage constructor
   
   
   //TEST METHODS HEERE
   
   public void rightSize(){
	   image.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
   }
   
   
 //saveImage Method
   public void saveImageNew()
   {
	   String newName = file.getName().substring(0,file.getName().length() -4);
	   try {
		    // Making the directory if it doesn't exist already!
		   File savedDirectory =new File(System.getProperty("user.dir") + "\\" + "savedImages");
		   if(!savedDirectory.exists()){
			   
			   savedDirectory.mkdir();
		   }
		   
		    File outputfile = new File(System.getProperty("user.dir") + "\\savedImages\\" + newName+"Edited.png");
		    ImageIO.write(image, "PNG", outputfile);
	   }
      catch(Exception e)
      {
         System.out.println(e.getMessage());            
      }
   }
   
   
   //TEST METHODS END HERE
   
   
   //GETTERS 
   /**
    * Accessor to get BufferedImage
    * @return image
    */
   public BufferedImage getBuffered()
   {
      return image;
      
   }
   
   //Returns an icon
   /**
    * Method to get height of buffered image
    * @return height of image (buffered image)
    */
   public int getHeightImage()
   {
      return image.getHeight();
   }
   
   /**
    * Method to get width of buffered image
    * @return width of image (buffered image)
    */
   public int getWidthImage()
   {
      return image.getWidth();
   }
   
   
   /**
    * Method to get icon of buffered image
    * @return icon
    */
   public Icon getIcon()
   {
      return icon;
   }
   
   /**
    * Method to get height of icon
    * @return icon height
    */
   public int getHeight()
   {
      return icon.getIconHeight();
   }
   
   /**
    * Method to get width of icon
    * @return icon width
    */
   public int getWidth()
   {
      return icon.getIconWidth();
   }
   
   //SETTERS
   
   /**
    * Method to set image icon
    * @param icon
    * Uncommenting getScaledInstance causes image to remain that size even resizing 
    * - image blurs because smaller image is zoomed
    */
   // setting the image icon using the setImageIcon() and resizing it to fit the new pop up Jframe
   public void setImageIcon(ImageIcon icon)
   {
	   
	  icon = new ImageIcon(icon.getImage());//.getScaledInstance(550, 520, java.awt.Image.SCALE_SMOOTH));
      this.icon = icon;
   }
   
  /**
   * Method to create buffered image from image icon
   */
   public void createBufferedViaImageIcon()
   {
	  image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics g = image.createGraphics();
      icon.paintIcon(null, g, 0,0);
      g.dispose();
   }
   
  /**
   * Method to set buffered image
   * @param img BufferedImage
   */
   public void setBufferedImage(BufferedImage img)
   {
      this.image = img;
   }
   
 
}
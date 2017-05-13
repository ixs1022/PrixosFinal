import java.io.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

/**
 * Class that implements Editing Options
 * Used by different commands to carry out actions needed to edit image
 *  - resize, rotate, save, flip
 * @author Ivan Kovacevic
 *
 */
public class ImageEditor implements EditingOptions{
	
	//ATTRIBUTES
	CustomImage image;
	
	/**
	 * Constructor for ImageEditor
	 * @param image CustomImage
	 */
   public ImageEditor(CustomImage image){
      this.image = image;
   }
   
   //METHODS

   //Method for resizing the image OVERRIDE because of the Command pattern (From EditingOptions interface)
   /**
    * Method to resize image
    * @param w int - width
    * @param h int - height
    */
   @Override
   public void resize(int w, int h){
      Image im = image.getBuffered().getScaledInstance(w, h, image.getBuffered().SCALE_DEFAULT);   
      image.setImageIcon(new ImageIcon(im));
      image.createBufferedViaImageIcon();
   }
   
 //Method for fliping the image OVERRIDE because of the Command pattern (From EditingOptions interface)
   /**
    * Method to flip image
    */
   @Override
   public void flip(){
      BufferedImage flipped  = createFlipped(image.getBuffered());
      image.setImageIcon(new ImageIcon(flipped));
      image.setBufferedImage(flipped);
   }
   
 //Method for rotating the image OVERRIDE because of the Command pattern (From EditingOptions interface)
   /**
    * Method to rotate image
    * param deg double
    */
   @Override
   public void rotate(double deg){
      BufferedImage rotated = createRotated(image.getBuffered(), deg);
      image.setImageIcon(new ImageIcon(rotated));
      image.setBufferedImage(rotated);
   }
   
   
   //Saves the new BufferedImage as png OVERRIDE because of the Command pattern (From EditingOptions interface)
   /**
    * Method to save new edited image
    */
   @Override
   public void saveImage(){
	   image.saveImageNew();
   }
  
  
   
   // A guide fore rotating and flipping - read this please http://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
   /**
    * Method to create rotated image
    * @param image BufferedImage
    * @param deg double
    * @return BufferedImage
    */
   private static BufferedImage createRotated(BufferedImage image, double deg){
       
	   AffineTransform at = AffineTransform.getRotateInstance(Math.PI, image.getWidth()/2, image.getHeight()/2.0);
       return createTransformed(image, at);
    }
   
   /**
    * Method to create flipped image
    * @param image BufferedImage
    * @return BufferedImage
    */
   private static BufferedImage createFlipped(BufferedImage image){
      AffineTransform at = new AffineTransform();
      at.concatenate(AffineTransform.getScaleInstance(1, -1));
      at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
      return createTransformed(image, at);
   }
   
   /**
    * Method to create transformed image- either flipped or rotated
    * @param image Buffered Imaged
    * @param at AffineTransform
    * @return BufferedImage
    */
   private static BufferedImage createTransformed(BufferedImage image, AffineTransform at){
	   
	  BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = newImage.createGraphics();
      g.transform(at);
      g.drawImage(image, 0, 0, null);
      g.dispose();
      return newImage;
   }
   
}// End of class ImageEditor

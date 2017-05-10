import java.io.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

//Author Ivan Kovacevic

public class ImageEditor{
	
	//ATTRIBUTES
	
	CustomImage image;
	
	//CONSTRUCTOR
	
   public ImageEditor(CustomImage image){
      this.image = image;
   }
   
   //METHODS
   
   //Method for resizing the image
   public void resize(int w, int h){
      Image im = image.getBuffered().getScaledInstance(w, h, image.getBuffered().SCALE_DEFAULT);   
      image.setImageIcon(new ImageIcon(im));
      image.createBufferedViaImageIcon();
   }
   
 //Method for fliping the image
   public void flip(){
      BufferedImage flipped  = createFlipped(image.getBuffered());
      image.setImageIcon(new ImageIcon(flipped));
      image.setBufferedImage(flipped);
   }
   
 //Method for rotating the image
   public void rotate(double deg){
      BufferedImage rotated = createRotated(image.getBuffered(), deg);
      image.setImageIcon(new ImageIcon(rotated));
      image.setBufferedImage(rotated);
   }
   
   
   //Saves the new BufferedImage as png
   public void saveImage(){
	   image.saveImageNew();
   }
  
  
   
   // A guide fore rotating and flipping - read this please http://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
   
   static BufferedImage createRotated(BufferedImage image, double deg){
       
	   AffineTransform at = AffineTransform.getRotateInstance(deg, image.getWidth()/2, image.getHeight()/2.0);
       return createTransformed(image, at);
    }
   
   
   private static BufferedImage createFlipped(BufferedImage image){
      AffineTransform at = new AffineTransform();
      at.concatenate(AffineTransform.getScaleInstance(1, -1));
      at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
      return createTransformed(image, at);
   }
   
   
   private static BufferedImage createTransformed(BufferedImage image, AffineTransform at){
	   
	  BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = newImage.createGraphics();
      g.transform(at);
      g.drawImage(image, 0, 0, null);
      g.dispose();
      return newImage;
   }
   
}// End of class ImageEditor

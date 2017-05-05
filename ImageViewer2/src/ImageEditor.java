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
   
   public void resize(int w, int h){
      Image im = image.getBuffered().getScaledInstance(w, h, image.getBuffered().SCALE_DEFAULT);   
      image.setIcon(new ImageIcon(im));
      image.setBufferedFromImageIcon();
   }
   
   public void flip(){
      BufferedImage flipped  = createFlipped(image.getBuffered());
      image.setIcon(new ImageIcon(flipped));
      image.setBuffered(flipped);
   }
   
   public void rotate(double deg){
      BufferedImage rotated = createRotated(image.getBuffered(), deg);
      image.setIcon(new ImageIcon(rotated));
      image.setBuffered(rotated);
   }
   
   public void saveImage(){
	   image.saveImageNew();
   }
  
   //Returns a rotated BufferedImage 
   private static BufferedImage createRotated(BufferedImage image, double deg){
       System.out.println("ImageEditor - createRotated()"); 
	   AffineTransform at = AffineTransform.getRotateInstance(Math.PI, image.getWidth()/2, image.getHeight()/2.0);
        return createTransformed(image, at);
    }
   
   
   private static BufferedImage createFlipped(BufferedImage image){
      AffineTransform at = new AffineTransform();
      at.concatenate(AffineTransform.getScaleInstance(1, -1));
      at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
      return createTransformed(image, at);
   }
   
   
   private static BufferedImage createTransformed(BufferedImage image, AffineTransform at){
	   System.out.println("ImageEditor - createTransformed()"); 
	   BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = newImage.createGraphics();
      g.transform(at);
      g.drawImage(image, 0, 0, null);
      g.dispose();
      return newImage;
   }
   
}// End of class ImageEditor
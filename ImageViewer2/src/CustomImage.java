import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

// Author Ivan Kovacevic

public class CustomImage{
	
	//ATTRIBUTES
   ImageIcon icon;
   BufferedImage img = null;
   File f;
   ArrayList<ImageIcon> alImages;
   
   //CONSTRUCTOR
   
   public CustomImage( File f){
	   
      try{
         icon =new ImageIcon(f.toURL());
         img = ImageIO.read(f);
         img.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
         this.f = f;
         //this.alImages = alImages;
      }
      catch(Exception e){
    	  System.out.println("ERROR: " + e.getMessage());
      }
   }// End of MadeImage constructor
   
   
   //TEST METHODS HEERE
   
   public void rightSize(){
	   img.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
   }
   
   
 //saveImage Method
   public void saveImageNew()
   {
	   String newName = f.getName().substring(0,f.getName().length() -4);
	   try {
		    // retrieve image
		    BufferedImage bi = img;
		    File outputfile = new File("ImageViewer/"+newName+"Edited.png");
		    ImageIO.write(img, "PNG", outputfile);
	   }
      catch(Exception e)
      {
         System.out.println(e.getMessage());            
      }
   }
   
   
   //TEST METHODS END HERE
   
   
   //GETTERS 
   
   public BufferedImage getBuffered()
   {
      return img;
   }
   
   public Icon getIcon()
   {
      return icon;
   }
   
   public int getHeight()
   {
      return icon.getIconHeight();
   }
   
   public int getWidth()
   {
      return icon.getIconWidth();
   }
   
   //SETTERS
   public void setIcon(ImageIcon icon)
   {
      this.icon = icon;
   }
   
  
   public void setBufferedFromImageIcon()
   {
      img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics g = img.createGraphics();
      icon.paintIcon(null, g, 0,0);
      g.dispose();
   }
   
  
   public void setBuffered(BufferedImage img)
   {
      this.img = img;
   }
   
  
   
   public String getType()
   {
      return f.getName().substring(f.getName().length()-3, f.getName().length());
   }
}
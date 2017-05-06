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
   BufferedImage image = null;
   File file;
   ArrayList<ImageIcon> alImages;
   
   //CONSTRUCTOR
   
   public CustomImage(File file){
	   
      try{
        // icon = new ImageIcon(f.toURL());
         image = ImageIO.read(file);
         image.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
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
		    // retrieve image
		    BufferedImage bi = image;
		    File outputfile = new File("ImageViewer/"+newName+"Edited.png");
		    ImageIO.write(image, "PNG", outputfile);
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
      return image;
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
	   image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics g = image.createGraphics();
      icon.paintIcon(null, g, 0,0);
      g.dispose();
   }
   
  
   public void setBuffered(BufferedImage img)
   {
      this.image = img;
   }
   
  
   
   public String getType()
   {
      return file.getName().substring(file.getName().length()-3, file.getName().length());
   }
}
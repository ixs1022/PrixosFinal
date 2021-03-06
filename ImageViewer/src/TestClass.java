import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import com.sun.prism.paint.Color;

public class TestClass extends JPanel{

    private BufferedImage image;
    private Graphics g;

    public TestClass() {
    	
    	
       try {                
          image = ImageIO.read(new File("balloon-hot-air.jpg"));
       } catch (IOException ex) {
            // handle exception...
       }
       
       
	}
    
    
   public void remove() throws IOException{
	  
	   image = ImageIO.read(new File("cliffs-yosemite-halfdome-sierras.jpg"));
	   g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	   repaint();
   }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this); // see javadoc for more info on the parameters            
    }
    
    
    public BufferedImage getImage(){
    	return image;
    }
    
    public Graphics2D rotateImageByDegrees(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, this);
        g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
        g2d.dispose();
        
        return g2d;
    }
    
   
}
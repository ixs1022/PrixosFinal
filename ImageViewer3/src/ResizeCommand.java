import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ResizeCommand changes the size of the image through user input
 * in dialog box (action sheet)
 * 
 * @author isabella
 *
 */
public class ResizeCommand implements Command {
	//attributes
	private CustomImage image;
	private JFrame frame;
	private DisplayFrame display;
	
	/**
	 * Constructor for resize command
	 * @param jf JFrame
	 * @param ci CustomImage
	 */
	public ResizeCommand(JFrame jf, CustomImage ci){
		frame = jf;
		display = new DisplayFrame(ci);
		image = ci;
	}
	@Override
	public void execute() {
		resize();
		
	}
	public void resize(){
		String w = JOptionPane.showInputDialog(frame, "Enter new width:", null);
		String h = JOptionPane.showInputDialog(frame, "Enter new height:", null);
		
		try{
			image.getBuffered();
			Image im = image.getBuffered().getScaledInstance(Integer.parseInt(w), Integer.parseInt(h), BufferedImage.SCALE_DEFAULT);   
		    image.setImageIcon(new ImageIcon(im));
		    image.createBufferedViaImageIcon();
		    frame.setVisible(false);
		    display.saveMemento();
			display.showFrame(image);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(frame,"Something went wrong while trying to resize image :: " +e.getMessage());
			
		}
	}

}

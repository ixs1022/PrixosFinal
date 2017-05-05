import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * ImageViewer is the main class for this application.
 * It provides the Graphical User Interface that the client will interact with
 * The purpose of this application is to allow the user to:
 * 	Organize images into albums and search for images by album
 * 	Edit images (crop, rotate, resize, mirror) without altering original
 *
 * @author isabella
 * 
 */
public class ImageViewer extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// attributes
	private JMenuItem jmiSave;
	private JMenuItem jmiSaveAs;
	private JMenuItem jmiClose;
	private JMenuItem jmiUndo;
	private JMenuItem jmiRedo;
	private JButton jbEdit;
	private JButton jbCrop;
	private JButton jbRotate;
	private JButton jbMirror;
	private JButton jbResize;
	private JButton jbDelete;
	private JButton jbOpen;
	private JButton jbNew;
	private int cur = 0;
	/**
	 * Main method of application
	 * Instantiates the constructor which builds the GUI
	 * Handles the actions called by client
	 */
	public static void main(String [] args){
		new ImageViewer();
	}
	
	/**
	 * Constructor for ImageViewer
	 * Builds Graphical User Interface that will allow client to
	 * interact with and use application
	 */
	public ImageViewer(){
		//JFrame
		setSize(850, 700);
		setTitle("ImageViewer");
		
		//Components for JFrame
		//MenuBar & Menu + MenuItems
		JMenuBar jmbMenuBar = new JMenuBar();
		JMenu jmFile = new JMenu("File");
			jmiSave = new JMenuItem("Save");
			jmiSaveAs = new JMenuItem("SaveAs");
			jmiClose = new JMenuItem("Close");
			jmFile.add(jmiSave);
			jmFile.add(jmiSaveAs);
			jmFile.add(jmiClose);
		jmbMenuBar.add(jmFile);
		JMenu jmEdit = new JMenu("Edit");
			jmiUndo = new JMenuItem("Undo");
			jmiRedo = new JMenuItem("Redo");
			jmEdit.add(jmiUndo);
			jmEdit.add(jmiRedo);
		jmbMenuBar.add(jmEdit);
		setJMenuBar(jmbMenuBar);
		
		
		JPanel jpImages = new JPanel(new CardLayout());
			ArrayList<ImageIcon> alImages = new ArrayList<ImageIcon>();
				alImages.add(new ImageIcon("ImageViewer/balloon-hot-air.jpg"));
				alImages.add(new ImageIcon("ImageViewer/beaver-lodge-on-martin-lake.jpg"));
				alImages.add(new ImageIcon("ImageViewer/beer-and-bread.jpg"));
				alImages.add(new ImageIcon("ImageViewer/bengal-tiger.jpg"));
				alImages.add(new ImageIcon("ImageViewer/biking-at-chincoteague-national-wildlife-refuge.jpg"));
				alImages.add(new ImageIcon("ImageViewer/cactus-photo.jpg"));
				alImages.add(new ImageIcon("ImageViewer/chinese-dragons-flat-stanley.jpg"));
				alImages.add(new ImageIcon("ImageViewer/cliffs-yosemite-halfdome-sierras.jpg"));
				alImages.add(new ImageIcon("ImageViewer/columbia-shuttle-start.jpg"));
				alImages.add(new ImageIcon("ImageViewer/decomposing-cow-skull.jpg"));
				alImages.add(new ImageIcon("ImageViewer/first-man-on-moon-walking-on-the-moon.jpg"));
				alImages.add(new ImageIcon("ImageViewer/great-fireworks-night.jpg"));
				alImages.add(new ImageIcon("ImageViewer/man-checking-gill-nets.jpg"));
				alImages.add(new ImageIcon("ImageViewer/rock-climber-on-the-wall.jpg"));
				alImages.add(new ImageIcon("ImageViewer/soldier-on-military-boat.jpg"));
				alImages.add(new ImageIcon("ImageViewer/spring-in-hills.jpg"));
				alImages.add(new ImageIcon("ImageViewer/the-manna-organic-shop-kilcullen.jpg"));
				alImages.add(new ImageIcon("ImageViewer/tower-bridge-in-london-england.jpg"));
				alImages.add(new ImageIcon("ImageViewer/winter-road.jpg"));
				alImages.add(new ImageIcon("ImageViewer/wooden-window.jpg"));
				alImages.add(new ImageIcon("ImageViewer/yankees-stadium-crowd.jpg"));
				alImages.add(new ImageIcon("ImageViewer/yard-gate.jpg"));
				
				
			int numCards;
			if(alImages.size() % 4 == 0){
				numCards = alImages.size()/4;
			}
			else{
				numCards = alImages.size()/4 + 1;
			}
			
			ArrayList<JPanel> alCards = new ArrayList<JPanel>();
			int k = alImages.size() -1;
			int x = 0;
			while(x < k){
				//System.out.println("while");
				for(int i = 1; i <= numCards; i++)
				{
					//System.out.println("In outer for loop");
					JPanel jpImageGrid = new JPanel(new GridLayout(0,2,20,20));
						for(int j=0; j < 4; j++){
							//System.out.println(x);
							if(x < k){
								ImageIcon img = alImages.get(x);
								//System.out.println(img.toString());
								java.awt.Image image = img.getImage();
								java.awt.Image newImage = image.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
								ImageIcon newImg = new ImageIcon(newImage);
								JLabel jlImage = new JLabel(newImg);
								
								//ACTION LISTENER FOR A NEW IMAGE THAT IS ADDED
								
								jlImage.addMouseListener(new MouseAdapter() {
									
									
								      public void mouseClicked(MouseEvent me) {
								          System.out.println("CLICKED");
								          String aloba = "" + img;
								          System.out.println("" + img);
								          File f = new File(aloba);
								          CustomImage made = new CustomImage(f);
								          made.rightSize();
								          
								          DisplayFrame df = new DisplayFrame();
								          df.showFrame(made);
								          
								        
								        }
								      });
								jpImageGrid.add(jlImage);
								x++;
								
							}
							else{
								break;
							}
						}
						
					alCards.add(jpImageGrid);
					jpImages.add(jpImageGrid);
				}
			}
		
		add(jpImages);
		JPanel jpButtons = new JPanel();
			JButton jbPrev = new JButton("Previous");
				jbPrev.setEnabled(false);
			JButton jbNext = new JButton("Next");
			jpButtons.add(jbPrev);
			jpButtons.add(jbNext);
		add(jpButtons, BorderLayout.SOUTH);
		
			jbNext.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					jbPrev.setEnabled(true);
					if(cur == numCards -1){
						jbNext.setEnabled(false);
					}
					else{
						alCards.get(cur).setVisible(false);
						alCards.get(cur+1).setVisible(true);
						cur++;
						if(cur == numCards -1){
							jbNext.setEnabled(false);
						}
					}
				}
			});
			jbPrev.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					jbNext.setEnabled(true);
					if(cur == 0){
						jbPrev.setEnabled(false);
					}
					else{
						alCards.get(cur).setVisible(false);
						alCards.get(cur-1).setVisible(true);
						cur--;
						if(cur == 0){
							jbPrev.setEnabled(false);
						}
					}
					
				}
			});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}

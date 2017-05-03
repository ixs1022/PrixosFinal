import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

//import com.sun.glass.events.MouseEvent;
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
public class ImageViewer1 extends JFrame implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// attributes
	public JMenuItem jmiSave;
	public JMenuItem jmiSaveAs;
	public JMenuItem jmiClose;
	public JMenuItem jmiUndo;
	public JMenuItem jmiRedo;
	public JButton jbEdit;
	public JButton jbCrop;
	public JButton jbRotate;
	public JButton jbMirror;
	public JButton jbResize;
	public JButton jbDelete;
	public JButton jbOpen;
	public JButton jbNew;
	public int cur = 0;
	public JLabel label2;
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
	public ImageViewer1(){
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
		
		// Option bar for images
		/*JPanel jpOptions = new JPanel();
			jbEdit = new JButton("Edit");
			jbDelete = new JButton("Delete");
			jpOptions.add(jbEdit);
				jbCrop = new JButton("Crop");
				//jbCrop.setVisible(false);
				jbRotate = new JButton("Rotate");
				//jbRotate.setVisible(false);
				jbResize = new JButton("Resize");
				//jbResize.setVisible(false);
				jbMirror = new JButton("Mirror");
				//jbMirror.setVisible(false);
			jpOptions.add(jbCrop);
			jpOptions.add(jbRotate);
			jpOptions.add(jbResize);
			jpOptions.add(jbMirror);
			jpOptions.add(jbDelete);
		add(jpOptions, BorderLayout.NORTH);*/
		
		JPanel jpImages = new JPanel(new CardLayout());
		
		
		ImageIcon img2 = new ImageIcon("ImageViewer/rock-climber-on-the-wall.jpg");
		java.awt.Image image2 = img2.getImage();
		java.awt.Image newImage2 = image2.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImg2 = new ImageIcon(newImage2);
		label2 = new JLabel("label");
		label2.setIcon(newImg2);
		
		jpImages.add(label2);
		
		label2.addMouseListener(new MouseAdapter() {
			
			@Override
	        public void mouseClicked(java.awt.event.MouseEvent arg0) {

	            System.out.println("ALO");
	            JFrame jframe = new JFrame();
	            
	            
	            jframe.setSize(500, 500);
	            jframe.setVisible(true);
	            
	            JLabel label = new JLabel("labelinjo");
	            ImageIcon img2 = new ImageIcon("ImageViewer/rock-climber-on-the-wall.jpg");
	    		java.awt.Image image2 = img2.getImage();
	    		java.awt.Image newImage2 = image2.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
	    		ImageIcon newImg2 = new ImageIcon(newImage2);
	    		label.setIcon(newImg2);
	    		
	    		jframe.add(label);

	        }

	    });
		
		
		
		
		
			ArrayList<ImageIcon> alImages = new ArrayList<ImageIcon>();
				//alImages.add(new ImageIcon("ImageViewer/balloon-hot-air.jpg"));
				alImages.add(new ImageIcon("ImageViewer/beaver-lodge-on-martin-lake.jpg"));
				alImages.add(new ImageIcon("ImageViewer/beer-and-bread.jpg"));
				alImages.add(new ImageIcon("ImageViewer/bengal-tiger.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/biking-at-chincoteague-national-wildlife-refuge.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/cactus-photo.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/chinese-dragons-flat-stanley.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/cliffs-yosemite-halfdome-sierras.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/columbia-shuttle-start.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/decomposing-cow-skull.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/first-man-on-moon-walking-on-the-moon.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/great-fireworks-night.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/man-checking-gill-nets.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/rock-climber-on-the-wall.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/soldier-on-military-boat.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/spring-in-hills.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/the-manna-organic-shop-kilcullen.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/tower-bridge-in-london-england.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/winter-road.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/wooden-window.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/yankees-stadium-crowd.jpg"));
			//	alImages.add(new ImageIcon("ImageViewer/yard-gate.jpg"));
				
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
								jpImageGrid.add(new JLabel(newImg));
								x++;
								//k--;
							}
							else{
								break;
							}
						}
						//jpImageGrid.add(new JLabel("Images"));
					alCards.add(jpImageGrid);
					jpImages.add(jpImageGrid);
				}
			}
			
			
		CustomImage img1 = new CustomImage(new ImageIcon("ImageViewer/balloon-hot-air.jpg"));
		
		
		
		
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
		
			
		// Panel -- Card Layout
		/*JPanel jpCards = new JPanel(new CardLayout());
			// Card #1 - Albums
			JPanel jpAlbums = new JPanel();
				JPanel jpAlbumList = new JPanel();
					jbNew = new JButton("New Album");
					jbOpen = new JButton("Open Album");
				jpAlbumList.add(jbNew);
			jpAlbums.add(jpAlbumList, BorderLayout.WEST);
		jpCards.add(jpAlbums);
		
			
			
			
			
		add(jpCards, BorderLayout.CENTER);*/
		
		
		
		// JFrame configuration
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		System.out.println("CLICKED");
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
	private JFrame jf;
	private int cur = 0;
	
	private Image image1;
	private ImageIcon newImg1;
	private BufferedImage bi;
	private Graphics g;
	private JLabel jlOld;
	private JLabel jlNew;
	private JPanel jpOptions;
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
				alImages.add(new ImageIcon("balloon-hot-air.jpg"));
				alImages.add(new ImageIcon("beaver-lodge-on-martin-lake.jpg"));
				alImages.add(new ImageIcon("beer-and-bread.jpg"));
				alImages.add(new ImageIcon("bengal-tiger.jpg"));
				alImages.add(new ImageIcon("biking-at-chincoteague-national-wildlife-refuge.jpg"));
				alImages.add(new ImageIcon("cactus-photo.jpg"));
				alImages.add(new ImageIcon("chinese-dragons-flat-stanley.jpg"));
				alImages.add(new ImageIcon("cliffs-yosemite-halfdome-sierras.jpg"));
				alImages.add(new ImageIcon("columbia-shuttle-start.jpg"));
				alImages.add(new ImageIcon("decomposing-cow-skull.jpg"));
				alImages.add(new ImageIcon("first-man-on-moon-walking-on-the-moon.jpg"));
				alImages.add(new ImageIcon("great-fireworks-night.jpg"));
				alImages.add(new ImageIcon("man-checking-gill-nets.jpg"));
				alImages.add(new ImageIcon("rock-climber-on-the-wall.jpg"));
				alImages.add(new ImageIcon("soldier-on-military-boat.jpg"));
				alImages.add(new ImageIcon("spring-in-hills.jpg"));
				alImages.add(new ImageIcon("the-manna-organic-shop-kilcullen.jpg"));
				alImages.add(new ImageIcon("tower-bridge-in-london-england.jpg"));
				alImages.add(new ImageIcon("winter-road.jpg"));
				alImages.add(new ImageIcon("wooden-window.jpg"));
				alImages.add(new ImageIcon("yankees-stadium-crowd.jpg"));
				alImages.add(new ImageIcon("yard-gate.jpg"));
				
				/*alImages.add(new ImageIcon("ImageViwer/balloon-hot-air.jpg"));
				alImages.add(new ImageIcon("ImageViwer/beaver-lodge-on-martin-lake.jpg"));
				alImages.add(new ImageIcon("ImageViwer/beer-and-bread.jpg"));
				alImages.add(new ImageIcon("ImageViwer/bengal-tiger.jpg"));
				alImages.add(new ImageIcon("ImageViwer/biking-at-chincoteague-national-wildlife-refuge.jpg"));
				alImages.add(new ImageIcon("ImageViwer/cactus-photo.jpg"));
				alImages.add(new ImageIcon("ImageViwer/chinese-dragons-flat-stanley.jpg"));
				alImages.add(new ImageIcon("ImageViwer/cliffs-yosemite-halfdome-sierras.jpg"));
				alImages.add(new ImageIcon("ImageViwer/columbia-shuttle-start.jpg"));
				alImages.add(new ImageIcon("ImageViwer/decomposing-cow-skull.jpg"));
				alImages.add(new ImageIcon("ImageViwer/first-man-on-moon-walking-on-the-moon.jpg"));
				alImages.add(new ImageIcon("ImageViwer/great-fireworks-night.jpg"));
				alImages.add(new ImageIcon("ImageViwer/man-checking-gill-nets.jpg"));
				alImages.add(new ImageIcon("ImageViwer/rock-climber-on-the-wall.jpg"));
				alImages.add(new ImageIcon("ImageViwer/soldier-on-military-boat.jpg"));
				alImages.add(new ImageIcon("ImageViwer/spring-in-hills.jpg"));
				alImages.add(new ImageIcon("ImageViwer/the-manna-organic-shop-kilcullen.jpg"));
				alImages.add(new ImageIcon("ImageViwer/tower-bridge-in-london-england.jpg"));
				alImages.add(new ImageIcon("ImageViwer/winter-road.jpg"));
				alImages.add(new ImageIcon("ImageViwer/wooden-window.jpg"));
				alImages.add(new ImageIcon("ImageViwer/yankees-stadium-crowd.jpg"));
				alImages.add(new ImageIcon("ImageViwer/yard-gate.jpg"));*/
				
			int numCards;
			if(alImages.size() % 4 == 0){
				numCards = alImages.size()/4;
			}
			else{
				numCards = alImages.size()/4 + 1;
			}
			
			jbEdit = new JButton("Edit");
			jbDelete = new JButton("Delete");
			jbDelete.setVisible(false);
				jbCrop = new JButton("Crop");
				jbCrop.setVisible(false);
				jbRotate = new JButton("Rotate");
				jbRotate.setVisible(false);
				jbResize = new JButton("Resize");
				jbResize.setVisible(false);
				jbMirror = new JButton("Mirror");
				jbMirror.setVisible(false);
			
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
								jlImage.addMouseListener(new MouseAdapter() {
								      public void mouseClicked(MouseEvent me) {
								          System.out.println("CLICKED");
								           jf = new JFrame();
									  		jf.setSize(650, 600);
									  		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									  		//jf.setLocationRelativeTo(this);
									  		 image1 = img.getImage().getScaledInstance(600, 450, Image.SCALE_SMOOTH);
									  		 newImg1 = new ImageIcon(image1);
									  		
									  		
									  		     bi = new BufferedImage(
									  			newImg1.getIconWidth(),
									  			newImg1.getIconHeight(),
									  			BufferedImage.TYPE_INT_RGB);
									  			 g = bi.createGraphics();
									  			// paint the Icon to the BufferedImage.
									  			newImg1.paintIcon(null, g, 0,0);
									  			g.dispose();
									  			
									  			jlOld = new JLabel(new ImageIcon(bi));
									  		
									  			jf.add(jlOld);
									  		
									  	// Option bar for images
											 jpOptions = new JPanel();
												
														jbResize.addMouseListener(new MouseAdapter(){
															public void mouseClicked(MouseEvent me){
																System.out.println("Resize");
																 image1 = img.getImage().getScaledInstance(300,
																		 250, Image.SCALE_SMOOTH);
														  		 newImg1 = new ImageIcon(image1);
														  		
														  		
														  		     bi = new BufferedImage(
														  			newImg1.getIconWidth(),
														  			newImg1.getIconHeight(),
														  			BufferedImage.TYPE_INT_RGB);
														  			 g = bi.createGraphics();
														  			// paint the Icon to the BufferedImage.
														  			newImg1.paintIcon(null, g, 0,0);
														  			g.dispose();
														  			
														  			jlNew = new JLabel(new ImageIcon(bi));
														  			jf.remove(jlOld);
														  			jf.add(jlNew);
														  			
															}
														});
													
												jpOptions.add(jbEdit);	
												jpOptions.add(jbCrop);
												jpOptions.add(jbRotate);
												jpOptions.add(jbResize);
												jpOptions.add(jbMirror);
												jpOptions.add(jbDelete);
											jf.add(jpOptions, BorderLayout.NORTH);
									  		
									  		jf.setVisible(true);
								        }
								      });
								jpImageGrid.add(jlImage);
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
			
			CommandHandler ch = new CommandHandler(jf, jbEdit, jbCrop, jbDelete, jbMirror, jbResize, jbRotate, jmiSave, jpOptions, newImg1,bi);
			/*CommandHandler ch = new CommandHandler(jbEdit, jbCrop, jbDelete, jbMirror, jbResize, jbRotate);
			*/
			jbEdit.addActionListener(ch);
			jbCrop.addActionListener(ch);
			jbDelete.addActionListener(ch);
			jbMirror.addActionListener(ch);
			//jbResize.addActionListener(this);
			//jbRotate.addActionListener(ch);
			jbRotate.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					Integer[] options = {45,
			                90,
			                180};
					int n = JOptionPane.showOptionDialog(null,
					"How many degrees would you like to rotate the image?",
					"Rotate",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]);
					
					System.out.println("Choice: " +options[n]);
					
					double deg = (double) options[n];
					double radians = deg * Math.PI / 180;
					
					System.out.println("Image width: " +bi.getWidth() +"\tImage height: " +bi.getHeight());
					
					AffineTransform at = AffineTransform.getRotateInstance(radians, bi.getWidth()/2, bi.getHeight()/2);
					
					//AffineTransform at = new AffineTransform();
					at.rotate(radians, bi.getWidth()/2, bi.getHeight()/2);
					AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
					ato.filter(bi,null);
					
					 BufferedImage newImage = new BufferedImage(bi.getWidth(), bi.getHeight(),BufferedImage.TYPE_INT_ARGB);
				      Graphics2D g = newImage.createGraphics();
				      g.transform(at);
				      g.drawImage(bi, 0, 0, null);
				      g.dispose();
				}
			});
			jmiSave.addActionListener(ch);
		
		
		// JFrame configuration
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}

}

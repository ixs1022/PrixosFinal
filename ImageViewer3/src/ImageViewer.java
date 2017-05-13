import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	// attributes
	private static final long serialVersionUID = 1L;
	public static File dir;
	private JMenuItem jmiSave;
	private JMenuItem jmiSaveAs;
	private JMenuItem jmiClose;
	private JMenuItem jmiUndo;
	private JMenuItem jmiRedo;
	
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
		
		
		
	    
	    //TESTING THE CODE FOR ITERATING THORUGH A FOLDER
	    
	    JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("choosertitle");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			dir = new File("" + chooser.getSelectedFile());
		} else {
			System.out.println("No Selection Closing the program!");
			System.exit(0);
		}
		
		
		File[] directoryListing = dir.listFiles();
		
		//creating of array list
		ArrayList<ImageIcon> alImages = new ArrayList<ImageIcon>();
		
		if (dir.isDirectory()) { 
            for(File f : directoryListing) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    alImages.add(new ImageIcon(chooser.getSelectedFile() + "/" + f.getName()));

                } catch (final IOException e) {
                    // handle errors here
                }
            }// end of for
            
        }
		
		
		//END OF CODE TESTING
		
		JPanel jpImages = new JPanel(new CardLayout());
		
				
			/*
			 * calculate number of cards needed to display all images	
			 */
			int numCards;
			if(alImages.size() % 4 == 0){
				numCards = alImages.size()/4;
			}
			else{
				numCards = alImages.size()/4 + 1;
			}
			
			/*
			 * add images to JFrame in 2x2 grid
			 */
			ArrayList<JPanel> alCards = new ArrayList<JPanel>();
			int k = alImages.size() -1;
			int x = 0;
			while(x < k){
				for(int i = 1; i <= numCards; i++)
				{
					JPanel jpImageGrid = new JPanel(new GridLayout(0,2,20,20));
						for(int j=0; j < 4; j++){
							if(x < k){
								ImageIcon img = alImages.get(x);
								java.awt.Image image = img.getImage();
								java.awt.Image newImage = image.getScaledInstance(333, 250, java.awt.Image.SCALE_SMOOTH);
								ImageIcon newImg = new ImageIcon(newImage);
								JLabel jlImage = new JLabel(newImg);
								
								//ACTION LISTENER FOR A NEW IMAGE THAT IS ADDED
								
								jlImage.addMouseListener(new MouseAdapter() {
									
									
								      public void mouseClicked(MouseEvent me) {
								          System.out.println("CLICKED");
								          
								          String fileName = "" + img;
								          
								          File f = new File(fileName);
								          CustomImage madeImage = new CustomImage(f);
						
								          DisplayFrame df = new DisplayFrame(madeImage);

								          madeImage.setImageIcon(img);
								          df.showFrame(madeImage);
								          
								        
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
		
		/*
		 * buttons (next and prev) for flipping through cards of images
		 */
		JPanel jpButtons = new JPanel();
			JButton jbPrev = new JButton("Previous");
				jbPrev.setEnabled(false);
			JButton jbNext = new JButton("Next");
			jpButtons.add(jbPrev);
			jpButtons.add(jbNext);
		add(jpButtons, BorderLayout.SOUTH);
		
			/*
			 * action listener for next and prev buttons
			 * set enabled false if on first page for prev button
			 * or last page for next button
			 */
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
		
		// display JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
import java.awt.*;
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
		setSize(850, 600);
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
		JPanel jpOptions = new JPanel();
			jbEdit = new JButton("Edit");
			jbDelete = new JButton("Delete");
			jpOptions.add(jbEdit);
				jbCrop = new JButton("Crop");
				jbCrop.setVisible(false);
				jbRotate = new JButton("Rotate");
				jbRotate.setVisible(false);
				jbResize = new JButton("Resize");
				jbResize.setVisible(false);
				jbMirror = new JButton("Mirror");
				jbMirror.setVisible(false);
			jpOptions.add(jbCrop);
			jpOptions.add(jbRotate);
			jpOptions.add(jbResize);
			jpOptions.add(jbMirror);
			jpOptions.add(jbDelete);
		add(jpOptions);
			
		// Panel -- Card Layout
		JPanel jpCards = new JPanel(new CardLayout());
			// Card #1 - Albums
			JPanel jpAlbums = new JPanel();
				JPanel jpAlbumList = new JPanel();
					jbNew = new JButton("New Album");
					jbOpen = new JButton("Open Album");
				jpAlbumList.add(jbNew);
			jpAlbums.add(jpAlbumList, BorderLayout.WEST);
		jpCards.add(jpAlbums);
		
			// Card #2 - Image
			
			
			
			
		add(jpCards, BorderLayout.CENTER);
		
		// JFrame configuration
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}

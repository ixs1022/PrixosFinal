import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayFrame {
	
	
	private CustomImage image;
	private String imgHeight;
	private String imgWidth;
	private JFrame frame;
	
	private JButton jbUndo;
	private JButton jbRedo;
	
	CareTaker caretaker = new CareTaker();
	Originator originator = new Originator();
	int saved = 0, current = 0;
	
	//DEFAUTL CONSTRUCTOR
	
	public DisplayFrame(CustomImage image) {
		
		imgHeight = Integer.toString(image.getHeightImage());
		imgWidth = Integer.toString(image.getWidthImage());
		this.image = image;
	}
	
	
	//The most important method for displaying a new pop up frame

	

	public void showFrame(CustomImage i) {
		
		//Getting Original height and width

		 JLabel imageInfo = new JLabel("Original Image - Width: " + imgWidth + " " + " Height: " + imgHeight);
		
		// new frame to display images
		frame = new JFrame();
		JLabel label = new JLabel(i.getIcon());
		JScrollPane displayPane = new JScrollPane(label);
		
		frame.setSize(600, 600);
		frame.setLayout(new BorderLayout());
		frame.add(displayPane, BorderLayout.CENTER);
		frame.add(imageInfo, BorderLayout.NORTH);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,1));
		JPanel jpTransformers = new JPanel();
		JButton resizeButton = new JButton("Resize");
		JButton rotateButton = new JButton("Rotate");
		JButton flipButton = new JButton("Flip");
		JButton saveButton = new JButton("Save");
		
		JPanel jpMemento = new JPanel();
		 jbUndo = new JButton("Undo");
		 	//jbUndo.setEnabled(false);
		 jbRedo = new JButton ("Redo");
		 	//jbRedo.setEnabled(false);
		jpMemento.add(jbUndo);
		jpMemento.add(jbRedo);
		
		checkEnable();
		 
		jbUndo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(current >= 1){
					current--;
					CustomImage img = originator.restore(caretaker.getMemento(current));
					frame.setVisible(false);
					showFrame(img);
					
					System.out.println("Saved: " +saved+ "\tCurrent: " +current);
					System.out.println("Caretaker size: " +caretaker.getSize());
				}
			}
		});
		
		jbUndo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if((saved - 1) > current){
					current++;
					CustomImage img = originator.restore(caretaker.getMemento(current));
					frame.setVisible(false);
					showFrame(img);
					
					System.out.println("Saved: " +saved+ "\tCurrent: " +current);
					System.out.println("Caretaker size: " +caretaker.getSize());
				}
			}
		});
		
		
	
		resizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {

				/*String w = JOptionPane.showInputDialog(frame, "Enter Width!", null);
				String h = JOptionPane.showInputDialog(frame, "Enter Height!", null);

				try {
					ImageEditor editor = new ImageEditor(i);
					editor.resize(Integer.parseInt(w), Integer.parseInt(h));
					frame.setVisible(false);
					showFrame(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Error " + e.getMessage());

					JOptionPane.showMessageDialog(frame, "The input must be a number");
				}*/
				ResizeCommand rc = new ResizeCommand(frame, image);
				rc.execute();
				
			}
		});

		flipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				ImageEditor editor = new ImageEditor(i);
				editor.flip();
				
				//checkEnable();
				
				frame.setVisible(false);
				saveMemento();
				showFrame(i);
				/*FlipCommand fc = new FlipCommand(frame, image);
				fc.execute();*/
				
				
			}
		});
		
		//Adding actionListener for rotateButton
		rotateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				try {
					
					/*String deg = JOptionPane.showInputDialog(frame, "Rotating...", null);

					ImageEditor editor = new ImageEditor(i);
					editor.rotate(Double.parseDouble(deg));
					frame.setVisible(false);
					showFrame(i);
					*/
					RotateCommand rotc = new RotateCommand(frame, image);
					rotc.execute();
					saveMemento();
				} catch (Exception e) {
					//JOptionPane.showMessageDialog(frame, "The input must be a number");
					e.printStackTrace();
				}
			}
		});

		
		//Save works and renames the file to the same name + edited.
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				ImageEditor editor = new ImageEditor(i);
				editor.saveImage();
				/*SaveCommand sc = new SaveCommand(image);
				sc.execute();*/
			}
		});

		jpTransformers.add(resizeButton);
		jpTransformers.add(rotateButton);
		jpTransformers.add(flipButton);
		jpTransformers.add(saveButton);
		
		jpMemento.add(jbUndo);
		jpMemento.add(jbRedo);
		
		buttons.add(jpTransformers,BorderLayout.NORTH);
		buttons.add(jpMemento, BorderLayout.SOUTH);


		frame.add(buttons, BorderLayout.SOUTH);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Private method to check if redo and undo buttons should be enabled or disabled
	 * Called by saveMemento(i)
	 */
	private void checkEnable() {
		if(saved > 0 && current != 0){
			System.out.println("jbUndo.setEnabled(true)");
			jbUndo.setEnabled(true);
		}
		else{
			System.out.println("jbUndo.setEnabled(false)");
			jbUndo.setEnabled(false);
		}
		
		if(current != saved){
			System.out.println("jbRedo.setEnabled(true)");
			jbRedo.setEnabled(true);
		}
		else{
			System.out.println("jbRedo.setEnabled(false)");
			jbRedo.setEnabled(false);
		}	
	}
	
	/**
	 * Method to save memento each time action is performed on image
	 * @param i CustomImage
	 */
	public void saveMemento(){
		System.out.print("Save memento -- ");
		originator.set(image);
		caretaker.addMemento(originator.storeInMemento());
		saved++;
		current++;
		System.out.println("Saved: " +saved+ "\tCurrent: " +current);
		System.out.println("Caretaker size: " +caretaker.getSize());
		
		checkEnable();
	}

}

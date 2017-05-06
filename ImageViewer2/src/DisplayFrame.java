import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		JFrame frame = new JFrame();
		JLabel label = new JLabel(i.getIcon());
		JScrollPane displayPane = new JScrollPane(label);
		
		frame.setSize(600, 600);
		frame.setLayout(new BorderLayout());
		frame.add(displayPane, BorderLayout.CENTER);
		frame.add(imageInfo, BorderLayout.NORTH);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton resizeButton = new JButton("Resize");
		JButton rotateButton = new JButton("Rotate");
		JButton flipButton = new JButton("Flip");
		JButton saveButton = new JButton("Save");
		
		
	
		resizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {

				String w = JOptionPane.showInputDialog(frame, "Enter Width!", null);
				String h = JOptionPane.showInputDialog(frame, "Enter Height!", null);

				try {
					ImageEditor editor = new ImageEditor(i);
					editor.resize(Integer.parseInt(w), Integer.parseInt(h));
					frame.setVisible(false);
					showFrame(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Error " + e.getMessage());

					JOptionPane.showMessageDialog(frame, "The input must be a number");
				}
			}
		});

		flipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				ImageEditor editor = new ImageEditor(i);
				editor.flip();
				frame.setVisible(false);
				showFrame(i);
			}
		});
		
		//Adding actionListener for rotateButton
		rotateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				try {
					
					String deg = JOptionPane.showInputDialog(frame, "Rotating...", null);

					ImageEditor editor = new ImageEditor(i);
					editor.rotate(Double.parseDouble(deg));
					frame.setVisible(false);
					showFrame(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "The input must be a number");
				}
			}
		});

		
		//Save works and renames the file to the same name + edited.
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				ImageEditor editor = new ImageEditor(i);
				editor.saveImage();
			}
		});

		buttons.add(resizeButton);
		buttons.add(rotateButton);
		buttons.add(flipButton);
		buttons.add(saveButton);


		frame.add(buttons, BorderLayout.SOUTH);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

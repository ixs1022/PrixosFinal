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

	//DEFAUTL CONSTRUCTOR
	
	public DisplayFrame() {

	}
	
	
	//The most important method for displaying a new pop up frame

	public void showFrame(CustomImage i) {
		// new frame to display images
		JFrame frame = new JFrame();
		JLabel label = new JLabel(i.getIcon());
		JScrollPane displayPane = new JScrollPane(label);

		frame.setSize(600, 600);
		frame.setLayout(new BorderLayout());
		frame.add(displayPane, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton resize = new JButton("Resize");
		JButton rotate = new JButton("Rotate");
		JButton flip = new JButton("Flip");
		JButton save = new JButton("Save");

		resize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {

				String w = JOptionPane.showInputDialog(frame, "WIDTH?", null);
				String h = JOptionPane.showInputDialog(frame, "HEIGHT", null);

				try {
					ImageEditor editor = new ImageEditor(i);
					editor.resize(Integer.parseInt(w), Integer.parseInt(h));
					frame.setVisible(false);
					showFrame(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());

					JOptionPane.showMessageDialog(frame, "Only numbers please!");
				}
			}
		});

		flip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				ImageEditor editor = new ImageEditor(i);
				editor.flip();
				frame.setVisible(false);
				showFrame(i);
			}
		});

		rotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				try {
					System.out.println("DisplayFrame - rotate actionlistener");
					String deg = JOptionPane.showInputDialog(frame, "Rotate numbers yo", null);

					ImageEditor editor = new ImageEditor(i);
					editor.rotate(Double.parseDouble(deg));
					frame.setVisible(false);
					showFrame(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Only numbers please!");
				}
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				ImageEditor editor = new ImageEditor(i);
				editor.saveImage();
			}
		});

		buttons.add(resize);
		buttons.add(rotate);
		buttons.add(flip);
		buttons.add(save);

		frame.add(buttons, BorderLayout.SOUTH);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

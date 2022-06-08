package databasevisualtool;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ImageArray implements MouseListener, ImageObserver {

	BufferedImage[] allImages;

	public ImageArray(String set, int n) {
		File path = new File("res/mnist_png/" + set + "/" + n);
		File[] allFiles = path.listFiles();

		JButton test;
		JButton train;

		allImages = new BufferedImage[allFiles.length];

		JFrame window = new JFrame();
		JPanel panel = new JPanel();
		JScrollPane jScrollPane = new JScrollPane(panel);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(150, 1, 1, 1)); // training
		// panel.setLayout(new GridLayout(25,1,1,1)); //testing

		JLabel label[] = new JLabel[allFiles.length];

		for (int i = 0; i < allFiles.length; i++) {
			try {
				allImages[i] = ImageIO.read(allFiles[i]);
				label[i] = new JLabel();
				ImageIcon icon = new ImageIcon(allImages[i]);
				label[i].setIcon(icon);
				label[i].setOpaque(true);

				label[i].addMouseListener(this);
				// window.add(label[i]);
				panel.add(label[i]);
			} catch (IOException e) {

			}
		}
		// window.pack();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		window.getContentPane().add(jScrollPane);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		JLabel lbl = (JLabel) e.getSource();
		Icon icon = lbl.getIcon();

		ImageIcon myImage = (ImageIcon) lbl.getIcon();
		Image img = myImage.getImage();

		BufferedImage bi = new BufferedImage(img.getWidth(this), img.getHeight(this), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		try {
			g.drawImage(img, 0, 0, null);
			ImageIO.write(bi, "png", new File("saved.png"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, "Your image has been saved!");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();
		Icon icon = lbl.getIcon();

		ImageIcon myImage = (ImageIcon) lbl.getIcon();
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(lbl.getWidth() + 100, lbl.getHeight() + 100, Image.SCALE_SMOOTH);
		lbl.setIcon(new ImageIcon(newImg));
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
package databasevisualtool;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

	JButton training;
	JButton testing;
	JPopupMenu trainingMenu = new JPopupMenu("Training Menu");
	JPopupMenu testingMenu = new JPopupMenu("Testing Menu");

	private String lastClickedCategory;
	

	MyFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		training = new JButton("Training");
		training.addActionListener(this);
		testing = new JButton("Testing");
		testing.addActionListener(this);


		JMenuItem menuItem;
		for(int i = 0; i <= 9; i++) {
			menuItem = new JMenuItem(String.valueOf(i));
			menuItem.addActionListener(this);
			trainingMenu.add(menuItem);

			menuItem = new JMenuItem(String.valueOf(i));
			menuItem.addActionListener(this);
			testingMenu.add(menuItem);
		}

		training.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                trainingMenu.show(training, training.getWidth()/2, training.getHeight()/2);
            }
		});

		testing.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                testingMenu.show(testing, testing.getWidth()/2, testing.getHeight()/2);
            }
		});

		this.add(training);
		this.add(testing);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand() == "Training" || actionEvent.getActionCommand() == "Testing") {
			lastClickedCategory = actionEvent.getActionCommand();
		} else {
			ImageArray ig = new ImageArray(lastClickedCategory, Integer.parseInt(actionEvent.getActionCommand()));
		}

	}
}

// Java Program to create a toolbar and add action listener to its components .
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
public class Tool extends JFrame implements ActionListener, ItemListener {
	// toolbar
	static JToolBar tb;
	Scanner scn = new Scanner(System.in);
	System.out.print("Enter a number : ");
	int s = snc.ni

	// buttons
	static JButton b1, b2;

	// create a frame
	static JFrame f;

	// create a combo box
	static JComboBox x;

	// create a label
	static JLabel l, l1;

	public static void main(String[] args)
	{
		// create a object of class
		Tool to = new Tool();

		// create a label
		l = new JLabel("nothing selected");
		l1 = new JLabel("nothing selected");

		// create a frame
		f = new JFrame("Toolbar demo");

		// set layout for frame
		f.setLayout(new BorderLayout());

		// create a toolbar
		tb = new JToolBar();

		// create a panel
		JPanel p = new JPanel();

		// create a combobox
		x = new JComboBox(new String[] { "Nilendra", "item 2", "item 3" });

		// add actionListener
		x.addItemListener(to);

		// create new buttons
		b1 = new JButton("button 1");
		b2 = new JButton("button 2");

		// add ActionListener to it
		b1.addActionListener(to);
		b2.addActionListener(to);

		// add buttons
		p.add(b1);
		p.add(b2);

		// add menu to menu bar
		p.add(x);

		tb.add(p);

		// create a panel
		JPanel p1 = new JPanel();

		p1.add(l);
		p1.add(l1);

		// add toolbar to frame
		f.add(tb, BorderLayout.NORTH);
		f.add(p1, BorderLayout.CENTER);

		// set the size of the frame
		f.setSize(500, 500);
		f.setVisible(true);
	}

	// if button is pressed
	public void actionPerformed(ActionEvent e)
	{
		l.setText(e.getActionCommand() + " selected.");
	}

	// if combo box is selected
	public void itemStateChanged(ItemEvent e)
	{
		l1.setText(x.getSelectedItem() + " selected.");
	}
}

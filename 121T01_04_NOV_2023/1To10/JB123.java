// Using an array of JTextField to teach 123

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Teach123 extends JFrame implements ActionListener
{
	private final JButton [] buttonArray;
	private final String [] numberArray = {"One", "Two", "Three", "Four", "Five", "Six",
																	"Seven", "Eight", "Nine", "Ten"};
	
	public Teach123()
	{
		super ("Teach123");
		setLayout(new GridLayout(3, 4));
		
		//Construct the array
		buttonArray = new JButton [numberArray.length];
		//Initialize the array
		for (int i = 0; i < buttonArray.length; i++)
		{
			buttonArray[i] = new JButton();
			String imageFile = "" + (i + 1) + ".jpg";
			Icon ic = new ImageIcon (imageFile);
			buttonArray[i].setIcon (ic);
		}
		
		//Add the button array to the JFrame
		for (JButton jb : buttonArray)
		{
			add (jb);
		}
		
		//Register the event
		for (JButton jb : buttonArray)
		{
			jb.addActionListener (this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < buttonArray.length; i++)
		{
			if (e.getSource () == buttonArray[i])
			{
				String s = "I am " + numberArray[i];
				Icon ic = buttonArray[i].getIcon ();
				JOptionPane.showMessageDialog (null, s, "teach123", JOptionPane.PLAIN_MESSAGE, ic);
				buttonArray[i].setText (numberArray[i]);
			}
		}	
	}
}

class JB123
{
	public static void main (String [ ] args)
	{
		Teach123 t123 = new Teach123();
		t123.setSize(200, 300);
		t123.setVisible(true);
		t123.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

// The use of JOptionPane to interact with the use
//
// File name: JOP_1.java
//
// Read an exam mark and display its grade in the message dialog box

import javax.swing.JOptionPane;

class JOP_1
{
	public static void main (String [ ] args)
	{
		int exam;
		
		String s = JOptionPane.showInputDialog ("Enter an exam mark");
		exam = Integer.parseInt (s);
		
		if (exam >= 85)
			s = "Not bad!! You got an HD";
		else if (exam >= 75)
			s = "You are a Distinction";
		else if (exam >= 65)
			s = "You got only a Credit";
		else if (exam >= 50)
			s = "You passed the subject";
		else
			s = "Though you fail, work hard in future";
		
		// Display in a message dialog box
		JOptionPane.showMessageDialog (null, s, "Exam Analysis", 
																	JOptionPane.INFORMATION_MESSAGE);
	}
}
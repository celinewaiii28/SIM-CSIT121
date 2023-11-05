// The use of JOptionPane to interact with the use
//
// File name: JOP_2.java
//
// Read an exam mark and display its grade in the message dialog box

import javax.swing.JOptionPane;

class JOP_2
{
	public static void main (String [ ] args)
	{
		int exam;
			
		try
		{
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
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog (null, "Wrong information entered",
																				"Error message",
																				JOptionPane.WARNING_MESSAGE);
		}
		finally
		{
			JOptionPane.showMessageDialog (null, "If you keep quiet, I will give you more hints",
																				"I just said that ... ",
																				JOptionPane.ERROR_MESSAGE);
		}
	}
}
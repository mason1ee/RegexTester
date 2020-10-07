import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Program deployed dated 14th August 2019
 * © 2019 Mason Lee All Rights Reserved
 * Images used subjected to Owner's Copyright
 * 18034543, Aug 14, 2019 19:01:23 PM
 */

/**
 * @author 18034543
 *
 */
public class RegexT {

	/**
	 * @param args
	 */
	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel();
	private JLabel labelRegexE = new JLabel();
	private JLabel labelTestS = new JLabel();
	private JLabel labelOutput = new JLabel();
	private JLabel display = new JLabel();
	private JLabel credits = new JLabel();
	private JTextField textfieldRegexE = new JTextField();
	private JTextField textfieldTestS = new JTextField();
	private JButton buttonT = new JButton();
	private JButton buttonC = new JButton();
	private ImageIcon imgC = new ImageIcon(getClass().getClassLoader().getResource("correct.jpg"));
	private ImageIcon imgW = new ImageIcon(getClass().getClassLoader().getResource("wrong.jpg"));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegexT();

	}public RegexT() {
		textfieldRegexE.setColumns(26);
		textfieldTestS.setColumns(26);
		contentPane.add(labelRegexE);
		contentPane.add(textfieldRegexE);
		contentPane.add(labelTestS);
		contentPane.add(textfieldTestS);
		contentPane.add(buttonT);
		contentPane.add(buttonC);
		contentPane.add(labelOutput);
		contentPane.add(display);
		contentPane.add(credits);
		
		display.setVisible(false);
		labelRegexE.setText("Enter Regex:");
		labelTestS.setText("Enter test string:");
		credits.setForeground(Color.BLACK);
		credits.setText("© 2019 Mason Lee All Rights Reserved");
		buttonT.setText("Test");
		buttonC.setText("Clear");
		
		ActionListener handlecalculate = (ActionEvent e) -> doCheckRegex(e);
		buttonT.addActionListener(handlecalculate);
		
		ActionListener handleclear = (ActionEvent e) -> doClear(e);
		buttonC.addActionListener(handleclear);
		
		frame.setContentPane(contentPane);
		frame.setTitle("REGEX TESTER v1.12");
		frame.setSize(310,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void doCheckRegex(ActionEvent e) {
		String pattern = textfieldRegexE.getText();
		String test = textfieldTestS.getText();
		
		try {
			if(textfieldRegexE.getText().isEmpty() || textfieldTestS.getText().isEmpty()) {
				labelOutput.setForeground(Color.red);
				labelOutput.setText("Enter something...");
			}else if(Pattern.matches(pattern,test)) {
				labelOutput.setText("Regex CORRECT");
				display.setIcon(imgC);
				display.setHorizontalAlignment(JLabel.CENTER);
				display.setVisible(true);
			}else {
				labelOutput.setText("Regex INCORRECT");
				display.setIcon(imgW);
				display.setHorizontalAlignment(JLabel.CENTER);
				display.setVisible(true);
			}
		}catch(PatternSyntaxException pe) {
			labelOutput.setText("Illegal Regex");
			display.setVisible(false);
		}
	}
	public void doClear(ActionEvent e) {
		textfieldRegexE.setText("");
		textfieldTestS.setText("");
		labelOutput.setText("");
		display.setVisible(false);
	}

}

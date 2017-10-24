package yoyo;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Normalizer extends JFrame {
	private JTextField txtName;
	private JTextField txtRawScore;
	
	
	public Normalizer() {
		
		
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(400,400);
		
		JLabel lblNormalizer = new JLabel("Normalizer");
		lblNormalizer.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		lblNormalizer.setBounds(104, 6, 215, 32);
		getContentPane().add(lblNormalizer);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setBounds(6, 50, 130, 26);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtRawScore = new JTextField();
		txtRawScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtRawScore.setText("Raw Score");
		txtRawScore.setBounds(148, 50, 130, 26);
		getContentPane().add(txtRawScore);
		txtRawScore.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				double rawScore = Double.parseDouble(txtRawScore.getText());
				NormalizerConstructor nc = new NormalizerConstructor(name, rawScore);
				
				txtName.setText("Entered");
				txtRawScore.setText("Entered");
			}
		});
		btnEnter.setBounds(277, 50, 117, 29);
		getContentPane().add(btnEnter);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(104, 130, 185, 193);
		getContentPane().add(textArea);
		textArea.setVisible(true);
		
		
		JButton btnShowFinalScores = new JButton("Show Final Scores");
		btnShowFinalScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NormalizerConstructor.finalScoreReturn();
				ArrayList al = NormalizerConstructor.scoreNormalizer();
				
				for (int i=0;i<al.size();i++)
				{
					textArea.append(((NormalizerConstructor) al.get(i)).getName() + " - " + ((NormalizerConstructor) al.get(i)).getScore() + '\n');
					
				}
				
			}
		});
		btnShowFinalScores.setBounds(104, 89, 185, 29);
		getContentPane().add(btnShowFinalScores);
		
		
		
		
	}
	
	
	public static void main(String[] args)
	{
		Normalizer n = new Normalizer();
		
	}
}

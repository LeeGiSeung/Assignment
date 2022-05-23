package week12;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("콘텐츠 페인과 j프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancle"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
	}
}

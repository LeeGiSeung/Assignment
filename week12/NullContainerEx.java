package week12;

import javax.swing.*;
import java.awt.*;

public class NullContainerEx extends JFrame{
	public NullContainerEx() {
		setTitle("널콘테이터ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(null);
		
		JLabel la = new JLabel("Hello, 안녕이기승");
		la.setLocation(130, 50);
		la.setSize(200,20);
		c.add(la);
		
		for(int i=1; i<=9; i++) {
			JButton j = new JButton(Integer.toString(i));
			j.setLocation(i*15, i*15);
			j.setSize(50,20);
			c.add(j);
		}
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullContainerEx();
	}
}

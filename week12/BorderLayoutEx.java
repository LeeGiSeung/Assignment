package week12;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame{
	public BorderLayoutEx() {
		setTitle("보더레이아웃");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30,20));
		
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("div"), BorderLayout.WEST);
		c.add(new JButton("div"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.SOUTH);
		setSize(300,200);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}

}

package week12;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		setTitle("플로우레이아웃");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.setBackground(Color.blue);
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx();
	}
}

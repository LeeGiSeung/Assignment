package week12;

import javax.swing.*;
import java.awt.*;
public class CheckBoxEx extends JFrame {
	public CheckBoxEx() {
setTitle("üũ�ڽ� ����� ����");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Container c = getContentPane();
c.setLayout(new FlowLayout());
ImageIcon cherryIcon = new ImageIcon("src/week12/cherry.jpg");
ImageIcon selectedCherryIcon = new ImageIcon(
"src/week12/selectedCherry.jpg");
JCheckBox apple = new JCheckBox("���");
JCheckBox pear = new JCheckBox("��", true);
JCheckBox cherry = new JCheckBox("ü��", cherryIcon);
cherry.setBorderPainted(true);
cherry.setSelectedIcon(selectedCherryIcon);
c.add(apple);
c.add(pear);
c.add(cherry);
setSize(250,150);
setVisible(true);
}
public static void main(String [] args) {
new CheckBoxEx();
}
}
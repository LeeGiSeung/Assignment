package week12;

import javax.swing.*;
import java.awt.*;
public class LabelEx extends JFrame {
public LabelEx() {
setTitle("레이블 예제");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Container c = getContentPane();
c.setLayout(new FlowLayout());
JLabel textLabel = new JLabel("사랑합니다.");
ImageIcon beauty = new ImageIcon("src/week12/beauty.jpg");
JLabel imageLabel = new JLabel(beauty);
ImageIcon normalIcon = new ImageIcon("src/week12/normalIcon.gif");
JLabel label = new JLabel("보고싶으면 전화하세요",
normalIcon, SwingConstants.CENTER);
c.add(textLabel);
c.add(imageLabel);
c.add(label);
setSize(400,600);
setVisible(true);
}
public static void main(String [] args) {
new LabelEx();
}
}

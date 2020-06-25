

import java.awt.GridLayout;
import javax.swing.JFrame;


//主函数类，分别调用左右两视图
public class UI extends JFrame {

	
	Time panel2 = new Time();

	
	
	public UI() {
		
		
		setLayout(new GridLayout(1, 2, 20, 20));
		setTitle("倒计时");
		setSize(600, 400);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(false);
		
		//add(panel1);
		add(panel2);

	}
	

}

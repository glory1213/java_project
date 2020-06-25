import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();				
			}
		});

	};

	public static void createGUI() {

		MainFrame frame = new MainFrame("番茄钟");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.setSize(600, 400);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {//设置监听器通过增加弹窗控制窗口关闭
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				if(Time.flag == 0) {
					int value=JOptionPane.showConfirmDialog(null, "确定要关闭吗？\n每日任务未完成","提示", JOptionPane.YES_NO_OPTION);
					if (value==JOptionPane.OK_OPTION) {
						System.exit(0);
					}
					else {
						frame.setVisible(true);
					}
				}
				else {
					int value=JOptionPane.showConfirmDialog(null, "确定要关闭吗？\n每日任务已完成！","提示", JOptionPane.YES_NO_OPTION);
					if (value==JOptionPane.OK_OPTION) {
						System.exit(0);
					}
					else {
						frame.setVisible(true);
					}
				
				}
		
			}
		});
		
	}
}

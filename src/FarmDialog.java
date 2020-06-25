import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FarmDialog extends JDialog {

    public FarmDialog() {
        setTitle("专注“农场”");
        setLayout(null);
        //Container c = getContentPane();
        setBounds(400,200,700,400);
        getContentPane().setBackground(new Color(213,255,186));
        Container c = getContentPane();
        JPanel p1 = new JPanel(new GridLayout(4,6,10,10));
        p1.setBounds(45,115,600,200);
        p1.setBackground(new Color(213,255,186));

        int num = Time.total_sec/3600;  //小鸡数量

        String num1 = num + "";
        JLabel jl1 = new JLabel("您今天专注了"+ num1 +"个小时");
        jl1.setBounds(245,15,200,50);
        jl1.setFont(new Font("微软雅黑",Font.BOLD,20));

        JLabel jl2 = new JLabel("共拯救了" + num1 + "个小鸡");
        jl2.setBounds(245,45,200,50);
        jl2.setFont(new Font("微软雅黑",Font.BOLD,20));

        for(int i = 1; i <= num; i++) {
            JLabel jl = new JLabel();
            URL url = getClass().getResource("/Icon/Chicken.png");
            Icon icon = new ImageIcon(url);
            jl.setIcon(icon);
            //c.add(jl);
            p1.add(jl);
        }

        c.add(p1);
        c.add(jl1);
        c.add(jl2);


        setVisible(true);
    }

    /*public void addChicken(int num) {
        for(int i = 1; i < num; i++) {
            JLabel jl = new JLabel("/Icon/Chicken.png");
        }
    }*/
}

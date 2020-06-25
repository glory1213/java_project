import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

import java.io.*;

	 public class Remarks {
	        private JFrame frame = null;
	 
	        private JTable table = null;
	 
	        private Table_Model model = null;
	 
	        private JScrollPane s_pan = null;
	 
	        private JButton button_1 = null, button_2 = null, button_3 = null;
	 
	        private JPanel pane = null;
	        
	        private int num = 1;
	 
	        public Remarks() {

	            frame = new JFrame("备注和心路历程");
	            pane = new JPanel();
	            button_1 = new JButton("清除数据");
	            button_1.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    removeData();
	                }
	            });
	            button_2 = new JButton("添加数据");
	            button_2.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    addData();
	                }
	            });
	            button_3 = new JButton("保存数据");
	            button_3.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    try{
	                    	saveData();
	                    }catch(IOException a) {
	                    	System.out.println("exception!");
	                    }
	                }
	            });
	            pane.add(button_1);
	            pane.add(button_2);
	            pane.add(button_3);
	            model = new Table_Model(20);
	            table = new JTable(model);
	            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//用于避免同时删除多行时，报错
        	    table.getTableHeader().setReorderingAllowed(false);//同上
	            table.setBackground(Color.white);
	            TableColumnModel tcm = table.getColumnModel();
	            table.getRowHeight(800);
	            tcm.getColumn(0).setPreferredWidth(20);
	            tcm.getColumn(1).setPreferredWidth(200);


	            s_pan = new JScrollPane(table);
	 
	            frame.getContentPane().add(s_pan, BorderLayout.CENTER);
	            frame.getContentPane().add(pane, BorderLayout.NORTH);
	            //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            frame.setSize(600, 400);
	            frame.setVisible(false);
	            
	 
	        }
	        
	        void setVisible(boolean b) {
	        	this.frame.setVisible(b);
	        }
	 
	        private void addData() {
	            model.addRow(num++,"");
	            table.updateUI();
	        }
	 
	        private void removeData() {
	            int count[]=table.getSelectedRows();
	            if (count.length<=0||table.getRowCount()==0) {
	            	   return;
	            	  }else {
	            	   for (int i = count.length; i > 0; i--) {
	            	    model.removeRow(table.getSelectedRow());
	            	    table.clearSelection();//这行不加会在删除最后一行之后，再删除，就会有bug
	            	   }
	            	  }
	            table.updateUI();
	        
	        }
	 
	        private void saveData()  throws IOException {
	       
	        	 int col = model.getColumnCount();
		         int row = model.getRowCount();
		        
	        	 File f = new File("备注.txt");
	             FileOutputStream fop = new FileOutputStream(f);
	             OutputStreamWriter writer = new OutputStreamWriter(fop, "gbk");
	            for (int i = 0; i < col; i++) {
	            	writer.append(model.getColumnName(i) + "\t");
	            }
	            writer.append("\r\n");
	            for (int i = 0; i < row; i++) {
	                for (int j = 0; j < col; j++) {
	                	writer.append(model.getValueAt(i, j) + "\t");
	                }
	                writer.append("\r\n");
	            }
	            writer.append("------------------------------------");
	            writer.close();
	            fop.close();
	            FileInputStream fip = new FileInputStream(f);
	            // 构建FileInputStream对象
	     
	            InputStreamReader reader = new InputStreamReader(fip, "gbk");
	            // 构建InputStreamReader对象,编码与写入相同
	     
	            StringBuffer sb = new StringBuffer();
	            while (reader.ready()) {
	                sb.append((char) reader.read());
	                // 转成char加到StringBuffer对象中
	            }
//	            System.out.println(sb.toString());在控制台显示
	            reader.close();
	            // 关闭读取流
	     
	            fip.close();
	            // 关闭输入流,释放系统资源
	        }
	 
	      
	    class Table_Model extends AbstractTableModel {
	 
	        private static final long serialVersionUID = -7495940408592595397L;
	 
	        private Vector content = null;
	 
	        private String[] title_name = { "序号","备注" };
	 
	        public Table_Model() {
	            content = new Vector();
	        }
	 
	        public Table_Model(int count) {
	            content = new Vector(count);
	        }
	 
	        public void addRow(int num,String name) {
	        	

	            Vector v = new Vector(3);            
	            v.add(0, num);
	            v.add(1, name);
	            content.add(v);

	        }
	 
	        public void removeRow(int row) {
	            content.remove(row);
	        }
	 
//	        public void removeRows(int row, int count) {
//	            for (int i = 0; i < count; i++) {
//	                if (content.size() > row) {
//	                    content.remove(row);
//	                }
//	            }
//	        }
	 
	     
	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            if (columnIndex == 0) {
	                return false;
	            }
	            return true;
	        }
	 
	      
	        public void setValueAt(Object value, int row, int col) {
	            ((Vector) content.get(row)).remove(col);
	            ((Vector) content.get(row)).add(col, value);
	            this.fireTableCellUpdated(row, col);
	        }
	 
	        public String getColumnName(int col) {
	            return title_name[col];
	        }
	 
	        public int getColumnCount() {
	            return title_name.length;
	        }
	 
	        public int getRowCount() {
	            return content.size();
	        }
	 
	        public Object getValueAt(int row, int col) {
	            return ((Vector) content.get(row)).get(col);
	        }
	 
	     
	        public Class getColumnClass(int col) {
	            return getValueAt(0, col).getClass();
	        }
	 


	    }}

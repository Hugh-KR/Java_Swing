package search2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import search.UserDefaultJTableDAO;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Membergui2 {
	private static JTextField t1;
	private static MemberDAO dao = new MemberDAO();
	private static JComboBox combo;
	private static JScrollPane jsp;
	private static JTable jt;
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		String[] name = { "학번", "이름", "성별", "전화번호","이메일"};
		DefaultTableModel dt = new DefaultTableModel(name,0);
		
		
		
		f.getContentPane().setLayout(null);
	    String[] comboName = { "  ALL  ", "  s_id  ", " s_name ", " s_gender "," s_tel "," s_email " };
		
		
		combo = new JComboBox(comboName);
		combo.setBounds(42, 41, 97, 23);
		f.getContentPane().add(combo);
		
		jsp = new JScrollPane();
		jsp.setBounds(38, 74, 500, 453);
		f.getContentPane().add(jsp);
		
		jt = new JTable(dt);
		jsp.setColumnHeaderView(jt);
		t1 = new JTextField();
		t1.setBounds(151, 42, 278, 22);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		
		dao.userSelectAll(dt);
		if (dt.getRowCount() > 0)
	         jt.setRowSelectionInterval(0, 0);
		
		f.setSize(600, 700);

	  
		
		
		
		JButton search = new JButton("조회");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == search) {
					String fieldName = combo.getSelectedItem().toString();
					System.out.println("필드명 " + fieldName);
					if(fieldName.trim().equals("ALL")) {
						dao.userSelectAll(dt);
						if (dt.getRowCount() >0)
							jt.setRowSelectionInterval(0, 0);	
					}else {
						if(t1.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(null, "검색단어를 입력해주세요");
							t1.requestFocus();						
						}else { // 검색어를 입력했을경우
							dao.getUserSearch(dt, fieldName, t1.getText());
							if(dt.getRowCount() >0)
								jt.setRowSelectionInterval(0, 0);
						}
					}

					
				}
				
					
			}
		});
		search.setBounds(441, 41, 97, 23);
		f.getContentPane().add(search);
		
	
		f.setVisible(true);
		
	}
}

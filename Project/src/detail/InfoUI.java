package detail;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.MenuJTabaleExam;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoUI {
	private static JTextField textId;
	private static JTextField textName;
	private static JTextField textGrade;
	private static JTextField textState;
	private static JTextField textCollege;
	private static JTextField textMajor;
	private static JTextField textYear;

	public InfoUI(MenuJTabaleExam me) {
		JFrame f = new JFrame();
		f.setSize(635, 345);
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel.setBounds(44, 36, 59, 29);
		f.getContentPane().add(lblNewLabel);

		textId = new JTextField();
		textId.setBounds(126, 36, 160, 29);
		f.getContentPane().add(textId);
		textId.setColumns(10);
		textId.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(324, 36, 59, 29);
		f.getContentPane().add(lblNewLabel_1);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(402, 36, 160, 29);
		f.getContentPane().add(textName);
		textName.setEditable(false);

		JLabel lblNewLabel_2 = new JLabel("학년");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(44, 90, 59, 29);
		f.getContentPane().add(lblNewLabel_2);

		textGrade = new JTextField();
		textGrade.setColumns(10);
		textGrade.setBounds(126, 90, 160, 29);
		f.getContentPane().add(textGrade);

		JLabel lblNewLabel_3 = new JLabel("학적상태");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_3.setBounds(324, 89, 59, 29);
		f.getContentPane().add(lblNewLabel_3);

		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(402, 89, 160, 29);
		f.getContentPane().add(textState);

		JLabel lblNewLabel_4 = new JLabel("대학");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_4.setBounds(44, 141, 59, 29);
		f.getContentPane().add(lblNewLabel_4);

		textCollege = new JTextField();
		textCollege.setColumns(10);
		textCollege.setBounds(126, 141, 160, 29);
		f.getContentPane().add(textCollege);

		JLabel lblNewLabel_5 = new JLabel("학과");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_5.setBounds(324, 141, 59, 29);
		f.getContentPane().add(lblNewLabel_5);

		textMajor = new JTextField();
		textMajor.setColumns(10);
		textMajor.setBounds(402, 141, 160, 29);
		f.getContentPane().add(textMajor);

		JLabel lblNewLabel_4_1 = new JLabel("졸업예정년도");
		lblNewLabel_4_1.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(33, 193, 97, 29);
		f.getContentPane().add(lblNewLabel_4_1);

		textYear = new JTextField();
		textYear.setColumns(10);
		textYear.setBounds(126, 194, 160, 29);
		f.getContentPane().add(textYear);

		JButton btnAdd = new JButton("등록");
		btnAdd.setBounds(339, 193, 104, 30);
		f.getContentPane().add(btnAdd);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(458, 193, 104, 30);
		f.getContentPane().add(btnUpdate);

		JButton btnList = new JButton("학생목록");
		btnList.setBounds(38, 251, 124, 30);
		f.getContentPane().add(btnList);
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuJTabaleExam();
				f.dispose();
			}
		});

		JButton btnExit = new JButton("종료");
		btnExit.setBounds(174, 251, 124, 30);
		f.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		int row = me.jt.getSelectedRow();// 선택된 행
		textId.setText(me.jt.getValueAt(row, 0).toString());

		String studentidStr = textId.getText();
		int studentid = Integer.parseInt(studentidStr);

		InfoDAO dao = new InfoDAO();
		InfoVO vo = dao.readInfo(studentid);

		/* studentinfo 테이블에 정보가 없을 때 */
		if((vo.getGrade()) == 0) {	
			textName.setText(vo.getName());
			textGrade.setText("");
			textState.setText("");
			textCollege.setText("");
			textMajor.setText("");
			
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int option = JOptionPane.showConfirmDialog(f, "해당 학생정보를 등록하시겠습니까?");
					if(option == JOptionPane.YES_OPTION) {
						String strGrade = textGrade.getText();
						int grade = Integer.parseInt(strGrade);
						String state = textState.getText();
						String college = textCollege.getText();
						String major = textMajor.getText();
						dao.addInfo(studentid, grade, state, college, major);
						JOptionPane.showMessageDialog(f, "학생정보가 등록되었습니다");
					}
				}
			});
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(f, "수정할 학생정보가 없습니다");
				}
			});
			
		} else {
			textName.setText(vo.getName());
			textGrade.setText(String.valueOf(vo.getGrade()));
			textState.setText(vo.getState());
			textCollege.setText(vo.getCollege());
			textMajor.setText(vo.getMajor());

			btnAdd.addActionListener(new ActionListener() {	// 등록되어 있는데 등록 눌렀을 때
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(f, "해당 학생정보가 이미 등록되어있습니다");
				}
			});
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(f, "해당 학생정보를 수정하시겠습니까?");
					if(option == JOptionPane.YES_OPTION) {
						String strGrade = textGrade.getText();
						int grade = Integer.parseInt(strGrade);
						String state = textState.getText();
						String college = textCollege.getText();
						String major = textMajor.getText();
						dao.updateInfo(studentid, grade, state, college, major);
						JOptionPane.showMessageDialog(f, "학생정보가 수정되었습니다");
					}
				}
			});
		}
		
		String splitId = studentidStr.substring(0, 4); // 학번 중 몇 학번인지 자르기 EX) 2019
		int year = Integer.parseInt(splitId) + 4; // 학번 숫자로 변경 후 +4년
		textYear.setText(String.valueOf(year));
		
		f.setVisible(true);

	}

	public static void main(String[] args) {
	}
}

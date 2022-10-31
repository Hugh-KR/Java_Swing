package login;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import loginDb.MemberDB;

public class Login extends JFrame {

	public Login() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		Label l1 = new Label("학사관리시스템", Label.CENTER);
		Label l2 = new Label("ID");
		l2.setAlignment(Label.CENTER);
		Label l3 = new Label("PW");
		l3.setAlignment(Label.CENTER);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		getContentPane().add(t1);
		getContentPane().add(t2);
		t2.setEchoChar('*');

		JButton j1 = new JButton("로그인");
		JButton j2 = new JButton("회원가입");
		JButton j3 = new JButton("ID/PW 찾기");
	
		getContentPane().add(j1);
		getContentPane().add(j2);
		getContentPane().add(j3);

		Font font1 = new Font("굴림체", Font.BOLD, 30);
		l1.setFont(font1);

		l1.setBounds(100, 70, 300, 100);
		l2.setBounds(110, 195, 40, 40);
		l3.setBounds(110, 245, 40, 40);

		t1.setBounds(160, 200, 200, 30);
		t2.setBounds(160, 250, 200, 30);

		j1.setBounds(145, 330, 80, 30);
		j2.setBounds(255, 330, 100, 30);
		j3.setBounds(370, 250, 100, 30);

		getContentPane().add(p);
		setSize(500, 500);
		setTitle("로그인");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 버튼에 대한 기능 구현(이벤트 처리)
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pwd = t2.getText();
				MemberDB dao = new MemberDB();
				int result = dao.login(id, pwd);
				if (id.equals("manager")) {
					JOptionPane.showMessageDialog(null, "관리자로 로그인 했습니다.");
				} else if (result == 1) {
					JOptionPane.showMessageDialog(null, " 로그인 했습니다.");
				} else if (result == 0) {
					JOptionPane.showMessageDialog(null, " 로그인이 실패했습니다.");
				}
			}
		});

		// 회원가입 버튼을 누르면 회원가입하는 화면을 나오게 하고
		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JoinMember joinMember = new JoinMember();
				dispose();
			}
		});
		// IDPW찾기 구현중
		j3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMember searchMember = new SearchMember();
				dispose();
			}
		});

	}
}

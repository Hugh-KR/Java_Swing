package movie;

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

import member.MemberDAO;

public class Login extends JFrame {

   public Login() {
	 JPanel p = new JPanel();
	 setLocationRelativeTo(p);
	 Label l1 = new Label("MovieReservation", SwingConstants.CENTER);
	 Label l2 = new Label("ID");
	 Label l3 = new Label("PassWord");
	 add(l1);
	 add(l2);
	 add(l3);
	 
	 TextField t1 = new TextField();
	 TextField t2 = new TextField();
	 add(t1);
	 add(t2);
	 t2.setEchoChar('*');
	 
	 JButton j1 = new JButton("로그인");
	 JButton j2 = new JButton("회원가입");
	 add(j1);
	 add(j2);
	 
	 Font font1 = new Font("굴림체", Font.BOLD, 30);
	 l1.setFont(font1);
	 
	 l1.setBounds(120, 10, 10000, 100);
	 l2.setBounds(40, 200, 40, 40);
	 l3.setBounds(40, 250, 40, 40);
	 
	 t1.setBounds(120, 200, 200, 30);
	 t2.setBounds(120, 250, 200, 30);
	 
	 j1.setBounds(125, 330, 80, 30);
	 j2.setBounds(240, 330, 100, 30);
	 
	 add(p);
	 setSize(500, 500);
	 setTitle("로그인");
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setVisible(true);
	 
	 
	 //버튼에 대한 기능 구현(이벤트 처리)
	 j1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = t1.getText();
			String pwd = t2.getText();
			MemberDAO dao = new MemberDAO();
			int result = dao.login(id, pwd);
			if(result == 1) {
				if(id.equals("manager")) {
					JOptionPane.showMessageDialog(null, "관리자로 로그인 했습니다.");
					ManagerPage managerPage = new ManagerPage();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, " 로그인 했습니다.");
					SelectMenu selectMenu = new SelectMenu();
					dispose();
				} 
			} else if(result == 0) 
				JOptionPane.showMessageDialog(null, " 로그인이 실패했습니다.");
		}
	  });
	 
	 //회원가입 버튼을 누르면 회원가입하는 화면을 나오게 하고 
	 j2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JoinMember joinMember = new JoinMember();
			dispose();
		}
	  });
 
   }	 
}



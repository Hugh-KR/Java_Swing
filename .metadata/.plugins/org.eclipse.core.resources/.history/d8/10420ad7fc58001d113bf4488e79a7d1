package mainView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AccessDB {
	
	public static int insert(int id, String pw, String name, String tel, String email) {
		
		PreparedStatement ps = null;
		int rresult = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.드라이버 설정 성공");
			
			String url = "jdbc:mysql://localhost:3306/javaUserManage";
			String user = "root";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.db연결 성공");
			
			String sql = "insert into userInformation values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
			ps.setString(5, email);
			System.out.println("3.SQL문 객체 성공");
			
			int result = ps.executeUpdate();
			if(result == 1) {
				rresult = 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			rresult = 0;
		}finally {
			try {
				if(ps!=null && !ps.isClosed()) {
					ps.close();
				}
			}catch(Exception e2) { }
		}
		return rresult;
	}
	
	public static void delete(String id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.드라이버 설정 성공");
			
			String url = "jdbc:mysql://localhost:3306/school";
			String user = "scott";
			String password = "tiger";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.db연결 성공");
			
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3.SQL문 객체 성공");
			
			int result = ps.executeUpdate();
			System.out.println("4.SQL문 전송 성공, 결과 : " + result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

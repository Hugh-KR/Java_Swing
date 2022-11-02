package mainView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import D2.MemberVO;

public class AccessDB {
	
	public static int insert(int id, String name, String gender, String tel, String email) {
		
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
			ps.setString(2, name);
			ps.setString(3, gender);
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
	
	public ArrayList<UserVO> list() {
		ArrayList<UserVO> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.드라이버 설정 성공");
			
			String url = "jdbc:mysql://localhost:3306/javaUserManage";
			String user = "root";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.db연결 성공");
			
			String sql = "select * from userInformation";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.SQL문 객체 성공");
			
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				int id2 = result.getInt(1);
				String name = result.getString(2);
				String gender = result.getString(3);
				String tel = result.getString(4);
				String mail = result.getString(5);
				
				UserVO bag = null;
				bag = new UserVO();
				bag.setId(id2);
				bag.setName(name);
				bag.setGender(gender);
				bag.setTel(tel);
				bag.setEmail(mail);
				
				list.add(bag);
				}
			ps.close();
			con.close();
			result.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		return list;
	}

	
}

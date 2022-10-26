package member;
//데이터베이스 연결하기, 데이터베이스안에 삽입하기, 삭제하기, 수정하기, 검색하기 기능을 구현해 주는 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
   
	//필드선언(변수)
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/movie";
	String userid="root";
	String password = "1234";
	
	Connection conn = null; //연결
	Statement stmt = null; //sql문 전달
	PreparedStatement pstmt = null; //sql문 전달 나중에 ? ?안에 데이터를 추가할 수 잇다.  
	ResultSet rs = null; //DB의 처리 결과를 받을 때 
		
	//메소드 구현
	public void insertMember(String id, String name, String pwd, String phoneNumber) {
		// 데이터베이스안에 자료를 삽입하기 
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into member(id, name, pwd, phoneNumber) values ( ?, ?, ?, ? )";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, phoneNumber);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean checkId(String id) {
		// 아이디 중복 체크하기
		boolean result = false;
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select id from member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return result;
	}

	public int login(String id, String pwd) {
		// 로그인하기 아이디와 비밀번호를 member테이블 안에 있는지 확인하기
	    try {
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select pwd from member where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				if( rs.getString(1).contentEquals(pwd) ) return 1;
				else return 0;
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
		   } 
		} 
		return 0;
	}
}

package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InfoDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public InfoDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String user = "abcd";
			String password = "12345678";
			
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
	      try {
	          if (rs != null) rs.close();
	          if (ps != null) ps.close();
	      } catch (Exception e) {
	          System.out.println(e + "dbClose fail");
	      }
	}
	
	public InfoVO readInfo(int id) {
		InfoVO vo = null;
		
		try {
			String sql = "select s_id, s_name, ifnull(max(grade),0) grade, ifnull(max(state),0) state, ifnull(max(college),0) college, ifnull(max(major),0) major from student s left outer join studentinfo i on s.s_id =i.studentid where s_id=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
	
			if(rs.next()) {
				int studentid = rs.getInt("s_id");
				String name = rs.getString("s_name");
				int grade = rs.getInt("grade");
				String state = rs.getString("state");
				String college = rs.getString("college");
				String major = rs.getString("major");				
				
				vo = new InfoVO();
				
				vo.setId(studentid);
				vo.setName(name);
				vo.setGrade(grade);
				vo.setState(state);
				vo.setCollege(college);
				vo.setMajor(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	
	public InfoVO addInfo(int id, int grade, String state, String college, String major) {
		InfoVO vo = null;
		
		try {
			String sql = "insert into studentinfo values(?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, grade);
			ps.setString(3, state);
			ps.setString(4, college);
			ps.setString(5, major);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	
	public InfoVO updateInfo(int id, int grade, String state, String college, String major) {
		InfoVO vo = null;
		
		try {	
			String sql = "update studentinfo set grade=?, state=?, college=?, major=? where studentid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, grade);
			ps.setString(2, state);
			ps.setString(3, college);
			ps.setString(4, major);
			ps.setInt(5, id);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
}
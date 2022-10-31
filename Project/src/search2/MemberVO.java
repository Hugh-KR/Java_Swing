package search2;

public class MemberVO {
	private int s_id;
	private String s_name;
	private String s_gender;
	private String s_tel;
	private String s_email;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	@Override
	public String toString() {
		return "MemberVO [s_id=" + s_id + ", s_name=" + s_name + ", s_gender=" + s_gender + ", s_tel=" + s_tel
				+ ", s_email=" + s_email + "]";
	}
	
	
	
	
}

//[mms.member.db :데이터 베이스 관련 처리에 필요한 공통적인 기능의 클래스가 정의되는 패키지]

//1. DB관련 공통 기능 클래스
package mms.member.db;

//1. DB관련 공통 기능 클래스
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
//	static : 공용(객체생성이 필요없음)
//	void : 없다, 비어있다 라는 뜻(return 키워드가 없음)
//	public : 기본 접근 제어자 메소드(어디서든 사용가능)
	
	static {
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
	
		try {
			String jdbc_driver = "oracle.jdbc.driver.OracleDriver";//다리
			Class.forName(jdbc_driver);
		} catch (ClassNotFoundException e) {
		
		}
	}
	
	public static Connection getConnection() {
		//DB 작업에 필요한 connection 객체를 생성해 주는 메소드
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
			con= DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {

		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//transaction 처리 메소드

}
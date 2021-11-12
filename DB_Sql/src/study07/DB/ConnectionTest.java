package study07.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

		Connection con;
		
		//언제나 메모리에 있는 아이
		static{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버가 없습니다.");
				}
		}
		
		//메소드-객체 생성해야지만 쓸수있는 아이
		public void connect(){
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
		    try {
				con = DriverManager.getConnection(url, "javalink", "javalink");
				System.out.println("Connection Success!");
			} catch (SQLException e) {
				System.out.println("주소,id,pw가 다릅니다.");
			}

		}
		//메인메소드
		public static void main(String[] args) {
			ConnectionTest ct = new ConnectionTest();
			ct.connect();
			//Connection Success!가 출력되야 한다.

	}

}

package study07.DB;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTest {
	//위로 빼서 좀 줄이기
	Connection conn = null;
	Statement stmt = null;	
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
			conn = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!");
		} catch (SQLException e) {
			System.out.println("주소,id,pw가 다릅니다.");
		}
		
	}
	
	
	//자료 넣기
	public void insert() {
		// "'aaa','1111','홍길동','22','서울시','a@a.com'"
		try {
			// Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
			
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
//		getConnection : 연결                    주소, 아이디(데이터베이스 이름),암호
			conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = conn.createStatement();
			
			
			//오라클에 들어가면 이 명령을 실행해라(커뤼 랭귀지(오라클 언어)) // 기존하고 달라야한다
			String query = "insert into member1 values('aaa','1111','홍길동',22,'서울시','a@a.com')";
			
			int count = stmt.executeUpdate(query);
			if(count >0) {
				System.out.println("데이터가 저장되었습니다");
			} else
				System.out.println("데이터가 저장되지 않았습니다.");
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("정상종료");
		try {
			conn.close();
		} catch (SQLException e) {
			
		}

	}
//출력
	public void select() {

		try {
			// Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
			
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
//		getConnection : 연결                    주소, 아이디(데이터베이스 이름),암호
			conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = conn.createStatement();
			//오라클에 들어가면 이 명령을 실행해라(커뤼 랭귀지(오라클 언어))
			String query = "select * from member1";
			//그리고 실행된 결과값
			ResultSet rs = stmt.executeQuery(query);
			//오라클 결과값 뽑아낼려고 하는것
			while(rs.next()) {//읽을 문장이 있느냐?(true면 계속 실행)
				//문자열로 뽑아 내겠다
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString("name");
				String age = rs.getString(4);
				String addr = rs.getString("addr");
				String email = rs.getString("email");

				System.out.println(id+" : "+password+" : "+name+" : "+age+" : " +addr+" : " +email);
				
		
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("정상종료");
		try {
			conn.close();
		} catch (SQLException e) {
			
		}

	}

	//내용 수정
	public void update() {
		// id=aaa 를 찾아서 addr=부산시

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
			// 연결

			conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = conn.createStatement();
			
			//업데이트 // 변경내용을 앞에 찾을 아이디를 뒤에
			String query = "update member1 set addr='부산시' where id='aaa'";
			
			int count = stmt.executeUpdate(query);
			if(count >0) {
				System.out.println("업데이트가 되었습니다.");
			} else
				System.out.println("업데이트가 되지 않았습니다.");
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("정상종료");
		try {
			conn.close();
		} catch (SQLException e) {
			
		}

	}
    //삭제
	public void delete() {
        //id=aaa 삭제

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 다리
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//주소
			// 연결

			conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = conn.createStatement();
			
			//삭제
			String query = "delete member1 where id='aaa'";
			
			int count = stmt.executeUpdate(query);
			if(count >0) {
				System.out.println("데이터가 삭제되었습니다.");
			} else
				System.out.println("데이터가 삭제되지 안았습니다.");
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("정상종료");
		try {
			conn.close();
		} catch (SQLException e) {
			
		}

	}
	
//메인메소드 실행
	public static void main(String[] args) {
		CRUDTest st = new CRUDTest();
		
		st.connect();//데이터 베이스 연결
		st.insert();//데이터 입력
		System.out.println("insert 수행 후");
		st.connect();//데이터 베이스 연결
		st.select();//출력
		
		st.connect();
		st.update();//업데이트
		System.out.println("update 수행 후");
		st.connect();
		st.select();
		
		st.connect();
		st.delete();//삭제
		System.out.println("delete 수행 후");
		st.connect();
		st.select();	
	}

}
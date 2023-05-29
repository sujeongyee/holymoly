package holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import holy.main.MovieDBProperties;
import holy.vo.HmemberVO;
import holy.vo.ScheduleVO;

public class ScheduleDAO {
	
	
	private String url = MovieDBProperties.URL;
	private String uid = MovieDBProperties.UID;
	private String upw = MovieDBProperties.UPW;

	
	
	public ScheduleDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}		
		
	}
	
	public List<ScheduleVO> getSche(){
		String sql = "SELECT * FROM SCHEDULE";
		List<ScheduleVO> list = new ArrayList<>(); 
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {			
			//conn , pstmt ,resultset	
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);

			// 매개변수로 받아온 값

			rs= pstmt.executeQuery();

			while(rs.next()) {
				//String scheNum, String scheTime, int leftSeat, String theaNum, String filmNum
				String scheNum = rs.getString("scheNum");
				String scheTime = rs.getString("scheTime");
				int leftSeat = rs.getInt("leftSeat");
				String theaNum = rs.getString("theaNum");
				String filmNum = rs.getString("filmNum");

				//1행에 대한 값을 저장
				ScheduleVO vo = new ScheduleVO(scheNum,scheTime,leftSeat,theaNum,filmNum);

				//리스트에 vo를 추가
				list.add(vo);				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}



		return list;
	}
	

}

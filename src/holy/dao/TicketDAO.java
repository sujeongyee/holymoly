package holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import holy.main.MovieDBProperties;
import holy.vo.FilmVO;
import holy.vo.HmemberVO;
import holy.vo.ScheduleVO;
import holy.vo.TicketListVO;
import holy.vo.TicketingVO;

public class TicketDAO {
		
	private String url = MovieDBProperties.URL;
	private String uid = MovieDBProperties.UID;
	private String upw = MovieDBProperties.UPW;
	
	
	public TicketDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}	
	}
	
	
	public List<TicketListVO> getTicket(String id) {
		
		String sql = "select t.tickno, t.tickseat, t.tickdate, t.tickcount,\r\n"
				+ "    t.tickprice, t.paymehod, t.memid, s.schetime, s.theanum,\r\n"
				+ "    f.filmtitle, f.filmruntime\r\n"
				+ "from ticketing t\r\n"
				+ "join schedule s on t.schenum = s.schenum\r\n"
				+ "join film f on s.filmnum = f.filmnum\r\n"
				+ "where t.memid = ?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TicketListVO> list = new ArrayList();
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				TicketListVO tvo = new TicketListVO();
				tvo.getFvo().setFilmRuntime(rs.getString("filmruntime"));
				tvo.getFvo().setFilmTitle(rs.getString("filmtitle"));
				tvo.getSvo().setTheaNum(rs.getString("theanum"));
				tvo.getSvo().setScheTime(rs.getString("schetime"));
				
				
				tvo.getTickvo().setMemId(rs.getString("memid"));
				tvo.getTickvo().setPayMethod(rs.getString("paymehod"));
				
				tvo.getTickvo().setTickPrice(rs.getInt("tickprice"));
				tvo.getTickvo().setTickCount(rs.getInt("tickcount"));
				tvo.getTickvo().setTickSeat(rs.getString("tickseat"));
				tvo.getTickvo().setTickNo(rs.getString("tickno"));
				
				list.add(tvo);
				System.out.println("d");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list; 
	}
	
	
}

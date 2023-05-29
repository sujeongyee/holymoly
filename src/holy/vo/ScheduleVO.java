package holy.vo;

public class ScheduleVO {
	/*
	 * SCHNO    NOT NULL VARCHAR2(99) 
	SCHTIME  NOT NULL VARCHAR2(10) 
	MOVIENO           VARCHAR2(99) 
	TORDERNO          VARCHAR2(10) 
	 */
	
	private String scheNum;
	private String scheTime;
	private int leftSeat;
	private String theaNum;
	private String filmNum;
	
	public ScheduleVO() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleVO(String scheNum, String scheTime, int leftSeat, String theaNum, String filmNum) {
		super();
		this.scheNum = scheNum;
		this.scheTime = scheTime;
		this.leftSeat = leftSeat;
		this.theaNum = theaNum;
		this.filmNum = filmNum;
	}

	/**
	 * @return the scheNum
	 */
	public String getScheNum() {
		return scheNum;
	}

	/**
	 * @param scheNum the scheNum to set
	 */
	public void setScheNum(String scheNum) {
		this.scheNum = scheNum;
	}

	/**
	 * @return the scheTime
	 */
	public String getScheTime() {
		return scheTime;
	}

	/**
	 * @param scheTime the scheTime to set
	 */
	public void setScheTime(String scheTime) {
		this.scheTime = scheTime;
	}

	/**
	 * @return the leftSeat
	 */
	public int getLeftSeat() {
		return leftSeat;
	}

	/**
	 * @param leftSeat the leftSeat to set
	 */
	public void setLeftSeat(int leftSeat) {
		this.leftSeat = leftSeat;
	}

	/**
	 * @return the theaNum
	 */
	public String getTheaNum() {
		return theaNum;
	}

	/**
	 * @param theaNum the theaNum to set
	 */
	public void setTheaNum(String theaNum) {
		this.theaNum = theaNum;
	}

	/**
	 * @return the filmNum
	 */
	public String getFilmNum() {
		return filmNum;
	}

	/**
	 * @param filmNum the filmNum to set
	 */
	public void setFilmNum(String filmNum) {
		this.filmNum = filmNum;
	}

	
	
	
}

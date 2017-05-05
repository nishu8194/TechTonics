package allUtilities;

public class TechTalksPojo {

	private int empID;
	private String topic;
	private String date;
	private String day;
	private String presentor;
	 
	public TechTalksPojo() {
		// TODO Auto-generated constructor stub
	}

	public TechTalksPojo(int techTalkCode, String topic, String date, String day, String presentor) {
		super();
		this.empID = techTalkCode;
		this.topic = topic;
		this.date = date;
		this.day = day;
		this.presentor = presentor;
	}

	public int getEmpId() {
		return empID;
	}

	public void setEmpId(int techTalkCode) {
		this.empID = techTalkCode;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPresentor() {
		return presentor;
	}

	public void setPresentor(String presentor) {
		this.presentor = presentor;
	}
	
	
}

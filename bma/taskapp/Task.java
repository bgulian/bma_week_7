package bma.taskapp;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Task {
	private String taskName="";
	private Date beginDate;
	private Date endDate;
	private boolean complete = false;
	public static final int BEGIN_DATE = 0;
	public static final int END_DATE = 1;
	
	
	public	Task() {
		
	}
	
	public  Task(String name) {
		this.taskName = name;
	}
	
	public String getName() {
		return this.taskName;
	}
	
	public void setName(String name) {
		this.taskName = name;
	}
	
	public boolean isComplete() {
		return this.complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	/**
	 * 
	 * @return array[TASK.BEGIN_DATE, TASK.END_DATE]
	 */
	public Date[] getDates() {
		Date[] arr = new Date[2];
		arr[0] = this.beginDate;
		arr[1] = this.endDate;
		return arr;
	}
	
	/**
	 * setDate by a string representation of a date, like something scraped
	 * from an input field.
	 * @param whichDate
	 * @param daterep
	 */
	public void setDate(int whichDate, String daterep){
		Date d = this.getDate(whichDate);
		try {
			Date ld = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(daterep);
			d.setTime(ld.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	/**
	 * setDate by a Date.
	 * @param whichDate
	 * @param pd
	 */
	public void setDate(int whichDate, Date pd){
		Date d = this.getDate(whichDate);
		d.setTime(pd.getTime());
	}
	
	private Date getDate(int whichDate) {
		if (whichDate == Task.BEGIN_DATE) {
			return this.beginDate;
		} else if (whichDate == Task.END_DATE) {
			return this.endDate;
		}
		return null;
	}
	
	public String toString() {
		return "Task(" + this.taskName + "," + this.beginDate.toString() + "," + this.endDate.toString() + ")";
	}
	
	
}


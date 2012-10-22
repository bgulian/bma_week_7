package bma.taskapp;

import java.util.Date;


public class Application {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tasklist tl = new Tasklist();
		for (int i =0; i < 10; i++) {
			Task t = new Task("Task_" + i);
			t.setDate(Task.BEGIN_DATE, "October " + (i+1) + ", 2012" );
			t.setDate(Task.END_DATE,"October " + (i + 10) + ", 2012" );
			tl.addTask(t);
		}
		
		printTasks(tl.getTasks());
		Tasklist filterTL = tl.list(new Taskfilter() {
			
			  @SuppressWarnings("deprecation")
			public boolean accept(Task t) { 
				  return t.getDates()[Task.BEGIN_DATE].after(new Date("October 12,2012") ); 
			  }
		});
		
		//printTasks(filterTL.getTasks());
	}
	
	public static void printTasks(Object[] tlArray) {
		for (int i=0; i < tlArray.length; i++) {
			System.out.println ( tlArray[i]);
		}
		
	}

}

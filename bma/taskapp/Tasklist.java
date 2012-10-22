package bma.taskapp;

import bma.taskapp.*;
import java.util.*;

public class Tasklist {
	private ArrayList<Task> tasks = new ArrayList();
	public Tasklist() {
		
	}
	
	public void addTask(Task t) {
		tasks.add(t);
	}
	public Object[] getTasks() {
		return this.tasks.toArray();
	}
	public Task getTask(String name) {
		return this.find(name);
	}
	
	private boolean delete(String name) {
		return this.tasks.remove(this.find(name));
	}
	
	
	public Tasklist list(Taskfilter f) {
		Tasklist tl = new Tasklist();
		Iterator<Task> iterator = null;
		iterator = this.tasks.iterator();
	    while (iterator.hasNext()) {
	    	Task t = iterator.next();
	    	if (f.accept(t) == true){
	    		tl.addTask(t);
	    	}
	    }
		return tl;
	}
	
	/**
	 * finds object based on string alone - could just use contains()
	 * 
	 * @param name
	 * @return
	 */
	private Task find(String name) {
		int i=0;
		Iterator<Task> iterator = null;
		iterator = this.tasks.iterator();
	    while (iterator.hasNext()) {
	    	Task t = iterator.next();
	    	if (t.getName().equals(name)) {
	    		return t;
	    	}
	    	i++;
	    }
	    return null;
	}
}

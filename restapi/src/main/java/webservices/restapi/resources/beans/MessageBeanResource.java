package webservices.restapi.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageBeanResource {
	private @QueryParam(value = "year") int year;
	private @QueryParam(value = "start") int start;
	private @QueryParam(value = "stop") int stop;
	public void setStart(int start) {
		this.start = start;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStop() {
		return stop;
	}
	public void setStop(int stop) {
		this.stop = stop;
	}
	public int getStart() {
		return start;
	}
	

}

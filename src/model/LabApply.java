package model;

public class LabApply {
	private int id;
	private String classd;
	private int stu_num;
	private String teacher;
	private String week;
	private String time;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String lab;
	
	
	public LabApply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LabApply(String classd, int stu_num, String teacher, String week, String time, String monday, String tuesday,
			String wednesday, String thursday, String friday) {
		super();
		this.classd = classd;
		this.stu_num = stu_num;
		this.teacher = teacher;
		this.week = week;
		this.time = time;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
	}
	
	
	


	public LabApply(int id, String classd, int stu_num, String teacher, String week, String time, String monday,
			String tuesday, String wednesday, String thursday, String friday) {
		super();
		this.id = id;
		this.classd = classd;
		this.stu_num = stu_num;
		this.teacher = teacher;
		this.week = week;
		this.time = time;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
	}
	
	

	
	
	
	public LabApply(String classd, int stu_num) {
		super();
		this.classd = classd;
		this.stu_num = stu_num;
	}

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
	public String getClassd() {
		return classd;
	}
	public void setClassd(String classd) {
		this.classd = classd;
	}
	public int getStu_num() {
		return stu_num;
	}
	public void setStu_num(int stu_num) {
		this.stu_num = stu_num;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
}

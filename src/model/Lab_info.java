package model;


/**
 * 实验室实体
 * @author jiyuan
 *
 */
public class Lab_info {
	private int id;
	private String location;
	private int size;
	
	public Lab_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Lab_info(String location, int size) {
		super();
		this.location = location;
		this.size = size;
	}
	
	public Lab_info(int id, String location, int size) {
		super();
		this.id = id;
		this.location = location;
		this.size = size;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

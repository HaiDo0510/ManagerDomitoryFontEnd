package org.o7planning.fontend.model;







import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Student extends Base{
	private String code;

	private String full_name;

	private String cmt;

//	@DateTimeFormat(iso=ISO.DATE)
	private String birth_day;

	private String name_class;

	private String hometown;

	private String id_room;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String code, String full_name, String cmt, String birth_day, String name_class, String hometown,
			String id_room) {
		super();
		this.code = code;
		this.full_name = full_name;
		this.cmt = cmt;
		this.birth_day = birth_day;
		this.name_class = name_class;
		this.hometown = hometown;
		this.id_room = id_room;
	}


	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}


	public String getCmt() {
		return cmt;
	}


	public void setCmt(String cmt) {
		this.cmt = cmt;
	}


	public String getBirth_day() {
		return birth_day;
	}


	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}


	public String getName_class() {
		return name_class;
	}


	public void setName_class(String name_class) {
		this.name_class = name_class;
	}


	public String getHometown() {
		return hometown;
	}


	public void setHometown(String hometown) {
		this.hometown = hometown;
	}


	public String getId_room() {
		return id_room;
	}


	public void setId_room(String id_room) {
		this.id_room = id_room;
	}


	@Override
	public String toString() {
		return "Student [code=" + code + ", full_name=" + full_name + ", cmt=" + cmt + ", birth_day=" + birth_day
				+ ", name_class=" + name_class + ", hometown=" + hometown + ", id_room=" + id_room + "]";
	}
	
	
}

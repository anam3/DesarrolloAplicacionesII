package boots.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="students")
public class Student {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (length=45)
	private String name;
	@Column (length=45)
	private String first;
	@Column (length=45)
	private String last;
	@Temporal(TemporalType.DATE)
	@Column (name="date_nac")
	private Date dateNac;
	
	public Student(String name, String first, String last, Date dateNac) {
		super();
		this.name = name;
		this.first = first;
		this.last = last;
		this.dateNac = dateNac;
	}

	public Student() {
		this("","","",new Date());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Date getDateNac() {
		return dateNac;
	}

	public void setDateNac(Date dateNac) {
		this.dateNac = dateNac;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", first=" + first + ", last=" + last + ", dateNac=" + dateNac
				+ "]";
	}
	
}

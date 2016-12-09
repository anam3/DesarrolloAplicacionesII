package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="instruments")
public class Instrument {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String description;
	
	public Instrument(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Instrument() {
		this("","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Instrument [id=" + id + ", name=" + name + ", description=" + description + "]";
	}	
	
}

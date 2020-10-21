package main.java.com.solvd.people;

import org.apache.log4j.Logger;

import main.java.com.solvd.Main;
import main.java.com.solvd.interfaces.Contactable;
import main.java.com.solvd.interfaces.ISignatory;

public abstract class Person implements ISignatory, Contactable {
	private static final Logger logger = Logger.getLogger(Person.class);
	
	private String name;
	private String lastname;
	private int identification;
	private String gender;
	private int age;
	private String nationality;

	public Person() {
	}

	public Person(String name, String lastname, int identification, String gender, int age, String nationality) {
		this.name = name;
		this.lastname = lastname;
		this.identification = identification;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}

	@Override
	public int hashCode() {
		return identification;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (identification != other.identification)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ("Name: " + getName() + " " + getLastname() + "\n Identification: " + hashCode() + "\n Gender: "
				+ getGender());
	}

	@Override
	public String sign() {
		return name + " " + lastname + " " + identification;
	}

	@Override
	public void sendEmail() {
		logger.info(Contactable.MESSAGE + name + " " + lastname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}

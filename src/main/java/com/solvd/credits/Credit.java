package main.java.com.solvd.credits;

import main.java.com.solvd.interfaces.Invertible;
import main.java.com.solvd.people.Client;
import main.java.com.solvd.enums.CreditStatus;

public abstract class Credit implements Invertible{

	private int id;
	private float amount;
	private float interest;
	private int fees;
	private Client applicant;
	private CreditStatus state;
	private double score;

	public Credit() {
	}

	public Credit(int id, float amount, float interest, int fees, Client applicant) {
		this.id = id;
		this.amount = amount;
		this.interest = interest;
		this.fees = fees;
		this.applicant = applicant;
		this.state = CreditStatus.IN_EVALUATION;
	}
	
	@Override
	public void invest(double amount) {
		this.amount -= amount;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credit other = (Credit) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (fees != other.fees)
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(interest) != Float.floatToIntBits(other.interest))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ("Credit Id: " + id + "\n Amount: " + amount + "\n Interest: " + interest + "\n Fees: " + fees
				+ "\n State: " + state + "\n Score: " + score + "\nApplicant: \n " + applicant);
	}

	public float getFeeAmount() {
		return (amount + amount * interest) / fees;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public float getAmount() {
		return amount;
	}

	public float getInterest() {
		return interest;
	}

	public int getFees() {
		return fees;
	}

	public Client getApplicant() {
		return applicant;
	}

	public void setApplicant(Client applicant) {
		this.applicant = applicant;
	}

	public CreditStatus getState() {
		return state;
	}

	public void setApproved() {
		this.state = CreditStatus.APPROVED;
	}

	public void setDeclined() {
		this.state = CreditStatus.DECLINED;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}

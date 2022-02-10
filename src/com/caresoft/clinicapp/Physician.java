package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	private Integer id;
	private int pin;
	
	// TO DO: Constructor that takes an ID	
	public Physician(Integer id) {
		this.id = id;
		this.patientNotes = new ArrayList<String>();
		// super(id);
		// TODO Auto-generated constructor stub
	}
	
	// TO DO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		if (pin <=9999 && pin >= 1000) {
			this.pin = pin;
			return true;
		} 
		return false;
	};
	
	
	
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (this.id == confirmedAuthID) {
    		return true;
    	} 
    	return false;
    }
		
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
		
    // TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
			
}

package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {	
	private Integer employeeID;
	private int pin;
    private String role;
    private ArrayList<String> securityIncidents;

    // CONSTRUCTOR 
	public AdminUser(Integer employeeID, String role) {
		this.securityIncidents = new ArrayList<String>();
		this.employeeID = employeeID;
		this.role = role;	
	}
	
	// TO DO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		if (pin <= 999999 && pin >= 100000) {
			this.pin = pin;
			return true;
		} 
		return false;
	};
				
	public boolean accessAuthorized(Integer confirmedAuthID) {
	    if (this.employeeID == confirmedAuthID) {
	   		return true;
	    } 
	    this.authIncident();
	   	return false;
	   	   	
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    public ArrayList<String> reportSecurityIncidents() {
    	return this.securityIncidents;	
    }
    
    
    // GETTERS & SETTERS
    public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
}
	

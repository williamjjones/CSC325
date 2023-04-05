package model;



import java.io.Serializable;


public class Airport implements Serializable, Comparable<Airport> {
	private static final long serialVersionUID = 57898413;
    private String apName;
    private String apPhone;
    private String apCode;
    private String state;
    
    public Airport() {
        apName = null;
        apPhone = null;
        apCode = null;
        state = null;
    }
    
    public Airport(String name, String phone, String code, String state ) {
        apName = name;
        apPhone = phone;
        apCode = code;
        this.state = state;
    }
    
    public Airport(Airport other) {
            this(other.apName, other.apPhone, other.apCode, other.state);
    }
    
    public void setApName(String name) {
        apName = name;
    }
    
    public String getApName() {
        return apName;
    }
    
    public void setApPhone(String phone) {
        apPhone = phone;
    }
    
    public String getApPhone() {
        return apPhone;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setApCode(String code) {
        apCode = code;
    }
    
    public String getApCode() {
        return apCode;
    }
    
    public String display() {
		return "Airport [apName=" + apName + ", apPhone=" + apPhone + ", apCode=" + apCode + ", state=" + state + "]";
	}


	@Override
	public String toString() {
		return apCode + " - " + apName;
	}
	
	

	@Override
	public int compareTo(Airport o) {
		return this.apCode.compareTo(o.apCode);
	}
    

    
}

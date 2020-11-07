package anyTimeMoney;
import java.util.*;
class Admin 
{
	private String Password;
	Admin(){}
	
	Admin(String s){Password=s;}
	
	public String getPassword() {return Password;}
	
	public void changePassword(String s) {Password=s;}
	
	public ArrayList<String> transactions = new ArrayList<String>();
	
}
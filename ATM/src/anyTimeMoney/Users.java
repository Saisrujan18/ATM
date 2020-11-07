package anyTimeMoney;
import java.util.*;
public class Users 
{
	private String UserAccountNumber;
	private int UserPinCode;
	private double SavingsBalance;
	private double CurrentBalance;
	private ArrayList<String> MiniStatement =new  ArrayList<String>();
//	private String Bank;
	Users(){}
	Users(String accno,int pincode,double savbal,double currentbal)
	{
		UserAccountNumber=accno;
		UserPinCode=pincode;
		SavingsBalance=savbal;
		CurrentBalance=currentbal;
//		Bank=bank;
	}
	
	public String getUserAccountNumber(){	return UserAccountNumber;}
	public int getUserPinCode(){return UserPinCode;}
	public double getSavingsBalance(){return SavingsBalance;}
	public double getCurrentBalance(){return CurrentBalance;}
	public void setSavingsBalance(double i){SavingsBalance+=i;}
	public void setCurrentBalance(double i) {CurrentBalance+=i;}
//	public void setBank(String i) {Bank=i;}
//	public String  getBank() {return Bank;}
	public void addToMini(String s){MiniStatement.add(s);}
	public void UserMiniStatement()
	{
		for(int i=1;i<=3;i++)
		{
			if(MiniStatement.size()-i>=0)
			{
				System.out.println(MiniStatement.get(MiniStatement.size()-i));
			}
		}
	}
	
	public void changeUserPinCode(int pin)
	{
		if(Information.validPin(pin))
		{
			UserPinCode=pin;
			System.out.println("User pin successfully changed");
			System.out.println("SESSION ENDED");
		}
		else
		{
			System.out.println("Your Pin doesnt satisfy required criteria");
			System.out.println("SESSION ENDED");
		}
	}
	
}
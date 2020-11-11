package anyTimeMoney;
import java.util.*;
public class Users 
{
	private String UserAccountNumber;
	private int UserPinCode;
	private double SavingsBalance;
	private double CurrentBalance;
	private ArrayList<String> MiniStatement =new  ArrayList<String>();
	private ArrayList<String> AcessGiven = new ArrayList<String>();
	private ArrayList<String> AcessTaken = new ArrayList<String>();
	public ArrayList<String> AcessRequested = new ArrayList<String>();
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
	public void addToRequest(String s) {AcessRequested.add(s);}
	public int getSize() {return AcessRequested.size();}
	public void addToTaken(String s){AcessTaken.add(s);		}
	public void addToApproved (int[] s)
	{
		int notimes=s.length;
		int i=0;
		while(notimes>0)
		{
			if(s[i]==1)
			{
				String soootemp=AcessRequested.get(i);
				AcessGiven.add(soootemp);
				Information.getUser(Information.getvalidAccountNumberUser(soootemp)).addToTaken(UserAccountNumber);
			}
			i++;
			notimes--;
		}
	}
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
	public boolean Check(String s)
	{
		for(int i=0;i<AcessTaken.size();i++)
		{
			if(s.equals(AcessTaken.get(i)))
			{
				return true;
			}
		}
		return false;
	}
}
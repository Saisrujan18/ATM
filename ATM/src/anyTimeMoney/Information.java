package anyTimeMoney;

import java.util.*;

class Information 
{
	private static ArrayList<Users> UsersArrayList = new ArrayList<Users>();
	private static double SavingsMinBalance=0;
	private static double CurrentMinBalance=0;
	
	public static void addElement(Users u){UsersArrayList.add(u);}
	public static void setSavingsMinBalance(double savingsMinBalance) {SavingsMinBalance = savingsMinBalance;}
	public static void setCurrentMinBalance(double currentMinBalance){CurrentMinBalance=currentMinBalance;}
	public static Users getUser(int i){return UsersArrayList.get(i);}
	public static double getSavingsMinBalance() {return SavingsMinBalance;}
	public static double getCurrentMinBalance(){return CurrentMinBalance;}

	
	public static boolean validPin(int pin)
	{
		int count=0;
		while(pin!=0)
		{
			count++;
			pin/=10;
		}
		if(count==5)
		{
			return true;
		}
		return false;
	}
	
	public static boolean validAccountNumber(String accno)
	{
		
		for(int i=0;i<UsersArrayList.size();i++)
		{
			if(UsersArrayList.get(i).getUserAccountNumber().equals(accno))
			{
				return true;
			}
		}
		return false;
	}
	
	public static int getvalidAccountNumberUser(String accno)
	{
		for(int i=0;i<UsersArrayList.size();i++)
		{
			if(UsersArrayList.get(i).getUserAccountNumber().equals(accno))
			{
				return i;
			}
		}
		return 0;
	}
}
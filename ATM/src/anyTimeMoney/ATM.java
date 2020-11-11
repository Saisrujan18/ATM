package anyTimeMoney;

import java.util.*;

public class ATM 

{
	
	public static void main(String[] args)
	
	{
		
		Scanner x = new Scanner(System.in);
		
		System.out.println("<--- Welcome Admin ! You need to setup ATM for transactions --->");
		
		System.out.print("\nPlease create the password of your login : ");
		String tempPassword =x.next();
		Admin srujan = new Admin(tempPassword);
		
		System.out.println("Admin wont have seperate login for security");
		System.out.println("Admin should enter password when asked for AccountNumber");
		
		
		System.out.print("\n--->ENTER THE INITIAL NUMBER OF ACCOUNTS IN THE BANK : ");
		
		int numberOfAccounts=x.nextInt();
		
		for(int i=0;i<numberOfAccounts;i++)
		{
			System.out.print("-->Enter the Account number of the user : ");
			String  tempAccNo=x.next();
			
			System.out.print("   Enter the pincode of the user : ");
			int tempPin=x.nextInt();
			
			System.out.print("   Enter the initial balance in the savings account : ");
			double tempsav=x.nextDouble();
			
			System.out.print("   Enter the initial balance in the current account : ");
			double tempcur=x.nextDouble();
			Users newUser = new Users(tempAccNo,tempPin,tempsav,tempcur);
			
			Information.addElement(newUser);
		}
		
		System.out.print("\nEnter the minimum balance for savings account : ");
		double temp=x.nextDouble();
		Information.setSavingsMinBalance(temp);
		
		System.out.print("Enter the minimum balance for current account : ");
		temp=x.nextDouble();
		Information.setCurrentMinBalance(temp);
		
		CashManagement cash = new CashManagement();
		System.out.println("\n\nConfiguring the ATM machine\n");

		System.out.print("Enter the number of 2000 notes loaded in the atm : ");
		cash.set2000(x.nextInt());
		System.out.print("Enter the number of 500 notes loaded in the atm : ");
		cash.set500(x.nextInt());
		System.out.print("Enter the number of 200 notes loaded in the atm : ");
		cash.set200(x.nextInt());
		System.out.print("Enter the number of 100 notes loaded in the atm : ");
		cash.set100(x.nextInt());
		
		cash.UpdateMoney();
		
		System.out.println("\nStarting the ATM : ");
		boolean perform=true;
		while(perform)
		
		{
			System.out.println("<------------------------------------------------------------------------>");
			System.out.println("\n\nWELCOME SRUJAN\'S ATM");
			System.out.print("-->Please enter the AccountNumber : ");
			String UserInput=x.next();
			if(UserInput.equals(srujan.getPassword()))
			{
				System.out.println("Here are your options");
				System.out.println("Enter 1 to view all Transactions ");
				System.out.println("Enter 2 to change the ATM pin for Admin");
				System.out.println("Enter 3 to Shutdown ATM");
				System.out.println("Enter 4 to add money");
				System.out.println("Enter 5 to remove money");
				System.out.println("Enter 6 to view ATM present cash state ");
				int AdminOption=x.nextInt();
				if(AdminOption==1)
				{
					for(int i=0;i<srujan.transactions.size();i++)
					{
						System.out.println(srujan.transactions.get(i));
					}
				}
				else if(AdminOption==2)
				{
					System.out.print("Enter the new password : ");
					String newPassword=x.next();
					srujan.changePassword(newPassword);
					System.out.println("Password successfully changed :) ");
				}
				else if(AdminOption==3)
				{
					System.out.println("SHUTTING DOWN ATM");
					perform=false;
				}
				else if(AdminOption==4)
				{
					System.out.print("Enter the number of 2000 notes you wanna add : ");
					cash.set2000(x.nextInt());
					System.out.print("Enter the number of 500 notes you wanna add : ");
					cash.set500(x.nextInt());
					System.out.print("Enter the number of 200 notes you wanna add : ");
					cash.set200(x.nextInt());
					System.out.print("Enter the number of 100 notes you wanna add : ");
					cash.set100(x.nextInt());
					cash.UpdateMoney();
				}
				else if(AdminOption==5)
				{
					System.out.print("Enter the number of 2000 you wanna remove : ");
					int remove2000=x.nextInt();
					System.out.print("Enter the number of 500 you wanna remove : ");
					int remove500=x.nextInt();
					System.out.print("Enter the number of 200 you wanna remove : ");
					int remove200=x.nextInt();
					System.out.print("Enter the number of 100 you wanna remove : ");
					int remove100=x.nextInt();
					if(remove2000<=cash.get2000() && remove500<=cash.get500() && remove200<=cash.get200() && remove100<=cash.get100())
					{
						System.out.println("Money successfully removed");
						cash.set2000(-remove2000);
						cash.set500(-remove500);
						cash.set200(-remove200);
						cash.set100(-remove100);
						cash.UpdateMoney();
					}
					else
					{
						System.out.println("THE ATM DOESN'T MEET YOUR REQUIREMENTS :)");
					}
				}
				else
				{
					System.out.println("Total amount in the ATM : "+ cash.getMoney());
					System.out.println("Number of 2000 notes : "+cash.get2000());
					System.out.println("Number of 500 notes : "+cash.get500());
					System.out.println("Number of 200 notes : "+cash.get200());
					System.out.println("Number of 100 notes : "+cash.get100());
				}
			}
			else 
			{
				if(Information.validAccountNumber(UserInput))
				{
					Users currentUser = Information.getUser(Information.getvalidAccountNumberUser(UserInput));
					System.out.print("-->ENTER THE 5 DIGIT PIN : ");
					int UserPassword=x.nextInt();
					if(UserPassword==currentUser.getUserPinCode())
					{
						System.out.println("\nChoose 1 to check balance");
						System.out.println("Choose 2 to change pin");
						System.out.println("Choose 3 to deposit money in savings ");
						System.out.println("Choose 4 to deposit money in current ");
						System.out.println("Choose 5 to withdraw money from savings");
						System.out.println("Choose 6 to withdraw money from current");
						System.out.println("Choose 7 to transfer money ");
						System.out.println("Choose 8 for Mini Statement ");
						System.out.println("Choose 9 for requesting FamilyAccess");
						System.out.println("Choose 10 for Approving FamilyAccess ");
						System.out.println("Choose 11 for withdrawing money from FamilyMembers account");
						int UserOption=x.nextInt();
					
						switch(UserOption)
						{
						case 1:
								srujan.transactions.add(UserInput+" checked his balance");
								System.out.println("The account number of the user : "+currentUser.getUserAccountNumber());
								System.out.println("The Savings balance of the user : "+ currentUser.getSavingsBalance());
								System.out.println("The current balance of the user : "+currentUser.getCurrentBalance());
								Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User checked his balance");
								break;
					
						case 2:
								System.out.print("Enter the new 5 digit pincode for your account : ");
								int UsernewPassword=x.nextInt();
								if(Information.validPin(UsernewPassword))
								{	
									Information.getUser(Information.getvalidAccountNumberUser(UserInput)).changeUserPinCode(UsernewPassword);
									System.out.println("Pin Successfully updated");
									srujan.transactions.add(UserInput+" changed his pin to "+UsernewPassword);
									Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User changed his pin to "+UsernewPassword);
								}
								else
								{
									System.out.println("Entered pin is not 5 digit ");
									srujan.transactions.add(UserInput+ " tried updating his new pin, but failed ");
								}
								break;
					
						case 3:
								System.out.print("Enter the number of 2000's you are depositing : ");
								int tempMoney2000=x.nextInt();
								System.out.print("Enter the number of 500's you are depositing : ");
								int tempMoney500=x.nextInt();
								System.out.print("Enter the number of 200's you are depositing : ");
								int tempMoney200=x.nextInt();
								System.out.print("Enter the number of 100's you are depositing : ");
								int tempMoney100=x.nextInt();
								cash.set2000(tempMoney2000);
								cash.set500(tempMoney500);
								cash.set200(tempMoney200);
								cash.set100(tempMoney100);
								cash.UpdateMoney();
								double temporaryMoney=0;
								temporaryMoney+=tempMoney2000*2000 ;
								temporaryMoney+=tempMoney500*500;
								temporaryMoney+=tempMoney200*200 ;
								temporaryMoney+=tempMoney100*100;
								Information.getUser(Information.getvalidAccountNumberUser(UserInput)).setSavingsBalance(temporaryMoney);
								System.out.println("Money successfully deposited in Savings :)");
								srujan.transactions.add(UserInput+" desposited "+temporaryMoney+" to his savings ");
								Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User deposited "+temporaryMoney+" to his savings");
								break;
					
						case 4:
								System.out.print("Enter the number of 2000's you are depositing : ");
								int 	temp2Money2000=x.nextInt();
								System.out.print("Enter the number of 500's you are depositing : ");
								int temp2Money500=x.nextInt();
								System.out.print("Enter the number of 200's you are depositing : ");
								int temp2Money200=x.nextInt();
								System.out.print("Enter the number of 100's you are depositing : ");
								int temp2Money100=x.nextInt();
								cash.set2000(temp2Money2000);
								cash.set500(temp2Money500);
								cash.set200(temp2Money200);
								cash.set100(temp2Money100);
								cash.UpdateMoney();
								double temporary2Money=0;
								temporary2Money+=temp2Money2000*2000 ;
								temporary2Money+=temp2Money500*500;
								temporary2Money+=temp2Money200*200 ;
								temporary2Money+=temp2Money100*100;
								Information.getUser(Information.getvalidAccountNumberUser(UserInput)).setCurrentBalance(temporary2Money);
								System.out.println("Money Successfully deposited in Current :)");
								srujan.transactions.add(UserInput+" deposited "+temporary2Money+" to his current account");
								Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User deposited "+ temporary2Money+" to his current");
								break;
						case 5:
								System.out.print("Enter the amount you want to withdraw from savings account(multiple of hundred only) : ");
								double withdrawlAmount=x.nextDouble();
								if(currentUser.getSavingsBalance()>=Information.getSavingsMinBalance()+withdrawlAmount)
								{
									if(cash.getMoney()>=withdrawlAmount)
									{
										if(cash.arrange(withdrawlAmount))
										{
											System.out.println("Withdrawl successfull ");
											srujan.transactions.add(UserInput+" has withdrawn "+withdrawlAmount+" from his savings");
											Information.getUser(Information.getvalidAccountNumberUser(UserInput)).setSavingsBalance(-withdrawlAmount);
											Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User withdrawn "+withdrawlAmount+" from his savings");
										}
										
										else
										{
											System.out.println("SORRY FOR THE INCONVINIENCE , ATM DOESNT HAVE SUFFICIENT TO DISPENSE MONEY");
											srujan.transactions.add(UserInput+" has tried to withdraw money,but ATM couldnt accomodate");
										}
										
									}
									else
									{
										System.out.println("You cant withdraw this much money :)");
										srujan.transactions.add(UserInput+" was trying withdraw more money violates rules");
									}
								}
								
								break;
						case 6:
							System.out.print("Enter the amount you want to withdraw from current account(multiple of hundred only) : ");
							withdrawlAmount=x.nextDouble();
							if(currentUser.getCurrentBalance()>=Information.getCurrentMinBalance()+withdrawlAmount)
							{
								if(cash.getMoney()>=withdrawlAmount)
								{
									if(cash.arrange(withdrawlAmount))
									{
										srujan.transactions.add(UserInput+" has withdrwan "+withdrawlAmount+" from his savings account");
										System.out.println("Withdrawl successfull ");
										Information.getUser(Information.getvalidAccountNumberUser(UserInput)).setCurrentBalance(-withdrawlAmount);
										Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User has withdrawn "+withdrawlAmount+" from his current");
									}
									
									else
									{
										srujan.transactions.add(UserInput+" has tried withdrawing money but ATM couldnt process");
										System.out.println("SORRY FOR THE INCONVINIENCE , ATM DOESNT HAVE SUFFICIENT TO DISPENSE MONEY");
									}
								}
								else
								{
									srujan.transactions.add(UserInput+" tried drawing more money violates rules from current account");
									System.out.println("You cant withdraw this much money :)");
								}
							}
								break;
						case 7:
								System.out.print("From where do you want to transfer money (1/Savings 2/Current) : ");
								int TransferOption=x.nextInt();
								System.out.print("Enter the amount to be Transferred : ");
								double TransferAmount=x.nextDouble();
								System.out.println("Enter the Account number you want to transfer to : ");
								String TransferRecipAcc=x.next();
								System.out.print("Enter the reciving account number type(1/savings 2/current) : ");
								int TransferRecipType=x.nextInt();
								if(Information.validAccountNumber(TransferRecipAcc))
								{
									if(TransferOption==1)
									{
										if(currentUser.getSavingsBalance()>=Information.getSavingsMinBalance()+TransferAmount)
										{
											Information.getUser(Information.getvalidAccountNumberUser(UserInput)).setSavingsBalance(-TransferAmount);
											System.out.println("Transaction done :)");
											
											if(TransferRecipType==1)
											{
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).addToMini(UserInput+" transferred "+TransferAmount+" from his Savings to "+TransferRecipAcc+"'s "+"Savings" );
												Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini(UserInput+" transferred "+TransferAmount+" from his Savings to "+TransferRecipAcc+"'s "+"Savings" );
												srujan.transactions.add(UserInput+" transferred "+TransferAmount+" from his Savings to "+TransferRecipAcc+"'s "+"Savings" );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).setSavingsBalance(TransferAmount);
											}
											else
											{
												Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini(UserInput+" transferred "+TransferAmount+" from his Savings to "+TransferRecipAcc+"'s "+"current " );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).addToMini(UserInput+" transferred "+TransferAmount+" from his Savings to "+TransferRecipAcc+"'s "+"current " );
												srujan.transactions.add(UserInput+" transferred "+TransferAmount+" from his Savings to "+TransferRecipAcc+"'s "+"current" );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).setCurrentBalance(TransferAmount);
											}
										}
										else
										{
											srujan.transactions.add(UserInput+" tried transferring more money");
											System.out.println("Your savings account doesnt have enough amount to process this transaction");
										}
									}
									else
									{
										if(currentUser.getCurrentBalance()>=Information.getCurrentMinBalance()+TransferAmount)
										{
											Information.getUser(Information.getvalidAccountNumberUser(UserInput)).setCurrentBalance(-TransferAmount);
											System.out.println("Transaction done :)");
											if(TransferRecipType==1)
											{
												Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini(UserInput+" transferred "+TransferAmount+" from his current to "+TransferRecipAcc+"'s "+"Savings" );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).addToMini(UserInput+" transferred "+TransferAmount+" from his current to "+TransferRecipAcc+"'s "+"Savings" );
												srujan.transactions.add(UserInput+" transferred "+TransferAmount+" from his current to "+TransferRecipAcc+"'s "+"Savings" );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).setSavingsBalance(TransferAmount);
											}
											else
											{
												srujan.transactions.add(UserInput+" transferred "+TransferAmount+" from his current to "+TransferRecipAcc+"'s "+"current" );
												Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini(UserInput+" transferred "+TransferAmount+" from his current to "+TransferRecipAcc+"'s "+"current" );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).addToMini(UserInput+" transferred "+TransferAmount+" from his current to "+TransferRecipAcc+"'s "+"current" );
												Information.getUser(Information.getvalidAccountNumberUser(TransferRecipAcc)).setCurrentBalance(TransferAmount);
												
											}
										}
										else
										{
											srujan.transactions.add(UserInput+" tried transferring more money");
											System.out.println("Your Current account doesnt have enough amount to process this transaction");
										}
									}
								}
								else 
								{
									srujan.transactions.add(UserInput+" tried transferring ,but entered wrong ");
									System.out.println("Entered Detail(s) are incorrect");
								}
								break;
						case 8 :
							Information.getUser(Information.getvalidAccountNumberUser(UserInput)).UserMiniStatement();
								break;
						case  9 :
								System.out.print("Enter the account number of the Familymember you want to access : ");
								String reqAccessAcc = x.next();
								if(Information.validAccountNumber(reqAccessAcc))
								{
									System.out.println("Wait until "+reqAccessAcc +" approves your request .");
									Information.getUser(Information.getvalidAccountNumberUser(reqAccessAcc)).addToRequest(UserInput);
								
								}
								else 
								{
									System.out.println("This account doesnt exist :( ");
								}
								break;
						case 10 :
								System.out.println("the system will show all the accounts which asked to grant their request");
								System.out.println("Press 1 to approve and 2 to disaprove");
								int temporarySize=Information.getUser(Information.getvalidAccountNumberUser(UserInput)).getSize();
								int[] que = new int[temporarySize];
								for(int i=0;i<temporarySize;i++)
								{	que[i]=x.nextInt();}
								Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToApproved(que);
								System.out.println("Action completed");
								break;
						case 11 :
								System.out.print("Enter the FamilyMember account form which u wanna withdraw money : ");
								String withdrawFamAcc=x.next();
								if(Information.getUser(Information.getvalidAccountNumberUser(UserInput)).Check(withdrawFamAcc))
								{
									System.out.println("Due to security reasons you can only withdraw money from savings");
									System.out.print("Enter the amount you want to wthdraw ");
									double FamAccwithdrawl=x.nextDouble();
									
									if(Information.getUser(Information.getvalidAccountNumberUser(withdrawFamAcc)).getSavingsBalance()>=Information.getSavingsMinBalance()+FamAccwithdrawl)
									{
										if(cash.getMoney()>=FamAccwithdrawl)
										{
											if(cash.arrange(FamAccwithdrawl))
											{
												System.out.println("Withdrawl successfull ");
//												srujan.transactions.add(UserInput+" has withdrawn "+withdrawlAmount+" from his savings");
												Information.getUser(Information.getvalidAccountNumberUser(withdrawFamAcc)).setSavingsBalance(-FamAccwithdrawl);
//												Information.getUser(Information.getvalidAccountNumberUser(UserInput)).addToMini("User withdrawn "+withdrawlAmount+" from his savings");
											}
											
											else
											{
												System.out.println("SORRY FOR THE INCONVINIENCE , ATM DOESNT HAVE SUFFICIENT TO DISPENSE MONEY");
												srujan.transactions.add(UserInput+" has tried to withdraw money,but ATM couldnt accomodate");
											}
											
										}
										else
										{
											System.out.println("You cant withdraw this much money :)");
											srujan.transactions.add(UserInput+" was trying withdraw more money violates rules");
										}
									}
									
								}
								else {System.out.println("YOU DONT HAVE ACCESS TO THIS ACCOUNT");}
								break;
						default:
							srujan.transactions.add(UserInput+" entered invalid input ");
							System.out.println("USER INPUT IS INVALID");
							break;
					
						}
					}
					else
					{
						srujan.transactions.add(UserInput+" tried logging in by wrong password ");
						System.out.println("Entered pincode is incorrect");
					}
	
				}
				else
				{
					
					System.out.println("Your login is  cancelled ");
					System.out.println("You  entered incorrect account number");
				}
			}
		
		}
		x.close();
	}
}
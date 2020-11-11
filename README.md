### ATM
ATM after updating common and individual constraints

This ATM has an admin and Cashmanagement System.

Admin can do the following tasks :


     *Admin can view all transactions 
     *Add money to ATM in denominations 
     *Remove money from ATM in denominations
     *Can change his password.
     *Can view the current state of Cash in the ATM(in denominations)
     *Can SHUTDOWN the ATM (ONly Admin can do this ) 


*ATM identifies Admin i.e.,when ATM asks for Account number of the user . Admin enters his password (Only insiders know this)*


User after entering his account details ,he can only proceed forward if he enters a valid account number and later he is asked to enter pin code, of he enters correct pincode he can proceed further or else ATM restarts



1.Only Admin is given the option to stop ATM 

2.Users have the following options

     1.Withdraw money to savings account
     2.deposit money to current account
     3.withdraw money from current account
     4.deposit money to savings account
     5.He change his pin only if the changed pin is 5 digited(valid)
     6.He can also view his balance in savings and current account
     7.Also he can transfer money to different accounts and different account types
     8.User can request His family members to grant access to withdraw money from their savings account
     9.If User received any family withdrawl requests , he can approve them here,
     10.After approval ,User can withdraw money from his family members account.
--->Admin can
     - change his password
     - add money in denominations
     - remove money in denominations
     - view all transactions
         -its a string arraylist which is updated when there is an activity of the users
     - can also view the currents state of the ATM

----> As we all know ATM doesnt have infinite money ,so ATM here only allows withdrawal if the money inputed + Minbalance<=current balance and also if the ATM can give money in the denominations it has .(suppose asked for 500,if ATM has only 1 2000,then ATM cant proceed transaction).

--->these are the main features of my ATM.

AFTER SENDING A MAIL TO EASHAN SIR, SIR ADVISED ME TO DO ONLY COMMON CONSTRAINTS . I HAVE DONE 6 OF THEM(atleast 3) LEAVING DATABASE.

NEW FEATURES :

---> Added Family Access withdrwal

---> Added password encryption

---> Updated Transfer Option

---> Added OTP (double verfication)

---> Added Ministatement

---> Updated The option to change pin(both for admin as well as user)


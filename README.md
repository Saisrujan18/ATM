# ATM
ATM after updating common and individual constraints

# CS19B043_ATM_PM2
CS19B043's ATM

This ATM has an admin who should add money in denominations of 2000,500,200,100 .
Admin can view all transactions , add money to ATM ,remove money from ATM and also can change his password.

ATM identifies Admin i.e.,when ATM asks for Account number of the user . Admin enters his password (Only insiders know this)

User after entering his account details ,he can only proceed forward if he enters a valid account number and later he is asked to enter pin code, of he enters correct pincode he can proceed further or else ATM restarts


---->Only Admin is given the option to stop ATM 
---->Users have the following options
     --->Withdraw money to savings account
     --->deposit money to current account
     --->withdraw money from current account
     ---->deposit money to savings account
     ---->He change his pin only if the changed pin is 5 digited(valid)
    ---->He can also view his balance in savings and current account
    -----> Also he can transfer money to different accounts and different account types

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


package anyTimeMoney;

class CashManagement 
{
	private static int notes_2000=0;
	private static int notes_500=0;
	private static int notes_200=0;
	private static int notes_100=0;
	private static double money=0;
	
	public void set2000(int i){notes_2000+=i;}
	public void set500(int i){notes_500+=i;}	
	public void set200(int i){notes_200+=i;}
	public void set100(int i){notes_100+=i;}
	public void setMoney(double i) {money+=i;}
	
	
	public int get2000(){return notes_2000;}
	public int get500(){return notes_500;}
	public int get200(){return notes_200;}
	public int get100(){return notes_100;}
	public double getMoney() {return money;}

	public void UpdateMoney(){money=notes_2000*2000+notes_500*500+notes_200*200+notes_100*100;}

	public boolean arrange(double i)
	{
		if(i%100==0)
		{
			int count2000=0;
			int count500=0;
			int count200=0;
			int count100=0;
			while(i>=2000 && notes_2000!=0)
			{
				i-=2000;
				notes_2000--;
				count2000++;
			}
			while(i>=500 && notes_500!=0)
			{
				i-=500;
				notes_500--;
				count500++;
			}
			while(i>=200 && notes_200!=0)
			{
				i-=200;
				notes_200--;
				count200++;
			}
			while(i>100 && notes_100!=0)
			{
				i-=100;
				notes_100--;
				count100++;
			}
			if(i==0)
			{
				return true;
			}
			else
			{
				notes_2000+=count2000;
				notes_500+=count500;
				notes_200+=count200;
				notes_100+=count100;
				return false;
			}
		}
		return false;
	}
}
package anyTimeMoney;

class Encryption
{
	public static String encryptAdmin(String s)
	{
		String encrypted="getout";
		for(int i=s.length()-1;i>=0;i--)
		{
			encrypted+=String.valueOf(s.charAt(i));
		}
		encrypted+="wiuvviubwiuwevvwbvweivbw";
		return encrypted;
	}
	public static String decrypt(String s)
	{
		String decrypted =s.substring(6, s.length()-24);
		String de="";
		for(int i=decrypted.length()-1;i>=0;i--)
		{
			de+=String.valueOf(decrypted.charAt(i));
		}
		return de;
	}
	
	public static int encrypt(int i)
	{
		int encrypt=0;
		while(i!=0)
		{
			encrypt+=(i%10);
			encrypt*=10;
			i/=10;
		}
		encrypt+=99999;
		return encrypt;
	}
	
	public static int decrypt(int i)
	{
		int decrypt=i-99999;
		return decrypt/10;
	}
}
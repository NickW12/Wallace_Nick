
import java.util.Scanner;
public class GameGun
{
	static int bulletCount = 96;
	static int CLIPSIZE = 16;
	static int shotCount = 16;
	static String [] clip = new String [16];
	
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("No more bullets");
		resetClip();
		while (bulletCount > 0 || shotCount > 0)
		{
			System.out.println("Action Needed ");
			String action = kb.nextLine().toUpperCase();
			
			if (action.equals("R"))
			{
				reload();
			}
			if (action.equals("S"))
			{
				System.out.println(shoot());
			}
			printClip();
		}
	}
	
	public static void resetClip()
	{
		for (int i = 0; i < clip.length; i++)
		{
			clip[i] = "[]";
		}
	}
	
	public static String shoot()
	{
		if (shotCount > 0)
		{
			clip[shotCount-1] = "[]";
			shotCount -= 1;
			System.out.println("Boom!!!");
		}
		else
		{
			System.out.println("Reload!!!");
		}
		return "";
	}
	
	public static void reload()
	{
		if (bulletCount >= CLIPSIZE)
		{
			bulletCount -= CLIPSIZE;
			shotCount = CLIPSIZE;
		}
		else
		{
			shotCount = bulletCount;
			bulletCount = 0;
		}
		resetClip();
		for (int i = 0; i < shotCount; i++)
		{
			clip[i] = " * ";
		}
		
	}
	
	public static void printClip()
	{
		String output = "";
		output = "Bullets" + bulletCount + "Clip";
		for (int i = 0; i < CLIPSIZE; i++)
		{
			output += clip[i];
		}
		System.out.println(output);
	}
}

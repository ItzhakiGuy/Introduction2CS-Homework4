/**
* Course: Intro To Computer Science
* Homework: 4
* Task: 4+5
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/

// Grade: 10.0
public class CodeOps 
{
	//Returns the given word with the encryption with the code key
	public static String Encode (String orig,int code)
	{
		String secret="";
		char curlet;
		for (int i=0; i<orig.length(); i++)
		{
			if (orig.charAt(i)>='a' && orig.charAt(i)<='z')
			{
				curlet=(char)(((orig.charAt(i)+code-'a')%26)+'a');
				secret=secret+curlet;
			}
			else
				if (orig.charAt(i)>='A' && orig.charAt(i)<='Z')
				{
					curlet=(char)(((orig.charAt(i)+code-'A')%26)+'A');
					secret=secret+curlet;
				}
				else
					secret=secret+orig.charAt(i);
		}
		return secret;
	}

	//Returns the given word with the decryption with the code key
	public static String Decode (String sec,int code)
	{
		String ori="";
		char curlet;
		for (int i=0; i<sec.length(); i++)
		{
			if (sec.charAt(i)>='a' && sec.charAt(i)<='z')
			{
				if (sec.charAt(i)-code>='a')
					curlet=(char)(((sec.charAt(i)-code-'a')%26)+'a');
				else
					curlet=(char)((('z'+sec.charAt(i)-code-'a'-'a'+1)%26)+'a');
				ori=ori+curlet;
			}
			else
				if (sec.charAt(i)>='A' && sec.charAt(i)<='Z')
				{
					curlet=(char)(((sec.charAt(i)-code+'Z'-'A'-'A'+1)%26)+'A');
					ori=ori+curlet;
				}
				else
					ori=ori+sec.charAt(i);
		}
		return ori;
	}

	//Returns the given word with the decryption without a given key (Question 5)
	public static String Decode (String sec)
	{
		int[] count=new int[26];
		for (int i=0; i<sec.length(); i++)
			if (sec.charAt(i)>='a' && sec.charAt(i)<='z')
				count[sec.charAt(i)-'a']++;
		int maxcell=0;
		for (int i=1; i<count.length; i++)
			if (count[i]>count[maxcell]) 
				maxcell=i;
		int code=0;
		if (maxcell<'e'-'a')
			//code place is a letter before e means that the code passed z and find the key (letter+z-a-e) - can be written ((code+26)-4) for not writing in ASCII
			code=maxcell+'z'-'a'-'e'; 
		else
			//code place is a letter after e and find the key (letter-e) - can be written (code-4) for not writing in ASCII
			code=maxcell+'a'-'e';
		return Decode(sec, code);
	}


	public static void main(String[] args) 
	{
		String texti="";
		if (args.length==0) 
		{
			// Reads the text from standard input (typically, a user-supplied text file)
			texti=StdIn.readAll();	// This function reads all the text into one string
			System.out.println("Decoded: "+Decode(texti));
		}
		else
		{
			if (args.length==1) // Reads the text and decodes by finding the key
			{
				System.out.println("Decoded: "+Decode(args[0])); //Prints the Decoded word from given word and key
			}
			else
			{
				String text=args[0];
				int key=Integer.parseInt(args[1]);
				String cryp=Encode(text, key);
				System.out.println("Encoded: "+cryp); //Prints the Encoded word from given word and key
				System.out.println("Decoded: "+Decode(cryp, key)); //Prints the Decoded word from given word and key
			}
		}
	}
}
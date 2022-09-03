import java.rmi.*;
public class ManagementEmailsClient
{
	private static final String HOST = "localhost";
	public static void main(String[] args)
	{
		try
		{
			// Anazhtish toy apomakrysmenoy antikeimenoy kai metatropi thn
			// anafora toy se klash apomakrysmenhs diepafhs ManagementEmails
			ManagementEmails ref = (ManagementEmails) Naming.lookup("rmi://" + HOST + "/ManagementEmails");
			// Klhsh ton apomakrysmenon methodon
			String result = ref.getEmail("Panos");
			System.out.println("The email of the Panos is " + result);
			ref.putEmail("George","george@yahoo.com");
			System.out.println("The insertion of the George's email is OK");
			ref.removeEmail("John");
			System.out.println("The deletion of the John' email is OK");
			System.out.println("The email of the George is " + ref.getEmail("George"));
			System.out.println("The email of the John is " + ref.getEmail("John"));
		}
		catch (RemoteException re)
		{
			System.out.println("Remote Exception");
			re.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("Other Exception");
			e.printStackTrace();
		}
	}
}
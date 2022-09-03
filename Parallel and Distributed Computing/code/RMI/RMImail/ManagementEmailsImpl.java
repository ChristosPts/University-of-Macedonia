import java.rmi.*;
import java.rmi.server.*;
//import java.util.Hashtable;
import java.util.HashMap;

// H klash ayth ylopoiei thn apomakrysmenh diepafh ManagementEmails
public class ManagementEmailsImpl extends UnicastRemoteObject implements ManagementEmails
{
	//private Hashtable storeEmails;
	private HashMap<String, String> storeEmails;
	
	// Kataskeyasths
	public ManagementEmailsImpl() throws RemoteException
	{
		// Dhmioyrgia bashs dedomenon e-mails
		//storeEmails = new Hashtable();
		storeEmails = new HashMap<String, String>();
		storeEmails.put("Panos","panosm@uom.gr");
		storeEmails.put("John","johnf@gmail.com");
	}
	
	// Kodikas ylopoihshs ths apomakrysmenhs methodoy getEmail
	public String getEmail(String name) throws RemoteException
	{
		//return (String) storeEmails.get(name);
		return storeEmails.get(name);		
	}
	
	// Kodikas ylopoihshs ths apomakrysmenhs methodoy putEmail
	public void putEmail(String name, String email) throws RemoteException
	{
		storeEmails.put(name,email);
	}
	
	// Kodikas ylopoihshs ths apomakrysmenhs methodoy removeEmail
	public void removeEmail(String name) throws RemoteException
	{
		storeEmails.remove(name);
	}
}

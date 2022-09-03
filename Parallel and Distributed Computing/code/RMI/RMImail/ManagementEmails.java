import java.rmi.*;
public interface ManagementEmails extends Remote
{
	// ypografes ton apomakrysmenon methodon
	String getEmail(String name) throws RemoteException;
	void putEmail(String name, String email) throws RemoteException;
	void removeEmail(String name) throws RemoteException;
}
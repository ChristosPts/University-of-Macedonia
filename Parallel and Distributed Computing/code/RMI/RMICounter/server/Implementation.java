import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementation extends UnicastRemoteObject implements Interface{

	private static int CommVar;
	private static boolean first = true;
	
	public Implementation() throws RemoteException{
		super();
	}

	public synchronized void setCommVar() {
		if (first) {
			CommVar = 0;
			first = false;
		}
	}
	
	public synchronized void updateCommVar(int i) {
		CommVar += i;				
	}

	public synchronized int getCommVar() {
		return CommVar;
	}
	

}

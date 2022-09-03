import java.rmi.*;

public interface Addition extends Remote {
	
	// Ypografh ths apomakrysmenhs methodoy.
	public int add(int a, int b) throws RemoteException;
}

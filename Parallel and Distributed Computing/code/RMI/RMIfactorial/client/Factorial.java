import java.rmi.*;

public interface Factorial extends Remote {
	
	// Ypografh ths apomakrysmenhs methodoy.
	public int fact(int number) throws RemoteException;
}

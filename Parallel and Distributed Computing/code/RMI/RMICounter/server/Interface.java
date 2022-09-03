import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{

	void setCommVar() throws RemoteException;
	void updateCommVar(int i) throws RemoteException;
	int getCommVar() throws RemoteException;
	
}

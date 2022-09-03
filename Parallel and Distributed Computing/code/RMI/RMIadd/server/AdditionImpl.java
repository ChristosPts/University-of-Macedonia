import java.rmi.*;
import java.rmi.server.*;

public class AdditionImpl extends UnicastRemoteObject implements Addition {
	
	private static final long serialVersionUID = 1;

	public AdditionImpl() throws RemoteException {
	}
	
	public int add(int a, int b) throws RemoteException {
		return a+b;
	}
}

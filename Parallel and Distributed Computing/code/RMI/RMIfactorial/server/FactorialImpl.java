import java.rmi.*;
import java.rmi.server.*;

// H klash ayth ylopoiei thn apomakrysmenh diepafh Factorial.
public class FactorialImpl extends UnicastRemoteObject implements Factorial {
	
	private static final long serialVersionUID = 1;

	// Kataskeyasths.
	public FactorialImpl() throws RemoteException {
	}
	
	// Kodikas ylopoihshs ths apomakrysmenhs methodoy.
	public int fact(int number) throws RemoteException {
		int result = 1;
		for(int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}
}

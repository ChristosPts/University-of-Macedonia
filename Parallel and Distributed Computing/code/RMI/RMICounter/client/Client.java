import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private static final String HOST = "localhost";
	private static final int PORT = Registry.REGISTRY_PORT;
	
	
	public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException{
		
		Registry registry = LocateRegistry.getRegistry(HOST,PORT);
		String rmiObjName = "Counter";
		Interface iface = (Interface) registry.lookup(rmiObjName);

		iface.setCommVar();	
	
		for (int i=0; i<10000; i++) {
			System.out.println("The value of CommVar = " + iface.getCommVar());
			//System.out.println("Adding 1 to and sleeping for 3 secs");
			iface.updateCommVar(1);
			//Thread.sleep(3000);
		}

		System.out.println("Time is up, exiting...");
		
	}
	
}

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server {
	
	private static final String HOST = "localhost";
	private static final int PORT = Registry.REGISTRY_PORT;
	
	public static void main(String[] args) throws Exception {

		System.setProperty("java.rmi.server.hostname", HOST);		
		Implementation rObj = new Implementation();

		// Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		Registry reg = LocateRegistry.createRegistry(PORT);

		String rmiObjName = "Counter";
		reg.rebind(rmiObjName, rObj);
		System.out.println("Remote object bounded.");
 
		System.out.println("Press <Enter> for exit.");
		System.in.read();
		
		UnicastRemoteObject.unexportObject(rObj, true);
		reg.unbind(rmiObjName);
		System.out.println("Remote object unbounded.");
	}

}

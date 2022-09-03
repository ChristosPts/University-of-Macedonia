import java.rmi.*;
public class ManagementEmailsServer
{
	private static final String HOST = "localhost";
	public static void main(String[] args) throws Exception
	{
		// Dhmioyrgia antikeimenoy
		ManagementEmailsImpl robj = new ManagementEmailsImpl();
		// Eggrafh toy antikeimenoy sthn yphresia onomasias RMI
		// kato apo to onoma ManagementEmails
		String rmiObjectName = "rmi://" + HOST + "/ManagementEmails";
		Naming.rebind(rmiObjectName,robj);
	}
}
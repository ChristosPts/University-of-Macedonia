import java.io.*;

public class ClientProtocol {
    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));

    //Request comes from user input
    public String prepareRequest() throws IOException {
        System.out.print("Enter <number>' '<op>' '<number> or '!' for exit:");
        String theOutput = user.readLine();
        return theOutput;
    }

    //Reply goes to user screen
    public void processReply(String theInput) throws IOException {
        System.out.println("Message received from server: " + theInput);
    }
}
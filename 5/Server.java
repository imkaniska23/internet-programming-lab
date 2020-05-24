/**
 * Name: Revanth Reddy 
 * Roll: 16CS8027
**/

// A Java program for a Server 
import java.net.*; 
import java.io.*; 

public class Server 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null; 
	private DataOutputStream ou	 = null; 
	private DataInputStream input = null; 

	// constructor with port 
	public Server(int port) 
	{ 
		// starts server and waits for a connection 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted"); 

			// takes input from the client socket 
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
			ou = new DataOutputStream(socket.getOutputStream()); 
			input = new DataInputStream(System.in); 
			String line = ""; 

			// reads message from client until "Over" is sent 
			while (!line.equals("Over")) 
			{ 
				//reading message from client
				try
				{ 
					line = in.readUTF();
					if(!line.equals("Over"))
					{
						try {
							Integer x = Integer.parseInt(line);  
							System.out.println(x); 
							System.out.println("Received from Client "+ line); 
							line = "Doubled the Proper Number : "+ Integer.toString(x*2);
						} catch(NumberFormatException e){  
							line = "Client didn't send a Proper Number"; 
						}
						// sending message to client
						try
						{ 
							ou.writeUTF(line); 
						} 
						catch(IOException i) 
						{ 
							System.out.println(i); 
						} 
					}
				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				}
				
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Server server = new Server(5000); 
	} 
} 

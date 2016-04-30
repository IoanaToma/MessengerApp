import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static ServerSocket serverSocket;
    private static final int PORT = 1234;
 
    public static void main(String[] args)
    {   
        try
        {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e)
        {
            System.out.println("There was a problem setting up the port..");
            System.exit(1);
        }
        
        System.out.println("Server set up, waiting for clients!");
        
        do
        {
            Socket client = null;
            try 
            {
                client = serverSocket.accept();
            } 
            catch (IOException ex) 
            {
                System.out.println("The server could not accept the client!");
            }
            
            Connection handler = new Connection(client);
            handler.start();
            
        }while (true);
    }
}

class Connection extends Thread
{
    Socket client;
    String nickname;
    Scanner in;
    PrintWriter out;
 
    public Connection(Socket socket)
    {
        client = socket;
 
        try
        {
            in = new Scanner(client.getInputStream());
            out = new PrintWriter(client.getOutputStream(),true);
        }
        catch(IOException e){}
    }
 
    public void run()
    {
        nickname = in.nextLine();
        while(Memory.checkName(nickname) == false) //verifica sa nu fie folosit nickname-ul
        {
            out.println("Nickname is not available. Please choose another one!"); 
            nickname = in.nextLine();
        }
        out.println("Nick okay!"); 
        
        System.out.println(nickname + " is now connected!"); //pe server
        Memory.usersList.add(this); //adauga in lista
        Memory.broadcastUsersList();
        
        String message;
        do
        {
            message = in.nextLine();
            
            if(message.equals("Nick change coming"))
            {       
                boolean changeOk = false;
                message = in.nextLine();
                out.println("Nick change");
                while(!message.equals("Nick change canceled"))
                    if(Memory.changeNick(nickname, message) == false)
                    {
                        out.println("Nickname not available. Please try another one!");
                        message = in.nextLine();
                    }
                    else
                    {
                        out.println("Nick okay");
                        out.println(nickname);
                        changeOk = true;
                        break;
                    }
                out.println("Nick change canceled");
                if(changeOk == true)
                    Memory.broadcastUsersList();
            }
            else
                if(message.contains("*whisperreceiver*"))
                {   
                    String[] parts = message.split(" ");
                    if(Memory.searchUser(parts[1]) == null)
                        out.println("Whisper receiver not okay");
                    else
                        out.println("Whisper receiver okay");
                }
                else
                    if(message.contains("*whispermessage*"))
                    {   
                        String[] parts = message.split(" ");
                        Connection c = Memory.searchUser(parts[1]);
                        c.out.println(parts[0]);
                        out.println(parts[0]);
                        
                        message = "";
                        for(int i=1; i<parts.length; i++)
                            message = message + parts[i] + " ";
                        out.println(message);
                        
                        //my receiver's receiver is gonna be me
                        message = parts[2] + " ";
                        for(int i=2; i<parts.length; i++)
                            message = message + parts[i] + " ";
                        c.out.println(message);
                    }
                    else
                        Memory.broadcast(message);
            
        }while(!message.contains("Client wants to disconnect"));
        
        Memory.broadcast("\n" + nickname + " is now disconnected!\n");
        System.out.println(nickname + " is now disconnected!");
        
        for(int i=0; i<Memory.usersList.size(); i++)
            if(Memory.usersList.get(i).nickname == this.nickname)
            {
                Memory.usersList.remove(i);
                break;
            }
        
        Memory.broadcastUsersList();
        
        this.interrupt();
    }
}

class Memory
{
    static ArrayList<Connection> usersList = new ArrayList<Connection>();
    
    synchronized static void broadcast(String s)
    {
        Connection c;
        for(int i=0; i<usersList.size(); i++)
        {
            c = usersList.get(i);
            c.out.println(s);
        }
    }
    
    synchronized static void broadcastUsersList()
    {
        for(Connection c : usersList) 
        {   
            c.out.println("Online users");
            for(Connection c1 : usersList)
                c.out.println(c1.nickname); 
            c.out.println("End online users");
        } 
    }
    
    static boolean checkName(String name)
    {   
        for(int i=0; i<usersList.size(); i++)
            if(usersList.get(i).nickname.equals(name))
                return false;
        return true;
    }
    
    static boolean changeNick(String oldNick, String newNick)
    {
        if(checkName(newNick) == false)
            return false;
        
        Connection c = null;
        for(int i=0; i<usersList.size(); i++)
            if(usersList.get(i).nickname.equals(oldNick))
            {
                c = usersList.get(i);
                break;
            }
        c.nickname = newNick;
        return true;
    }
    
    static Connection searchUser(String name)
    {
        for(Connection c : usersList)
            if(c.nickname.equals(name))
                return c;
        return null;
    }
}

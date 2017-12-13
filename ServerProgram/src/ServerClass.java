
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ServerClass extends UnicastRemoteObject implements ServerInterface
{
    ServerClass()throws RemoteException
    {
        super();
    }
    Vector<String> v1=new Vector<String>();
    Vector<ClientInterface> v2=new Vector<ClientInterface>();
    @Override
    public void registerUser(ClientInterface ci,
            String name) throws RemoteException {
        System.out.println(name);
        v1.add(name);
        v2.add(ci);
        for(int i=0;i<v2.size();i++)
        {
            ClientInterface c=v2.get(i);
            c.refreshList(v1);
        }
        
    }
    public static void main(String[] args) {
        try{
        ServerClass ser=new ServerClass();
        Naming.rebind("chat", ser);
        System.out.println("Server Registered!!!");
        }catch(RemoteException | MalformedURLException e)
        {}
    }

    @Override
    public void sendMessage(String msg) throws RemoteException 
    {
        for(int i=0;i<v2.size();i++)
        {
            ClientInterface c=v2.get(i);
            c.refreshArea(msg);
        }
    }

    @Override
    public void removeUser(String name) throws RemoteException {
        int ind=v1.indexOf(name);
        v1.remove(ind);
        v2.remove(ind);
        for (ClientInterface c : v2) {
            c.refreshList(v1);
        }
    }
    
}

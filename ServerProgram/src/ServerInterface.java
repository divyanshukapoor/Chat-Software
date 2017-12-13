
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface 
        extends Remote
{
    void registerUser(ClientInterface ci,
            String name)
            throws RemoteException;
    void sendMessage(String msg)throws RemoteException;
    void removeUser(String name)throws RemoteException;
}

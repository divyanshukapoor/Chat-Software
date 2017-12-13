
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ClientClass extends UnicastRemoteObject implements ClientInterface
{
    JList l;
    JTextArea area;
    ClientClass(JList l,JTextArea area)throws RemoteException
    {
        super();
        this.l=l;
        this.area=area;
    }
    
    public void refreshArea(String msg)throws RemoteException
    {
        area.append(msg+"\n");
    }

    @Override
    public void refreshList(Vector<String> names) throws RemoteException 
    {
        l.setListData(names);
    }
    
}

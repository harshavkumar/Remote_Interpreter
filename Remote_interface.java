import java.rmi.*;

// Remote Interface

public interface Remote_interface extends Remote
{
String[] filename(String p) throws RemoteException;
byte[] filedata(String p) throws RemoteException;
}

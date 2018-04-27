import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

//Remote Implementation class

public class Implementation_class extends UnicastRemoteObject implements Remote_interface {

	String path;
	public String[] filename(String path) throws RemoteException
	{
	System.out.println("###remote method###");
	File file=new File(path);
	this.path=path;
	File[] files=file.listFiles();
	String str="";
	for(File i : files) {
	String name=i.getName();

if(i.isFile()) {
	str=str+name+":";
	}
	}
	return str.split(":");
	}
	public byte[] filedata(String filename) throws RemoteException
	{
	byte[] buffer=null;
	try {
	System.out.println("###remote method2###");
	String fullpath=path+"/"+filename;
	FileInputStream fis=new FileInputStream(fullpath);
	buffer=new byte[fis.available()];
	int index=0;
	while(true) {
	int var=fis.read();
	if(var==-1) break;
	buffer[index]=(byte)var;
	index++;
	}
	}
	catch(Throwable t) {
	System.out.println("error in Implementation_class "+t);
	}
	return buffer;
	}
	public Implementation_class() throws RemoteException
	{
	}
}

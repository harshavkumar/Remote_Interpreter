import java.rmi.*;
import java.util.*;
import java.io.*;

//Client Application

public class Reciever {
public static void main(String...args) {
try {
String url="rmi://192.168.225.32:63081//rmicodes";
Remote_interface ref=(JR)Naming.lookup(url);
Scanner sc=new Scanner(System.in);
System.out.print("enter a path :");
String path=sc.nextLine();
String[] data=ref.filename(path);
int i=1;
for(String str : data) {

System.out.println(i+":"+str);
i++;
}
System.out.print("enter file index :");
int index=sc.nextInt();
String actual_filename=data[index];
byte[] is=ref.filedata(actual_filename);
FileOutputStream fos=new FileOutputStream("d://"+data[index]);
for(byte ii : is) {
	fos.write(ii);
}
fos.close();
}
catch(Throwable  t) {
	System.out.println("error in Reciever "+t);
	t.printStackTrace();
}
}
}

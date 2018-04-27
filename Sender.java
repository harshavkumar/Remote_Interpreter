import java.rmi.*;

//Server Application

public class Sender {
public static void main(String...args) {
try {
String url="rmi://192.168.225.32:63081//rmicodes";
Implementation_class obj=new Implementation_class();
Naming.bind(url,obj);
System.out.println("Sender is waiting.....");
}
catch(Throwable  t) {
	System.out.println("error in Sender "+t);
}
}
}

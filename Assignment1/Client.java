import java.rmi.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String serverURL = "rmi://localhost/Server";
			ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
			System.out.println("Enter num1: ");
			double num1 = sc.nextDouble();
			System.out.println("Enter num2: ");
			double num2 = sc.nextDouble();
			System.out.println("Addition: " + serverIntf.addition(num1, num2));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
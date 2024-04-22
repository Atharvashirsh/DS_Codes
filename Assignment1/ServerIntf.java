import java.rmi.*;

interface ServerIntf extends Remote {
	// synt of meth declar: access_spec returntype met_name(arg)
	public double addition(double num1, double num2) throws RemoteException;
}
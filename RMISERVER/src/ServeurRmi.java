import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.BanqueRmiService;

public class ServeurRmi {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			BanqueRmiService od =new BanqueRmiService();
			System.out.println(od.toString());
			Naming.rebind("rmi://localhost:1099/BK", od);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

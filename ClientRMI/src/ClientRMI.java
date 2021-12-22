import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import metier.Compte;
import rmi.IbanqueRemote;

public class ClientRMI {
 public static void main(String[] args) {
	try {
		IbanqueRemote stub = (IbanqueRemote) Naming.lookup("rmi://localhost:1099/BK");
		System.out.println(stub.conversion(2000));
		System.out.println("Consultation d'un compte à distance");
		Compte cp =stub.consulterCompte(1);
		System.out.println("Code="+cp.getCode());
		System.out.println("Solde="+cp.getSolde());
		System.out.println("Date de sa creation est"+cp.getDateCreation());
		System.out.println("Liste des comptes");
		List<Compte> cptes =stub.listeComptes();
		for(Compte c:cptes) {
			System.out.println("Code="+c.getCode());
			System.out.println("Solde="+c.getSolde());
			System.out.println("Date de creation est"+c.getDateCreation());	
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}

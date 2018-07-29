package uiPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import manager.EncryptManager;;

public class UI {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static EncryptManager encryptManager = new EncryptManager();

	public static void main(String[] args) throws Exception 
	{
		int option = 0;
		
		do {
			System.out.println("Men\u00fa de escriptaci\u00f3n");
			System.out.println("Elija una opci\u00f3n para encriptar");
			System.out.println("1. Sim\u00e9trica");
			System.out.println("2. Asim\u00e9trica");
			System.out.println("3. QualityEncripter");
        	option = Integer.parseInt(br.readLine());
        	if (option >= 1 && option <= 4){
        		instantEncryptor(option);
        	}
		} while(option != 4);
	
	}
	
	public static void instantEncryptor(int option) throws Exception
	{
		encryptManager.instantEncryptor(option);
		showEncryptMenu();
	}
	
	public static void showEncryptMenu() throws Exception
	{
		int option = 0;
		
		do {
			System.out.println("Men\u00fa de escriptaci\u00f3n");
    		System.out.println("1.Crear llave");
        	System.out.println("2.Encriptar Mensaje");
        	System.out.println("3.Desencriptar Mensaje");
        	System.out.println("4.Salir");
        	option = Integer.parseInt(br.readLine());
        	if (option >= 1 && option <= 3){
        		executeAction(option);
        	}
    	} while (option != 4);
	}
	
	public static void executeAction(int option) throws Exception
	{
		if (option == 1){ 
			System.out.println("Key name: ");
			String name = br.readLine();
			encryptManager.createKey(name);
		}
		if (option == 2){
			System.out.println("Key name: ");
			String name = br.readLine();
			System.out.println("Message name: ");
			String messageName = br.readLine();
			System.out.println("Message: ");
			String message = br.readLine();
			encryptManager.encryptMessage(messageName,message,name);		
		}
		if (option == 3){
			System.out.println("Key name: ");
			String keyName = br.readLine();
			System.out.println("Message name: ");
			String messageName = br.readLine();
			System.out.println("El mensaje era: ");
			System.out.println(encryptManager.decryptMessage(messageName, keyName));;			
		}
	}

}

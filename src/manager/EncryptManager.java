package manager;

import components.EncryptorComponent;
import components.EncryptorComponentFactory;
import enums.EncryptorType;

public class EncryptManager {
	private EncryptorComponent encriptor;
	
	public void instantEncryptor(int option)
	{
		switch (option) {
		case 1:
			encriptor = EncryptorComponentFactory.Create(EncryptorType.SYMETRIC);
			break;
		case 2: 
			encriptor = EncryptorComponentFactory.Create(EncryptorType.ASYMETRIC);
			break;
		case 3: 
			encriptor = EncryptorComponentFactory.Create(EncryptorType.QUALITY);
			break;			
		default: 
			encriptor = null;
			break;
		}
	}
	
	public void createKey(String name) throws Exception
	{
		encriptor.createKey(name);
	}
	
	public void encryptMessage(String messageName, String message, String keyName) throws Exception
	{
		encriptor.encryptMessage(messageName, message, keyName);
	}
	
	public String decryptMessage(String messageName, String keyName) throws Exception
	{
		return encriptor.decryptMessage(messageName, keyName);
	}
	
}

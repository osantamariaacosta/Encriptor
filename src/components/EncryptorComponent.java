package components;


public abstract class EncryptorComponent {
	
	public abstract void createKey(String name) throws Exception;
	
	public abstract void encryptMessage(String messageName, String message, String keyName) throws Exception;
	
	public abstract void decryptMessage(String messageName, String keyName) throws Exception;
	
}

package components;


public abstract class EncryptorComponent {
	
	public abstract void createKey(String name) throws Exception;
	
	public abstract void encryptMessage(String messageName, String message, String keyName) throws Exception;
	
	public abstract String decryptMessage(String messageName, String keyName) throws Exception;
	
}

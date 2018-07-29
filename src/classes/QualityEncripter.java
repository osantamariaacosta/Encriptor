package classes;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import components.EncryptorComponent;

import java.util.Base64;

public class QualityEncripter extends EncryptorComponent {
	
	private static String textoEncriptado = new String();
    String base64EncryptedString = "";
	

	@Override
	public void createKey(String name) throws Exception 
	{
		
	}	
	
	public QualityEncripter() {
		
	}

	@Override
	public void encryptMessage(String messageName, String texto, String keyName) throws Exception
	{

        String secretKey = "qualityinfosolutions"; //llave para encriptar datos

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            base64EncryptedString = new String(base64Bytes);
            textoEncriptado = base64EncryptedString;
    	    System.out.println("El mensaje encriptado: ");
    		System.out.println(textoEncriptado);

        } catch (Exception error) {
        	System.out.println("Quality clase metodo encriptar");
        	System.out.println(error);
        	System.out.println(error.getMessage());
        }
	}
	
	
	@Override	
	public String decryptMessage(String messageName, String keyName) throws Exception 
	{

        String secretKey = "qualityinfosolutions"; //llave para desenciptar datos

        try {
            byte[] message = Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");
    		return base64EncryptedString;
            

        } catch (Exception error ) {
        	System.out.println("Quality clase metodo encriptar");
        	System.out.println(error);
        	System.out.println(error.getMessage());
        	return "mensaje no desencriptado";
        }
		
        
	}
		
	
}

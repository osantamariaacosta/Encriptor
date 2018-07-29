package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import components.EncryptorComponent;
import components.EncryptorComponentFactory;
import enums.EncryptorType;

public class Asymmetric {

	EncryptorComponent asymme;
	
	@Before
	public void inicialize()
	{
		asymme = EncryptorComponentFactory.Create(EncryptorType.ASYMETRIC);
	}
	
	
	@Test
	public void returnEncripterStrign() throws Exception {
		
		String mensaje = "prueba";
		assertTrue(mensaje.equals(asymme.decryptMessage("mensaje", "Test")));
	}

}

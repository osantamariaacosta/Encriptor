package components;

import classes.Symmetric;
import classes.Asymmetric;
import classes.QualityEncripter;
import enums.EncryptorType;

public class EncryptorComponentFactory {
	
	public static EncryptorComponent Create(EncryptorType pType)
	{
		switch (pType) {
		case SYMETRIC:
			return new Symmetric();
		case ASYMETRIC: 
			return new Asymmetric();
		case QUALITY: 
			return new QualityEncripter();
		default: 
			return null;
		}
	}
	
}

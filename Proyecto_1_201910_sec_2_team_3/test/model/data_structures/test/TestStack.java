package model.data_structures.test;

import org.junit.Before;

import junit.framework.TestCase;
import model.data_structures.ColaEstructura;
import model.data_structures.PilaEstructura;;

public class TestStack extends TestCase {
	
	
	private PilaEstructura<Integer> pila; 
	
	
	@Before
	public void setUp()
	{
		pila = new  PilaEstructura<Integer>();
		pila.push(1);
		pila.push(2);
		pila.push(3);
		
		
		
	}
	
	public void testPush()
	{
		pila.push(10);
		assertEquals("Error en el último", 10 , pila.pop().intValue());
	}
	public void testPop()
	{
		assertEquals("Error al agregar", 3 , pila.pop().intValue());
	}
	
	

}
package model.data_structures.test;

import org.junit.*;
import junit.framework.TestCase;
import model.data_structures.ListaDobleEnlazada;

public class TestListaEnlazada extends TestCase {
	
	ListaDobleEnlazada<Integer> lista;
	
	@Before
	public void setUp () {
		lista = new ListaDobleEnlazada<Integer> ();
		lista.add(12);
		lista.add(45);
		lista.add(3453);
		lista.addAtEnd(547);
		lista.addAtEnd(54);
		lista.addAtK(67, 0);
		lista.addAtK(69, 3);
	}
	
	public void testgetElement () {
		setUp();
		assertEquals ("Dato no esperado", 54, lista.getElement(4).intValue());
	}
	
	public void testSize () {
		setUp();
		assertEquals("Dato no esperado", 7, lista.getSize().intValue());
	}
	
	public void testAdd () {
		setUp();
		try {
			lista.add(25);
		}catch (Exception e) {
			e.printStackTrace();
			fail (" Se deberia agregar el elemento 25 en la lista ");
		}
	}
	
	public void testAddEnd () {
		setUp();
		try {
			lista.addAtEnd(4);
		}catch (Exception e) {
			e.printStackTrace();
			fail ("Se deberia agregar al final de la lista el elemento 4");
		}
	}
	
	public void testAddK () {
		setUp();
		try {
			lista.addAtK(84, 5);
		}catch (Exception e) {
			e.printStackTrace();
			fail ("Deberia añadirse en la posicion 5 de la lista el elemento 84");
		}
	}
	
	public void testDelete () {
		setUp();
		try {
			lista.delete(547);
		}catch (Exception e) {
			e.printStackTrace();
			fail ("Deberia eliminarse el elemento de tipo int 547 contenido en la lista");
		}
	}
	
	public void testDeleteAtK () {
		setUp();
		try {
			lista.deleteAtK(0);
		}catch (Exception e) {
			e.printStackTrace();
			fail ("Deberia eliminarse el elemento en la posicion 0 contenido en la lista");
		}
	}

}

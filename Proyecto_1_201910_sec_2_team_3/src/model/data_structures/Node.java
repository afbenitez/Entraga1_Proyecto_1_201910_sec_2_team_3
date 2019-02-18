package model.data_structures;


public class Node <T> {

	//Constante serializacion
	private final static long serialVersionUID = 1L;

	//-------------------------------------------------
	// Atributos
	//-------------------------------------------------

	/**
	 * Declaracion de nodos
	 */

	// Nodo anterior

	private Node <T> anterior;

	// Nodo siguiente 

	private Node <T> siguiente;

	private T elemento;

	//-------------------------------------------------
	// Constructor
	//-------------------------------------------------

	public Node (T pTipo) 
	{
		anterior = null;
		siguiente=null;
		elemento = pTipo;
	}

	//-------------------------------------------------
	// Metodos
	//-------------------------------------------------

	public T darElemento()
	{
		return elemento;
	}
	public Node <T> darAnterior ()
	{
		return anterior;
	}

	public Node <T> darSiguiente () 
	{
		return siguiente;
	}

	public void cambiarAnterior (Node <T> pAnterior) 
	{
		anterior = pAnterior;
	}

	public void cambiarSiguiente (Node <T> pSiguiente)
	{
		siguiente = pSiguiente;
	}

}

package model.data_structures;


import java.util.Iterator;

public class PilaEstructura <T> implements IStack<T> {

	//-------------------------------------------------
	// Atributos
	//-------------------------------------------------


	// Primer nodo
	Node <T> primero;

	// Tamaño de la lista
	private int tamanio;

	@Override
	public Iterator <T> iterator()
	{
		// TODO Auto-generated method stub
		Iterator <T> i = null;

		Node<T> act = primero;

		while (act != null){
			act = (Node<T>) primero.darSiguiente();
			i = (  (Iterator<T>) act );
		}
		return i;
	}

	public PilaEstructura() 
	{
		primero = null;
		tamanio = 0;
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return primero==null;
	}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return tamanio;
	}

	@Override
	public void push(T t) 
	{
		// TODO Auto-generated method stub
		if (primero == null) 
		{
			primero = new Node<T>(t);
			tamanio++;
		}
		else 
		{
			Node <T> pushed = new Node<T>(t);
			pushed.cambiarSiguiente(primero);
			primero = pushed;
			tamanio++;
		}
		
	}

	@Override
	public T pop() 
	{
		// TODO Auto-generated method stub

		Node <T> pop = primero;
		if(tamanio == 1)
		{
			primero = null;
			tamanio--;
			return pop.darElemento();
		}

		else
		{
			primero = primero.darSiguiente();
			tamanio--;
			return pop.darElemento();
		}

	}

}

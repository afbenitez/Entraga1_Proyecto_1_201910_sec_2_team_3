package model.data_structures;


import java.util.Iterator;

public class ColaEstructura  <T> implements IQueue<T>
{

	// Nodo anterior 
	Node<T> nodoAnterior;

	// Nodo siguiente
	Node <T> nodoSiguiente;

	// Primer nodo
	Node<T> primero;

	// Último nodo
	Node<T> ultimo;

	private int tamaño;



	public ColaEstructura() 
	{
		// TODO Auto-generated constructor stub
		tamaño = 0;
		primero = null;
		ultimo = null;
	}

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

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return primero == null;
	}


	public int size() 
	{
		return tamaño;
	}



	public void enqueue(T t)
	{
		if(primero == null)
		{
			primero = new Node<T>(t);
			ultimo = primero;

		}
		else
		{
			ultimo.cambiarSiguiente(new Node<T>(t)); 
			ultimo = ultimo.darSiguiente();
		}
		tamaño++;
	
	}

	public T darUltimo()
	{
		return ultimo.darElemento();
	}


	public T dequeue()
	{
		Node<T> sacada = primero;

		primero = primero.darSiguiente();
		tamaño--;
		return  sacada.darElemento();
	}
}
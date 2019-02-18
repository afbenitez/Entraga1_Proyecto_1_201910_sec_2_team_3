package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDobleEnlazada<T> implements ILinkedList<T> {

	/**
	 *  Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Node<T> primerNodo;

	private int cantidadElementos;

	private Node<T> actual;

	/**
	 * Construye una lista vacia
	 * <b>post:< /b> se ha inicializado el primer nodo en null
	 */
	public ListaDobleEnlazada() 
	{
		primerNodo = null;
		cantidadElementos = 0;
		actual = primerNodo;
	}

	/**
	 * Se construye una nueva lista cuyo primer nodo  guardará al elemento que llega por parámentro
	 * @param nPrimero el elemento a guardar en el primer nodo
	 * @throws NullPointerException si el elemento recibido es nulo
	 */
	public ListaDobleEnlazada(T nPrimero)
	{
		if(primerNodo == null)
		{
			throw new NullPointerException("Se recibe un elemento nulo");
		}
		primerNodo = new Node<T> (nPrimero);
		cantidadElementos = 1;
		actual = primerNodo;
	}


	@Override
	public Iterator<T> iterator() 
	{
		// TODO Auto-generated method stub
		return new IteratorLista<T> (primerNodo);
	}

	@Override
	public Node<T> darNodo(int pos) 
	{
		Node<T> actual = primerNodo;

		if(pos < 0 || pos > cantidadElementos)
		{
			throw new IndexOutOfBoundsException("Se está pidiendo el indice: " + pos + " y el tamaño de la lista es de " + cantidadElementos);
		}

		else
		{
			int posActual = 0;

			while(actual != null && posActual < pos)
			{
				actual = actual.darSiguiente();
				posActual ++;
			}
		}
		return actual;
		// TODO Auto-generated method stub


	}

	@Override
	public void add(T elem) 
	{
		// TODO Auto-generated method stub

		if(elem == null)
		{
			throw new NullPointerException("El elemento para agregar no existe");
		}

		else
		{
			if(primerNodo == null)
			{
				primerNodo =  new Node<T>(elem);
				cantidadElementos++;
			}
			if(!contains(elem))
			{

				Node<T> nuevo = new Node<T>(elem);
				nuevo.cambiarSiguiente(primerNodo);
				primerNodo = nuevo;
				cantidadElementos++;
			}

		}

	}

	@Override
	public void addAtEnd(T elem) {
		// TODO Auto-generated method stub
		if(elem == null)
		{
			throw new NullPointerException("El elemento para agregar no existe");
		}

		else
		{
			if(primerNodo == null)
			{
				primerNodo =  new Node<T> (elem);

				cantidadElementos++;
			}
			if(!contains(elem))
			{
				Node<T> ultimo = (Node<T>) darNodo(cantidadElementos-1);
				Node<T> nuevo = new Node<T>(elem);
				ultimo.cambiarSiguiente(nuevo);
				nuevo.cambiarAnterior(ultimo);

				cantidadElementos++;
			}

		}

	}

	@Override
	public void addAtK(T elem, int pos) {
		// TODO Auto-generated method stub

		if(pos < 0 || pos > getSize() )
			throw new IndexOutOfBoundsException("El elemento esta fuera de la lista");
		else if(elem == null)
			throw new NullPointerException("El elemento a agregar no existe");
		else if(primerNodo == null)
		{
			primerNodo = new Node<T>(elem);
			cantidadElementos++;
		}
		else
		{
			Node<T> nuevo = new Node<T> (elem);
			Node<T> anterior = (Node<T>) primerNodo;
			if(pos == 0)
			{
				anterior.cambiarAnterior(nuevo);
				nuevo.cambiarSiguiente(anterior);
				primerNodo = nuevo;
				cantidadElementos ++;
			}
			else if(pos == cantidadElementos)
			{
				addAtEnd(elem);
			}
			else
			{
				Node<T> siguiente = (Node<T>) darNodo(pos);
				nuevo = new Node<T> (elem);

				for(int i = 0; i<cantidadElementos-1; i++)
				{
					anterior = (Node<T>) anterior.darSiguiente();
				}
				nuevo.cambiarSiguiente(siguiente);
				nuevo.cambiarAnterior(anterior);
				anterior.cambiarSiguiente(nuevo);
				siguiente.cambiarAnterior(nuevo);
				cantidadElementos ++;
			}

		}


	}

	@Override
	public T getElement(int pos) 
	{
		// TODO Auto-generated method stub
		Node<T> actual = primerNodo;

		if(pos < 0 || pos > cantidadElementos)
		{
			throw new IndexOutOfBoundsException("Se está pidiendo el indice: " + pos + " y el tamaño de la lista es de " + cantidadElementos);
		}

		else
		{
			int posActual = 0;

			while(actual != null && posActual < pos)
			{
				actual = actual.darSiguiente();
				posActual ++;
			}
		}
		return (T) actual;
	}

	@Override
	public T getCurrentElement() {
		// TODO Auto-generated method stub
		return (T) actual;
	}

	@Override
	public Integer getSize() {
		// TODO Auto-generated method stub
		return cantidadElementos;
	}

	@Override
	public boolean delete(T elem) {

		// TODO Auto-generated method stub
		boolean elimino = false;

		if((Node<T>) primerNodo != null && contains(elem))
		{
			if(primerNodo.darElemento().equals(elem))
			{
				primerNodo = (Node<T>) primerNodo.darSiguiente();
				elimino = true;
				cantidadElementos--;
			}
			else if(primerNodo.equals(elem))
			{
				primerNodo = (Node<T>) primerNodo.darSiguiente();
				elimino = true;
				cantidadElementos--;
			}
			else if(getElement(cantidadElementos-1).equals(elem))
			{
				darNodo(cantidadElementos-2).cambiarSiguiente(null);
				elimino = true;
				cantidadElementos--;
			}
			else
			{
				Node<T> siguientes = (Node<T>) darNodo(cantidadElementos);
				Node<T> anterior = (Node<T>)primerNodo;
				int i = 0;
				while(i < cantidadElementos-1 && !elimino)
				{
					anterior = (Node<T>) anterior.darSiguiente();
					i++;
				}

				anterior.cambiarSiguiente(siguientes);
				siguientes.cambiarAnterior(anterior);
				cantidadElementos --;
				elimino = true;
			}
		}
		return elimino;

	}

	@Override
	public T deleteAtK(int pos) 
	{
		// TODO Auto-generated method stub
		T retornar = null;

		if( pos < 0 || pos >= getSize())
		{
			throw new IndexOutOfBoundsException("El indice seleccionado excede la lista");
		}
		else
		{
			if((Node<T>)primerNodo != null )
			{
				retornar = getElement(pos);
				if(pos == 0)
				{
					primerNodo = (Node<T>)primerNodo.darSiguiente();
					cantidadElementos --;
				}
				else if(pos == cantidadElementos - 1)
				{
					Node<T> anterior = (Node<T>)darNodo(cantidadElementos-2);
					anterior.cambiarSiguiente(null);
					cantidadElementos --;
				}
				else
				{
					Node<T> siguiente = (Node<T>)darNodo(pos+1);
					Node<T> anterior = (Node<T>)primerNodo;
					int i = 0;
					while(i < pos-1)
					{
						anterior = (Node<T>)anterior.darSiguiente();
						i ++;
					}
					anterior.cambiarSiguiente(siguiente);
					siguiente.cambiarAnterior(anterior);
					cantidadElementos --;
				}
			}
		}
		return retornar;
	}

	@Override
	public Node<T> next() 
	{
		// TODO Auto-generated method stub
		return actual.darSiguiente();
	}

	@Override
	public Node<T> previous() {
		// TODO Auto-generated method stub
		return actual.darAnterior();
	}

	public boolean contains(Object o) 
	{
		// TODO Completar según la documentación
		boolean tiene = false;

		if(primerNodo != null )
		{
			Node<T> actual = primerNodo;

			for(int i = 0  ; i < cantidadElementos && !tiene ; i ++)
			{
				if(actual.darElemento().equals(o))
				{
					tiene = true;
				}
				else if(actual.equals(o))
				{
					tiene = true;
				}

				actual = actual.darSiguiente();
			}
		}
		return tiene;
	}

}


class IteratorLista<T> implements Iterator<T>
{

	private Node<T> siguiente;

	public IteratorLista( Node<T> primero )
	{
		siguiente = primero;
	}

	public boolean hasNext( )
	{
		return siguiente != null;
	}

	public T next( )
	{
		if( siguiente == null )
		{ 
			throw new NoSuchElementException("No hay próximo"); 
		}
		
		T elemento = siguiente.darElemento(); 
		siguiente = siguiente.darSiguiente(); 
		return elemento;
	}
	

}

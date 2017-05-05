import java.util.Iterator;

class Stabel<T> implements Liste<T> {
	protected Node<T> start = null;

	protected class Node<T> {
		public T data;
		public Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	public int storrelse() {
		int i = 0;
		for (T n : this) {
			i++;
		}
		return i;
	}

	public boolean erTom() {
		if (storrelse() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void settInn(T element) {
		Node<T> temp = start;
		start = new Node(element);
		start.next = temp;
	}

	public T fjern() {
		if (start != null) {
			Node<T> temp = start;
			start = start.next;
			return temp.data;
		} else {
			return null;
		}
	}

	public Iterator<T> iterator() {
		return new StabelIterator(start);
	}

	class StabelIterator<T> implements Iterator<T> {
		Node<T> currentNext;

		public StabelIterator(Node<T> start) {
			currentNext = start;
		}

		public boolean hasNext() {
			if (currentNext == null) {
				return false;
			} else {
				return true;
			}
		}

		public T next() {
			T temp = currentNext.data;
			currentNext = currentNext.next;
			return temp;
		}
	}
}
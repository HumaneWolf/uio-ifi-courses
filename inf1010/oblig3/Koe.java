import java.util.Iterator;

class Koe<T> implements Liste<T> {
	protected Node<T> start = null;
	protected Node<T> end = null;

	protected class Node<T> {
		public T data;
		public Node<T> next = null;
		public Node<T> last = null;

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
		Node<T> temp = new Node(element);
		temp.last = end;
		if (temp.last != null) {
			temp.last.next = temp;
		}
		end = temp;
		if (start == null) {
			start = temp;
		}
	}

	public T fjern() {
		Node<T> temp = start;
		start = start.next;
		return temp.data;
	}

	public Iterator<T> iterator() {
		return new KoeIterator(start);
	}

	class KoeIterator<T> implements Iterator<T> {
		Node<T> currentNext;

		public KoeIterator(Node<T> start) {
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
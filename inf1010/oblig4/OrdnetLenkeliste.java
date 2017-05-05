import java.util.Iterator;

class OrdnetLenkeliste<T extends Comparable<T>> extends Stabel<T> { //Inherits that it has to implement iterable.
	//Extends since most of it is the same. Just the settInn() method and iterator that needs change.

	public OrdnetLenkeliste() {
		super();
	}

	@Override
	public void settInn(T element) {
		Node<T> temp = new Node(element);
		if (super.start == null) {
			super.start = temp;
		} else {
			OrdnetLenkelisteIterator iterator = new OrdnetLenkelisteIterator(super.start); //To access the custom method "nextNode()";
			Node<T> n = null;
			Node<T> last = null;
			while (iterator.hasNext()) {
				n = iterator.nextNode();
				if (n.data.compareTo(temp.data) >= 0) {
					temp.next = n;
					if (last != null) {
						last.next = temp;
					} else {
						start = temp;
					}
					break;
				} else if (n.next == null) {
					n.next = temp;
				}
				last = n;
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new OrdnetLenkelisteIterator<T>(super.start);
	}

	class OrdnetLenkelisteIterator<T> implements Iterator<T> {
		Node<T> currentNext;

		public OrdnetLenkelisteIterator(Node<T> start) {
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

		public Node<T> nextNode() {
			Node<T> temp = currentNext;
			currentNext = currentNext.next;
			return temp;
		}
	}
}
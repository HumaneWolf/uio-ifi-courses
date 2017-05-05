import java.util.Iterator;

class StatiskTabell<T> implements Tabell<T> {
	protected T[] tabell;

	public StatiskTabell(int size) {
		tabell = (T[]) new Object[size];
	}

	public int storrelse() {
		for (int i = 0; i < tabell.length; i++) {
			if (tabell[i] == null) {
				return i;
			}
		}
		//If it is full.
		return tabell.length;
	}

	public boolean erTom() {
		if (storrelse() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void settInn(T element) {
		int size = storrelse();
		if (size < tabell.length) {
			tabell[size] = element;
		} else {
			throw new FullTabellUnntak(tabell.length);
		}
	}

	public T hentFraPlass(int plass) {
		T temp = null;
		try {
			temp = tabell[plass];
			return temp;
		} catch (Exception e) {
			throw new UgyldigPlassUnntak(plass, storrelse());
		}
	}


	public Iterator<T> iterator() {
		return new StatiskTabellIterator(tabell, storrelse());
	}

	class StatiskTabellIterator<T> implements Iterator<T> {
		T[] tabell;
		int active = 0;
		int size;

		public StatiskTabellIterator(T[] tabell, int size) {
			this.tabell = tabell;
			this.size = size;
		}

		public boolean hasNext() {
			if (active < size) {
				return true;
			} else {
				return false;
			}
		}

		public T next() {
			active++;
			return tabell[active-1];
		}
	}
}
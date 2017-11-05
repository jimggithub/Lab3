package jimlab3;

/****************************************************************************
 * Queue Implementation
 *
 * @author Anabetsy Rivero
 * @version 1.0 created on 07/08/16 created for course CISC-0503 Summer 2016
 *          Data Structures and Algorithms created for instructor Dr. Jeremy
 *          Lanman
 *****************************************************************************/
public class QueueLL<T> implements Queue<T> {

	public QueueLL() {

	}

	public class node<T> {
		public node(T data, node next) {
			this.data = data;
			this.next = next;
		}

		public T data;
		public node next;
	}

	public node front, back;
	public int count;

	// Transformers/Mutators
	public void enqueue(T element) {
		node nn = new node(element, null);

		if (isEmpty())
			front = nn;
		if (back != null)
			back.next = nn;
		back = nn;
		count++;
	}

	public T dequeue() {
		if (isEmpty())
			return null;
		T frontItem = this.getFront();
		front = front.next;
		count--;
		if (count == 0)
			back = null;
		return frontItem;
	}

	public void makeEmpty() {
		front = back = null;
		count = 0;
	}

	// Observers/Accessors
	public T getFront() {
		if (isEmpty())
			return null;
		return (T) front.data;
	}

	@Override
	public int size() {
		return 0;
	}

	public int Size() {

		return count;
	}

	public boolean isEmpty() {

		return count == 0;
	}

	public boolean isFull() {

		return false;
	}

	public String toString() {
		String ret = "";
		node current = front;
		for (int i = 0; i < count; i++) {
			ret += current.data.toString() + ", ";
			current = current.next;
		}

		return ret;
	}
}
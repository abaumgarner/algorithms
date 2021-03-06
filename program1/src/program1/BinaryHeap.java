package program1;

import java.util.Arrays;

public class BinaryHeap {
	protected Node[] array;
	protected int size;

	public BinaryHeap() {
		array = new Node[10000];
		size = 0;
	}

	public void add(Node value) {
		if (size >= array.length - 1) {
			array = this.resize();
		}

		size++;

		int index = size;
		array[index] = value;

		bubbleUp();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Node peek() {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		return array[1];
	}

	public Node remove() {
		Node result = peek();

		array[1] = array[size];
		array[size] = null;
		size--;

		bubbleDown();

		return result;
	}

	public String toString() {
		return Arrays.toString(array);
	}

	protected void bubbleDown() {
		int index = 1;
		while (hasLeftChild(index)) {
			int smallerChild = leftIndex(index);

			if (hasRightChild(index)
					&& array[leftIndex(index)]
							.compareTo(array[rightIndex(index)]) < 0) {
				smallerChild = rightIndex(index);
			}

			if (array[index].compareTo(array[smallerChild]) < 0) {
				swap(index, smallerChild);
			} else {
				break;
			}

			index = smallerChild;
		}
	}

	protected void bubbleUp() {
		int index = this.size;

		while (hasParent(index) && parent(index).compareTo(array[index]) < 0) {
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}
	}

	protected boolean hasParent(int index) {
		return index > 1;
	}

	protected int leftIndex(int index) {
		return index * 2;
	}

	protected int rightIndex(int i) {
		return i * 2 + 1;
	}

	protected boolean hasLeftChild(int i) {
		return leftIndex(i) <= size;
	}

	protected boolean hasRightChild(int i) {
		return rightIndex(i) <= size;
	}

	protected Node parent(int i) {
		return array[parentIndex(i)];
	}

	protected int parentIndex(int i) {
		return i / 2;
	}

	protected Node[] resize() {
		return (Node[]) Arrays.copyOf(array, array.length * 2);
	}

	protected void swap(int index1, int index2) {
		Node tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
}

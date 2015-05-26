package program1;

public class Node {
	int number;
	int index;

	public Node(int num, int location) {
		this.number = num;
		this.index = location;
	}

	public String toString() {
		return this.index + " \t" + this.number;
	}

	public int getNumber() {
		return this.number;
	}

	public int getIndex() {
		return this.index;
	}

	public int compareTo(Node that) {
		return this.number - that.number;
	}
}

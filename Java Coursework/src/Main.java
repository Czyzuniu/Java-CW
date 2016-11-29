
public class Main implements Runnable {

	public void run() {

		InputReader inputReader = new InputReader();
		inputReader.order();
	}

	public static void main(String[] args) {

		new Thread(new Main()).start();

	}

}

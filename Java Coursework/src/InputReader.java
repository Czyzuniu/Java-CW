import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	private int width, height, length, grade, colours, type, quantity;
	private double totalCost;
	private boolean bottom, corner, sealed, orderCompleted;
	private Scanner reader;
	private ArrayList<BoxModel> boxes;
	private String another;

	public InputReader() {
		reader = new Scanner(System.in);
		boxes = new ArrayList<BoxModel>();
		quantity = 0;
		totalCost = 0;
		orderCompleted = false;
	}

	public void order() {

		while (!orderCompleted) {
			System.out.println("Please enter a width: ");
			width = reader.nextInt();
			System.out.println("Please enter a height : ");
			height = reader.nextInt();
			System.out.println("Please enter a length : ");
			length = reader.nextInt();
			System.out.println("Please enter a grade : ");
			grade = reader.nextInt();
			System.out.println("Please enter how many colours would you like to have : ");

			colours = reader.nextInt();
			System.out.println("Would you like bottom reinforcement? : ");
			bottom = reader.nextBoolean();
			System.out.println("Would you like corner reinforcement? : ");
			corner = reader.nextBoolean();
			System.out.println("Would you like the box to be sealed? : ");
			sealed = reader.nextBoolean();
			System.out.println("How many of these boxes would you like to order?");
			quantity = reader.nextInt();

			if (calculateType() == 1) {
				System.out.println("Type 1 was selected for this order");
				for (int i = 0; i < quantity; i++) {
					boxes.add(new BoxType1(width, height, length, grade, colours, sealed, bottom, corner));
				}

			}

			if (calculateType() == 2) {
				System.out.println("Type 2 was selected for this order");
				for (int i = 0; i < quantity; i++) {
					boxes.add(new BoxType2(width, height, length, grade, colours, sealed, bottom, corner));
				}

			}

			if (calculateType() == 3) {
				System.out.println("Type 3 was selected for this order");
				for (int i = 0; i < quantity; i++) {
					boxes.add(new BoxType3(width, height, length, grade, colours, sealed, bottom, corner));
				}

			}

			if (calculateType() == 4) {

				System.out.println("Type 4 was selected for this order");
				for (int i = 0; i < quantity; i++) {
					boxes.add(new BoxType4(width, height, length, grade, colours, sealed, bottom, corner));
				}

			}

			if (calculateType() == 5) {

				System.out.println("Type 5 was selected for this order");
				for (int i = 0; i < quantity; i++) {
					boxes.add(new BoxType5(width, height, length, grade, colours, sealed, bottom, corner));
				}

			}

			if (calculateType() == 0)

			{
				System.out.println("Sorry, but we are not producing boxes of your specifications");
			}

			System.out.println("You currently have " + boxes.size() + " items in your order");
			System.out.println("Would you like to add something more to your order?");
			another = reader.next();
			if (another.equalsIgnoreCase("no")) {
				orderCompleted = true;

			} else {
				type = 0;
			}

		}

		for (BoxModel b : boxes) {

			b.calculateCost();
			System.out.println(b.cost);
			totalCost += b.cost;

		}
		System.out.println("Total cost of your order was: " + totalCost + " pounds");

	}

	public int calculateType() {
		if (grade > 0 && grade < 6) {

			if (grade >= 1 && grade <= 3 && colours == 0 && bottom == false && corner == false) {
				return type = 1;
			}
			if (grade >= 2 && grade <= 4 && colours == 1 && bottom == false && corner == false) {
				return type = 2;
			}
			if (grade >= 2 && grade <= 5 && colours == 2 && bottom == false && corner == false) {
				return type = 3;
			}
			if (grade >= 2 && grade <= 5 && colours == 2 && bottom == true && corner == false) {
				return type = 4;
			}
			if (grade >= 3 && grade <= 5 && colours == 2 && bottom == true && corner == true) {
				return type = 5;
			}

		} else {
			return type = 0;
		}

		return type;
	}

}

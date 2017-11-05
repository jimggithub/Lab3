package jimlab3;

import java.util.Scanner;
import java.io.*;

/****************************************************************************
 * CampPosanivee The program will keep track of who is enrolled for the two-week
 * summer camp. The program uses a binary search tree to maintain the set of
 * campers enrolled in Camp Posanivee. The program is not case sensitive and
 * read a text file to process commands. The commands include: H (help), E
 * (enroll new camper), W (withdraw a camper), D (display the age and gender of
 * a camper), A (display avg age of campers), L (list all campers), S (print the
 * number of boy and girl campers), P (display all campers names in preorder), Q
 * (quit).
 * 
 * @author Jim Griffin
 * @version 1.0
 * @date 11-2-2017
 * @course MCIS-0503 Fall 2017 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public class CampPosanivee {

	/*************************************************************************
	 * The main method is the controlling method for Camp Posanivee.
	 * Preconditions: must have properly formatted data file. Postconditions: be
	 * able to create a Queue and BST for data.
	 *
	 * @param args
	 * @throws IOException
	 ************************************************************************/
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to Camp Posanivee! ");

		// Get the name of the file from the user
		System.out.println("Please, enter the name of the data file: ");

		// Create new Scanner object to read user input
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		Scanner fileToRead = new Scanner(new File(fileName));

		// Sets the condition for reading the first character of each line in
		// file.
		boolean flag = true;
		QueueLL<Camper> Q = new QueueLL<>();
		BST1<Camper> tree = new BST1<>();

		while (fileToRead.hasNext()) {
			String[] line = fileToRead.nextLine().split(" ");
			System.out.println("Command:" + line[0].toString());
			// System.out.println("Command: "+Arrays.deepToString(line));
			// System.out.println("Tree: "+tree);

			char action = line[0].charAt(0);

			// if line starts with 'A', print the average age of the campers
			if (action == 'A') {
				tree.traverse(tree.root, BST1.INORDER);
				double avgAge = 0;
				double totAge = 0;
				double num = tree.Q.count;
				for (int i = 0; i < num; i++) {
					Camper c = (Camper) tree.Q.dequeue();
					totAge += c.getAge();
					avgAge = Math.round(totAge * 1.0 / num * 100) / 100d;
				}
				System.out.println("The average age of the campers is: " + avgAge);

			}

			// if line starts with 'H', print a list of commands
			if (action == 'H') {
				System.out.println(" The commands available are:" + "\n" + " E(enroll camper)" + "\n "
						+ "W(withdraw camper)" + "\n " + "D(display age and gender of camper)" + "\n"
						+ " A(display average age of campers" + "\n" + " L(display campers' names in alphabetical order"
						+ "\n " + "S(display number of boys and girls" + "\n" + " P(List campers' names in preorder"
						+ "\n" + " Q(quit)");
			}

			// if line starts with 'E', enqueue/insert camper
			if (action == 'E') {
				Camper o = new Camper(line[1], Integer.parseInt(line[2]), line[3]);
				tree.insert(o);
				System.out.println("New camper " + o.getName() + " " + "of age " + o.getAge() + " and gender "
						+ o.getGender() + " added ");

			}
			// if line starts with 'W', delete camper and print his/her info
			if (action == 'W') {
				Camper c = (Camper) tree.lookup(new Camper(line[1], 0, "x"));
				tree.delete(c);
				System.out.println("Camper " + c.getName() + " withdrawn");
			}

			// if line starts with 'D', display age and gender of the camper
			if (action == 'D') {
				// Prints age and gender of camper upon request from text file.
				Camper x = (Camper) tree.lookup(new Camper(line[1], 0, "x"));

				System.out.println(
						"The age and gender of camper " + line[1] + " are " + x.getAge() + " and " + x.getGender());
			}

			// if line starts with 'L', list campers' names in alphabetical
			// order
			if (action == 'L') {
				System.out.println("The campers' names are: " + tree.toString().replace("{", " ").replace("}", " "));
			}

			// if line starts with 'S', print the number of boy and girl campers
			if (action == 'S') {
				// tree.traverse(tree.root, BST1.INORDER);
				int num = tree.Q.count;
				int girlCount = 0;
				int boyCount = 0;
				for (int i = 0; i < num; i++) {
					Camper c = (Camper) tree.Q.dequeue();
					if (c.getGender().equals("M")) {
						boyCount++;
					}
					if (c.getGender().equals("F")) {
						girlCount++;
					}
					// System.out.println(c.getGender());

				}
				if (!tree.isEmpty()) {
					System.out.println("The number of girls is: " + girlCount);
					System.out.println("The number of boys is: " + boyCount);
				} else if (tree.isEmpty()) {
					System.out.println("Camp Posanivee is empty!");
				}
			}

			// if line starts with 'P', print all campers' names in preorder
			if (action == 'P') {
				// Prints campers' names in preorder as requested by text file
				// command
				System.out.println("The campers' names in preorder is: " + tree.toString(BST1.PREORDER));
				System.out.println();

			}

			// if line starts with 'Q', quit
			else if (action == 'Q') {
				break;
			}
		}

		System.out.println("***Camp Posanivee Terminated***");
		System.out.println("Good bye! ");
	}
}

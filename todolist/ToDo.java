package todolist;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ToDo {
	static String user;
	static File file;
	public static void main(String[] args) {
		ToDo list = new ToDo();
		if(args.length > 0) {
			user = args[0];
			list.loginUser(user);
		}
		else {
			System.out.print("Username: ");
			Scanner s = new Scanner(System.in);
			user = s.next();
			list.loginUser(user);
		}
	}
	void createUser(String user) {
		Scanner s = new Scanner(System.in);
		System.out.print("It looks like you don't have a ToDo List. Would you like to create one with the username \"" + user + "\"? [Y/N]  ");
		String answer = s.next();
		boolean loop = true;
		while(loop) {
			switch(answer.toLowerCase()) {
				case "n":
					System.out.println();
					System.out.println("Goodbye!");
					System.exit(0);
				case "y":
					try {
						file.createNewFile();
					}
					catch(IOException e) {
						System.out.println(e.getMessage());		// Wouldn't compile without this so it'll be interesting if it ever needs to be caught
					}
					loop = false;
					break;
				default:
					s.nextLine();
					System.out.println();
					System.out.println("Please answer properly.");
					System.out.print("Would you like to create a ToDo List with the username \"" + user + "\"? [Y/N]  ");
					answer = s.next();
			}
		}
	}
	
	void loginUser(String user) {
		file = new File("todolist/users/" + user + ".txt");
		if(file.exists()) {
			System.out.println();
			System.out.println("Welcome, " + user + ".");
			System.out.println();
			this.menu(user);
		}
		else {
			this.createUser(user);
			this.menu(user);
		}
	}
	
	void menu(String user) {
		boolean loop = true;
		while (loop) {
			System.out.println();
			System.out.println("Enter a number.");
			System.out.println("(1) View ToDo List.");
			System.out.println("(2) Add new task.");
			System.out.println("(3) Remove task.");
			System.out.println("(4) Update due-date");
			System.out.println("(5) Delete ToDo List.");
			System.out.println("(6) Log out.");
			System.out.println();
			Scanner s = new Scanner(System.in);
			int option;
			try {
				option = s.nextInt();
				s.nextLine();
				switch(option) {
				case 1:
					try {
						Scanner scan = new Scanner(file);
						System.out.println();
						int i = 1;
						while(scan.hasNextLine()) {
							System.out.println(i + " - " + scan.nextLine());
							i++;
						}
					}
					catch(FileNotFoundException e) {								// Should never get thrown
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("2");
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("4");
					break;
				case 5:
					System.out.println();
					System.out.print("Are you sure you want to delete the ToDo List for user \"" + user + "\"? [Y/N]  ");
					String answer = s.next();
					if(answer.toLowerCase().equals("y")) {
						file.delete();
						System.out.println();
						System.out.println("ToDo List deleted.");
						createUser(user);
					}
					break;
				case 6:
					System.out.println();
					System.out.println("Goodbye, " + user + "!");
					loop = false;
					break;
				default:
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e) {
				System.out.println();
				System.out.println("Please enter a number corresponding to a menu item.");
			}
		}
	}
}

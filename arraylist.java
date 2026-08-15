import java.util.ArrayList;

public class arraylist {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();

		names.add("Aman");
		names.add("Riya");
		names.add("Karan");

		System.out.println("Initial list: " + names);
		System.out.println("First item: " + names.get(0));

		names.set(1, "Neha");
		System.out.println("After set: " + names);

		names.remove(2);
		System.out.println("After remove: " + names);

		System.out.println("Contains Aman? " + names.contains("Aman"));
		System.out.println("Size: " + names.size());

		System.out.println("Items using loop:");
		for (String name : names) {
			System.out.println(name);
		}
	}
}

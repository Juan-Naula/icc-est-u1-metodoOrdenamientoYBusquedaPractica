package view;

import java.util.Scanner;
import model.Person;

public class View {
	private Scanner scanner = new Scanner(System.in);

	public int showMenu() {
		System.out.println("\n--- Menú Principal ---");
		System.out.println("1. Agregar persona");
		System.out.println("2. Agregar varias personas");
		System.out.println("3. Mostrar personas");
		System.out.println("4. Ordenar personas");
		System.out.println("5. Buscar persona");
		System.out.println("6. Salir");
		System.out.print("Seleccione una opción: ");
		try {
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	public Person inputPerson() {
		System.out.print("Nombre: ");
		String name = scanner.nextLine().trim();
		System.out.print("Edad: ");
		int age = 0;
		try {
			age = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Entrada inválida para edad, se usará 0.");
		}
		return new Person(name, age);
	}

	public int selectSortingMethod() {
		System.out.println("\nMétodos de ordenamiento:");
		System.out.println("1. sortByNameWithBubble (Nombre ascendente - Burbuja)");
		System.out.println("2. sortByNameWithSelectionDes (Nombre descendente - Selección)");
		System.out.println("3. sortByAgeWithInsertion (Edad ascendente - Inserción)");
		System.out.println("4. sortByNameWithInsertion (Nombre ascendente - Inserción)");
		System.out.print("Seleccione método: ");
		try {
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	public int selectSearchCriterion() {
		System.out.println("\nCriterios de búsqueda:");
		System.out.println("1. Buscar por edad");
		System.out.println("2. Buscar por nombre");
		System.out.print("Seleccione criterio: ");
		try {
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	public void displayPersons(Person[] persons) {
		System.out.println("\n--- Lista de Personas ---");
		if (persons == null || persons.length == 0) {
			System.out.println("(vacío)");
			return;
		}
		for (Person p : persons) {
			System.out.println("- " + p);
		}
	}

	public void displaySearchResult(Person p) {
		if (p == null) {
			System.out.println("Persona no encontrada.");
		} else {
			System.out.println("Persona encontrada: " + p);
		}
	}

	public int inputAge() {
		System.out.print("Ingrese edad a buscar: ");
		try {
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Entrada inválida, se usará 0.");
			return 0;
		}
	}

	public String inputName() {
		System.out.print("Ingrese nombre a buscar: ");
		return scanner.nextLine().trim();
	}
}


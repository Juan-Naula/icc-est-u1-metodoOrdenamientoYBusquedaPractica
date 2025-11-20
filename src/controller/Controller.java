package controller;

import java.util.ArrayList;
import java.util.List;

import model.Person;
import view.View;

public class Controller {
	private View view;
	private SortingMethods sorter;
	private SearchMethods searcher;
	private List<Person> persons = new ArrayList<>();

	public Controller(View view, SortingMethods sorter, SearchMethods searcher) {
		this.view = view;
		this.sorter = sorter;
		this.searcher = searcher;
	}

	public void start() {
		boolean running = true;
		while (running) {
			int option = view.showMenu();
			switch (option) {
				case 1:
					addPersons();
					break;
				case 2:
					inputPersons();
					break;
				case 3:
					view.displayPersons(persons.toArray(new Person[0]));
					break;
				case 4:
					sortPersons();
					break;
				case 5:
					searchPerson();
					break;
				case 6:
					running = false;
					break;
				default:
					System.out.println("Opción inválida.");
			}
		}
		System.out.println("Saliendo...");
	}

	// Pide varias personas hasta que el usuario deje nombre vacío
	public void inputPersons() {
		System.out.println("Ingresar personas (dejar nombre vacío para terminar):");
		while (true) {
			Person p = view.inputPerson();
			if (p.getName() == null || p.getName().isEmpty()) break;
			persons.add(p);
			System.out.println("Añadida: " + p);
		}
	}

	// Añade una sola persona
	public void addPersons() {
		Person p = view.inputPerson();
		if (p.getName() == null || p.getName().isEmpty()) {
			System.out.println("Nombre vacío, no se añadió.");
			return;
		}
		persons.add(p);
		System.out.println("Persona añadida: " + p);
	}

	public void sortPersons() {
		if (persons.isEmpty()) {
			System.out.println("No hay personas para ordenar.");
			return;
		}
		int method = view.selectSortingMethod();
		Person[] arr = persons.toArray(new Person[0]);
		switch (method) {
			case 1:
				sorter.sortByNameWithBubble(arr);
				break;
			case 2:
				sorter.sortByNameWithSelectionDes(arr);
				break;
			case 3:
				sorter.sortByAgeWithInsertion(arr);
				break;
			case 4:
				sorter.sortByNameWithInsertion(arr);
				break;
			default:
				System.out.println("Método inválido.");
				return;
		}
		persons.clear();
		for (Person p : arr) persons.add(p);
		System.out.println("Ordenamiento completado.");
		view.displayPersons(arr);
	}

	public void searchPerson() {
		if (persons.isEmpty()) {
			System.out.println("No hay personas para buscar.");
			return;
		}
		int criterion = view.selectSearchCriterion();
		Person[] arr = persons.toArray(new Person[0]);
		switch (criterion) {
			case 1:
				if (!searcher.isSortedByAge(arr)) {
					System.out.println("El arreglo no está ordenado por edad. Ordene primero por edad.");
					return;
				}
				int age = view.inputAge();
				Person foundA = searcher.binarySearchByAge(arr, age);
				view.displaySearchResult(foundA);
				break;
			case 2:
				if (!searcher.isSortedByName(arr)) {
					System.out.println("El arreglo no está ordenado por nombre. Ordene primero por nombre.");
					return;
				}
				String name = view.inputName();
				Person foundN = searcher.binarySearchByName(arr, name);
				view.displaySearchResult(foundN);
				break;
			default:
				System.out.println("Criterio inválido.");
		}
	}
}


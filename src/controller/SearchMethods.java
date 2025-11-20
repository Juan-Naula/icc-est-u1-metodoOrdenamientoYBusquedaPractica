package controller;

import model.Person;

public class SearchMethods {

	public Person binarySearchByAge(Person[] arr, int age) {
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid].getAge() == age) return arr[mid];
			if (arr[mid].getAge() < age) lo = mid + 1;
			else hi = mid - 1;
		}
		return null;
	}

	public Person binarySearchByName(Person[] arr, String name) {
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = arr[mid].getName().compareToIgnoreCase(name);
			if (cmp == 0) return arr[mid];
			if (cmp < 0) lo = mid + 1;
			else hi = mid - 1;
		}
		return null;
	}

	public boolean isSortedByAge(Person[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1].getAge() > arr[i].getAge()) return false;
		}
		return true;
	}

	public boolean isSortedByName(Person[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1].getName().compareToIgnoreCase(arr[i].getName()) > 0) return false;
		}
		return true;
	}
}


package controller;

import model.Person;

public class SortingMethods {

	public void sortByNameWithBubble(Person[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j].getName().compareToIgnoreCase(arr[j + 1].getName()) > 0) {
					Person tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	public void sortByNameWithSelectionDes(Person[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j].getName().compareToIgnoreCase(arr[maxIdx].getName()) > 0) {
					maxIdx = j;
				}
			}
			Person tmp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = tmp;
		}
	}

	public void sortByAgeWithInsertion(Person[] arr) {
		for (int i = 1; i < arr.length; i++) {
			Person key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].getAge() > key.getAge()) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public void sortByNameWithInsertion(Person[] arr) {
		for (int i = 1; i < arr.length; i++) {
			Person key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].getName().compareToIgnoreCase(key.getName()) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}


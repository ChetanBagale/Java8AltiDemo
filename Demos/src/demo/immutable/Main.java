package demo.immutable;

import java.io.PrintWriter;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */

public class Main {
	public static List<String> processData(ArrayList<String> array) {
		/*
		 * Modify this method to process `array` as indicated in the question. At the
		 * end, return a List containing the appropriate values
		 *
		 * Please create appropriate classes, and use appropriate data structures as
		 * necessary.
		 *
		 * Do not print anything in this method.
		 *
		 * Submit this entire program (not just this method) as your answer
		 */

		Map<String, String> map = new HashMap<>();

		for (String str : array) {
			int count = 0;

			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == ',')
					count++;

				if (count == 3) {
					i++;
					System.out.println("Count:" + count);
					String product = "";
					String cost = "";
					System.out.println(str.charAt(i));
					while (str.charAt(i) != ',') {
						product = product + str.charAt(i);
						i++;
					}
					i++;
					while (str.charAt(i) != ',') {
						cost = cost + str.charAt(i);
						i++;

					}
					cost = cost.trim();
					for (int j = 0; j < cost.length(); j++) {
						if (cost.charAt(j) == 'R' || cost.charAt(j) == 's') {
							System.out.println("Inside");
							cost = cost.replace(cost.charAt(j), ' ');
						}

					}

					product = product.trim();
					if (map.containsKey(product)) {
						if (Integer.parseInt(map.get(product).trim()) < Integer.parseInt(cost.trim())) {
							map.put(product.trim(), cost.trim());
						}
					}

					else {
						map.put(product.trim(), cost.trim());
					}
					break;

				}

			}

		}
		System.out.println("Map:" + map);
		List<String> retVal = new ArrayList<String>();

		String name = "";

		for (String str : array) {
			int count = 0;

			for (int i = 0; i < str.length(); i++) {

				name=extractName(str);

				if (str.charAt(i) == ',')
					count++;

				if (count == 3) {
					i++;
					System.out.println("Count:" + count);
					String product = "";
					String cost = "";
					System.out.println(str.charAt(i));
					while (str.charAt(i) != ',') {
						product = product + str.charAt(i);
						i++;
					}
					i++;
					while (str.charAt(i) != ',') {
						cost = cost + str.charAt(i);
						i++;

					}
					cost = cost.trim();
					for (int j = 0; j < cost.length(); j++) {
						if (cost.charAt(j) == 'R' || cost.charAt(j) == 's') {
							System.out.println("Inside");
							cost = cost.replace(cost.charAt(j), ' ');
						}

					}

					System.out.println("Product:" + product);
					product = product.trim();
					if (map.containsKey(product)) {
						System.out.println("Inside If:" + map.containsKey(product));
						if (Integer.parseInt(map.get(product).trim()) > Integer.parseInt(cost.trim())) {

							retVal.add(name);
						}
					}

					break;

				}

			}

		}

		return retVal;
	}

	public static String extractName(String str) {
		String name = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ',')
				return name;

			name = name + str.charAt(i);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Starting main....");
		ArrayList<String> inputData = new ArrayList<String>();
		String line;
		
		inputData.add("Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash");
		inputData.add("Mohit Gupta, Baner, 1, Samsung Battery, Rs 900, Credit Card");
		inputData.add("Rajan Patil, Aundh, 3, Samsung Battery, Rs 1000, Cash");
		inputData.add("Nina Kothari, Baner, 4, Earphones, Rs 500, Credit Card");
		inputData.add("T Sunitha, Shivajinagar, 5, Earphones, Rs 550, Credit Card");
		inputData.add("Rohan Gade, Aundh, 10, Motorola Battery, Rs 1000, Credit Card");
		inputData.add("Rajan Patil, Shivajinagar, 21, Earphones, Rs 550, Credit Card");
		inputData.add("Rajan Patil, Aundh, 22, USB Cable, Rs 150, UPI");
		inputData.add("Meena Kothari, Baner, 23, USB Cable, Rs 100, Cash");
		inputData.add("Nina Kothari, Baner, 24, USB Cable, Rs 200, UPI");
		inputData.add("Mohit Gupta, Baner, 25, USB Cable, Rs 150, UPI");

		List<String> retVal = processData(inputData);
		PrintWriter output = new PrintWriter(System.out);
		for (String str : retVal)
			System.out.println("Data=" + str);
		output.close();
	}

}

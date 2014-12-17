Question:
//Given array of people, each represented by their name (a string) and their position in line (an integer). 
//Write a function that takes a name and returns their 3 nearest neighbors. 
//We can assume for the sake of simplicity that there are at least 4 people in the list.
	public static Person[] findNearestNeighbors(Person[] people, String target) {
		Person[] neighbors = new Person[3];
		Arrays.sort(people);
		for (int i = 0; i < people.length; i++) {
			if (people[i].name.equals(target)) {
				int before = i - 1;
				int after = i + 1;
				int index = 0;
				while (index < 3) {
					if (after < people.length && (before < 0 || 
					    Math.abs(people[before].position-people[i].position) > Math.abs(people[after].position-people[i].position))) {
						neighbors[index] = people[after];
						after++;
					} else {
						neighbors[index] = people[before];
						before--;
					}
					index++;
				}
			}
		}
		return neighbors;
	}
	
	private static class Person implements Comparable<Person> { 
		public String name;
		public int position;
		@Override
		public int compareTo(Person other) {
			return ((Person) other).position - this.position; 
		}
	}

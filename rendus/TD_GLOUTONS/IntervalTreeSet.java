/*
 * M415 2019-2020: additional algorithmic
 */
package M415.td3.interval;

//see : https://www.careercup.com/question?id=12743699

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors; // Eclipse seems to ignore it, inserted by hand

/**
*
* The IntervalTreeSet Class implements greedy algorithms for finding the
* largest subset of compatible intervals for a given set of interval requests
* 
* Precondition : a set of non empty intervals
* 
* Postcondition : the cardinality of the largest subset of non intersecting
* intervals
* 
* @author m6k415
* @version 1.16.0227
*/
public class IntervalTreeSet extends TreeSet<Interval> {
	/*
	 * https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html
	 */

	// TODO : constructor with array parameter
	private static final long serialVersionUID = 1L;

	/**
	 * compute the number of conflicts for a given interval inside current set
	 * 
	 * @param interval
	 *            : the given interval
	 */
	private int countConflicts(Interval interval) {
		int count = 0;
		for (Interval current : this) {
			// if (current > interval) return count;
			if (interval.getEnd() <= current.getStart())
				break;
			if (interval.intersects(current)) {
				// interval does conflict with itself
				count++;
			}
		}
		return count;
	}

	/**
	 * remove elements from current set that conflict with a given interval
	 * 
	 * @param interval
	 *            : the given interval (supposed not null)
	 */
	private void removeConflicts(Interval interval) {
		List<Interval> conflicts = new ArrayList<>();
		for (Interval current : this) {
			if (interval.getEnd() <= current.getStart())
				break;
			if (interval.intersects(current) && (current != interval)) {
				conflicts.add(current);
			}
		}
		this.removeAll(conflicts);
	}

	/**
	 * compute the maximum conflict number for a given time in current set
	 * 
	 * @return max
	 */
	int intersectionMax() {
		if (this.size() == 0)
			return 0;
		int[] start = new int[this.size()];
		int[] finish = new int[this.size()];
		int i = 0;
		for (Interval current : this) {
			start[i] = current.getStart();
			finish[i++] = current.getEnd();
		}
		// Arrays.sort(start); // already sorted this way
		Arrays.sort(finish);
		int count = 0;
		int max = count;
		int s = 0;
		int f = 0;
		while (s < start.length && f < finish.length) {
			if (start[s] < finish[f]) {
				count++;
				max = Math.max(count, max);
				s++;
			} else {
				count--;
				f++;
			}
		}
		return max;
	}

	/**
	 * compute the largest conflictless subset of current set using algorithm 1:
	 * take the interval that starts the earlier first.
	 * 
	 * Iterative implementation.
	 * 
	 * @return accepted : the set of compatible intervals selected
	 */
	IntervalTreeSet getStartEarlierFirst() {
		// TODO : write as others method with removeConflicts
		IntervalTreeSet accepted = new IntervalTreeSet();
		accepted.addAll(this); // copy of this
		// iterate over original this and remove elements from the accepted copy
		Iterator<Interval> iterator = this.iterator();
		Interval current;
		if (iterator.hasNext()) {
			current = iterator.next();
			Interval next;
			while (iterator.hasNext()) {
				// remove conflicting intervals without using removeConflicts
				next = iterator.next();
				if (next.intersects(current)) {
					accepted.remove(next);
				} else {
					current = next;
				}
			}
		}
		return accepted;
	}

	/**
	 * compute the largest conflictless subset of current set using algorithm 1:
	 * take the interval that starts the earlier first.
	 * 
	 * Recursive implementation.
	 * 
	 * @param sortedSet : set of input intervals
	 */
	void getStartEarlierRec(SortedSet<Interval> sortedSet) {
		if (!sortedSet.isEmpty()) {
			Interval head = sortedSet.first();
			this.add(head);
			// build an empty interval matching the end of head
			Interval next = new Interval(head.getEnd(), head.getEnd());
			// check with head instead : wrong
			// returns the subset of intervals greater or equal to next (all but
			// those intersecting head)
			this.getStartEarlierRec(sortedSet.tailSet(next));
		}
	}

	/**
	 * compute the largest conflictless subset of current set using algorithm 2:
	 * take the smallest interval first
	 * 
	 * @return accepted : the set of compatible intervals selected
	 */
	IntervalTreeSet getSmallerFirst() {
		// use tab to sort intervals according to appropriate Comparator
		Interval[] tab = this.toArray(new Interval[0]);
		Arrays.sort(tab, Interval.IntervalSizeComparator);

		// copy from which we remove conflicting intervals
		IntervalTreeSet accepted = new IntervalTreeSet();
		accepted.addAll(this);

		// Collections.sort(accepted, Interval.IntervalSizeComparator);
		// this does not make sense for Set or SortedSet
		// One could use List, but then tailSet will be missing

		// iterate over tab and remove elements from the accepted copy
		for (Interval interval : tab) { //
			if (accepted.contains(interval)) { // same objects!!!
				accepted.removeConflicts(interval);
			}
		}
		return accepted;
	}

	/**
	 * compute the largest conflictless subset of current set using algorithm 3:
	 * take the interval with the smaller number of conflicts first
	 * 
	 * @return accepted : the set of compatible intervals selected
	 */
	IntervalTreeSet getLessConflictsFirst() {
		// compute conflict number for each interval and store result in map
		// Instead of map, one can use an array?
		// Question : does the number of conflicts have to be updated during the
		// process? This is not the solution we have selected.
		Map<Interval, Integer> map = new HashMap<>();
		for (Interval interval : this) {
			map.put(interval, this.countConflicts(interval));
		}
		// sort map by respect to value and output to a list
		// http://stackoverflow.com/questions/30425836/java-8-stream-map-to-list-of-keys-sorted-by-values
		List<Interval> sortedByConflicts = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey).collect(Collectors.toList());

		// make a copy from which we remove conflicting intervals
		IntervalTreeSet accepted = new IntervalTreeSet();
		accepted.addAll(this);
		for (Interval interval : sortedByConflicts) {
			if (accepted.contains(interval)) {
				accepted.removeConflicts(interval);
			}
		}
		return accepted;
	}

	/**
	 * compute the largest conflictless subset of current set using optimal
	 * algorithm 4: take the interval that finishes the earlier first
	 * 
	 * @return accepted : the set of compatible intervals selected
	 */
	IntervalTreeSet getFinishEarlierFirst() {
		// use tab to sort intervals according to appropriate Comparator
		Interval[] tab = this.toArray(new Interval[0]);
		Arrays.sort(tab, Interval.IntervalFinishComparator);

		// make a copy from which we remove conflicting intervals
		IntervalTreeSet accepted = new IntervalTreeSet();
		accepted.addAll(this);
		for (Interval interval : tab) {
			if (accepted.contains(interval)) {
				accepted.removeConflicts(interval);
			}
		}
		return accepted;
	}

	/**
	 * display elements from current set with dashes [---w---]
	 * 
	 */
	void display() {
		int i = this.size();
		System.out.println(
				"     012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		for (Interval current : this) {
			System.out.printf("%3d: %s%n", i, current.display());
			i--;
		}
	}

	public static void main(String[] args) {

		// see also the Junit tests provided with this Class

		Interval[] tab = { new Interval(10, 15), new Interval(20, 25), new Interval(5, 35), new Interval(40, 50),
				new Interval(55, 63), new Interval(60, 65), };

		IntervalTreeSet requests = new IntervalTreeSet();
		Collections.addAll(requests, tab);

		IntervalTreeSet[] req = new IntervalTreeSet[4];
		req[0] = new IntervalTreeSet();
		Collections.addAll(req[0], tab);

		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet earlier = requests.getStartEarlierFirst();
				System.out.println("Earlier started first iterative: " + earlier.toString());
		earlier.display();

		Interval g = new Interval(70, 85);
		requests.add(g);
		Interval h = new Interval(40, 45);
		requests.add(h);

		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet earlierRec = new IntervalTreeSet();
		earlierRec.getStartEarlierRec(requests);
		System.out.println("Earlier started first recursive: " + earlierRec.toString());
		earlierRec.display();

		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet smaller = requests.getSmallerFirst();
		System.out.println("Smaller first: " + smaller.toString());
		smaller.display();
		
		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet finishEarlier = requests.getFinishEarlierFirst();
		System.out.println("Finish Earlier first: " + finishEarlier.toString());
		finishEarlier.display();
		
		/*
		 * 		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet earlierRec = new IntervalTreeSet();
		earlierRec.getStartEarlierRec(requests);
		System.out.println("Earlier started first recursive: " + earlierRec.toString());
		earlierRec.display();

		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet smaller = requests.getSmallerFirst();
		System.out.println("Smaller first: " + smaller.toString());
		smaller.display();

		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet finish = requests.getFinishEarlierFirst();
		System.out.println("Earlier finished first: " + finish.toString());
		finish.display();

		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		IntervalTreeSet less = requests.getLessConflictsFirst();
		System.out.println("Less conflicts first: " + less.toString());
		less.display();

		System.out.println();
		System.out.println("Requests: " + requests.toString());
		requests.display();
		System.out.println("Intersection Max: " + requests.intersectionMax());
		Interval i = new Interval(5, 100);
		requests.add(i);
		Interval j = new Interval(10, 100);
		requests.add(j);
		Interval k = new Interval(10, 50);
		requests.add(k);
		System.out.println("Requests: " + requests.toString());
		requests.display();
		System.out.println("Intersection Max: " + requests.intersectionMax());

		IntervalTreeSet its = new IntervalTreeSet();
		System.out.println("Requests: " + its.toString());
		its.display();
		System.out.println("Intersection Max: " + its.intersectionMax());

		Interval its1 = new Interval(0, 1);
		Interval its2 = new Interval(1, 2);
		Interval its3 = new Interval(1, 3);
		Interval its4 = new Interval(1, 4);
		its.add(its1);
		System.out.println("Requests: " + its.toString());
		its.display();
		System.out.println("Intersection Max: " + its.intersectionMax());

		its.add(its2);
		System.out.println("Requests: " + its.toString());
		its.display();
		System.out.println("Intersection Max: " + its.intersectionMax());

		its.add(its3);
		its.add(its4);
		System.out.println("Requests: " + its.toString());
		its.display();
		System.out.println("Intersection Max: " + its.intersectionMax());

		Interval its5 = new Interval(3, 8);
		Interval its6 = new Interval(3, 7);
		Interval its7 = new Interval(3, 5);
		Interval its8 = new Interval(3, 9);
		Interval its9 = new Interval(2, 9);
		Interval its10 = new Interval(3, 10);
		Interval its11 = new Interval(3, 11);
		its.add(its5);
		its.add(its6);
		its.add(its7);
		its.add(its8);
		its.add(its9);
		its.add(its10);
		its.add(its11);
		System.out.println("Requests: " + its.toString());
		its.display();
		System.out.println("Intersection Max: " + its.intersectionMax());
		*/
		

	}

}


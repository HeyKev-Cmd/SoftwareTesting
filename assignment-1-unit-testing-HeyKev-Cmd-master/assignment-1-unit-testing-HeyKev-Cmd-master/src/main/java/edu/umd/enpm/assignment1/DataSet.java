package edu.umd.enpm.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DataSet implements Comparable<DataSet> {
	List<DataPoint> dataPoints = new ArrayList<DataPoint>();
	
	/**
	 * @return	the list of DataPoints of the current DataSet
	 */
	public List<DataPoint> getDataPoints() {
		return dataPoints;
	}
	
	/**
	 * Adds an data point to the current data set
	 * 
	 * @param point
	 */
	public void addPoint(DataPoint point) {
		dataPoints.add(point);
		
		Collections.sort(dataPoints);
	}

	/**
	 * Determines if the current Data Set subsumes the argument Data Set.
	 * DataSet_A subsumes DataSet_B if it has every DataPoint DataSet_B has. 
	 * 
	 * @param c
	 * 
	 * @return	the value true if the current DataSet subsumes the argument 
	 */
	public boolean subsumes(DataSet c) {
		if (dataPoints.size() < c.dataPoints.size()) {
			return false;
		}
		
		for (int x = 0; x < c.dataPoints.size(); x++) {
			if (!dataPoints.contains(c.dataPoints.get(x))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * DataSet are ordered by length then by the first differing DataPoint
	 * 
	 * @return	the value 0 if DataSet contains the same DataPoints as the current DataSet
	 * 			the value less than 0 if ...
	 * 			the value greater than 0 if ...
	 */
	public int compareTo(DataSet c) {
		int size = Math.min(dataPoints.size(), c.dataPoints.size());
		int x = 0;
		
		while (x < size && dataPoints.get(x).compareTo(c.dataPoints.get(x)) == 0) {
			x++;
		}
		
		if (x == size) {
			return dataPoints.size() - c.dataPoints.size();
		}
		
		return dataPoints.get(x).compareTo(c.dataPoints.get(x));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DataSet)) return false;
		DataSet dataSet = (DataSet) o;
		return Objects.equals(getDataPoints(), dataSet.getDataPoints());
	}

	@Override
	public int hashCode() {
		int result=17;
		for (DataPoint i : this.dataPoints){
			result=result*(31+i.getXValue()+31+i.getYValue());
		}
		return result;
	}
	//	public boolean equals(Object obj) {
//		/** TODO
//		 * implement equals() method
//		 */
//
//		return false;
//	}
//
//	public int hashCode() {
//		/** TODO
//		 * implement hashCode() method
//		 */
//
//		return 42;
//	}
	
	/**
	 * @return		string representation of the current DataSet
	 */
	public String toString() {
		String str = "";
		
		for (DataPoint point : dataPoints) {
			str += point + " ";
		}
		
		return str.trim();
	}
}
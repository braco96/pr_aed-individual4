package aed.positiveiterator;

import aed.positionlist.NodePositionList;
import aed.positionlist.PositionList;

public class Example {
	public static void main(String[] args) {
		PositionList<Integer> l = new NodePositionList<Integer>(new Integer [] {null,null, -1,null,null,2,-3,3,4,5,null,null}); 
		
		PositivePositionListIterator<Integer> i = new PositivePositionListIterator<Integer>(l); 
		
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}	

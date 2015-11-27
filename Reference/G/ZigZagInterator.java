Suppose you have a Iterator class with has_next() and get_next() methods.

Please design and implement a ZigzagIterator class as a wrapper of multiple iterators.

class ZigZagIterator{
	    List<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>();
	    int index = 0;
	    public void ZigzagIterator(List<Integer> v1, List<Integer> v2, List<Integer> v3, List<Integer> v4) {  
	    	if(v1.iterator().hasNext())
	    		iterators.add(v1.iterator());
	    	if(v2.iterator().hasNext())
	    		iterators.add(v2.iterator());
	    	if(v3.iterator().hasNext())
	    		iterators.add(v3.iterator());
	    	if(v4.iterator().hasNext())
	    		iterators.add(v4.iterator());
	    }
	    
	    public int next() {
	    	int ret = iterators.get(index).next();
	    	if(!iterators.get(index).hasNext()){
	    		iterators.remove(index);
	    		if(index==iterators.size())
	    			index=0;
	    	}else{
	    		index = (index+1)%iterators.size();
	    	}
	    	return ret;
	    }
	    
	    public boolean hasNext() {
	    	return !iterators.isEmpty();
	    }
}


//using ListIterator<Iterator<Integer>> iterator

	    List<Iterator<Integer>> collection = new ArrayList<Iterator<Integer>>();
	    ListIterator<Iterator<Integer>> iterator;
	    int index = 0;
	    public void ZigzagIterator(List<Integer> v1, List<Integer> v2, List<Integer> v3, List<Integer> v4) {  
	    	if(v1.iterator().hasNext())
	    		collection.add(v1.iterator());
	    	if(v2.iterator().hasNext())
	    		collection.add(v2.iterator());
	    	if(v3.iterator().hasNext())
	    		collection.add(v3.iterator());
	    	if(v4.iterator().hasNext())
	    		collection.add(v4.iterator());
	    	iterator = collection.listIterator();
	    }
	    
	    public void backToBegin(){
	    	while(iterator.hasPrevious())
	    		iterator.previous();
	    }
	    
	    public int next() {
	    	Iterator<Integer> curIt = iterator.next();
	    	int ret = curIt.next();
	    	if(!curIt.hasNext())
	    		iterator.remove();
	    	if(!iterator.hasNext())
	    		backToBegin();
	    	return ret;
	    }
	    
	    public boolean hasNext() {
	    	return iterator.hasNext();
	    }

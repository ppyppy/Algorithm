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



//nested iterator, so funny

	    Stack<Iterator<Object>> stack = new Stack<Iterator<Object>>();
	    Iterator<Object> iterator;
	    public void ZigzagIterator(Iterator<Object> iterator) {  
	    	this.iterator = iterator;
	    }
	    
	    public int next() {
	    	if(!iterator.hasNext())
	    		iterator = stack.pop();
	    	Object obj = iterator.next();
	    	Iterator<Object> pre = iterator;
	    	while(!(obj instanceof Integer)){
	    			iterator = (Iterator<Object>) obj;
	    			if(pre.hasNext())
	    				stack.push(pre);
	    			obj = iterator.next();
	    			pre = iterator;
	    	}
	    	return (int) obj;
	    }
	    
	    public boolean hasNext() {
	    	return iterator.hasNext() || !stack.isEmpty();
	    }
	    
	    			//{0, {1, 2}, 3, {4, {5, 6}}}
			List<Object> list = new ArrayList<Object>();
			list.add(0);
			List<Object> list11 = new ArrayList<Object>();
//			list11.add(1);list11.add(2);
			list.add(list11.iterator());
			list.add(3);
			List<Object> list12 = new ArrayList<Object>();
			list12.add(4);
			List<Object> list121 = new ArrayList<Object>();
			list121.add(5);list121.add(6);
			list12.add(list121.iterator());
			list.add(list12.iterator());
			
			
	    	Solution s = new Solution();
	    	s.ZigzagIterator(list.iterator());
	    	while(s.hasNext()){
	    		System.out.print(s.next()+",");
	    	}

//Given k sorted streams where each stream could possibly be infinite in length, 
//describe an efficient algorithm to merge the k streams into a new stream (also in sorted order).
http://www.careercup.com/question?id=9655082

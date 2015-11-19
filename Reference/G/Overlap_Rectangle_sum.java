    http://codercareer.blogspot.com/2011/12/no-27-area-of-rectangles.html
//get the rectangles area, do not duplicate overlap area
    
    class Rect{
    	int left;
    	int right;
    	int top;
    	int bottom;
    }
    
    class Range{
    	int low;
    	int high;
    	public Range(int n1, int n2){
    		low = n1;
    		high = n2;
    	}
    	public boolean isOverlap(Range range){
    		if(low>range.high || high<range.low)
    			return false;
    		return true;
    	}
    	void merge(Range range){
    		low = Math.min(low, range.low);
    		high = Math.max(high, range.high);
    	}
    }
    
    public int getArea(List<Rect> list){
    	if(list==null || list.size()==0)
    		return 0;
    	List<Integer> xlist = getXList(list);
    	int sum = 0;
    	for(int i=1; i<xlist.size(); i++){
    		int x1=xlist.get(i-1); 
    		int x2=xlist.get(i);
    		if(x1==x2)
    			continue;
    		List<Range> rlist = getRange(list, x1, x2);
    		for(Range range : rlist){
    			sum += (range.high-range.low)*(x2-x1);
    		}
    	}
    	return sum;
    }
    
    
    
    private List<Range> getRange(List<Rect> list, int x1, int x2) {
		// TODO Auto-generated method stub
    	LinkedList<Range> rlist = new LinkedList<Range>();
    	for(Rect rect : list){
    		if(rect.left<=x1 && rect.right>=x2){
    			rlist.add(new Range(rect.bottom, rect.top));
    		}
    	}
    	Collections.sort(rlist, new Comparator<Range>(){
			@Override
			public int compare(Range o1, Range o2) {
				// TODO Auto-generated method stub
				return o1.low-o2.low;
			}
    	});
    	List<Range> ret = new ArrayList<Range>();
    	Range range = rlist.removeFirst();
    	while(!rlist.isEmpty()){
    		Range first = rlist.removeFirst();
    		if(range.isOverlap(first)){
    			range.merge(first);
    		}else{
    			ret.add(range);
    			range = first;
    		}
    	}
    	ret.add(range);
		return ret;
	}



	private List<Integer> getXList(List<Rect> list) {
		// TODO Auto-generated method stub
    	List<Integer> xList = new ArrayList<Integer>();
    	for(Rect rect : list){
    		xList.add(rect.left);
    		xList.add(rect.right);
    	}
    	Collections.sort(xList);
		return xList;
	}

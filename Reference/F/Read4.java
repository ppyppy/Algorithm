The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.


	    public int read(char[] buf, int n) {
	    	char[] tmp = new char[4];
	    	int readBytes = 0;
	    	boolean isEnd = false;
	    	while(!isEnd && readBytes<n){
	    		int bytes = read4(tmp);
	    		if(bytes<4)
	    			isEnd = true;
	    		bytes = Math.min(bytes, n-readBytes);
	    		System.arraycopy(tmp, 0, buf, readBytes, bytes);
	    		readBytes += bytes;
	    	}
	    	return readBytes;
	    }
	    
	    
	    
	    The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.


	    Queue<Character> remain = new LinkedList<Character>();
	    public int readMultiple(char[] buf, int n){
	    	int readBytes = 0;
	    	while(readBytes<n && !remain.isEmpty()){
	    		buf[readBytes++] = remain.poll();
	    	}
	    	boolean isEnd = false;
	    	char[] tmp = new char[4];
	    	while(!isEnd && readBytes<n){
	    		int bytes = read4(tmp);
	    		if(bytes<4)
	    			isEnd = true;
	    		if(bytes>n-readBytes){
	    			System.arraycopy(tmp, 0, buf, readBytes, n-readBytes);
	    			for(int i=n-readBytes; i<bytes; i++)
	    				remain.add(tmp[i]);
	    			return n;
	    		}
	    		System.arraycopy(tmp, 0, buf, readBytes, bytes);
	    		readBytes += bytes;
	    	}
	    	return readBytes;
	    }

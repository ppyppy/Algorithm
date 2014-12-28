	int getNextBigger(int num){
		int n = num;
		int c0 =0, c1=0;
		while( (n&1)==0 && n>0){
			c0++;
			n >>>= 1;
		}
		while( (n&1)==1 ){
			c1++;
			n >>>= 1;
		}
		if( (c0+c1)>=31 || (c0+c1)==0 )
			throw new RuntimeException("invalid");
		int c = c0+c1;
		int val = ~( (1<<c) - 1);
		num |= 1<<c;
		num &= val;
		num |= ((1<<(c1-1))-1);
		return num;
	}
	
	int getNextSmaller(int num){
		int n = num;
		int c0=0, c1=0;
		while( (n&1)>0 ){
			c1++;
			n >>>= 1;
		}
		if(n==0)
			throw new RuntimeException("invalid");
		while( (n&1)==0 && n!=0){
			c0++;
			n >>>= 1;
		}
		num &= (~0)<<(c0+c1+1);
		num |= ( ((1<<(c1+1))-1) << (c0-1) );
		return num;
	}

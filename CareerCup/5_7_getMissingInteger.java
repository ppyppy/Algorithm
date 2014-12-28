 //If count2(0s) <= count2(ls),then LSB2(v) = 0. •
 //If count2(0s) > count2(ls),then LSB2(v) = 1.



	public int findMissing(ArrayList<BitInteger> array){
		if(array==null)
			throw new RuntimeException("Invalid!");
		return findMissing(array, 0);
	}
	public int findMissing(ArrayList<BitInteger> array, int col){
		if(col>=array.size())
			return 0;
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>();
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>();
		for(BitInteger val : array){
			if(val.get(col)==0){
				zeroBits.add(val);
			}else{
				oneBits.add(val);
			}
		}
		if(zeroBits.size()>oneBits.size()){
			BitInteger ret = findMissing(array, col+1);
			ret = ( (ret<<1) | 0x01 );
		}else{
			BitInteger ret = findMissing(array, col+1);
			ret <<= 1;
		}
		return ret;
	}

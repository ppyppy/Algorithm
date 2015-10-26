//Convert between string of hex adecimal characters and array of nibbles

char[] hexChar = {'0', '1', ......, 'D', 'E', 'F'};

String binaryToHexString(byte[] b){
	StringBuffer sb = new StringBuffer(b.length*2); //1 byte 8 bits, 1 hex char 4 bits
	for(int i=0; i<b.length; i++){
		sb.append( hexChar[(b[i]&0xf0)>>>4] );
		sb.append( hexChar[(b[i]&0x0f)] );
	}
	return sb.toString();
}

byte[] hexStringToBinary(String s){
	int len = s.length();
	byte[] data = new byte[len/2]; //1 byte 8 bits, 1 hex char 4 bits
	for(; i<len; i+=2){
		if( (i+1)==len )
			data[i/2] = (byte)( Character.digit(s.charAt(i),16) ); //if len is odd
		else
			data[i/2] = (byte)( Character.digit(s.charAt(i),16)<<4 + Character.digit(s.charAt(i+1),16) );
	}
	return data;
}

// like 0x06, big endian: 0110 0000  litter endian: 0000 0110

//Java
boolean endianess(){
	int num = 1;
	char ch = (char)num;
	return ch>0;
}

//c++
bool endianess(){
    int num = 1;
	char* pch = (char *)&num;
	return (*pch)>0;
}
//or
bool endianess(){
	union{
		int theInteger;
		char singleByte;
	}endianTest;
	
	endianTest.theInteger = 1;
	return endianTest.singleByte>0;
}

//reverte byte
byte reverse(byte ch){
	int base = 0x01, rbase = 0x80;
	byte ret = 0x00;
	while(base<=0x80){
		if( (base&ch)>0 ){
			ret |= rbase;
		}
		rbase >>>= 1;
		base <<= 1;
	}
	return ret;
}

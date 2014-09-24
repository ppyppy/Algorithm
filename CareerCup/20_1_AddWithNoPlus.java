int addWithNoPlus(int value, int carry){
	if(carry==0)
		return value;
	int sum = value^carry;
	int carry = (value&carry)<<1;
	return addWithNoPlus(sum, carry);
}
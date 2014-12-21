    //http://www.hawstein.com/posts/3.4.html
    
    //recursive
    void hanoi(int n, char src, char bri, char dst){
        if(n==1){
            System.out.println("Move disk " + n +" from " + src + " to " + dst);
        }
        else{
            hanoi(n-1, src, dst, bri);
            System.out.println("Move disk " + n +" from " + src + " to " + dst);
            hanoi(n-1, bri, src, dst);
        }
    }
   
   //iterative
    class op{
        int begin, end;
        char src, bri, dst;
        op(){

        }
        op(int pbegin, int pend, char psrc, char pbri, char pdst){
        	this.begin = pbegin;
        	this.end = pend;
        	this.src = psrc;
        	this.bri = pbri;
        	this.dst = pdst;
        }
    };
    void hanoi1(int n, char src, char bri, char dst){
        Stack<op> st = new Stack<op>();
        op tmp;
        st.push(new op(1, n, src, bri, dst));
        while(!st.empty()){
            tmp = st.pop();
            if(tmp.begin != tmp.end){
                st.push(new op(tmp.begin, tmp.end-1, tmp.bri, tmp.src, tmp.dst));
                st.push(new op(tmp.end, tmp.end, tmp.src, tmp.bri, tmp.dst));
                st.push(new op(tmp.begin, tmp.end-1, tmp.src, tmp.dst, tmp.bri));
            }
            else{
                System.out.println("Move disk " + tmp.begin +" from " + tmp.src + " to " + tmp.dst);
            }

        }
    }

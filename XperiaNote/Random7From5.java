我们先给出一个组合，再来进行分析。组合如下：

5 * (Rand5() - 1) + Rand5()
Rand5产生1到5的数，减1就产生0到4的数，乘以5后可以产生的数是：0,5,10,15,20。 再加上第二个Rand5()产生的1,2,3,4,5。我们可以得到1到25， 而且每个数都只由一种组合得到，即上述代码可以等概率地生成1到25。OK， 到这基本上也就解决了。

套用上面的模板，我们可以得到如下代码：

int Rand7(){
    int x = ~(1<<31); // max int
    while(x > 7)
        x = 5 * (Rand5() - 1) + Rand5() // Rand25
    return x;
}

Randab = b * (Randa - 1) + Randb
Randab = a * (Randb - 1) + Randa

publicclassSolution{
  public static int randomNumber7() {
      int values[][] = {  { 1, 1, 1, 2, 2 }, 
                          { 2, 3, 3, 3, 4 }, 
                          { 4, 4, 5, 5, 5 }, 
                          { 6, 6, 6, 7, 7 }, 
                          { 7, 0, 0, 0, 0} };
      int result = 0; 
     while (result == 0) {
         int i = randomNumber5(); 
         int j = randomNumber5();
         result = values[i-1][j-1];
     }
      return result; 
  }
  public static int randomNumber5() { 
      // implemented for us
  } 
}


Shuffle:

public static int[] shuffleArray(int[] input) {
    for (int i = 0; i < input.length; i++) {
        int swap = i + (int) (Math.random() * (input.length - i)); 
        int temp = input[swap];
        input[swap] = input[i];
        input[i] = temp;
    }
    return input; 
}

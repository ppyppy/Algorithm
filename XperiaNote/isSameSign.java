Question:
Given two integers, write a function that checks to see if the two numbers are the same sign using
bitwise operators.
Answer:
1. public class Solution43 {
2. public static boolean isSameSign(int x, int y) {
3.      return ((x ^ y) > 0); //only when x!=y, if x==y, equals 0
4. }
5. }

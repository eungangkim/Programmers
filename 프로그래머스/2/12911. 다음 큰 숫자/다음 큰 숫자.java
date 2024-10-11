class Solution {
    public int  solution(int n)
    {
      int a = Integer.bitCount(n);
      int compare = n+1;
      while(true) {
        if(Integer.bitCount(compare)==a)
          break;
        compare++;
      }
      return compare;
    }
}
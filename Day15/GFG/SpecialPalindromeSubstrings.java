//GFG
//Special Palindrome Substrings
//Time complexity: O(N*M)
//Space complexity: O(N)

package GFG;

public class SpecialPalindromeSubstrings {
    
    public static void main(String[] args) {
        String s1="abaa", s2="bb";
        System.out.println(specialPalindrome(s1, s2));
    }

    public  static int specialPalindrome(String a, String b){
        //Code Here
        int l1 = a.length(), l2 = b.length();
        if(l1<l2)
        return -1;
        
        int ans = Integer.MAX_VALUE;
         char s1[] = a.toCharArray(), s2[] = b.toCharArray();
         for(int i=0 ; i<l1-l2+1 ; i++)
        {
            //1
            char temp[]=(a.substring(0,i)+b+a.substring(i+l2)).toCharArray();
         //     for(char x : temp)
         //   {
         //       System.out.print(x+" ");
         //   }
         //   System.out.println();
             int cost=0;
        //2
             for(int j=i ; j<i+l2 ; j++)
             {
                 if(s1[j]!=temp[j])
                     cost++;
             }
             //   System.out.print(cost+" ");
         //3    
            int is_palin=1;
             for(int j=0 ; j<Math.ceil(l1/2.0) ; j++) // checking palindrome
             { 
     
              if((j<i || j>=i+l2) && temp[j]!=temp[l1-j-1]) // if s2 is in the 1st half 
                     cost++;
                     
              else if( (l1-i-1<j || l1-i-l2-1>=j) && temp[j]!=temp[l1-j-1])     //s2 in 2nd half 
               cost++;
               
               //s2 in mid 
               else if (temp[j]!=temp[l1-j-1])
                {
                    is_palin=0;// not poss to make it palindrome
                     break;
                }
             }
               if(is_palin==1)
                 ans=Math.min(ans,cost);
             
        }
         if(ans == Integer.MAX_VALUE){
           return -1;
         }
         return ans;
     }
}

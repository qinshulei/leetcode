/**
* Excel Sheet Column Title Total Accepted: 24226 Total Submissions: 135093 My Submissions Question Solution 
* Given a positive integer, return its corresponding column title as appear in an Excel sheet.
*
* For example:
*
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    53  -> BA
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.
*
*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String result="";
        
        while(n > 0)
        {
            char temp = 'A'-1;

            if (n%26==0){
              temp = 'Z';
              n = n / 26 - 1;
              result = temp + result;
          
            } else {
               temp = (char)(temp +  n%26);
               n = n / 26;
               result = temp + result;
            }
        }
        return result;
    }
    
    public String produce(int a)
    {
      return "";
    }
    
    public static void main(String[] argc)
    {
       ExcelSheetColumnTitle test=new ExcelSheetColumnTitle();
       System.out.println(test.convertToTitle(26));
       System.out.println(test.convertToTitle(27));
       System.out.println(test.convertToTitle(28));
       System.out.println(test.convertToTitle(53));
    }
}
class Solution {
    public boolean isPalindrome(String s){
        String str ="";
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                str += Character.toLowerCase(ch);
            }
        }
        String reverse ="";
        for(int j=str.length()-1;j>=0;j--){
                reverse += str.charAt(j);
            }

        return reverse.equals(str);    
    }
}
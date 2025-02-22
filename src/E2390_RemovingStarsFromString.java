import java.util.Stack;

public class E2390_RemovingStarsFromString {
    public String removeStars(String s) {
        
        char[] tokenz = s.toCharArray();
        Stack<Character> staccko = new Stack<>();

        for (int i = 0; i < tokenz.length; i++) {
            
            char currToken = tokenz[i];
            if (currToken == '*' && !staccko.isEmpty()){
                staccko.pop();
            }
            else{

                staccko.push(currToken);
            }

        }

        Character[] arr = staccko.toArray(new Character[0]);
        var sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();

    }
    
}

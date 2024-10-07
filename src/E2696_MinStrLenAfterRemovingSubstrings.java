import java.util.Stack;

public class E2696_MinStrLenAfterRemovingSubstrings {
    
    public int minLength(String s){
    
        Stack<Character> st = new Stack<>();
        char[] tokens = s.toCharArray();
        st.push(tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            
            if(tokens[i] == 'B'){
                if(!st.isEmpty() && st.peek() == 'A'){
                    st.pop();
                    continue;
                }
            }
            else if(tokens[i] == 'D'){
                if(!st.isEmpty() && st.peek() == 'C'){
                    st.pop();
                    continue;
                }
        
            }
            
            st.push(tokens[i]);
            
        }

        return st.size();

    }
}

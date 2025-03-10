import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M17_LetterCombosPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()){return new ArrayList<>();}
        HashMap<Character, char[]> map = initMap();
        ArrayList<String> combinations = new ArrayList<String>();
        char[] charDigits = digits.toCharArray();
        iterate(charDigits, 0, null, combinations, map);
        return combinations;

    }

    private HashMap<Character, char[]> initMap(){
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        return map;

    }
    
    private void iterate(char[] digits, int currDigitIndex, StringBuilder currString, ArrayList<String> combos, HashMap<Character, char[]> map){
        
        if(currString == null){
            currString = new StringBuilder();
        }

        if(currDigitIndex == digits.length){
            combos.add(currString.toString());
            return;
        }
    
        for(char token : map.get(digits[currDigitIndex])){
            currString.append(token);
            iterate(digits, currDigitIndex + 1, currString, combos, map);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}

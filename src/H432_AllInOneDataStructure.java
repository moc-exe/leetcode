import java.util.HashMap;

public class H432_AllInOneDataStructure{

    class AllOne {

        private HashMap<String, Integer> map;
        String maxKey = null;
        String minKey = null;

        public AllOne() {
            
            map = new HashMap<>();
        
        }
        
        public void inc(String key) {
            
            if(map.isEmpty()){

                map.put(key, 1);
                maxKey = key;
                minKey = key;
            
            }
            else if(!map.containsKey(key)){
                map.put(key, 1);
                minKey = checkMinKey();
            }
            else{

                var currCount = map.get(key);
                currCount +=1;
                map.put(key, currCount);
                maxKey = (currCount > map.get(maxKey) ? key : maxKey);
                minKey = (key.equals(minKey) ? checkMinKey() : minKey);
                
            }

        }
        
        public void dec(String key) {
            
            var currCount = map.get(key);
            currCount--;
            if(currCount == 0){
            
                map.remove(key);
                if(map.isEmpty()){
                    minKey = null; 
                    maxKey = null;
                    return;
                }
                maxKey = checkMaxKey();
                minKey = checkMinKey();
            }
            else{

                map.put(key, currCount);
                maxKey = (key.equals(maxKey) ? checkMaxKey() : maxKey);

            }
            






        }
        
        public String getMaxKey() { return map.isEmpty() ? "" : maxKey;}
        
        public String getMinKey() { return map.isEmpty() ? "" : minKey;}

        // if incr curr min key --> check for new min key 
        // if decr curr max key --> check for new max key
        // overall incr and decr max / min keys should be spread across many ops and shouldnt affect the avg complexity
        // also needa track the size of the main hashmap to 

        // will only be called if the incremented key is truly the min key curr
        private String checkMinKey(){

            var min = (map.get(minKey) == null ? map.get(maxKey) : map.get(minKey));
            
            for (var key : map.keySet()){

                if (map.get(key) <= min){

                    minKey = key;
                    min = map.get(key);
                
                }
            }
        
            return minKey;
        }

        private String checkMaxKey(){

            // we know wont be called in context of an empty map

            var max = (map.get(maxKey) == null ? 0 : map.get(maxKey));

            for (var key : map.keySet()){

                if (map.get(key) > max){

                    maxKey = key;
                    max = map.get(key);
                
                }
            }

            return maxKey;
        }

    }

    /**
     * Your AllOne object will be instantiated and called as such:
     * AllOne obj = new AllOne();
     * obj.inc(key);
     * obj.dec(key);
     * String param_3 = obj.getMaxKey();
     * String param_4 = obj.getMinKey();
     */

}
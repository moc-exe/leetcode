// link: https://leetcode.com/problems/design-circular-deque/?envType=daily-question&envId=2024-09-28

public class M641_CircularDeque {
    
    class MyCircularDeque {

        private final int MAX_CAPACITY;
        private final int arrLen;
        private int[] mainArr; 
        private int front; 
        private int rear;
        private int size;

        public MyCircularDeque(int k) {
            MAX_CAPACITY = k;
            arrLen = MAX_CAPACITY + 1;
            mainArr = new int[arrLen];
            front = 0; 
            rear = 0; 
            size = 0; 
        }
        
        public boolean insertFront(int value) {
            
            if(isFull()){
                return false;
            }
            else{

                if(((front - 1) % arrLen + arrLen) % arrLen == rear){
                    return false;
                }
                else{

                    front = ((front - 1) % arrLen + arrLen) % arrLen;
                    mainArr[front] = value; 
                    size++; 
                    return true; 
                }
            
            }
        }
        
        public boolean insertLast(int value) {
            
            if(isFull()){
                return false;
            }
            else{

                if(((rear + 1) % arrLen + arrLen) % arrLen == front){
                    return false;
                }
                else{

                    mainArr[rear] = value;
                    rear = ((rear + 1) % arrLen + arrLen) % arrLen;
                    size++;
                    return true;
                }
            }

        }
        
        public boolean deleteFront() {
            
            if(isEmpty()){return false;}
            else{

                front = ((front + 1) % arrLen + arrLen) % arrLen;
                size--;
                return true;
            }

        }
        
        public boolean deleteLast() {

            if(isEmpty()){return false;}
            else{

                rear = ((rear - 1) % arrLen + arrLen) % arrLen;
                size--;
                return true;

            }

        }
        
        public int getFront() { return isEmpty() ? -1 : mainArr[front];}
        
        public int getRear() { return isEmpty() ? -1 : mainArr[((rear-1) % arrLen + arrLen)%arrLen];}
        
        public boolean isEmpty() { return size == 0;}
        
        public boolean isFull() { return size == MAX_CAPACITY;}
    }
    
    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */


}

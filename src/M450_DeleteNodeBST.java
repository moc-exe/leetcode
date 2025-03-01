/* 
 * MEDIUM 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */

public class M450_DeleteNodeBST {
    
    public class TreeNode{
        
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    
    }

    public TreeNode deleteNode(TreeNode root, int key){

        // 3 situations

        if(root == null){
            return null;
        }
        TreeNode[] targetNodes = new TreeNode[2];
        getNodes(root, null, targetNodes, key);

        TreeNode targetParent = targetNodes[0];
        TreeNode removalTarget = targetNodes[1];

        if(targetParent == null && removalTarget == null){
            // nothhing found
            return root;
        }

        if(removalTarget.left == null && removalTarget.right == null){
            // no children, simply remove the target

            if(targetParent == null){
                // means it's the head that has to be removed
                return null;

            }
            else{

                if(isLeftChild(targetParent, removalTarget)){
                    targetParent.left = null;
                }
                else{ // right child
                    targetParent.right = null;
                }
            }
        }
        else if(removalTarget.left == null && removalTarget.right != null){
            // only right child exists
            if(targetParent == null){
                // then it's head

               return removalTarget.right;

            }
            else{

                if(isLeftChild(targetParent, removalTarget)){
                    targetParent.left = removalTarget.right;
                }
                else{
                    targetParent.right = removalTarget.right;
                }
            }
        }
        else if(removalTarget.right == null && removalTarget.left != null){

            if(targetParent == null){
                // then it's head
               return removalTarget.left;
            }
            else{
                if(isLeftChild(targetParent, removalTarget)){
                    targetParent.left = removalTarget.left;
                }
                else{
                    targetParent.right = removalTarget.left;
                }
            }
        }
        else{
            
            // else 2 children
            
            TreeNode[] predecessorAndParent = getInOrderLeftPredecessor(removalTarget.left, removalTarget);

            TreeNode predecessor = predecessorAndParent[1];
            TreeNode predecessorParent = predecessorAndParent[0];

            removalTarget.val = predecessor.val;
            
            if(predecessorParent == removalTarget){
                predecessorParent.left = predecessor.left;
            }
            else{
                predecessorParent.right = predecessor.left;
            }
        }
        return root;
    }

    public void getNodes(TreeNode curr, TreeNode prev, TreeNode[] nodesArr, int key){

        if(curr == null){
            return;
        }

        if(curr.val == key){
            nodesArr[0] = prev;
            nodesArr[1] = curr;
            return;
        }

        if(curr.left != null){

            getNodes(curr.left, curr, nodesArr, key);

        }
        if(curr.right != null){

            getNodes(curr.right, curr, nodesArr, key);
        }
    }

    public boolean isLeftChild(TreeNode parent, TreeNode child){

        return child == parent.left ? true : false;
    
    }

    public TreeNode[] getInOrderLeftPredecessor(TreeNode curr, TreeNode parent){


        while(curr.right != null){

            parent = curr;
            curr = curr.right;

        }

        TreeNode[] arr = new TreeNode[2];
        arr[0] = parent;
        arr[1] = curr;
        return arr;
    }
    

}

package important450.tree;

public class ConstructTree_from_Inorder_Preorder {
    Node root;
    int preIndex;
    Node buildTree(int[] inorder, int[] preorder, int n) {
        root = null;
        preIndex = 0;
        buildTreeUtil(inorder, preorder, 0, inorder.length-1);
        return root;
    }

    Node buildTreeUtil(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return null;

        Node tempNode = new Node(preOrder[preIndex++]);
        if (startIndex == endIndex)
            return tempNode;

        int inIndex = search(inOrder, startIndex, endIndex, tempNode.data);

        tempNode.left = buildTreeUtil(inOrder, preOrder, startIndex, inIndex-1);
        tempNode.right = buildTreeUtil(inOrder, preOrder, inIndex+1, endIndex);

        return tempNode;
    }

    int search(int[] arr, int start, int end, int value) {
        int i;
        for(i=start; i<= end; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        int[] inorder = {1, 6, 8, 7};
        int[] preorder = {1, 6, 7, 8};

        ConstructTree_from_Inorder_Preorder sed = new ConstructTree_from_Inorder_Preorder();
        sed.buildTree(inorder, preorder, 4);
    }
}

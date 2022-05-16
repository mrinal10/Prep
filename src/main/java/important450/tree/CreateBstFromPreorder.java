package important450.tree;

class Index {
    int index = 0;
}
public class CreateBstFromPreorder {
    Index index;
    int arraySize = 0;
    private TreeNode bstFromPreorderUtil(int[] preorder, Index curIndex, int key, int min, int max) {

        if(curIndex.index >= arraySize) {
            return null;
        }

        TreeNode root = null;

        if(key > min && key < max) {
            root = new TreeNode(key);
            curIndex.index += 1;

            if(curIndex.index > arraySize) {
                root.left = bstFromPreorderUtil(preorder, curIndex, preorder[curIndex.index], min, key );
            }
            if(curIndex.index > arraySize) {
                root.right = bstFromPreorderUtil(preorder, curIndex, preorder[curIndex.index], key, max );
            }
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        arraySize = preorder.length;
        index = new Index();
        return bstFromPreorderUtil(preorder, index, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

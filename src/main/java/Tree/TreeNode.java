package Tree;

/**
 * @Auther: 99615
 * @Date: 2021/1/28 09:48
 * @Description:
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x){
        val=x;
    }
    @Override
    public String toString(){
        return "val: "+val;
    }
}

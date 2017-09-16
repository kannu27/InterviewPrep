
public class BSTNode<T>{

    public int key;
    public  T data;
    public  BSTNode<T> left;
    public BSTNode<T> right;

    public BSTNode(int key, T data){
      this.key = key;
      this.data = data;
    }

    public String toString(){
      return "Key and node value is [" + this.key + "," + this.data.toString() + "]";
    }

    public T search(BSTNode<T> node,int key){
      if(node == null) return null;
      if(node.key == key){
        return node.data;
      }else if (key <= node.key){
        return search(node.left, key);
      }else{
          return search(node.right, key);
      }

    }
    public boolean contains(BSTNode<T> root,int key){
      if(root == null) return false;
      if(root.key == key){
        return true;
      }else if (key <= root.key){
        return contains(root.left, key);
      }else{
          return contains(root.right, key);
      }

    }

    public  BSTNode<T> insert(BSTNode<T> root, int key, T data){
      if(root == null){
          return new BSTNode<T>(key, data);
      }else{
        if(key <= root.key){
          root.left = insert(root.left, key, data);
        }else{
          root.right = insert(root.right, key, data);
        }
        return root;
      }
    }

    public void preOrder(BSTNode<T> root){
      if(root == null) return;
      visit(root);
      preOrder(root.left);
      preOrder(root.right);
    }
    public void InOrder(BSTNode<T> root){
      if(root == null) return;
      InOrder(root.left);
      visit(root);

      InOrder(root.right);
    }

    public void postOrder(BSTNode<T> root){
      if(root == null) return;

      postOrder(root.left);
      postOrder(root.right);
      visit(root);
    }
    private void visit(BSTNode<T> node){
      System.out.println(node.toString());
    }

    public static void main(String[] args)
    {
      System.out.println("Hiii");
      BSTNode<String> root = new BSTNode<String>(50, "Ganmani");
      root = root.insert(root,10, "Vanz");
      root = root.insert(root,60, "Anees");
      root = root.insert(root,15, "CD");
      System.out.println(root.search(root,10).toString());
      root.InOrder(root);
    }


}

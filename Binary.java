import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter values to insert into the binary tree");

        int value;
        while (true) {
            System.out.print("Enter a value (0 to stop): ");
            value = scan.nextInt();

            if (value == 0) {
                break;
            }

            binaryTree.insert(value);
        }

        while (true) {
            System.out.println("\nBinary Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Traversal");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scan.nextInt();
                    binaryTree.insert(insertValue);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scan.nextInt();
                    binaryTree.delete(deleteValue);
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = scan.nextInt();
                    boolean found = binaryTree.search(searchValue);
                    System.out.println(found ? "Value found in the tree." : "Value not found in the tree.");
                    break;
                case 4:
                    System.out.println("Traversal Options:");
                    System.out.println("1. Preorder");
                    System.out.println("2. Inorder");
                    System.out.println("3. Postorder");
                    System.out.print("Enter traversal choice: ");
                    int traversalChoice = scan.nextInt();
                    binaryTree.traverse(traversalChoice);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
}

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Insert a node
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Delete a node
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private TreeNode deleteRec(TreeNode root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Search for a node
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode root, int data) {
        if (root == null || root.data == data) {
            return root != null;
        }

        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    // Perform tree traversal
    public void traverse(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Preorder Traversal:");
                preorder(root);
                break;
            case 2:
                System.out.println("Inorder Traversal:");
                inorder(root);
                break;
            case 3:
                System.out.println("Postorder Traversal:");
                postorder(root);
                break;
            default:
                System.out.println("Invalid choice for traversal");
        }
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** @author 
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {
	// Exercise 1

	/**
	 * negateAll is a method that converts the positives elements of a tree to negative
	 * and negative elements to positive.
	 * @param t is a tree of integers 
	 * @return returns empty tree if the tree is empty else
	 * returns a new tree containing all the elements of a with their sign negated
	 */
	public static Tree<Integer> negateAll(Tree<Integer> t) {

		if (t.isEmpty())
			return t;
		else
			return new Tree<Integer>(t.getValue()*-1, negateAll(t.getLeft()), 
					negateAll(t.getRight()));
	}

	// Exercise 2
	/**
	 * allPositives is boolean method that checks whether all the values in its nodes are positive
	 * @param a is a tree of integers
	 * @return returns true if the tree is empty or if all nodes are 
	 * positives (greater or equal to zero), else it returns false if 
	 * any node of the tree is a negative integer 
	 */
	public static boolean allPositive(Tree<Integer> a) {

		if (a.isEmpty())
			return true;
		else if (a.getValue()>= 0 && allPositive(a.getLeft()) && allPositive(a.getRight()))
			return  true;

		else 
			return false;
	}

	// Exercise 3
	/**
	 * Method mirror creates a tree that is the mirror image of a along the left-right axis
	 * @param t is a tree of Generic Type
	 * @return returns empty tree if the tree is empty else returns
	 * mirror image of a along the left-right axis of the tree 
	 */
	public static<E> Tree<E> mirror(Tree<E> t) {
		if (t.isEmpty())
			return t;

		else
			return new Tree<E>(t.getValue(), mirror(t.getRight()), mirror(t.getLeft())); // swap getRight and getLeft

	}

	// Exercise 4
	/**
	 * Postorder method created a list of Generic Type with postorder using 
	 * the helper function postorder
	 * @param t is a tree of Generic Type
	 * @return returns a list as postorder
	 */
	public static<E> List<E> postorder(Tree<E> t) {

			return postorder(t, new List());
			
//			return ListOpsGeneric.append(postorder(t.getLeft()), 
//					ListOpsGeneric.append(postorder(t.getRight()), ListOpsGeneric.cons(t.getValue(),new List<E>())));
	}
	/**
	 * postorder is a helper function for postorder method by 
	 * changing the argument to fit the 
	 * @param t is a tree of Generic Type
	 * @param l is a list of Generic Type
	 * @return returns a list of Generic Type
	 */
	public static<E> List<E> postorder(Tree<E> t, List<E> l) {
		
		if (t.isEmpty())
		return l;
		else
		return postorder(t.getLeft(), postorder(t.getRight(), 
					new List(t.getValue(),l)));
	}

	// Exercise 5
	/**
	 * Method isSearchTree is a boolean method that checks
	 * whether a tree is a binary search tree using a 
	 * helper function isSearchTree
	 * @param a is a tree of integers
	 * @return returns true if tree is empty or when the tree is
	 * a binary search tree else returns false
	 */
	public static boolean isSearchTree(Tree<Integer> a) {

		if (a.isEmpty())
			return true;

			return isSearchTree(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * isSearchTree is the helper function for isSearchTree method
	 * @param a is a tree of integers
	 * @param min is the minimum integer value that the root can take 
	 * @param max is the maximum integer value that the root can take
	 * @return returns false if a node does not follow the binary search tree 
	 * properties and or true if it does
	 */
	public static boolean isSearchTree(Tree<Integer> a, int min, int max) {

		if (a.getValue()<min || a.getValue()>max)
			return false;

		boolean left=false; 
		
		if (!a.getLeft().isEmpty()) {
		
				if (a.getLeft().getValue()<a.getValue()) {

					left = isSearchTree(a.getLeft(), min, a.getValue());
				}
		else 
			left = false;
		}else {
			left = true;
		}
		boolean right = false; 
		
		if (!a.getRight().isEmpty()) {
		
				if (a.getRight().getValue()>a.getValue()) {

					right = isSearchTree(a.getRight(), a.getValue()+1, max);
				}
		else 
			right = false;
		}else {
			right = true;
		}
		return (left && right);

	}

	// Exercise 6
	/**
	 * This method prints values stored in a tree in descending order
	 * @param a is a tree of integers
	 */
	public static void printDescending(Tree<Integer> a) {
		if (!a.isEmpty()) {
		
			
			printDescending(a.getRight());
			System.out.printf( a.getValue()+" ");
			printDescending(a.getLeft());
		}
	 
	}

	// Exercise 7
	/**
	 * Method max finds the maximum value stored in a 
	 * binary search tree searching only on the right side
	 * making the search O(log n) time 
	 * @param a is a tree of integers
	 * @throws throws illegalArgumentException if the tree is empty
	 * @return returns the root if the tree only contains 1 value
	 * else returns the maximum value in a tree
	 */
	public static int max(Tree<Integer> a) {
	
		if (a.isEmpty())
            throw new IllegalArgumentException("Tree does not have any nodes");
		
		else if (a.getRight().isEmpty())
            return a.getValue();
		
		else if (a.getValue() < a.getRight().getValue())
			return max(a.getRight());
		
		return a.getValue();
	}

	// Exercise 8
	/**
	 * Delete method deletes a node from the tree
	 * maintaining the binary search tree properties
	 * @param a is a tree of integers
	 * @param x is the node that needs to be deleted
	 * @return returns empty list if tree is empty else returns
	 * a new tree with x deleted
	 */
	public static Tree<Integer> delete(Tree<Integer> a, int x) {
	
		if (a.isEmpty()) 
		      return new Tree();
		
		// new tree to hold the right or left subtree that x is placed as root
		Tree r = a.getRight();
		Tree<Integer> l = a.getLeft();
		
		// finding x
		      
	if (x < a.getValue()) {
			 l = delete(a.getLeft(), x);
				return new Tree(a.getValue(), l, a.getRight());
		}
		else if (x > a.getValue()){
			 r = delete(a.getRight(),x);
		 	return new Tree(a.getValue(), a.getLeft(), r);
		}
	
	// case 2 if the node has 1 child
		else {
			if (l.isEmpty())
				return r;
		
		else 
			if (r.isEmpty())
				return  l;
		}
		 
	// case 3 if the node has 2 children
	
		int z = max(l);
		
		//delete(l,node); // how to delete z in the old position??
		return new Tree(z, delete(l,z), r);
		    	
	}


	// Exercise 9
	/**
	 * isHeightBalanced method is a boolean method checking
	 * whether a tree is Height Balanced Tree
	 * @param a is a tree of integers
	 * @return returns true if the tree is empty or the tree is Height Balanced Tree
	 * else returns false 
	 */
	public static<E> boolean isHeightBalanced(Tree<E> a) {
		
		if (a.isEmpty())
		return true;
		int diff = Math.abs((a.getLeft().getHeight()-a.getRight().getHeight()));
		isHeightBalanced(a.getLeft());
		isHeightBalanced(a.getRight());
		
		
		if (diff > 1)
			return false;
		else 
			return true;
		
			
	}

	// Exercise 10
	/**
	 * insertHB method inserts a node in a tree 
	 * and maintains the height balanced tree properties
	 * using the helper function leftRotate and rightRotate
	 * @param x is the node that needs to be inserted
	 * @param a is a tree of integers
	 * @return returns a new tree with the new node inserted
	 */
	public static Tree<Integer> insertHB(int x, Tree<Integer> a) {
		
		if (a.isEmpty())
		return new Tree(x);
			
		
		else if (x < a.getValue()) {
				Tree l = insertHB(x, a.getLeft());
				return rightRotate(new Tree(a.getValue(), l, a.getRight()));
		}
			else {
				
				Tree r = insertHB(x,a.getRight());
				return  leftRotate(new Tree(a.getValue(), a.getLeft(), r));
		
			}
	}
	
	/**
	 * deleteHB method deletes a node in a tree 
	 * and maintains the height balanced tree properties
	 * using the helper function leftRotate and rightRotate
	 * @param x is the node that needs to be deleted
	 * @param a is a tree of integers
	 * @return returns empty tree if the tree is empty else
	 * returns a new tree with the new node inserted 
	 */
	public static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if (a.isEmpty()) 
		      return new Tree();
		
		// new tree to hold the right or left subtree that x is placed as root
		Tree r = a.getRight();
		Tree<Integer> l = a.getLeft();
		
		// finding x
		      
	if (x < a.getValue()) {
			 l = delete(a.getLeft(), x);
				return leftRotate(new Tree(a.getValue(), l, a.getRight()));
		}
		else if (x > a.getValue()){
			 r = delete(a.getRight(),x);
		 	return rightRotate(new Tree(a.getValue(), a.getLeft(), r));
		}
	
	// case 2 if the node has 1 child
		else {
			if (l.isEmpty())
				return r;
		
		else 
			if (r.isEmpty())
				return  l;
		}
		 
	// case 3 if the node has 2 children
	
		int z = max(l);
		
		//delete(l,node); // how to delete z in the old position??
		return new Tree(z, delete(l,z), r);
	}
	
	
		/**
		 * rightRotate is a helper function for method deleteHB and
		 * insertHB to ensure that the tree maintains the AVL 
		 * properties when it is left heavy
		 * @param a is an Integer tree
		 * @return returns a tree thats is balanced according to the
		 * AVL rules
		 */
		// rotates the left side thats inbalanced leftleft tree
		public static Tree<Integer> rightRotate( Tree<Integer> a) { 
	
		
			if (!isHeightBalanced(a)) {// if not height balanced
				
				if (a.getLeft().getLeft().getHeight()+1 > a.getLeft().getRight().getHeight()) {
					Tree right = new Tree(a.getValue(), a.getLeft().getRight(), a.getRight());
				//single rotation left heavy tree LL
					return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), right);
				}
					else {
						Tree leftDouble =  new Tree(a.getLeft().getValue(), a.getLeft().getLeft(),
						a.getLeft().getRight().getLeft());
						Tree rightDouble = new Tree(a.getValue(), a.getLeft().getRight().getRight(), a.getRight());
				//double rotation left heavy tree LR
				return new Tree(a.getLeft().getRight().getValue(), leftDouble, rightDouble);
					}
			}
			else 
				return a;
		}
		/**
		 * leftRotate is a helper function for method deleteHB and
		 * insertHB to ensure that the tree maintains the AVL 
		 * properties when it is right heavy
		 * @param a is an Integer tree
		 * @return returns a tree thats is balanced according to the
		 * AVL rules
		 */
		public static Tree<Integer> leftRotate( Tree<Integer> a) { 
			
			if (!isHeightBalanced(a)) {  // if not height balanced
				
			if (a.getRight().getRight().getHeight() +1 > a.getRight().getLeft().getHeight()) {
				Tree left = new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft());
			//single rotation left heavy tree LL
			return new Tree(a.getRight().getValue(), left, a.getRight().getRight());
			}
		
			else {
				Tree leftDouble =  new Tree(a.getValue(), a.getLeft(),
						a.getRight().getLeft().getRight());
		Tree rightDouble = new Tree(a.getRight().getValue(), a.getRight().getLeft().getRight(), 
						a.getRight().getRight());
			//double rotation left heavy tree LR
			return new Tree(a.getRight().getRight().getValue(), leftDouble, rightDouble);
			}
			}
			else 
				return a;
			

		}
	
	
}

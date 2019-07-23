import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author Shukri Ali
 * 
 *
 */

public class Worksheet2Test {
	
	

	Tree<Integer> a =new Tree ();//empty tree
	Tree<Integer> b =new Tree (50, new Tree(), new Tree()); // tree with one node
	Tree<Integer> c =new Tree (50, new Tree(25, new Tree(10),new Tree()), new Tree()); // left left tree 
	Tree<Integer> d =new Tree (50, new Tree(), new Tree(60, new Tree(), new Tree(70))); // right right tree
	Tree<Integer> e =new Tree (50 , new Tree(25, new Tree(10),new Tree(30)), 
			new Tree(60, new Tree(55), new Tree(70))); // Balanced Search Tree
	Tree<Integer> f =new Tree (10, new Tree(-5, new Tree(-15),new Tree(-1)), 
			new Tree(20, new Tree(55), new Tree(70))); // tree with negative and positive valueas
	Tree<Integer> g = new Tree(10, new Tree(5, new Tree(), new Tree(7)), new Tree()); // left right tree
	Tree<Integer> h = new Tree(10, new Tree(), new Tree(15, new Tree(12), new Tree())); //right left tree
	Tree<Integer> z =new Tree (50, 
			new Tree(25, new Tree(10, new Tree(5), new Tree()),new Tree()), 
			new Tree()); 
	
	//Exercise 1 - negateAll
		@Test
		public void ex1Test1() {
			
			Tree expected = new Tree ();
			Tree  actual = Worksheet2.negateAll(a);
			assertEquals(actual, expected);
		}
		@Test
		public void ex1Test2() {
			Tree expected = new Tree (-50, new Tree(), new Tree());
			Tree  actual = Worksheet2.negateAll(b);
			assertEquals(actual, expected);
		}
		@Test
		public void ex1Test3() {
			Tree expected = new Tree (-10, new Tree(5, new Tree(15),new Tree(1)), 
					new Tree(-20, new Tree(-55), new Tree(-70))); 
			Tree  actual = Worksheet2.negateAll(f);
			assertEquals(actual, expected);
		}
		
		//Exercise 2 - allPositive
		@Test
		public void ex2Test1() {

			Boolean expected = true;
			boolean  actual = Worksheet2.allPositive(a);
			assertEquals(actual, expected);
		}
		@Test
		public void ex2Test2() {
			Boolean expected = true;
			Boolean  actual = Worksheet2.allPositive(b);
			assertEquals(actual, expected);
		}
		@Test
		public void ex2Test3() {
			Boolean expected = false; 
			Boolean  actual = Worksheet2.allPositive(f);
			assertEquals(actual, expected);
		}
		//Exercise 3 - mirror
		@Test
		public void ex3Test1() {

			Tree expected = new Tree ();
			Tree  actual = Worksheet2.mirror(a);
			assertEquals(actual, expected);
		}
		@Test
		public void ex3Test2() {
			Tree expected = new Tree (50, new Tree(), new Tree());
			Tree  actual = Worksheet2.mirror(b);
			assertEquals(actual, expected);
		}
		@Test
		public void ex3Test3() {
			Tree expected = new Tree (50, new Tree(60, new Tree(70),new Tree(55)), 
					new Tree(25, new Tree(30), new Tree(10)));
			Tree  actual = Worksheet2.mirror(e);
			assertEquals(actual, expected);
		}
		@Test
		public void ex3Test4() {
			Tree expected = new Tree (50, new Tree(), new Tree(25, new Tree(), new Tree(10)));
			Tree  actual = Worksheet2.mirror(c);
			assertEquals(actual, expected);
		}
		//Exercise 4 - postorder
		@Test
		public void ex4Test1() {

			List expected = new List ();
			List  actual = Worksheet2.postorder(a);
			assertEquals(actual, expected);
		}
		@Test
		public void ex4Test2() {
			List<Integer> expected = new List<Integer>();
			expected = new List<Integer>(50, expected);
			List  actual = Worksheet2.postorder(b);
			assertEquals(actual, expected);
		}
		@Test
		public void ex4Test3() {
			List<Integer> expected = new List<Integer>();
			expected = new List<Integer>(50, expected);
			expected = new List<Integer>(60, expected);
			expected = new List<Integer>(70, expected);
			expected = new List<Integer>(55, expected);
			expected = new List<Integer>(25, expected);
			expected = new List<Integer>(30, expected);
			expected = new List<Integer>(10, expected);
			List  actual = Worksheet2.postorder(e);
			assertEquals(actual, expected);
		}
		@Test
		public void ex4Test4() {
			List<Integer> expected = new List<Integer>();
			expected = new List<Integer>(50, expected);
			expected = new List<Integer>(60, expected);
			expected = new List<Integer>(70, expected);
			List  actual = Worksheet2.postorder(d);
			assertEquals(actual, expected);
		}
		
		//Exercise 5 - isSearchTree
		@Test
		public void ex5Test1() {

			Boolean expected = true;
			boolean  actual = Worksheet2.isSearchTree(a);
		}
		@Test
		public void ex5Test2() {
			Boolean expected = false;
			Boolean  actual = Worksheet2.isSearchTree(b);
		}
		@Test
		public void ex5Test3() {
			Boolean expected = true; 
			Boolean  actual = Worksheet2.isSearchTree(f);
		}
		
		//Exercise 7 - isSearchTree
		@Test (expected = IllegalArgumentException.class)
		public void ex7Test1() {
			
			Worksheet2.max(a);
		}
		@Test
		public void ex7Test2() {
			int expected = 50;
			int  actual = Worksheet2.max(b);
			assertEquals(actual, expected);
		}
		@Test
		public void ex7Test3() {
			int expected = 70; 
			int  actual = Worksheet2.max(f);
			assertEquals(actual, expected);
		}
		//Exercise 8 - delete
		@Test
		public void ex8Test1() {
			
			Tree expected = new Tree ();
			Tree  actual = Worksheet2.delete(a,8);
			assertEquals(actual, expected);
		}
		@Test
		public void ex8Test2() {
			Tree expected = new Tree ();
			Tree  actual = Worksheet2.delete(b,50);
			assertEquals(actual, expected);
		}
		@Test
		public void ex8Test3() {
			Tree expected = new Tree (30, new Tree(25, new Tree(10),new Tree()), 
					new Tree(60, new Tree(55), new Tree(70)));
			Tree  actual = Worksheet2.delete(e,50);
			assertEquals(actual, expected);
		}
		@Test
		public void ex8Test4() {
			Tree<Integer> expected =
					new Tree (50, 
	    			new Tree(10, new Tree(5), new Tree()), 
	    			new Tree()); 
			Tree  actual = Worksheet2.delete(z,25);
			assertEquals(actual, expected);
		}
		//Exercise 9 - allPositive
		@Test
		public void ex9Test1() {

			Boolean expected = true;
			boolean  actual = Worksheet2.isHeightBalanced(a);
			assertEquals(actual, expected);
		}
		@Test
		public void ex9Test2() {
			Boolean expected = true;
			Boolean  actual = Worksheet2.isHeightBalanced(b);
			assertEquals(actual, expected);
		}
		@Test
		public void ex9Test3() {
			Boolean expected = true; 
			Boolean  actual = Worksheet2.isHeightBalanced(f);
			assertEquals(actual, expected);
		}
		
		//Exercise 10A - InsertHB
		@Test
		public void ex10ATest1() {
			Tree<Integer> a1 =new Tree (50, new Tree(25, new Tree(),new Tree()), new Tree()); // left left tree 
			Tree expected = new Tree (25, new Tree(10), new Tree(50));
			Tree  actual = Worksheet2.insertHB(10,a1);
			assertEquals(actual, expected);
		}
		@Test
		public void ex10ATest2() {
			Tree<Integer> a2 =new Tree (50, new Tree(), new Tree(60));//right right tree
			Tree expected = new Tree (60, new Tree(50), new Tree(70));
			Tree  actual = Worksheet2.insertHB(70,a2);
			assertEquals(actual, expected);
		}
		@Test
		public void ex10ATest3() {
			Tree<Integer> a0 = new Tree(10, new Tree(5, new Tree(), new Tree()), new Tree()); // left right tree
			Tree expected = new Tree(7, new Tree(5), new Tree(10));
			Tree  actual = Worksheet2.insertHB(7,a0);
			assertEquals(actual, expected);
		}
		@Test
		public void ex10ATest4() {
			Tree<Integer> a4 =new Tree (50, new Tree(25), new Tree()); // left left tree 
			Tree<Integer> expected =new Tree(25, new Tree(10), new Tree(50));
			Tree  actual = Worksheet2.insertHB(10,a4);
			assertEquals(actual, expected);
		}
		//Exercise 10B - deleteHB
		@Test
		public void ex10BTest1() {
			Tree<Integer> c =new Tree (50, new Tree(25, new Tree(10),new Tree()), new Tree(70)); // left left tree 
			Tree expected = new Tree (25, new Tree(10), new Tree(50));
			Tree  actual = Worksheet2.deleteHB(c,70);
			assertEquals(actual, expected);
		}
		@Test
		public void ex10BTest2() {
			Tree<Integer> d =new Tree (50, new Tree(25), new Tree(60, new Tree(), new Tree(70))); // right right tree
			Tree expected = new Tree (60, new Tree(50), new Tree(70));
			Tree  actual = Worksheet2.deleteHB(d,25);
			assertEquals(actual, expected);
		}
		@Test
		public void ex10BTest3() {
			Tree<Integer> g = new Tree(10, new Tree(5, new Tree(), new Tree(7)), new Tree()); // left right tree
			Tree expected = new Tree (30, new Tree(25, new Tree(10),new Tree()), 
					new Tree(60, new Tree(55), new Tree(70)));
			Tree  actual = Worksheet2.deleteHB(e,50);
			assertEquals(actual, expected);
		}
		@Test
		public void ex10BTest4() {
			Tree<Integer> h = new Tree(10, new Tree(6), new Tree(20,new Tree(), new Tree(25))); //right left tree
			Tree<Integer> expected =
					new Tree (20, new Tree(10), new Tree(25)); 
			Tree  actual = Worksheet2.deleteHB(h,6);
			assertEquals(actual, expected);
		}
}

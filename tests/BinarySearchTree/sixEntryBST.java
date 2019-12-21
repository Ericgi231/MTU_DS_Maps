import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;

@jug.SuiteName("sixEntryBST")
public class sixEntryBST {

	private BinarySearchTree<Integer,String> TARGET = init();
	private BinarySearchTree<Integer,String> T = init();

	public BinarySearchTree<Integer,String> init() {
		return new BinarySearchTree<Integer,String>();
	}

	@Before
	public void setup() throws Throwable {
		TARGET.put(10,"A");
			TARGET.put(5,"B");
			TARGET.put(15,"C");
			TARGET.put(8,"D");
			TARGET.put(9,"E");
			TARGET.put(3,"F");
	}

	@org.junit.Test()
	@jug.TestName("size() is 6")
	public void Test1() throws Throwable {
		
		org.junit.Assert.assertEquals("size() is 6", (Object)(6), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("check the tree is build correctly: root has 10")
	public void Test2() throws Throwable {
		
		org.junit.Assert.assertEquals("check the tree is build correctly: root has 10", (Object)(10), (Object)(TARGET.getTree().root().getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("check the tree is build correctly: 10's left is 5")
	public void Test3() throws Throwable {
		
		org.junit.Assert.assertEquals("check the tree is build correctly: 10's left is 5", (Object)(5), (Object)(TARGET.getTree().left(TARGET.getTree().root()).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("check the tree is build correctly: 10's right is 15")
	public void Test4() throws Throwable {
		
		org.junit.Assert.assertEquals("check the tree is build correctly: 10's right is 15", (Object)(15), (Object)(TARGET.getTree().right(TARGET.getTree().root()).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("check the tree is build correctly: 5's left is 3")
	public void Test5() throws Throwable {
		
		org.junit.Assert.assertEquals("check the tree is build correctly: 5's left is 3", (Object)(3), (Object)(TARGET.getTree().left(TARGET.getTree().left(TARGET.getTree().root())).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("check the tree is build correctly: 5's right is 8")
	public void Test6() throws Throwable {
		
		org.junit.Assert.assertEquals("check the tree is build correctly: 5's right is 8", (Object)(8), (Object)(TARGET.getTree().right(TARGET.getTree().left(TARGET.getTree().root())).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("check the tree is build correctly: 8's right is 9")
	public void Test7() throws Throwable {
		
		org.junit.Assert.assertEquals("check the tree is build correctly: 8's right is 9", (Object)(9), (Object)(TARGET.getTree().right(TARGET.getTree().right(TARGET.getTree().left(TARGET.getTree().root()))).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("get(10)")
	public void Test8() throws Throwable {
		
		org.junit.Assert.assertEquals("get(10)", (Object)("A"), (Object)(TARGET.get(10)));
	}

	@org.junit.Test()
	@jug.TestName("get(8)")
	public void Test9() throws Throwable {
		
		org.junit.Assert.assertEquals("get(8)", (Object)("D"), (Object)(TARGET.get(8)));
	}

	@org.junit.Test()
	@jug.TestName("get(18)")
	public void Test10() throws Throwable {
		
		org.junit.Assert.assertEquals("get(18)", (Object)(null), (Object)(TARGET.get(18)));
	}

	@org.junit.Test()
	@jug.TestName("put(10,\"AA\") returns A")
	public void Test11() throws Throwable {
		
		org.junit.Assert.assertEquals("put(10,\"AA\") returns A", (Object)("A"), (Object)(TARGET.put(10,"AA")));
	}

	@org.junit.Test()
	@jug.TestName("put(20,\"G\"); get(20) returns G")
	public void Test12() throws Throwable {
		TARGET.put(20,"G");
		
		org.junit.Assert.assertEquals("put(20,\"G\"); get(20) returns G", (Object)("G"), (Object)(TARGET.get(20)));
	}

	@org.junit.Test()
	@jug.TestName("put(20,\"G\") returns null")
	public void Test13() throws Throwable {
		
		org.junit.Assert.assertEquals("put(20,\"G\") returns null", (Object)(null), (Object)(TARGET.put(20,"G")));
	}

	@org.junit.Test()
	@jug.TestName("put(20,\"G\"); size() is 7")
	public void Test14() throws Throwable {
		TARGET.put(20,"B");
		
		org.junit.Assert.assertEquals("put(20,\"G\"); size() is 7", (Object)(7), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("remove(10): return \"A\"")
	public void Test15() throws Throwable {
		
		org.junit.Assert.assertEquals("remove(10): return \"A\"", (Object)("A"), (Object)(TARGET.remove(10)));
	}

	@org.junit.Test()
	@jug.TestName("remove(10): root has 15")
	public void Test16() throws Throwable {
		TARGET.remove(10);
		
		org.junit.Assert.assertEquals("remove(10): root has 15", (Object)(15), (Object)(TARGET.getTree().root().getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("remove(5): root.left has 8")
	public void Test17() throws Throwable {
		TARGET.remove(5);
		
		org.junit.Assert.assertEquals("remove(5): root.left has 8", (Object)(8), (Object)(TARGET.getTree().left(TARGET.getTree().root()).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("remove(8): root.left.right has 9")
	public void Test18() throws Throwable {
		TARGET.remove(8);
		
		org.junit.Assert.assertEquals("remove(8): root.left.right has 9", (Object)(9), (Object)(TARGET.getTree().right(TARGET.getTree().left(TARGET.getTree().root())).getElement().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("remove(2): return null")
	public void Test19() throws Throwable {
		
		org.junit.Assert.assertEquals("remove(2): return null", (Object)(null), (Object)(TARGET.remove(2)));
	}

	@org.junit.Test()
	@jug.TestName("ceiling(6): return 8")
	public void Test20() throws Throwable {
		
		org.junit.Assert.assertEquals("ceiling(6): return 8", (Object)(8), (Object)(TARGET.ceilingEntry(6).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("ceiling(8): return 8")
	public void Test21() throws Throwable {
		
		org.junit.Assert.assertEquals("ceiling(8): return 8", (Object)(8), (Object)(TARGET.ceilingEntry(8).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("higher(6): return 8")
	public void Test22() throws Throwable {
		
		org.junit.Assert.assertEquals("higher(6): return 8", (Object)(8), (Object)(TARGET.higherEntry(6).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("higher(8): return 9")
	public void Test23() throws Throwable {
		
		org.junit.Assert.assertEquals("higher(8): return 9", (Object)(9), (Object)(TARGET.higherEntry(8).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("floor(6): returns 5")
	public void Test24() throws Throwable {
		
		org.junit.Assert.assertEquals("floor(6): returns 5", (Object)(5), (Object)(TARGET.floorEntry(6).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("floor(9): returns 9")
	public void Test25() throws Throwable {
		
		org.junit.Assert.assertEquals("floor(9): returns 9", (Object)(9), (Object)(TARGET.floorEntry(9).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("lowerEntry(6): returns 5")
	public void Test26() throws Throwable {
		
		org.junit.Assert.assertEquals("lowerEntry(6): returns 5", (Object)(5), (Object)(TARGET.lowerEntry(6).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("lowerEntry(9): returns 8")
	public void Test27() throws Throwable {
		
		org.junit.Assert.assertEquals("lowerEntry(9): returns 8", (Object)(8), (Object)(TARGET.lowerEntry(9).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("first(): returns 3")
	public void Test28() throws Throwable {
		
		org.junit.Assert.assertEquals("first(): returns 3", (Object)(3), (Object)(TARGET.firstEntry().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("last(): returns 15")
	public void Test29() throws Throwable {
		
		org.junit.Assert.assertEquals("last(): returns 15", (Object)(15), (Object)(TARGET.lastEntry().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("values(): A,B,C,D,E,F")
	public void Test30() throws Throwable {
		String values[] = {"A","B","C","D","E","F"}
		;
		LinkedList<String> expected = new LinkedList<String>();
		for (int i=0;i <6 ;i++) {
			  expected.add(values[i]);
		  }
		LinkedList<String> actual = new LinkedList<String>();
		for (String s: TARGET.values()) {
			  actual.add(s);
		  }
		Boolean ret = expected.containsAll(actual) && actual.containsAll(expected);
		
		org.junit.Assert.assertEquals("values(): A,B,C,D,E,F", (Object)(true), (Object)(ret));
	}

}

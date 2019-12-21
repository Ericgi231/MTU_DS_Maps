import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;

@jug.SuiteName("root only - \"A\"")
public class oneEntryBST {

	private BinarySearchTree<Integer,String> TARGET = init();
	private BinarySearchTree<Integer,String> T = init();

	public BinarySearchTree<Integer,String> init() {
		return new BinarySearchTree<Integer,String>();
	}

	@Before
	public void setup() throws Throwable {
		TARGET.put(1,"A");
	}

	@org.junit.Test(timeout=10000)
	@jug.TestName("numer of entries: Size is 1")
	public void Test1() throws Throwable {
		
		org.junit.Assert.assertEquals("numer of entries: Size is 1", (Object)(1), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("isEmpty: isEmpty is false")
	public void Test2() throws Throwable {
		
		org.junit.Assert.assertEquals("isEmpty: isEmpty is false", (Object)(false), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName("get(1)")
	public void Test3() throws Throwable {
		
		org.junit.Assert.assertEquals("get(1)", (Object)("A"), (Object)(TARGET.get(1)));
	}

	@org.junit.Test()
	@jug.TestName("get(2)")
	public void Test4() throws Throwable {
		
		org.junit.Assert.assertEquals("get(2)", (Object)(null), (Object)(TARGET.get(2)));
	}

	@org.junit.Test()
	@jug.TestName("put(1,\"B\") returns A")
	public void Test5() throws Throwable {
		
		org.junit.Assert.assertEquals("put(1,\"B\") returns A", (Object)("A"), (Object)(TARGET.put(1,"B")));
	}

	@org.junit.Test()
	@jug.TestName("put(1,\"B\"); get(1) returns B")
	public void Test6() throws Throwable {
		TARGET.put(1,"B");
		
		org.junit.Assert.assertEquals("put(1,\"B\"); get(1) returns B", (Object)("B"), (Object)(TARGET.get(1)));
	}

	@org.junit.Test()
	@jug.TestName("put(2,\"B\") returns null")
	public void Test7() throws Throwable {
		
		org.junit.Assert.assertEquals("put(2,\"B\") returns null", (Object)(null), (Object)(TARGET.put(2,"B")));
	}

	@org.junit.Test()
	@jug.TestName("put(2,\"B\") size() = 2")
	public void Test8() throws Throwable {
		TARGET.put(2,"B");
		
		org.junit.Assert.assertEquals("put(2,\"B\") size() = 2", (Object)(2), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("remove(1): return \"A\"")
	public void Test9() throws Throwable {
		
		org.junit.Assert.assertEquals("remove(1): return \"A\"", (Object)("A"), (Object)(TARGET.remove(1)));
	}

	@org.junit.Test()
	@jug.TestName("remove(2): return null")
	public void Test10() throws Throwable {
		
		org.junit.Assert.assertEquals("remove(2): return null", (Object)(null), (Object)(TARGET.remove(2)));
	}

}

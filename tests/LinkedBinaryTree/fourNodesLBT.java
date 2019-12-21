import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;
import java.util.Iterator;

@jug.SuiteName("fourNodesLBT")
public class fourNodesLBT {

	private LinkedBinaryTree<String> TARGET = init();
	private LinkedBinaryTree<String> T = init();

	public LinkedBinaryTree<String> init() {
		return new LinkedBinaryTree<String>();
	}

	@Before
	public void setup() throws Throwable {
		Position<String> n1 = TARGET.addRoot("A");
			Position<String> n2 = TARGET.addLeft(n1, "B");
			Position<String> n3 = TARGET.addRight(n1, "C");
			Position<String> n4 = TARGET.addLeft(n2, "D");
	}

	@org.junit.Test()
	@jug.TestName("TARGET.remove(TARGET.root()) throws IllegalArgumentException;")
	public void Test1() throws Throwable {
		
		{ boolean thrown = false;
			try {
				TARGET.remove(TARGET.root());
			} catch (Throwable t) {
				thrown = true;
				org.junit.Assert.assertThat("TARGET.remove(TARGET.root()) throws IllegalArgumentException;", t, org.hamcrest.CoreMatchers.instanceOf(IllegalArgumentException.class));
			}
			if(!thrown){
				org.junit.Assert.fail("TARGET.remove(TARGET.root()) throws IllegalArgumentException;: Expected Throwable IllegalArgumentException");
			}
		}
	}

	@org.junit.Test()
	@jug.TestName("TARGET.right(TARGET.root()) equals null;")
	public void Test2() throws Throwable {
		Position<String> n3 = TARGET.right(TARGET.root());
		TARGET.remove(n3);
		
		org.junit.Assert.assertEquals("TARGET.right(TARGET.root()) equals null;", (Object)(null), (Object)(TARGET.right(TARGET.root())));
	}

	@org.junit.Test()
	@jug.TestName("TARGET.left(TARGET.root()) equals n4;")
	public void Test3() throws Throwable {
		Position<String> n2 = TARGET.left(TARGET.root());
		Position<String> n4 = TARGET.left(TARGET.left(TARGET.root()));
		TARGET.remove(n2);
		
		org.junit.Assert.assertEquals("TARGET.left(TARGET.root()) equals n4;", (Object)(n4), (Object)(TARGET.left(TARGET.root())));
	}

	@org.junit.Test()
	@jug.TestName("TARGET.size() equals 3;")
	public void Test4() throws Throwable {
		Position<String> n4 = TARGET.left(TARGET.left(TARGET.root()));
		TARGET.remove(n4);
		
		org.junit.Assert.assertEquals("TARGET.size() equals 3;", (Object)(3), (Object)(TARGET.size()));
	}

}

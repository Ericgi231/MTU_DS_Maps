import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;
import java.util.Iterator;

@jug.SuiteName("root only - \"A\"")
public class rootOnlyLBT {

	private LinkedBinaryTree<String> TARGET = init();
	private LinkedBinaryTree<String> T = init();

	public LinkedBinaryTree<String> init() {
		return new LinkedBinaryTree<String>();
	}

	@Before
	public void setup() throws Throwable {
		TARGET.addRoot("A");
	}

	@org.junit.Test(timeout=10000)
	@jug.TestName("remove(): remove(root)")
	public void Test1() throws Throwable {
		TARGET.remove(TARGET.root());
		
		org.junit.Assert.assertEquals("remove(): remove(root)", (Object)(0), (Object)(TARGET.size()));
	}
	
	@org.junit.Test(timeout=10000)
	@jug.TestName("remove(): remove(root)")
	public void Test2() throws Throwable {
		TARGET.remove(TARGET.root());
		
		org.junit.Assert.assertEquals("remove(): remove(root)", (Object)null, (Object)(TARGET.root()));
	}

}

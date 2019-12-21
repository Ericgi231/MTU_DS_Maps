import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;

@jug.SuiteName("One Item List - Entries:{[\"1\",\"A\"]}")
public class oneItemListHM {

	private HashMap<String, String> TARGET = init();
	private HashMap<String, String> T = init();

	public HashMap<String, String> init() {
		return new HashMap<String, String>(5);
	}

	@Before
	public void setup() throws Throwable {
		TARGET.put("1", "A");
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying size() = 1")
	public void Test1() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying size() = 1", (Object)(1), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("Verifying isEmpty() = false")
	public void Test2() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying isEmpty() = false", (Object)(false), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName("Verifying get(\"1\") = \"A\"")
	public void Test3() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying get(\"1\") = \"A\"", (Object)("A"), (Object)(TARGET.get("1")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying remove(1), remove(1) = null")
	public void Test4() throws Throwable {
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals("Verifying remove(1), remove(1) = null", (Object)(null), (Object)(TARGET.remove("1")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying put(\"1\",\"B\") = \"A\"")
	public void Test5() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying put(\"1\",\"B\") = \"A\"", (Object)("A"), (Object)(TARGET.put("1", "B")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying put(\"1\",\"B\"); get(\"1\") = \"B\"")
	public void Test6() throws Throwable {
		TARGET.put("1", "B");
		
		org.junit.Assert.assertEquals("Verifying put(\"1\",\"B\"); get(\"1\") = \"B\"", (Object)("B"), (Object)(TARGET.get("1")));
	}

}

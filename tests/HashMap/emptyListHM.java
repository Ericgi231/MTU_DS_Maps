import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;

@jug.SuiteName("Empty Map")
public class emptyListHM {

	private HashMap<String, String> TARGET = init();
	private HashMap<String, String> T = init();

	public HashMap<String, String> init() {
		return new HashMap<String, String>(10);
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying size() = 0")
	public void Test1() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying size() = 0", (Object)(0), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("Verifying isEmpty() = true")
	public void Test2() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying isEmpty() = true", (Object)(true), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName("V value = put(\"50\",\"A\"): Verifying value = null")
	public void Test3() throws Throwable {
		String value = TARGET.put("50","A");
		
		org.junit.Assert.assertEquals("V value = put(\"50\",\"A\"): Verifying value = null", (Object)(null), (Object)(value));
	}

	@org.junit.Test()
	@jug.TestName("put(\"50\",\"A\"); V value = put(\"50\",\"B\"): Verifying value = \"A\"")
	public void Test4() throws Throwable {
		TARGET.put("50","A");
		String value = TARGET.put("50","B");
		
		org.junit.Assert.assertEquals("put(\"50\",\"A\"); V value = put(\"50\",\"B\"): Verifying value = \"A\"", (Object)("A"), (Object)(value));
	}

	@org.junit.Test()
	@jug.TestName("V = put(\"50\",\"A\"); remove(e): Verifying size() = 0")
	public void Test5() throws Throwable {
		TARGET.put("50","A");
		TARGET.remove("50");
		
		org.junit.Assert.assertEquals("V = put(\"50\",\"A\"); remove(e): Verifying size() = 0", (Object)(0), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName("Verifying get(\"1\") returns null")
	public void Test6() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying get(\"1\") returns null", (Object)(null), (Object)(TARGET.get("1")));
	}

}

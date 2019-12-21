import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;

@jug.SuiteName("Empty Map")
public class emptyListLF {

	private UnorderedMap<String, String> TARGET = init();
	private UnorderedMap<String, String> T = init();

	public UnorderedMap<String, String> init() {
		return new UnorderedMap<String, String>();
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
	@jug.TestName("Verifying  get(\"1\",\"B\") returns null")
	public void Test3() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying  get(\"1\",\"B\") returns null", (Object)(null), (Object)(TARGET.get("1")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying remove(\"2\") return null")
	public void Test4() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying remove(\"2\") return null", (Object)(null), (Object)(TARGET.remove("2")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying put(\"1\",\"A\") return null")
	public void Test5() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying put(\"1\",\"A\") return null", (Object)(null), (Object)(TARGET.put("1","A")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying isEmpty()=false")
	public void Test6() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying isEmpty()=false", (Object)(false), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"2\", \"B\"): Verifying get(2)=\"B\"")
	public void Test7() throws Throwable {
		TARGET.put("2", "B");
		
		org.junit.Assert.assertEquals(".put(\"2\", \"B\"): Verifying get(2)=\"B\"", (Object)("B"), (Object)(TARGET.get("2")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"A\", \"1\"): Verifying size()=1")
	public void Test8() throws Throwable {
		TARGET.put("A", "1");
		
		org.junit.Assert.assertEquals(".put(\"A\", \"1\"): Verifying size()=1", (Object)(1), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying remove(1) returns A")
	public void Test9() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying remove(1) returns A", (Object)("A"), (Object)(TARGET.remove("1")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying remove(2) returns null")
	public void Test10() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying remove(2) returns null", (Object)(null), (Object)(TARGET.remove("2")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"A\", \"1\"): remove(\"A\"): Verifying remove(\"B\") returns null")
	public void Test11() throws Throwable {
		TARGET.put("A", "1");
		TARGET.remove("A");
		
		org.junit.Assert.assertEquals(".put(\"A\", \"1\"): remove(\"A\"): Verifying remove(\"B\") returns null", (Object)(null), (Object)(TARGET.remove("B")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying isEmpty()=true")
	public void Test12() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying isEmpty()=true", (Object)(true), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying size()=0")
	public void Test13() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying size()=0", (Object)(0), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying .get(\"1\") returns null")
	public void Test14() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying .get(\"1\") returns null", (Object)(null), (Object)(TARGET.get("1")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"3\", \"A\"): .put(\"5\", \"C\"): put(\"7\",\"D\"): Verifying size()=3")
	public void Test15() throws Throwable {
		TARGET.put("3", "A");
		TARGET.put("5", "C");
		TARGET.put("7", "D");
		
		org.junit.Assert.assertEquals(".put(\"3\", \"A\"): .put(\"5\", \"C\"): put(\"7\",\"D\"): Verifying size()=3", (Object)(3), (Object)(TARGET.size()));
	}

}

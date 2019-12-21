import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;

@jug.SuiteName("Empty Map")
public class emptyTable {

	private LookupTable<String, String> TARGET = init();
	private LookupTable<String, String> T = init();

	public LookupTable<String, String> init() {
		return new LookupTable<String, String>();
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying .size equals 0")
	public void Test1() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .size equals 0", (Object)(0), (Object)(TARGET.size()));
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
	@jug.TestName(".put(\"1\", \"A\"): Verifying remove(1) returns A")
	public void Test6() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying remove(1) returns A", (Object)("A"), (Object)(TARGET.remove("1")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying remove(2) returns null")
	public void Test7() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying remove(2) returns null", (Object)(null), (Object)(TARGET.remove("2")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"A\", \"1\"): remove(\"A\"): Verifying remove(\"B\") returns null")
	public void Test8() throws Throwable {
		TARGET.put("A", "1");
		TARGET.remove("A");
		
		org.junit.Assert.assertEquals(".put(\"A\", \"1\"): remove(\"A\"): Verifying remove(\"B\") returns null", (Object)(null), (Object)(TARGET.remove("B")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying isEmpty()=true")
	public void Test9() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying isEmpty()=true", (Object)(true), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying size()=0")
	public void Test10() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying size()=0", (Object)(0), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): remove(\"1\"): Verifying .get(\"1\") returns null")
	public void Test11() throws Throwable {
		TARGET.put("1", "A");
		TARGET.remove("1");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): remove(\"1\"): Verifying .get(\"1\") returns null", (Object)(null), (Object)(TARGET.get("1")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying .ceilingEntry(\"B\") returns null")
	public void Test12() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .ceilingEntry(\"B\") returns null", (Object)(null), (Object)(TARGET.ceilingEntry("B")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying .firstEntry() returns null")
	public void Test13() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .firstEntry() returns null", (Object)(null), (Object)(TARGET.firstEntry()));
	}

	@org.junit.Test()
	@jug.TestName("Verifying .floorEntry(\"B\") returns null")
	public void Test14() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .floorEntry(\"B\") returns null", (Object)(null), (Object)(TARGET.floorEntry("B")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying .higherEntry(\"B\") returns null")
	public void Test15() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .higherEntry(\"B\") returns null", (Object)(null), (Object)(TARGET.higherEntry("B")));
	}

	@org.junit.Test()
	@jug.TestName("Verifying .lastEntry() returns null")
	public void Test16() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .lastEntry() returns null", (Object)(null), (Object)(TARGET.lastEntry()));
	}

	@org.junit.Test()
	@jug.TestName("Verifying .lowerEntry(\"B\") returns null")
	public void Test17() throws Throwable {
		
		org.junit.Assert.assertEquals("Verifying .lowerEntry(\"B\") returns null", (Object)(null), (Object)(TARGET.lowerEntry("B")));
	}

}

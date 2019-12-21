import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;

@jug.SuiteName("Small Map")
public class smallTable {

	private LookupTable<String, String> TARGET = init();
	private LookupTable<String, String> T = init();

	public LookupTable<String, String> init() {
		return new LookupTable<String, String>();
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName(".put(\"1\", \"A\"): Verifying isEmpty() equals false")
	public void Test1() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying isEmpty() equals false", (Object)(false), (Object)(TARGET.isEmpty()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"2\", \"B\"): Verifying get(2) equals \"B\"")
	public void Test2() throws Throwable {
		TARGET.put("2", "B");
		
		org.junit.Assert.assertEquals(".put(\"2\", \"B\"): Verifying get(2) equals \"B\"", (Object)("B"), (Object)(TARGET.get("2")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"A\", \"1\"): Verifying size() equals 1")
	public void Test3() throws Throwable {
		TARGET.put("A", "1");
		
		org.junit.Assert.assertEquals(".put(\"A\", \"1\"): Verifying size() equals 1", (Object)(1), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"3\", \"A\"): .put(\"5\", \"C\"): put(\"7\",\"D\"): Verifying size() equals 3")
	public void Test4() throws Throwable {
		TARGET.put("3", "A");
		TARGET.put("5", "C");
		TARGET.put("7", "D");
		
		org.junit.Assert.assertEquals(".put(\"3\", \"A\"): .put(\"5\", \"C\"): put(\"7\",\"D\"): Verifying size() equals 3", (Object)(3), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"C\"): Verifying put(\"1\",\"A\") equals \"C\"")
	public void Test5() throws Throwable {
		TARGET.put("1", "C");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"C\"): Verifying put(\"1\",\"A\") equals \"C\"", (Object)("C"), (Object)(TARGET.put("1", "A")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"C\"): .put(\"3\", \"D\"): .put(\"1\", \"F\") Verifying put(\"1\",\"A\") equals \"F\"")
	public void Test6() throws Throwable {
		TARGET.put("1", "C");
		TARGET.put("3", "D");
		TARGET.put("1", "F");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"C\"): .put(\"3\", \"D\"): .put(\"1\", \"F\") Verifying put(\"1\",\"A\") equals \"F\"", (Object)("F"), (Object)(TARGET.put("1", "A")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): .put(\"1\", \"B\"): Verifying .get(\"1\") equals \"B\"")
	public void Test7() throws Throwable {
		TARGET.put("1", "A");
		TARGET.put("1", "B");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): .put(\"1\", \"B\"): Verifying .get(\"1\") equals \"B\"", (Object)("B"), (Object)(TARGET.get("1")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): .put(\"1\", \"B\"): Verifying .size() equals \"B\"")
	public void Test8() throws Throwable {
		TARGET.put("1", "A");
		TARGET.put("1", "B");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): .put(\"1\", \"B\"): Verifying .size() equals \"B\"", (Object)(1), (Object)(TARGET.size()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying .ceilingEntry(\"1\").getValue() equals \"A\"")
	public void Test9() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying .ceilingEntry(\"1\").getValue() equals \"A\"", (Object)("A"), (Object)(TARGET.ceilingEntry("1").getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying .firstEntry().getValue() equals \"A\"")
	public void Test10() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying .firstEntry().getValue() equals \"A\"", (Object)("A"), (Object)(TARGET.firstEntry().getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying .floorEntry(\"1\").getKey() equals \"1\"")
	public void Test11() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying .floorEntry(\"1\").getKey() equals \"1\"", (Object)("1"), (Object)(TARGET.ceilingEntry("1").getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying .lastEntry().getKey() equals \"1\"")
	public void Test12() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying .lastEntry().getKey() equals \"1\"", (Object)("1"), (Object)(TARGET.lastEntry().getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying .higherEntry(\"1\") returns null")
	public void Test13() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying .higherEntry(\"1\") returns null", (Object)(null), (Object)(TARGET.higherEntry("1")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): Verifying .lowerEntry(\"1\") returns null")
	public void Test14() throws Throwable {
		TARGET.put("1", "A");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): Verifying .lowerEntry(\"1\") returns null", (Object)(null), (Object)(TARGET.lowerEntry("1")));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .ceilingEntry(\"1\").getKey() equals \"1\"")
	public void Test15() throws Throwable {
		TARGET.put("1", "A");
		TARGET.put("2", "B");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .ceilingEntry(\"1\").getKey() equals \"1\"", (Object)("1"), (Object)(TARGET.ceilingEntry("1").getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .ceilingEntry(\"0\").getValue() equals \"A\"")
	public void Test16() throws Throwable {
		TARGET.put("1", "A");
		TARGET.put("2", "B");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .ceilingEntry(\"0\").getValue() equals \"A\"", (Object)("A"), (Object)(TARGET.ceilingEntry("0").getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .ceilingEntry(\"1\").getValue() equals \"B\"")
	public void Test17() throws Throwable {
		TARGET.put("5", "A");
		TARGET.put("3", "B");
		
		org.junit.Assert.assertEquals(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .ceilingEntry(\"1\").getValue() equals \"B\"", (Object)("B"), (Object)(TARGET.ceilingEntry("1").getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .ceilingEntry(\"3\").getKey() equals \"3\"")
	public void Test18() throws Throwable {
		TARGET.put("5", "A");
		TARGET.put("3", "B");
		
		org.junit.Assert.assertEquals(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .ceilingEntry(\"3\").getKey() equals \"3\"", (Object)("3"), (Object)(TARGET.ceilingEntry("3").getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .floorEntry(\"2\").getValue() equals \"B\"")
	public void Test19() throws Throwable {
		TARGET.put("1", "A");
		TARGET.put("2", "B");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .floorEntry(\"2\").getValue() equals \"B\"", (Object)("B"), (Object)(TARGET.floorEntry("2").getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .floorEntry(\"3\").getValue() equals \"B\"")
	public void Test20() throws Throwable {
		TARGET.put("1", "A");
		TARGET.put("2", "B");
		
		org.junit.Assert.assertEquals(".put(\"1\", \"A\"): .put(\"2\", \"B\"): Verifying .floorEntry(\"3\").getValue() equals \"B\"", (Object)("B"), (Object)(TARGET.floorEntry("3").getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .floorEntry(\"7\").getKey() equals \"5\"")
	public void Test21() throws Throwable {
		TARGET.put("5", "A");
		TARGET.put("3", "B");
		
		org.junit.Assert.assertEquals(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .floorEntry(\"7\").getKey() equals \"5\"", (Object)("5"), (Object)(TARGET.floorEntry("7").getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .floorEntry(\"5\").getValue() equals \"A\"")
	public void Test22() throws Throwable {
		TARGET.put("5", "A");
		TARGET.put("3", "B");
		
		org.junit.Assert.assertEquals(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .floorEntry(\"5\").getValue() equals \"A\"", (Object)("A"), (Object)(TARGET.floorEntry("5").getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"A\", \"1\"): .put(\"B\", \"2\"): Verifying .lastEntry().getValue() equals \"2\"")
	public void Test23() throws Throwable {
		TARGET.put("A", "1");
		TARGET.put("B", "2");
		
		org.junit.Assert.assertEquals(".put(\"A\", \"1\"): .put(\"B\", \"2\"): Verifying .lastEntry().getValue() equals \"2\"", (Object)("2"), (Object)(TARGET.lastEntry().getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"A\", \"1\"): .put(\"B\", \"2\"): Verifying .firstEntry().getKey() equals \"A\"")
	public void Test24() throws Throwable {
		TARGET.put("A", "1");
		TARGET.put("B", "2");
		
		org.junit.Assert.assertEquals(".put(\"A\", \"1\"): .put(\"B\", \"2\"): Verifying .firstEntry().getKey() equals \"A\"", (Object)("A"), (Object)(TARGET.firstEntry().getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .higherEntry(\"3\").getKey() equals \"5\"")
	public void Test25() throws Throwable {
		TARGET.put("5", "A");
		TARGET.put("3", "B");
		
		org.junit.Assert.assertEquals(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .higherEntry(\"3\").getKey() equals \"5\"", (Object)("5"), (Object)(TARGET.higherEntry("3").getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .lowerEntry(\"5\").getValue() equals \"B\"")
	public void Test26() throws Throwable {
		TARGET.put("5", "A");
		TARGET.put("3", "B");
		
		org.junit.Assert.assertEquals(".put(\"5\", \"A\"): .put(\"3\", \"B\"): Verifying .lowerEntry(\"5\").getValue() equals \"B\"", (Object)("B"), (Object)(TARGET.lowerEntry("5").getValue()));
	}

}

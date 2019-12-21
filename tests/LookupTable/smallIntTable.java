import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;
import java.util.Random;

@jug.SuiteName("Small Integer Key Map")
public class smallIntTable {

	private LookupTable<Integer, String> TARGET = init();
	private LookupTable<Integer, String> T = init();

	public LookupTable<Integer, String> init() {
		return new LookupTable<Integer, String>();
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .ceilingEntry(3).getKey() equals 3")
	public void Test1() throws Throwable {
		TARGET.put(1, "A");
		TARGET.put(5, "E");
		TARGET.put(3, "C");
		
		org.junit.Assert.assertEquals(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .ceilingEntry(3).getKey() equals 3", (Object)(3), (Object)(TARGET.ceilingEntry(3).getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .ceilingEntry(2).getValue() equals \"C\"")
	public void Test2() throws Throwable {
		TARGET.put(1, "A");
		TARGET.put(5, "E");
		TARGET.put(3, "C");
		
		org.junit.Assert.assertEquals(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .ceilingEntry(2).getValue() equals \"C\"", (Object)("C"), (Object)(TARGET.ceilingEntry(2).getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .floorEntry(5).getValue() equals \"E\"")
	public void Test3() throws Throwable {
		TARGET.put(1, "A");
		TARGET.put(5, "E");
		TARGET.put(3, "C");
		
		org.junit.Assert.assertEquals(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .floorEntry(5).getValue() equals \"E\"", (Object)("E"), (Object)(TARGET.floorEntry(5).getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .floorEntry(4).getKey() equals 3")
	public void Test4() throws Throwable {
		TARGET.put(1, "A");
		TARGET.put(5, "E");
		TARGET.put(3, "C");
		
		org.junit.Assert.assertEquals(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying .floorEntry(4).getKey() equals 3", (Object)(3), (Object)(TARGET.floorEntry(4).getKey()));
	}

	@org.junit.Test()
	@jug.TestName(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying higherEntry(1).getValue() equals \"C\"")
	public void Test5() throws Throwable {
		TARGET.put(1, "A");
		TARGET.put(5, "E");
		TARGET.put(3, "C");
		
		org.junit.Assert.assertEquals(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying higherEntry(1).getValue() equals \"C\"", (Object)("C"), (Object)(TARGET.higherEntry(1).getValue()));
	}

	@org.junit.Test()
	@jug.TestName(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying lowerEntry(5).getKey() equals 3")
	public void Test6() throws Throwable {
		TARGET.put(1, "A");
		TARGET.put(5, "E");
		TARGET.put(3, "C");
		
		org.junit.Assert.assertEquals(".put(1, \"A\"): .put(5, \"E\") .put(3, \"C\"): Verifying lowerEntry(5).getKey() equals 3", (Object)(3), (Object)(TARGET.lowerEntry(5).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying lastEntry().getValue()")
	public void Test7() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying lastEntry().getValue()", (Object)("AAAAAAAAAA"), (Object)(TARGET.lastEntry().getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying firstEntry().getValue")
	public void Test8() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying firstEntry().getValue", (Object)("A"), (Object)(TARGET.firstEntry().getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying higherEntry(1).getKey()")
	public void Test9() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying higherEntry(1).getKey()", (Object)(2), (Object)(TARGET.higherEntry(1).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying lowerEntry(9).getValue()")
	public void Test10() throws Throwable {
		String s="A";
		for(int i=9;i>=0;i--){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying lowerEntry(9).getValue()", (Object)("AA"), (Object)(TARGET.lowerEntry(9).getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying floorEntry(9).getValue()")
	public void Test11() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){ 
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying floorEntry(9).getValue()", (Object)("AAAAAAAAAA"), (Object)(TARGET.floorEntry(9).getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying ceilingEntry(5).getKey()")
	public void Test12() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying ceilingEntry(5).getKey()", (Object)(5), (Object)(TARGET.ceilingEntry(5).getKey()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying subMap")
	public void Test13() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying subMap", (Object)("AAAAAA"), (Object)(TARGET.subMap(5,9).iterator().next().getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 10 items into the map: Verifying subMap")
	public void Test14() throws Throwable {
		String s="A";
		for(int i=0;i<10;i++){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 10 items into the map: Verifying subMap", (Object)("AAAAAA"), (Object)(TARGET.subMap(5,14).iterator().next().getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 50 items into the map: Verifying lastEntry().getKey()")
	public void Test15() throws Throwable {
		String s="A";
		for(int i=50;i>0;i--){
			TARGET.put(i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 50 items into the map: Verifying lastEntry().getKey()", (Object)(50), (Object)(TARGET.lastEntry().getKey()));
	}

	@org.junit.Test()
	@jug.TestName("put 50 items into the map: Verifying higherEntry(3).getValue()")
	public void Test16() throws Throwable {
		String s="A";
		for(int i=1;i<=50;i++){
			TARGET.put(2*i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 50 items into the map: Verifying higherEntry(3).getValue()", (Object)("AA"), (Object)(TARGET.higherEntry(3).getValue()));
	}

	@org.junit.Test()
	@jug.TestName("put 50 items into the map: Verifying subMap")
	public void Test17() throws Throwable {
		String s="A";
		for(int i=1;i<=50;i++){
			TARGET.put(2*i, s);
			s=s+"A";
			}
		
		org.junit.Assert.assertEquals("put 50 items into the map: Verifying subMap", (Object)(2), (Object)(TARGET.subMap(0,100).iterator().next().getKey()));
	}

}

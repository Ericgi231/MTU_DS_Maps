import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;

@jug.SuiteName("Multiple Item List - Entries:{[\"3\",\"C\"],[\"1\",\"A\"],[\"2\",\"B\"],[\"1\",\"D\"]}")
public class multipleItemRepeatedListHM {

	private HashMap<String, String> TARGET = init();
	private HashMap<String, String> T = init();

	public HashMap<String, String> init() {
		return new HashMap<String, String>(10);
	}

	@Before
	public void setup() throws Throwable {
		TARGET.put("3", "C");
			TARGET.put("1", "A");
			TARGET.put("2", "B");
			TARGET.put("1", "D");
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying keySet() count = 3")
	public void Test1() throws Throwable {
		int k = 0;
		Iterable<String> mapKeys = TARGET.keySet();
		for(String i : mapKeys)
				k++;
		
		org.junit.Assert.assertEquals("Verifying keySet() count = 3", (Object)(3), (Object)(k));
	}

	@org.junit.Test()
	@jug.TestName("Verifying keySet() returns Keys:{\"1\",\"2\",\"3\"}")
	public void Test2() throws Throwable {
		String [] keys = {"1","2","3"}
		;
		Iterable<String> mapKeys = TARGET.keySet();
		boolean [] checked = new boolean[keys.length];
		for(String e : mapKeys) {
				for(int j=0; j<keys.length; j++) {
					if(keys[j].equals(e)) {
						checked[j]=true;
					}
				}
			}
		for(int j=0; j<checked.length; j++)//;
		
		org.junit.Assert.assertEquals("Verifying keySet() returns Keys:{\"1\",\"2\",\"3\"}", (Object)(true), (Object)(checked[j]));
	}

	@org.junit.Test()
	@jug.TestName("Verifying values() count = 3")
	public void Test3() throws Throwable {
		int k = 0;
		Iterable<String> mapValues = TARGET.values();
		for(String i : mapValues)
				k++;
		
		org.junit.Assert.assertEquals("Verifying values() count = 3", (Object)(3), (Object)(k));
	}

	@org.junit.Test()
	@jug.TestName("Verifying values() returns Values:{\"B\",\"C\",\"D\"}")
	public void Test4() throws Throwable {
		String [] values = {"B","C","D"}
		;
		Iterable<String> mapValues = TARGET.values();
		boolean [] checked = new boolean[values.length];
		for(String e : mapValues) {
				for(int j=0; j<values.length; j++) {
					if(values[j].equals(e)) {
						checked[j]=true;
					}
				}
			}
		for(int j=0; j<checked.length; j++)//;
		
		org.junit.Assert.assertEquals("Verifying values() returns Values:{\"B\",\"C\",\"D\"}", (Object)(true), (Object)(checked[j]));
	}

	@org.junit.Test()
	@jug.TestName("Verifying values() doesn't contain \"A\"")
	public void Test5() throws Throwable {
		boolean found = false;
		String value1 = "A";
		Iterable<String> mapValues = TARGET.values();
		for(String i : mapValues)
				if(value1.equals(i))
					found = true;
		
		org.junit.Assert.assertEquals("Verifying values() doesn't contain \"A\"", (Object)(false), (Object)(found));
	}

}

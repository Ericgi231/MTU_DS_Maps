import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;

@jug.SuiteName("Multiple Item List - Entries:{[\"3\",\"C\"],[\"1\",\"A\"],[\"2\",\"B\"],[\"4\",\"D\"]}")
public class multipleItemUniqueListHM {

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
			TARGET.put("4", "D");
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("remove(2) - Verifying keySet() count = 3")
	public void Test1() throws Throwable {
		TARGET.remove("2");
		int k = 0;
		Iterable<String> mapKeys = TARGET.keySet();
		for(String i : mapKeys)
				k++;
		
		org.junit.Assert.assertEquals("remove(2) - Verifying keySet() count = 3", (Object)(3), (Object)(k));
	}

	@org.junit.Test()
	@jug.TestName("remove(2) - Verifying keySet() returns Keys:{\"1\",\"3\",\"4\"}")
	public void Test2() throws Throwable {
		TARGET.remove("2");
		String [] keys = {"1","3","4"}
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
		
		org.junit.Assert.assertEquals("remove(2) - Verifying keySet() returns Keys:{\"1\",\"3\",\"4\"}", (Object)(true), (Object)(checked[j]));
	}

	@org.junit.Test()
	@jug.TestName("remove(2) - Verifying keySet() doesn't contain \"2\"")
	public void Test3() throws Throwable {
		TARGET.remove("2");
		boolean found = false;
		String key4 = "2";
		Iterable<String> mapKeys = TARGET.keySet();
		for(String i : mapKeys)
				if(key4.equals(i))
					found = true;
		
		org.junit.Assert.assertEquals("remove(2) - Verifying keySet() doesn't contain \"2\"", (Object)(false), (Object)(found));
	}

	@org.junit.Test()
	@jug.TestName("remove(2) - Verifying values() count = 3")
	public void Test4() throws Throwable {
		TARGET.remove("2");
		int k = 0;
		Iterable<String> mapValues = TARGET.values();
		for(String i : mapValues)
				k++;
		
		org.junit.Assert.assertEquals("remove(2) - Verifying values() count = 3", (Object)(3), (Object)(k));
	}

	@org.junit.Test()
	@jug.TestName("remove(2) - Verifying values() returns Values:{\"A\",\"C\",\"D\"}")
	public void Test5() throws Throwable {
		String [] values = {"A","C","D"}
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
		
		org.junit.Assert.assertEquals("remove(2) - Verifying values() returns Values:{\"A\",\"C\",\"D\"}", (Object)(true), (Object)(checked[j]));
	}

	@org.junit.Test()
	@jug.TestName("remove(2) - Verifying values() doesn't contain \"B\"")
	public void Test6() throws Throwable {
		TARGET.remove("2");
		boolean found = false;
		String value2 = "B";
		Iterable<String> mapValues = TARGET.values();
		for(String i : mapValues)
				if(value2.equals(i))
					found = true;
		
		org.junit.Assert.assertEquals("remove(2) - Verifying values() doesn't contain \"B\"", (Object)(false), (Object)(found));
	}

}

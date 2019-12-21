import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;

@jug.SuiteName("Two Item List - Entries:{[\"1\",\"A\"],[\"2\",\"B\"]}")
public class twoItemListHM {

	private HashMap<String, String> TARGET = init();
	private HashMap<String, String> T = init();

	public HashMap<String, String> init() {
		return new HashMap<String, String>(5);
	}

	@Before
	public void setup() throws Throwable {
		TARGET.put("1", "A");
			TARGET.put("2", "B");
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying keySet() count = 2")
	public void Test1() throws Throwable {
		int k = 0;
		Iterable<String> mapKeys = TARGET.keySet();
		for(String i : mapKeys)
				k++;
		
		org.junit.Assert.assertEquals("Verifying keySet() count = 2", (Object)(2), (Object)(k));
	}

	@org.junit.Test()
	@jug.TestName("Verifying keySet() returns Keys:{\"1\",\"2\"}")
	public void Test2() throws Throwable {
		String [] keySet = {"1","2"}
		;
		Iterable<String> mapKeys = TARGET.keySet();
		boolean [] checked = new boolean[keySet.length];
		for(String e : mapKeys) {
				for(int j=0; j<keySet.length; j++) {
					if(keySet[j].equals(e)) {
						checked[j]=true;
					}
				}
			}
		for(int j=0; j<checked.length; j++)//;
		
		org.junit.Assert.assertEquals("Verifying keySet() returns Keys:{\"1\",\"2\"}", (Object)(true), (Object)(checked[j]));
	}

	@org.junit.Test()
	@jug.TestName("Verifying values() count = 2")
	public void Test3() throws Throwable {
		int k = 0;
		Iterable<String> mapValues = TARGET.values();
		for(String i : mapValues)
				k++;
		
		org.junit.Assert.assertEquals("Verifying values() count = 2", (Object)(2), (Object)(k));
	}

	@org.junit.Test()
	@jug.TestName("Verifying values() returns Values:{\"A\",\"B\"}")
	public void Test4() throws Throwable {
		String [] values = {"A","B"}
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
		
		org.junit.Assert.assertEquals("Verifying values() returns Values:{\"A\",\"B\"}", (Object)(true), (Object)(checked[j]));
	}

}

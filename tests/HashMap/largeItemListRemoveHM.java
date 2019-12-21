import org.junit.*;
import jug.*;
import cs2321.*;
import net.datastructures.*;

@jug.SuiteName("Large Item List 10000 items [n[i],i], where n[0] is \"1234\" and n[i]=(721*x(n-1)+51)%10000 (as a string)")
public class largeItemListRemoveHM {

	private HashMap<String, String> TARGET = init();
	private HashMap<String, String> T = init();

	public HashMap<String, String> init() {
		return new HashMap<String, String>(12000);
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying remove(i) for i = 1...10000")
	public void Test1() throws Throwable {
		Integer [] value2key = new Integer[10000];
		Integer [] key2value = new Integer[10000];
		int val = 1234;
		for(int i=0; i<10000; i++) 
			{
				value2key[i]=val;
				key2value[val]=i;
				TARGET.put(""+val, ""+i);
				val = (721 * val + 51) % 10000;
			}
		for(int i=0; i<key2value.length; i++)//;
		
		org.junit.Assert.assertEquals("Verifying remove(i) for i = 1...10000", (Object)(true), (Object)((TARGET.remove(""+i).equals(""+key2value[i]))));
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying size() = 0 after remove(i) for i = 1...10000")
	public void Test2() throws Throwable {
		Integer [] value2key = new Integer[10000];
		Integer [] key2value = new Integer[10000];
		int val = 1234;
		for(int i=0; i<10000; i++) 
			{
				value2key[i]=val;
				key2value[val]=i;
				TARGET.put(""+val, ""+i);
				val = (721 * val + 51) % 10000;
			}
		for(int i=0; i<key2value.length; i++)
				TARGET.remove(""+i).equals(""+key2value[i]);
		
		org.junit.Assert.assertEquals("Verifying size() = 0 after remove(i) for i = 1...10000", (Object)(0), (Object)(TARGET.size()));
	}

	@org.junit.Test(timeout=60000)
	@jug.TestName("Verifying isEmpty() = true after remove(i) for i = 1...10000")
	public void Test3() throws Throwable {
		Integer [] value2key = new Integer[10000];
		Integer [] key2value = new Integer[10000];
		int val = 1234;
		for(int i=0; i<10000; i++) 
			{
				value2key[i]=val;
				key2value[val]=i;
				TARGET.put(""+val, ""+i);
				val = (721 * val + 51) % 10000;
			}
		for(int i=0; i<key2value.length; i++)
				TARGET.remove(""+i).equals(""+key2value[i]);
		
		org.junit.Assert.assertEquals("Verifying isEmpty() = true after remove(i) for i = 1...10000", (Object)(true), (Object)(TARGET.isEmpty()));
	}

}

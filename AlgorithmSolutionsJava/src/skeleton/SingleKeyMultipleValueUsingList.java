package skeleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SingleKeyMultipleValueUsingList {
 
    public static void main(String[] args) {
 
        // create map to store
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
 
        // create list one and store values
        List<String> valSetOne = new ArrayList<String>();
        valSetOne.add("Apple");
        valSetOne.add("Aeroplane");
 
        // create list two and store values
        List<String> valSetTwo = new ArrayList<String>();
        valSetTwo.add("Bat");
        valSetTwo.add("Banana");
 
        // create list three and store values
        List<String> valSetThree = new ArrayList<String>();
        valSetThree.add("Cat");
        valSetThree.add("Car");
 
        // put values into map
        map.put("A", valSetOne);
        map.put("B", valSetTwo);
        map.put("C", valSetThree);
        
        // iterate and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = " + values + "n");
        }
        Set<String> test = map.keySet();
        Iterator<String> itr = test.iterator();
        while (itr.hasNext()){
        	String key = itr.next();
        	System.out.print("Key Value : " +  key +"  Values are : "+ map.get(key));
        	System.out.println();
        }
    }
}

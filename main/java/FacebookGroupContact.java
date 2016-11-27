package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
class Contact includes a String name and a List<string>.
The list includes some email address of this person.
For example:
#1 John1 [john@gmail.com]
#2 Mary [mary@gmail.com]
#3 John2 [john@yahoo.com]
#4 John3 [john@gmail.com, john@yahoo.com, john@hotmail.com]
#5 Bob [bob@gmail.com]
#6 John4 [john@yahoo.com, john@hotmail.com]
Based on the email address, group the contacts, output a List<List<String>>.
Here #1¬#3¬#4 are the same person.
*/
class Contact {
    String name;
    List<String> emails;

    public Contact(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }
}
public class FacebookGroupContact {
    //    use union-find. Build a hash table from email to name index,
    //    union all name index with same email, group all names with the same father together,
    //    transfer name index to the name.
    Map<String, List<Integer>> emailToNameIndexMap = new HashMap<String, List<Integer>>();

    List<List<String>> groupContact(List<Contact> input) {
        List<List<String>> result = new ArrayList<List<String>>();
        int size = input.size();
        for (int i = 0; i < size; i++) {
            List<String> emails = input.get(i).emails;
            for (int k = 0; k < emails.size(); k++) {
                if (emailToNameIndexMap.containsKey(emails.get(k))) {
                    List<Integer> idxList = emailToNameIndexMap.get(emails.get(k));
                    idxList.add(i);
                    emailToNameIndexMap.put(emails.get(k), idxList);
                } else {
                    List<Integer> idxList = new ArrayList<Integer>();
                    idxList.add(i);
                    emailToNameIndexMap.put(emails.get(k), idxList);
                }
            }
        }

        // union all names which has same email
        UnionFind uf = new UnionFind(size);
        for (List<Integer> value : emailToNameIndexMap.values()) {
            for (int i = 0; i < value.size() - 1; i++) {
                uf.union(value.get(i), value.get(i+1));
            }
        }

        // group names based on parent
        Map<Integer, List<String>> parentToNames = new HashMap<Integer, List<String>>();
        int[] parent = uf.getParent();
        for (int i =0 ; i < parent.length; i++) {
            int p = parent[i];
            if (parentToNames.containsKey(p)) {
                List<String> nameList = parentToNames.get(p);
                nameList.add(input.get(i).name);
                parentToNames.put(p, nameList);
            } else {
                List<String> nameList = new ArrayList<String>();
                nameList.add(input.get(i).name);
                parentToNames.put(p, nameList);
            }
        }

        // add name list to result list
        for (List<String> names : parentToNames.values()) {
            result.add(names);
        }

        return result;
    }

    public static void main(String[] args) {
        FacebookGroupContact g = new FacebookGroupContact();

        List<Contact> input = new ArrayList<Contact>();

        List<String> emails = new ArrayList<String>();
        emails.add("john@gmail.com");
        Contact c1 = new Contact("John1", emails);
        input.add(c1);

        emails = new ArrayList<String>();
        emails.add("mary@gmail.com");
        Contact c2 = new Contact("Mary", emails);
        input.add(c2);

        emails = new ArrayList<String>();
        emails.add("john@yahoo.com");
        Contact c3 = new Contact("John2", emails);
        input.add(c3);

        emails = new ArrayList<String>();
        emails.add("john@gmail.com");
        emails.add("john@yahoo.com");
        emails.add("john@hotmail.com");
        Contact c4 = new Contact("John3", emails);
        input.add(c4);

        emails = new ArrayList<String>();
        emails.add("bob@gmail.com");
        Contact c5 = new Contact("Bob", emails);
        input.add(c5);

        emails = new ArrayList<String>();
        emails.add("john@yahoo.com");
        emails.add("john@hotmail.com");
        Contact c6 = new Contact("John4", emails);
        input.add(c6);

        g.groupContact(input);
    }
}

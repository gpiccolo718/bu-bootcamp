import java.util.HashMap;
import java.util.ArrayList;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: Add contacts here
        contacts.put("Maeve Keeley", new Contact("Maeve Keeley", "+1 (847) 530-4239"));
        contacts.put("Caitlin Bedell", new Contact("Caitlin Bedell", "+1 (914) 217-8483"));
        contacts.put("Katie Martin", new Contact("Katie Martin","+1 (484) 886-7371"));
        contacts.put("Mom", new Contact("Mom", "+1 (347) 203-1347"));
        contacts.put("Dad", new Contact("Dad","+1 (347) 203-1153"));

        // Step 5: Look for a contact
        Contact found = contacts.get("Caitlin Bedell");
        
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }
        
        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===");
        System.out.println(sorted);
    }
}
import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties
public class Users {

    public String name;
    public String username;
    public String email;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Users() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Users(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("username", username);
        result.put("email", email);

        return result;
    }
    // [END post_to_map]
}



Users userdat = childSnapshot.getValue(Users.class);
System.out.println("name: "+userdat.toMap().get("name"));

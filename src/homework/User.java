package homework;

/**
 * Created by ST001 on 2017/3/22.
 */
public class User {
    String username;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    void User(String username){
        setUsername(username);
    }
    void User(String username,String key){
        getUsername();
        getKey();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("ABCD");
        System.out.println(user.getUsername());

        user.User("ABC","Key");
        System.out.println(user.getUsername()+" "+user.getKey());

    }
}

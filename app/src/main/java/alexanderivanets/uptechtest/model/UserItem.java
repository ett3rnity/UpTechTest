package alexanderivanets.uptechtest.model;

/**
 * Created by alexander on 07.10.17.
 */

public class UserItem {
    private String name;
    private String token;
    private String userId;

    public UserItem(String name, String token, String userId){
        this.name = name;
        this.token = token;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }
}

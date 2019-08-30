public class Users {

    private int id;
    private String username;
    private String token;

    public Users(){

    }

    public Users(int id, String token, String username) {
        this.id = id;
        this.token = token;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

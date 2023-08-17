import java.util.HashSet;
import java.util.Set;

public class User implements Comparable<User> {

    private String userName;
    private String firstName;
    private String lastName;

    private Set<String> emailSet = new HashSet<>();


    public User() {
    }

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addEmail(String email) {
        emailSet.add(email);
    }

    public Set<String> getEmailSet() {
        return emailSet;
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}

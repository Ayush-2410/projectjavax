 
package bean;


public class User {

    int id,type;
   String name,email,username,password,mobile;

    public User() {
    }

    public User(int id,String name, String email, String username, String password, String mobile,int type) 
    {
        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }
    public User(String name, String email, String username, String password, String mobile,int type) {
        this.type = type;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return name;
    }
   
    
     
}


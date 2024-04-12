package vinnsla;

public class User {
    private String kennitala;
    private String nafn;
    private String email;
    private String password;

    public User(String kennitala, String nafn, String email, String password) {
        this.kennitala = kennitala;
        this.nafn = nafn;
        this.email = email;
        this.password = password;
    }


    public String getKennitala() {
        return kennitala;
    }

    public void setKennitala(String kennitala) {
        this.kennitala = kennitala;
    }

    public String getNafn() {
        return nafn;
    }

    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

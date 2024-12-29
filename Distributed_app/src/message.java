
import java.io.Serializable;

public class message implements Serializable {
    private String login;
    private String passwd;
    private float value;
    private char typeOp;

    public message(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }
    public message(String login, String passwd, char typeOp, float value){
        this.login = login;
        this.passwd = passwd;
        this.typeOp = typeOp;
        this.value = value;
    }
    public message(String login, String passwd, char typeOp){
        this.login = login;
        this.passwd = passwd;
        this.typeOp = typeOp;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setTypeOp(char typeOp) {
        this.typeOp = typeOp;
    }

    public float getValue() {
        return value;
    }

    public char getTypeOp() {
        return typeOp;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}


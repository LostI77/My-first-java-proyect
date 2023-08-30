import java.io.Serializable;

public class User implements Serializable{

    private String myNAME;
    private String myLASTNAME;
    private String myUSERNAME;
    private int myAGE;
    private String myGMAIl;
    private String myPASSWORD;

    public User(String myName, String myLastName, String myUsername, int myAge, String myGmail, String myPassword) {
        this.myNAME = myName;
        this.myLASTNAME = myLastName;
        this.myUSERNAME = myUsername;
        this.myAGE = myAge;
        this.myGMAIl = myGmail;
        this.myPASSWORD = myPassword;
    }
    public String getMyNAME() { return myNAME; }
    public String getMyLASTNAME() {
        return myLASTNAME;
    }
    public String getMyUSERNAME() {
        return myUSERNAME;
    }
    public int getMyAGE() {
        return myAGE;
    }
    public String getMyGMAIl() {
        return myGMAIl;
    };
    public String getMyPASSWORD() { return myPASSWORD; }
}

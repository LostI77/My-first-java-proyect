import java.io.Serializable;

public class User implements Serializable{

    private String myNAME;
    private String myLASTNAME;
    private int myAGE;
    private String myGMAIl;
    private String myPASSWORD;

    public User(String myName, String myLastName, int myAge, String myGmail, String myPassword) {
        this.myNAME = myName;
        this.myLASTNAME = myLastName;
        this.myAGE = myAge;
        this.myGMAIl = myGmail;
        this.myPASSWORD = myPassword;
    }
    public String getMyNAME() {
        return myNAME;
    }
    public String getMyLASTNAME() {
        return myLASTNAME;
    }
    public int getMyAGE() {
        return myAGE;
    }
    public String getMyGMAIl() {
        return myGMAIl;
    };
    public String getMyPASSWORD() {
        return myPASSWORD;
    }
}

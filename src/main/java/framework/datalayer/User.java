package framework.datalayer;

public class User {
	 public String userEmail ;
	    public String userNewPswd;
	    public String userOldPswd ;

	    public User()
	    {
	        userEmail = "";
	        userNewPswd = "";
	        userOldPswd = "";

	    }

	    public User(String email, String newPd, String oldPd)
	    {
	        userEmail = email;
	        userNewPswd = newPd;
	        userOldPswd = oldPd;
	    }


}

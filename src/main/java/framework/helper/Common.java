package framework.helper;

public class Common {
	public static String ioDataFolderPath = System.getProperty("user.dir") + "/IOData/";
	public static String driverFolderPath = ioDataFolderPath + "Drivers/";
	public static String reportPath = ioDataFolderPath + "Reports/";

	public static String credentialsFilePath = ioDataFolderPath + "Credentials.txt";
	public static String usersFilePath = ioDataFolderPath + "Users.txt";
	

	public static String GetDriverFolderPath() {
		return driverFolderPath;
	}


	public static String GetCredentialsPath() {
		return credentialsFilePath;

	}

	public static String GetUsersPath() {
		return usersFilePath;

	}

}

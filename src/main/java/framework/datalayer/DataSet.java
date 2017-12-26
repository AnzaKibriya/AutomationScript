package framework.datalayer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import framework.helper.Common;

public class DataSet {

    public static String baseURL;

    public static String CandidateID;
    public static String Pswd;

    public static String recruiterEmailId;
    public static String recruiterEmailPswd;

    public static String hmUserName;
    public static String hmCurrentPswd;
	public static String hmPreviousPswd;

    public static String currentMoment;
    public static String browserRequired;


	public static String tempUserEmail = "";
	public static String tempUserCurrentPswd = "";
	public static String tempUserPreviousPswd = "";

	//public static ArrayList<User> listUsers;

	private static void FillDataFromFiles() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(Common.GetCredentialsPath()));
        for (String line: lines) {
            String tempKey = line.split("=")[0].trim();
            String tempValue = line.split("=")[1].trim();

            if ("baseURL".equals(tempKey))
                baseURL = tempValue;
            else if ("CandidateID".equals(tempKey))
                CandidateID = tempValue;
            else if ("Pswd".equals(tempKey))
                Pswd = tempValue;
            else if ("recruiterEmailId".equals(tempKey))
                recruiterEmailId = tempValue;
            else if ("recruiterEmailPswd".equals(tempKey))
            	recruiterEmailPswd = tempValue;
            else if ("hmUserName".equals(tempKey))
            	hmUserName = tempValue;
            else if ("hmCurrentPswd".equals(tempKey))
                hmCurrentPswd = tempValue;
            else if ("hmPreviousPswd".equals(tempKey))
            	hmPreviousPswd = tempValue;
            else if ("currentMoment".equals(tempKey))
                currentMoment = tempValue;
            else if ("browserRequired".equals(tempKey))
                browserRequired = tempValue;

        }

//        List<String> usersData = Files.readAllLines(Paths.get(Common.GetUsersPath()));
//        if (usersData.size() > 0) {
//           // listUsers = new ArrayList<User>();
//
//            for (String line: usersData) {
//                User tempUser = new User();
//                tempUser.userEmail = line.split(":")[1].trim();
//                tempUser.userNewPswd = line.split(":")[2].trim();
//                tempUser.userOldPswd = line.split(":")[3].trim();
//               // listUsers.add(tempUser);
//
//                tempUserEmail = tempUser.userEmail;
//                tempUserCurrentPswd = tempUser.userNewPswd;
//                tempUserPreviousPswd = tempUser.userOldPswd;
//
//            }
//        }
    }

	public static void FillNewCredentials() throws IOException {
        FillDataFromFiles();
        GetCurrentMoment();
        GenerateUser();
	}

    public static void FillExistingCredentials() throws IOException {
        FillDataFromFiles();
    }
    public static void UpdateAdminPasswords() throws IOException {
        String tempStr = null;
        tempStr = hmCurrentPswd;
        hmCurrentPswd = hmPreviousPswd;
        hmPreviousPswd = tempStr;
        UpdateAdminCredantials();
    }

    public static void UpdateUserPasswords() throws IOException {
        String tempStr = null;
        tempStr = tempUserCurrentPswd;
        tempUserCurrentPswd = tempUserPreviousPswd;
        tempUserPreviousPswd = tempStr;
        UpdateUsers();
    }


	public static void UpdateAdminCredantials() throws IOException {
		//List<String> lines = Files.readAllLines(Paths.get(Common.GetCredentialsPath()));
        FileWriter fw = new FileWriter(String.valueOf(Paths.get(Common.GetCredentialsPath())));
        String fileContent = null;
        fileContent =   "baseURL=" + baseURL+
                        "\nCandidateID="+ CandidateID +
                        "\nPswd="+ Pswd +
                        "\nrecruiterEmailId="+ recruiterEmailId +
                        "\nrecruiterEmailPswd="+ recruiterEmailPswd +
                        "\nhmUserName="+ hmUserName +
                        "\nhmCurrentPswd="+ hmCurrentPswd +
                        "\nrecruiterEmailPswd="+ hmPreviousPswd +
                        "\ncurrentMoment="+ currentMoment +
                        "\nbrowserRequired="+ browserRequired;
        fw.flush();
        fw.write(fileContent);
        fw.close();

	}

    public static void UpdateUsers() throws IOException {
        //List<String> lines = Files.readAllLines(Paths.get(Common.GetCredentialsPath()));
        FileWriter fw = new FileWriter(String.valueOf(Paths.get(Common.GetUsersPath())));
       // String fileContent = "";


//        for (User tempUser: listUsers ) {
//            if (tempUser.userEmail.contains(tempUserEmail)) {
//                tempUser.userNewPswd = tempUserCurrentPswd;
//                tempUser.userOldPswd = tempUserPreviousPswd;
//            }
//
//
//            String tempLine = "user" +  ":" +
//                    tempUser.userEmail + ":" +
//                    tempUser.userNewPswd + ":" +
//                    tempUser.userOldPswd + "\n";
//
//            fileContent = fileContent + tempLine;
//            //fileContent.concat(tempLine);
//        }

        String tempLine = "user" +  ":" +
                tempUserEmail + ":" +
                tempUserCurrentPswd + ":" +
                tempUserPreviousPswd + "\n";

       // fileContent = fileContent + tempLine;

        fw.flush();
        fw.write(tempLine);

        fw.close();

    }


    private static String GetCurrentMoment()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmm");
        Date date = new Date();
        String moment = dateFormat.format(date);
        currentMoment = moment;
        return moment;
    }


    public static void GenerateUser() throws IOException {

        tempUserEmail = "testkualitatem1+" + currentMoment + "@gmail.com";
        tempUserCurrentPswd = "Kualitatem1";
        tempUserPreviousPswd = "kualitatem1";

        User tempUser = new User(tempUserEmail, tempUserCurrentPswd, tempUserPreviousPswd);
        //listUsers.add(tempUser);


        UpdateUsers();
    }

}

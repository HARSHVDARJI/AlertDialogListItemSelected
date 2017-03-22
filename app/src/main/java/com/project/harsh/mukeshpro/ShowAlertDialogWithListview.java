//package com.project.harsh.mukeshpro;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///**
// * Created by harsh on 22/3/17.
// */
//
//public class ShowAlertDialogWithListview {
//
//    String agentString = "{\n" +
//            "\t\"agent_data\":\n" +
//            "\t\t[\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"Agent_Id\": \"1\",\n" +
//            "\t\t\t\t\"Fname\": \"Aakash\",\n" +
//            "\t\t\t\t\"Lname\": \"Bhatia\",\n" +
//            "\t\t\t\t\"Address\": \"B45 Gopal Nagar Society\",\n" +
//            "\t\t\t\t\"Pincode\": \"382480\",\n" +
//            "\t\t\t\t\"Email\": \"aakashbhatia@gmail.com\",\n" +
//            "\t\t\t\t\"Phone\": \"9874561230\",\n" +
//            "\t\t\t\t\"Password\": \"aakash\",\n" +
//            "\t\t\t\t\"Area\": \"New Ranip\",\n" +
//            "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
//            "\t\t\t\t\"State\": \"Gujarat\",\n" +
//            "\t\t\t\t\"Gender\": \"Male\",\n" +
//            "\t\t\t\t\"Aadhar\": \"1874 6547 8955\",\n" +
//            "\t\t\t\t\"Dob\": \"04-24-90\"\n" +
//            "\t\t\t},\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"Agent_Id\": \"2\",\n" +
//            "\t\t\t\t\"Fname\": \"Gautam\",\n" +
//            "\t\t\t\t\"Lname\": \"Mishra\",\n" +
//            "\t\t\t\t\"Address\": \"1 Rambagh Society\",\n" +
//            "\t\t\t\t\"Pincode\": \"348577\",\n" +
//            "\t\t\t\t\"Email\": \"gautammishra@gmail.com\",\n" +
//            "\t\t\t\t\"Phone\": \"8745961235\",\n" +
//            "\t\t\t\t\"Password\": \"gautam\",\n" +
//            "\t\t\t\t\"Area\": \"Navrangpura\",\n" +
//            "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
//            "\t\t\t\t\"State\": \"Gujarat\",\n" +
//            "\t\t\t\t\"Gender\": \"Male\",\n" +
//            "\t\t\t\t\"Aadhar\": \"1875 4578 6587\",\n" +
//            "\t\t\t\t\"Dob\": \"03-21-92\"\n" +
//            "\t\t\t},\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"Agent_Id\": \"3\",\n" +
//            "\t\t\t\t\"Fname\": \"Ashwin\",\n" +
//            "\t\t\t\t\"Lname\": \"Parekh\",\n" +
//            "\t\t\t\t\"Address\": \"72 Wishwa Flats\",\n" +
//            "\t\t\t\t\"Pincode\": \"383800\",\n" +
//            "\t\t\t\t\"Email\": \"ashwinparekh@gmail.com\",\n" +
//            "\t\t\t\t\"Phone\": \"9874654848\",\n" +
//            "\t\t\t\t\"Password\": \"ashwin\",\n" +
//            "\t\t\t\t\"Area\": \"Wadaj\",\n" +
//            "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
//            "\t\t\t\t\"State\": \"Gujarat\",\n" +
//            "\t\t\t\t\"Gender\": \"Male\",\n" +
//            "\t\t\t\t\"Aadhar\": \"1875 4587 8598\",\n" +
//            "\t\t\t\t\"Dob\": \"02-12-91\"\n" +
//            "\t\t\t},\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"Agent_Id\": \"4\",\n" +
//            "\t\t\t\t\"Fname\": \"Jaimin\",\n" +
//            "\t\t\t\t\"Lname\": \"Panchal\",\n" +
//            "\t\t\t\t\"Address\": \"32 Tirupati Nagar\",\n" +
//            "\t\t\t\t\"Pincode\": \"383800\",\n" +
//            "\t\t\t\t\"Email\": \"jaiminpanchal@gmail.com\",\n" +
//            "\t\t\t\t\"Phone\": \"8545457898\",\n" +
//            "\t\t\t\t\"Password\": \"jaimin\",\n" +
//            "\t\t\t\t\"Area\": \"Wadaj\",\n" +
//            "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
//            "\t\t\t\t\"State\": \"Gujarat\",\n" +
//            "\t\t\t\t\"Gender\": \"Male\",\n" +
//            "\t\t\t\t\"Aadhar\": \"1875 7898 1236\",\n" +
//            "\t\t\t\t\"Dob\": \"01-17-93\"\n" +
//            "\t\t\t},\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"Agent_Id\": \"5\",\n" +
//            "\t\t\t\t\"Fname\": \"Rajveer\",\n" +
//            "\t\t\t\t\"Lname\": \"Dataniya\",\n" +
//            "\t\t\t\t\"Address\": \"J8 Ramnagar\",\n" +
//            "\t\t\t\t\"Pincode\": \"382480\",\n" +
//            "\t\t\t\t\"Email\": \"rajveerdataniya@gmail.com\",\n" +
//            "\t\t\t\t\"Phone\": \"8845789812\",\n" +
//            "\t\t\t\t\"Password\": \"rajveer\",\n" +
//            "\t\t\t\t\"Area\": \"New Ranip\",\n" +
//            "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
//            "\t\t\t\t\"State\": \"Gujarat\",\n" +
//            "\t\t\t\t\"Gender\": \"Male\",\n" +
//            "\t\t\t\t\"Aadhar\": \"1873 7415 9874\",\n" +
//            "\t\t\t\t\"Dob\": \"05-15-91\"\n" +
//            "\t\t\t},\n" +
//            "\t\t]\n" +
//            "}";
//
//    final ArrayList<AgentNamesPost> names = new ArrayList<AgentNamesPost>();
//    try{
//
//    }
//}

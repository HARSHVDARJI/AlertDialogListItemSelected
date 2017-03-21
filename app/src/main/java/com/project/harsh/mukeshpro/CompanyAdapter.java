package com.project.harsh.mukeshpro;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CompanyAdapter extends BaseAdapter{

    Context context;
    int layoutResourceId;
    ArrayList<CompanyPost> posts;
    AlertDialog alertDialog1;
    CharSequence[] values = {" First Item "," Second Item "," Third Item "};

    public CompanyAdapter(Context context, int layoutResourceId, ArrayList<CompanyPost> posts) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder
    {
        TextView id, name, mobile, amount, address, area, city, state, assignTo;
        Button assign, edit;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.company_rows, parent, false);

            holder.id = (TextView)convertView.findViewById(R.id.customerid);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.mobile = (TextView)convertView.findViewById(R.id.mobileno);
            holder.amount = (TextView)convertView.findViewById(R.id.amount);
            holder.address = (TextView)convertView.findViewById(R.id.address);
            holder.area = (TextView)convertView.findViewById(R.id.area);
            holder.city = (TextView)convertView.findViewById(R.id.city);
            holder.state = (TextView)convertView.findViewById(R.id.state);
            holder.assignTo = (TextView)convertView.findViewById(R.id.assignTo);

            holder.assign = (Button)convertView.findViewById(R.id.btn_assign);
            holder.edit = (Button)convertView.findViewById(R.id.btn_edit);

            convertView.setTag(holder);
        }

        else {

            holder = (ViewHolder)convertView.getTag();
        }

        holder.id.setText("ID: " +posts.get(position).getCustomer_id());
        holder.name.setText("Name: " +posts.get(position).getName());
        holder.mobile.setText("Mobile No: " +posts.get(position).getMobile_no());
        holder.amount.setText("Amount: "+posts.get(position).getAmount());
        holder.address.setText("Address: " +posts.get(position).getAddress());
        holder.area.setText("Area: "+posts.get(position).getArea());
        holder.city.setText("City: "+posts.get(position).getCity());
        holder.state.setText("State: "+posts.get(position).getState());

        String none = "None";

        holder.assignTo.setText("Assign To : " +none);

        holder.assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                
                
                /*************** Call method inside this**/
                 ShowAlertDialogWithListview();
               
                /********************/
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());

                builder.setTitle("Select Your Choice");

                builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {

                        switch(item)
                        {
                            case 0:

                                Toast.makeText(v.getRootView().getContext(), "First Item Clicked", Toast.LENGTH_LONG).show();
                                break;
                            case 1:

                                Toast.makeText(v.getRootView().getContext(), "Second Item Clicked", Toast.LENGTH_LONG).show();
                                break;
                            case 2:

                                Toast.makeText(v.getRootView().getContext(), "Third Item Clicked", Toast.LENGTH_LONG).show();
                                break;
                        }
                        alertDialog1.dismiss();
                    }
                });
                alertDialog1 = builder.create();
                alertDialog1.show();
//                Toast.makeText(context, "Assign Clicked: " +position, Toast.LENGTH_SHORT).show();
            }
        });
//
//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Edit Clicked: " +position, Toast.LENGTH_SHORT).show();
//            }
//        });
        return convertView;
    }

    private void CreateAlertDialogWithRadioButtonGroup() {

    }
    
    /****************************************************************************************************/
    
    public void ShowAlertDialogWithListview()
    {
        String agentString = "{\n" +
                "\t\"agent_data\":\n" +
                "\t\t[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"1\",\n" +
                "\t\t\t\t\"Fname\": \"Aakash\",\n" +
                "\t\t\t\t\"Lname\": \"Bhatia\",\n" +
                "\t\t\t\t\"Address\": \"B45 Gopal Nagar Society\",\n" +
                "\t\t\t\t\"Pincode\": \"382480\",\n" +
                "\t\t\t\t\"Email\": \"aakashbhatia@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"9874561230\",\n" +
                "\t\t\t\t\"Password\": \"aakash\",\n" +
                "\t\t\t\t\"Area\": \"New Ranip\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1874 6547 8955\",\n" +
                "\t\t\t\t\"Dob\": \"04-24-90\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"2\",\n" +
                "\t\t\t\t\"Fname\": \"Gautam\",\n" +
                "\t\t\t\t\"Lname\": \"Mishra\",\n" +
                "\t\t\t\t\"Address\": \"1 Rambagh Society\",\n" +
                "\t\t\t\t\"Pincode\": \"348577\",\n" +
                "\t\t\t\t\"Email\": \"gautammishra@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"8745961235\",\n" +
                "\t\t\t\t\"Password\": \"gautam\",\n" +
                "\t\t\t\t\"Area\": \"Navrangpura\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1875 4578 6587\",\n" +
                "\t\t\t\t\"Dob\": \"03-21-92\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"3\",\n" +
                "\t\t\t\t\"Fname\": \"Ashwin\",\n" +
                "\t\t\t\t\"Lname\": \"Parekh\",\n" +
                "\t\t\t\t\"Address\": \"72 Wishwa Flats\",\n" +
                "\t\t\t\t\"Pincode\": \"383800\",\n" +
                "\t\t\t\t\"Email\": \"ashwinparekh@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"9874654848\",\n" +
                "\t\t\t\t\"Password\": \"ashwin\",\n" +
                "\t\t\t\t\"Area\": \"Wadaj\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1875 4587 8598\",\n" +
                "\t\t\t\t\"Dob\": \"02-12-91\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"4\",\n" +
                "\t\t\t\t\"Fname\": \"Jaimin\",\n" +
                "\t\t\t\t\"Lname\": \"Panchal\",\n" +
                "\t\t\t\t\"Address\": \"32 Tirupati Nagar\",\n" +
                "\t\t\t\t\"Pincode\": \"383800\",\n" +
                "\t\t\t\t\"Email\": \"jaiminpanchal@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"8545457898\",\n" +
                "\t\t\t\t\"Password\": \"jaimin\",\n" +
                "\t\t\t\t\"Area\": \"Wadaj\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1875 7898 1236\",\n" +
                "\t\t\t\t\"Dob\": \"01-17-93\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"5\",\n" +
                "\t\t\t\t\"Fname\": \"Rajveer\",\n" +
                "\t\t\t\t\"Lname\": \"Dataniya\",\n" +
                "\t\t\t\t\"Address\": \"J8 Ramnagar\",\n" +
                "\t\t\t\t\"Pincode\": \"382480\",\n" +
                "\t\t\t\t\"Email\": \"rajveerdataniya@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"8845789812\",\n" +
                "\t\t\t\t\"Password\": \"rajveer\",\n" +
                "\t\t\t\t\"Area\": \"New Ranip\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1873 7415 9874\",\n" +
                "\t\t\t\t\"Dob\": \"05-15-91\"\n" +
                "\t\t\t},\n" +
                "\t\t]\n" +
                "}";

        final ArrayList<AgentNamesPost> names = new ArrayList<AgentNamesPost>();

        try {
            JSONObject rootObject = new JSONObject(agentString);
            JSONArray jsonArray =  rootObject.getJSONArray("agent_data");

            for (int i = 0; i <jsonArray.length() ; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                AgentNamesPost post = new AgentNamesPost();

                String fname = jsonObject.getString("Fname");
                //String lname = jsonObject.getString("Lname");

                post.setFname(fname);
                //post.setLname(lname);

                names.add(post);

                //Create sequence of items
                final CharSequence[] Names = names.toArray(new String[names.size()]);

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                dialogBuilder.setTitle("Agent Names");

                dialogBuilder.setItems(Names, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        String selectedText = Names[item].toString();  //Selected item in listview
                    }
                });
                //Create alert dialog object via builder
                AlertDialog alertDialogObject = dialogBuilder.create();
                //Show the dialog
                alertDialogObject.show();

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    /****************************************************************************************************/


}

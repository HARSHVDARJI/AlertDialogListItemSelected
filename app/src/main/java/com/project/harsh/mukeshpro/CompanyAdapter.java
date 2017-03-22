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
    ArrayList<AgentNamesPost> agnames;
    AlertDialog alertDialog1;
//    CharSequence[] values = {" First Item "," Second Item "," Third Item "};



    public CompanyAdapter(Context context, int layoutResourceId, ArrayList<CompanyPost> posts,
                          ArrayList<AgentNamesPost> agnames) {
        super();
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.posts = posts;
        this.agnames = agnames;
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

    @Override
    public int getViewTypeCount() {
        return 2;
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
        final String[] stringarray =  new String[agnames.size()];
        for (int i = 0; i <agnames.size() ; i++) {
            stringarray[i] = agnames.get(i).toString();
        }
        holder.assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());

                builder.setTitle("Select Your Choice");
                builder.setSingleChoiceItems(stringarray, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getRootView().getContext(), "name"+ which, Toast.LENGTH_LONG).show();
                        alertDialog1.dismiss();
                        }
                });
//                builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int item) {
//
//                        switch(item)
//                        {
//                            case 0:
//
//                                Toast.makeText(v.getRootView().getContext(), "First Item Clicked", Toast.LENGTH_LONG).show();
//                                break;
//                            case 1:
//
//                                Toast.makeText(v.getRootView().getContext(), "Second Item Clicked", Toast.LENGTH_LONG).show();
//                                break;
//                            case 2:
//
//                                Toast.makeText(v.getRootView().getContext(), "Third Item Clicked", Toast.LENGTH_LONG).show();
//                                break;
//                        }
//                        alertDialog1.dismiss();
//                    }
//                });
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
}
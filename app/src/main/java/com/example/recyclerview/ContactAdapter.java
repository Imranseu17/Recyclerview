package com.example.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.databinding.ContactitemBinding;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    ArrayList<Contact> contactList ;

    public ContactAdapter(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ContactitemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.contactitem, viewGroup, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Contact current = contactList.get(i);
        viewHolder.contactitemBinding.name.setText("Name: "+current.getName());
        viewHolder.contactitemBinding.phone.setText("Phone Number: "+current.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        if(contactList.isEmpty())
            return 0;
        else
          return contactList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        ContactitemBinding contactitemBinding;


        public ViewHolder(ContactitemBinding contactitemBinding) {
            super(contactitemBinding.getRoot());
            this.contactitemBinding = contactitemBinding;
        }
    }

}

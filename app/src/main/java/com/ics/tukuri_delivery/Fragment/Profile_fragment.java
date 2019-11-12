package com.ics.tukuri_delivery.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ics.tukuri_delivery.AppUtils.AppPrefrences;
import com.ics.tukuri_delivery.R;

public class Profile_fragment extends Fragment
{

    TextView name , mobile , address, mail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        name = view.findViewById(R.id.tx_pname);
        mobile = view.findViewById(R.id.tx_pmobile);
        address = view.findViewById(R.id.tx_paddress);
        mail = view.findViewById(R.id.tx_pmail);

        name.setText(""+ AppPrefrences.getName(getActivity()));
        mobile.setText(""+AppPrefrences.getMobile(getActivity()));
        address.setText(""+AppPrefrences.getAddress(getActivity()));
        mail.setText(""+AppPrefrences.getMail(getActivity()));

        return view;
    }
}

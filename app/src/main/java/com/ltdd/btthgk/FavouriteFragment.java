package com.ltdd.btthgk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavouriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavouriteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    ArrayList<Items> items = new ArrayList<>();
    Adapter adapter;
    Boolean kt=false;
    int j=0;


    public FavouriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavouriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavouriteFragment newInstance(String param1, String param2) {
        FavouriteFragment fragment = new FavouriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.list_view);
        Button btthem = (Button) view.findViewById(R.id.bt_them);
        EditText item_ten = (EditText) view.findViewById(R.id.edt_them);
        EditText item_mota = (EditText) view.findViewById(R.id.edt_hint);
        items.add(new Items("salad","60.000VNĐ",R.drawable.salad)) ;
        items.add(new Items("Trái cây","50.000VNĐ",R.drawable.fruits)) ;
        items.add(new Items("Gà nướng","200.000VNĐ",R.drawable.chicken)) ;
        items.add(new Items("Trà đào","25.000VNĐ",R.drawable.tea)) ;
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(new Items(item_ten.getText().toString(),item_mota.getText().toString(),0));
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new Adapter(getActivity(),items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Details.class);
                intent.putExtra("dulieu",items.get(i).getTen());
                if (kt!=true)
                    startActivity(intent);
                kt=false;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(getActivity());
        alertDiaLog.setTitle("Thông báo");

        alertDiaLog.setMessage("Bạn có muốn xóa "+items.get(pos).getTen()+" ?"    );
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);

                adapter.notifyDataSetChanged();

            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}
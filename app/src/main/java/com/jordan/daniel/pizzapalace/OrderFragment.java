package com.jordan.daniel.pizzapalace;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        GridView toppingsGridView = (GridView) view.findViewById(R.id.toppingsGridView);

        ArrayList<String> labels = new ArrayList<>();
        labels.add("@string/order_toppings_label_pepperoni");
        labels.add("@string/order_toppings_label_bacon");
        labels.add("@string/order_toppings_label_ham");
        labels.add("@string/order_toppings_label_pineapple");
        labels.add("@string/order_toppings_label_hamburger");
        labels.add("@string/order_toppings_label_mushrooms");
        labels.add("@string/order_toppings_label_anchovies");
        labels.add("@string/order_toppings_label_green_olives");
        labels.add("@string/order_toppings_label_black_olives");
        labels.add("@string/order_toppings_label_peppers");
        labels.add("@string/order_toppings_label_onions");
        labels.add("@string/order_toppings_label_sausage");
        labels.add("@string/order_toppings_label_spinach");
        labels.add("@string/order_toppings_label_extra_cheese");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.order_toppings_row,labels);
        toppingsGridView.setAdapter(adapter);

        return view;
    }

    public class CustomAdapter extends ArrayAdapter{

        ArrayList<String> labels = new ArrayList<>();

        public CustomAdapter(Context context, int textViewResourceId, ArrayList objects){
            super(context, textViewResourceId, objects);
            labels = objects;
        }

        @Override
        public int getCount() {
            return super.getCount();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View view = convertView;
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.order_toppings_row, null);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.toppingCheckBox);
            checkBox.setText(labels.get(position));
            return view;

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

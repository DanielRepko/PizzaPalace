package com.jordan.daniel.pizzapalace;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jordan.daniel.pizzapalace.JavaBean.Pizza;

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
        //gridview for checkboxes
        GridView toppingsGridView = (GridView) view.findViewById(R.id.toppingsGridView);

        //ArrayList for checkbox labels with references to string values inside strings.xml
        ArrayList<Integer> labels = new ArrayList<>();
        labels.add(R.string.order_toppings_label_pepperoni);
        labels.add(R.string.order_toppings_label_bacon);
        labels.add(R.string.order_toppings_label_ham);
        labels.add(R.string.order_toppings_label_pineapple);
        labels.add(R.string.order_toppings_label_hamburger);
        labels.add(R.string.order_toppings_label_mushrooms);
        labels.add(R.string.order_toppings_label_anchovies);
        labels.add(R.string.order_toppings_label_green_olives);
        labels.add(R.string.order_toppings_label_black_olives);
        labels.add(R.string.order_toppings_label_peppers);
        labels.add(R.string.order_toppings_label_onions);
        labels.add(R.string.order_toppings_label_sausage);
        labels.add(R.string.order_toppings_label_spinach);
        labels.add(R.string.order_toppings_label_extra_cheese);

        //CustomAdapter for toppingsGridView
        CustomAdapter adapter1 = new CustomAdapter(getContext(),R.layout.order_toppings_row,labels);
        toppingsGridView.setAdapter(adapter1);

        //spinner for size options
        Spinner sizeSpinner = (Spinner) view.findViewById(R.id.sizeSpinner);

        //ArrayList for sizeSpinner with references to string values inside strings.xml\
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("Small");
        sizes.add("Medium");
        sizes.add("Large");

        //Adapter for sizeSpinner
        CustomSpinnerAdapter adapter2 = new CustomSpinnerAdapter(getContext(), R.layout.order_spinner_item, sizes);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapter2);

        /**
         * ArrayList to store all of the pizza types inside of the
         * ListView on the Pizza List page
         *
         * NOTE: final product will loop through the ListView on the
         * Pizza List page, but for now will be manually filled inside of
         * OrderFragment purely for testing purposes
         */
        ArrayList<Pizza> pizzas = new ArrayList<>();
        ArrayList<String> toppings = new ArrayList<>();

        toppings.add("Pepperoni");
        toppings.add("Bacon");
        toppings.add("Ham");
        toppings.add("Hamburger");
        toppings.add("Sausage");
        pizzas.add(new Pizza("Meat Lover's", toppings));

        toppings.clear();
        toppings.add("Pineapple");
        toppings.add("Ham");
        pizzas.add(new Pizza("Hawaiian", toppings));

        final Spinner typeSpinner = (Spinner) view.findViewById(R.id.typeSpinner);

        ArrayList<String> types = new ArrayList<>();
        types.add("-- Custom --");
        for(int i = 0; i < pizzas.size(); i++){
            types.add(pizzas.get(i).getName());
        }
        CustomSpinnerAdapter adapter3 = new CustomSpinnerAdapter(getContext(), R.layout.order_spinner_item, types);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter3);

        /**
         * The purpose of this onItemSelectedListener is to check off the CheckBoxes of the
         * appropriate toppings according to what type is selected in the type spinner
         *
         * Ex. is the item for Meat Lover's inside typeSpinner is selected, then the
         * CheckBoxes for pepperoni, bacon, ham, hamburger, and sausage will be checked off
         */

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    /**
     * This is allows checkboxes to be placed inside of toppingsGridView
     */
    public class CustomAdapter extends ArrayAdapter{

        ArrayList<Integer> labels = new ArrayList<>();

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
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.order_toppings_row, null);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.toppingCheckBox);
            checkBox.setText(labels.get(position));
            convertView = checkBox;
            return convertView;

        }
    }

    /**
     * This allows TextViews that reference strings.xml values to be placed inside the spinners
     */
    public class CustomSpinnerAdapter extends ArrayAdapter{
        ArrayList<String> labels = new ArrayList<>();

        public CustomSpinnerAdapter(Context context, int textViewResourceId, ArrayList objects){
            super(context, textViewResourceId, objects);
            labels = objects;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.order_spinner_item, null);
            TextView spinnerText = (TextView) convertView.findViewById(R.id.spinnerText);
            spinnerText.setText(labels.get(position));
            convertView = spinnerText;
            return convertView;

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

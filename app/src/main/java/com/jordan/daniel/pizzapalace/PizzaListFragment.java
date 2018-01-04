package com.jordan.daniel.pizzapalace;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jordan.daniel.pizzapalace.JavaBean.Pizza;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PizzaListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PizzaListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PizzaListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ListView list;
    FragmentManager fm;
    public static ArrayList<Pizza> pizzaArrayList;

    public PizzaListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PizzaListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PizzaListFragment newInstance(String param1, String param2) {
        PizzaListFragment fragment = new PizzaListFragment();
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
        View view = inflater.inflate(R.layout.fragment_pizza_list, container, false);

        list = (ListView) view.findViewById(R.id.pizzaList);

        pizzaArrayList = new ArrayList<Pizza>();

        ArrayList<String> meatLoversPizza = new ArrayList<String>();
        meatLoversPizza.add("Pepperoni");
        meatLoversPizza.add("Bacon");
        meatLoversPizza.add("Ham");
        meatLoversPizza.add("Hamburger");
        meatLoversPizza.add("Sausage");
        pizzaArrayList.add(new Pizza("Meat Lover's", meatLoversPizza));

        ArrayList<String> hawaiianPizza = new ArrayList<String>();
        hawaiianPizza.add("Pineapple");
        hawaiianPizza.add("Ham");
        pizzaArrayList.add(new Pizza("Hawaiian", hawaiianPizza));

        ArrayList<String> motherlodePizza = new ArrayList<String>();
        motherlodePizza.add("Pepperoni");
        motherlodePizza.add("Bacon");
        motherlodePizza.add("Ham");
        motherlodePizza.add("Pineapple");
        motherlodePizza.add("Hamburger");
        motherlodePizza.add("Mushrooms");
        motherlodePizza.add("Anchovies");
        motherlodePizza.add("Green Olives");
        motherlodePizza.add("Black Olives");
        motherlodePizza.add("Peppers");
        motherlodePizza.add("Onions");
        motherlodePizza.add("Sausage");
        motherlodePizza.add("Spinach");
        motherlodePizza.add("Extra Cheese");
        pizzaArrayList.add(new Pizza("The Motherlode", motherlodePizza));

        ArrayList<String> vegetarianPizza = new ArrayList<String>();
        vegetarianPizza.add("Pineapple");
        vegetarianPizza.add("Mushrooms");
        vegetarianPizza.add("Green Olives");
        vegetarianPizza.add("Black Olives");
        vegetarianPizza.add("Peppers");
        vegetarianPizza.add("Onions");
        vegetarianPizza.add("Spinach");
        pizzaArrayList.add(new Pizza("Vegetarian", vegetarianPizza));

        ArrayList<String> cheeseburgerPizza = new ArrayList<String>();
        cheeseburgerPizza.add("Bacon");
        cheeseburgerPizza.add("Hamburger");
        cheeseburgerPizza.add("Mushrooms");
        cheeseburgerPizza.add("Onions");
        cheeseburgerPizza .add("Extra Cheese");
        pizzaArrayList.add(new Pizza("Cheeseburger", cheeseburgerPizza));

        CustomAdapter adapter = new CustomAdapter(getContext(), pizzaArrayList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fm = getFragmentManager();
                FragmentTransaction trans = fm.beginTransaction();
                trans.replace(R.id.content, new OrderFragment());
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        return view;
    }

    public class CustomAdapter extends ArrayAdapter<Pizza> {
        public CustomAdapter(Context context, ArrayList<Pizza> items) {
            super(context, 0, items);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);
            }

            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView toppings = (TextView) convertView.findViewById(R.id.toppings);

            Pizza pizza = getItem(position);
            name.setText(pizza.getName());
            String toppingString = "";

            for(int i = 0; i < pizza.getToppings().size(); i++) {
                toppingString += pizza.getToppings().get(i) + ", ";
            }
            toppings.setText(toppingString);

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

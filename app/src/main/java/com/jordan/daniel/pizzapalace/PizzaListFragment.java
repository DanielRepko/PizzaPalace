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
import com.jordan.daniel.pizzapalace.JavaBean.PizzaList;

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

    /**
     * value is set to the index number of the selected
     * list item plus one
     */
    public static int itemChosen;

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

        ArrayList<Pizza> pizzaArrayList = new PizzaList();

        CustomAdapter adapter = new CustomAdapter(getContext(), pizzaArrayList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fm = getFragmentManager();
                PizzaListFragment.itemChosen = i + 1;
                FragmentTransaction trans = fm.beginTransaction();
                trans.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_back_in, R.anim.fade_back_out);
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

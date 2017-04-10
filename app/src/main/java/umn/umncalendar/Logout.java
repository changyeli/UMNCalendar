package umn.umncalendar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Logout extends Fragment{
    private Button logout_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_logout, container, false);
        logout_btn = (Button) v.findViewById(R.id.button);
        logout_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Logout.this.getActivity(), LoginActivity.class);
                Logout.this.getActivity().startActivity(i);
            }
        });
        return v;
    }



}

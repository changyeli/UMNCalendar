package umn.umncalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class Recommended_Tab extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*EventManager eventManager = new EventManager();
        List<String> interests = eventManager.getInterests();
        List<Event> recommendedEvents = eventManager.getRecommendedEvents(interests);*/
        return inflater.inflate(R.layout.fragment_recommended, container, false);
    }
}

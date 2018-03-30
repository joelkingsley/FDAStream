package com.chennaicoderiders.fdastream;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentaryFragment extends Fragment {

    ArrayList<SectionDataModel> allSampleData;
    ArrayList<Video> allVideos;
    ArrayList<PlaylistDataModel> playlistDataModels;
    Activity mActivity;

    public DocumentaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_animation, container, false);

        RecyclerView my_recycler_view = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), playlistDataModels);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();

        DBHandler dbHandler = new DBHandler(mActivity);
        allVideos = dbHandler.getAllDocumentaryVideos();

        //createDummyData();

        playlistDataModels = new ArrayList<>();
        PlaylistDataModel playlistDataModel = new PlaylistDataModel("All Videos",allVideos);
        playlistDataModels.add(playlistDataModel);
    }

}

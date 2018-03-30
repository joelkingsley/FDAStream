package com.chennaicoderiders.fdastream;

import java.util.ArrayList;

/**
 * Created by karthikeyansekar on 28/03/18.
 */

public class PlaylistDataModel {
    private String headerTitle;
    private ArrayList<Video> allVideosinPlaylist;

    public PlaylistDataModel() {

    }

    public PlaylistDataModel(String headerTitle, ArrayList<Video> allVideosinPlaylist) {
        this.headerTitle = headerTitle;
        this.allVideosinPlaylist = allVideosinPlaylist;
    }


    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<Video> getAllVideosinPlaylist() {
        return allVideosinPlaylist;
    }

    public void setAllItemsInSection(ArrayList<Video> allVideosinPlaylist) {
        this.allVideosinPlaylist= allVideosinPlaylist;
    }
}

package com.chennaicoderiders.fdastream;

public class Video {

    long _id;
    String _url;
    String _name;
    String _desc;
    String _category;
    String _language;
    int _year;
    String _director;
    String _image_url;
    String _duration;

    public Video(long _id, String _url, String _name, String _desc, String _category, String _language, int _year, String _director, String _image_url, String _duration) {
        this._id = _id;
        this._url = _url;
        this._name = _name;
        this._desc = _desc;
        this._category = _category;
        this._language = _language;
        this._year = _year;
        this._director = _director;
        this._image_url = _image_url;
        this._duration = _duration;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public String get_category() {
        return _category;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public String get_language() {
        return _language;
    }

    public void set_language(String _language) {
        this._language = _language;
    }

    public int get_year() {
        return _year;
    }

    public void set_year(int _year) {
        this._year = _year;
    }

    public String get_director() {
        return _director;
    }

    public void set_director(String _director) {
        this._director = _director;
    }

    public String get_image_url() {
        return _image_url;
    }

    public void set_image_url(String _image_url) {
        this._image_url = _image_url;
    }

    public String get_duration() {
        return _duration;
    }

    public void set_duration(String _duration) {
        this._duration = _duration;
    }


    public Video(String _url, String _name, String _desc, String _category, String _language, int _year, String _director, String _image_url, String _duration) {
        this._url = _url;
        this._name = _name;
        this._desc = _desc;
        this._category = _category;
        this._language = _language;
        this._year = _year;
        this._director = _director;
        this._image_url = _image_url;
        this._duration = _duration;
    }

    public Video(String _url, String _name, String _desc, String _image_url) {
        this._url = _url;
        this._name = _name;
        this._desc = _desc;
        this._image_url = _image_url;

        this._category = "";
        this._language = "";
        this._year = -1;
        this._director = "";
        this._duration = "";
    }

    public Video(long _id, String _name, String _image_url) {
        this._id = _id;
        this._name = _name;
        this._image_url = _image_url;
    }
}
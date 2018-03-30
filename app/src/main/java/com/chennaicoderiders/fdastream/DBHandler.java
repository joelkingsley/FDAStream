package com.chennaicoderiders.fdastream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteAssetHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "films.db";

    private static final String TABLE_FILM = "film";

    public static final String F_KEY_ID = "id";
    public static final String F_KEY_URL = "url";
    public static final String F_KEY_NAME = "name";
    public static final String F_KEY_DESC = "desc";
    public static final String F_KEY_CATEGORY = "category";
    public static final String F_KEY_LANGUAGE = "language";
    public static final String F_KEY_YEAR = "year";
    public static final String F_KEY_DIRECTOR = "director";
    public static final String F_KEY_IMAGE_URL = "image_url";
    public static final String F_KEY_DURATION = "duration";

    public static final String F_CAT_ANIMATION = "Animation Film";
    public static final String F_CAT_DOCUMENTARIES = "Documentaries";
    public static final String F_CAT_NEWS = "News Coverages";
    public static final String F_CAT_BIOGRAPHIES = "Biographies";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<Video> getAllVideos(){
        ArrayList<Video> allVideos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Video video = new Video(cursor.getLong(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getString(9));
                allVideos.add(video);
            }while(cursor.moveToNext());
        }
        return allVideos;
    }

    public ArrayList<Video> getAllAnimationVideos(){
        ArrayList<Video> allVideos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM + " WHERE " + F_KEY_CATEGORY + " LIKE " + '"' + F_CAT_ANIMATION + '"';
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Video video = new Video(cursor.getLong(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getString(9));
                allVideos.add(video);
            }while(cursor.moveToNext());
        }
        return allVideos;
    }

    public ArrayList<Video> getAllDocumentaryVideos(){
        ArrayList<Video> allVideos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM + " WHERE " + F_KEY_CATEGORY + " LIKE " + '"' + F_CAT_DOCUMENTARIES + '"';
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Video video = new Video(cursor.getLong(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getString(9));
                allVideos.add(video);
            }while(cursor.moveToNext());
        }
        return allVideos;
    }

    public ArrayList<Video> getAllNewsVideos(){
        ArrayList<Video> allVideos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM + " WHERE " + F_KEY_CATEGORY + " LIKE " + '"' + F_CAT_NEWS + '"';
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Video video = new Video(cursor.getLong(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getString(9));
                allVideos.add(video);
            }while(cursor.moveToNext());
        }
        return allVideos;
    }

    public ArrayList<Video> getAllBiographyVideos(){
        ArrayList<Video> allVideos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM + " WHERE " + F_KEY_CATEGORY + " LIKE " + '"' + F_CAT_BIOGRAPHIES + '"';
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Video video = new Video(cursor.getLong(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getString(9));
                allVideos.add(video);
            }while(cursor.moveToNext());
        }
        return allVideos;
    }


    public Video getVideo(long id){
        Video video = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM + " WHERE " + F_KEY_ID + "=" + id;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            video = new Video(cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getInt(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9));
        }

        return video;

    }

    public Video getMinVideo(long id){
        Video video = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + F_KEY_NAME + "," + F_KEY_URL + "," + F_KEY_IMAGE_URL + "," + F_KEY_DESC + " FROM " + TABLE_FILM + " WHERE " + F_KEY_ID + "=" + id;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            video = new Video(cursor.getString(1),cursor.getString(0), cursor.getString(3),cursor.getString(2));
        }

        return video;
    }

}
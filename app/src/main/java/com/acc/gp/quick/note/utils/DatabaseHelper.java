package com.acc.gp.quick.note.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.acc.gp.quick.note.model.Note;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SharePreferenceUtils sharePreferenceUtils;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QuickNote";
    private static final String TABLE_FOLDER = "tb_folder";
    private static final String TABLE_NOTE = "tb_note";
    private static final String ID = "id";
    private static final String FOLDER_ID = "folder_id";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String NOTE_CREATED = "note_created";
    private static final String NOTE_UPDATED = "note_updated";
    private static final String IMAGE_PATH = "image_path";
    private static final String BACKGROUND_COLOR = "background_color";
    private static final String FOLDER_NAME = "folder_name";
    private static final String FOLDER_CREATED = "folder_created";

    public static final String CREATE_TABLE_FOLDER =
            "CREATE TABLE " + TABLE_FOLDER + "("
                    + FOLDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + FOLDER_NAME + " TEXT ,"
                    + FOLDER_CREATED + " DATETIME DEFAULT CURRENT_TIMESTAMP "
                    + ")";

    public static final String CREATE_TABLE_NOTE =
            "CREATE TABLE " + TABLE_NOTE + "("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + FOLDER_ID + " INTEGER ,"
                    + TITLE + " TEXT ,"
                    + CONTENT + " TEXT ,"
                    + NOTE_CREATED + " LONG ,"
                    + NOTE_UPDATED + " LONG ,"
                    + IMAGE_PATH + " TEXT ,"
                    + BACKGROUND_COLOR + " TEXT "
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        sharePreferenceUtils = new SharePreferenceUtils(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FOLDER);
        db.execSQL(CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOLDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

    public boolean addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, note.getId());
        values.put(FOLDER_ID, note.getFolderId());
        values.put(TITLE, note.getTitle());
        values.put(CONTENT, note.getContent());
        values.put(NOTE_CREATED, note.getNoteCreated());
        values.put(NOTE_UPDATED, note.getNoteUpdated());
        values.put(IMAGE_PATH, note.getImagePath());
        values.put(BACKGROUND_COLOR, note.getBackgroundColor());
        long rowInserted = db.insert(TABLE_NOTE, null, values);
        db.close();
        if (rowInserted != -1)
            return true;
        else
            return false;
    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        String selectQuery;
        int sortType = sharePreferenceUtils.getIntData(Const.KEY_SHARE_SORT_TYPE);
        if (sortType == Const.SORT_BY_CREATED)
            selectQuery = "SELECT  * FROM " + TABLE_NOTE + " ORDER BY " + NOTE_CREATED + " DESC";
        else
            selectQuery = "SELECT  * FROM " + TABLE_NOTE + " ORDER BY " + NOTE_UPDATED + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(ID)));
                note.setFolderId(cursor.getInt(cursor.getColumnIndex(FOLDER_ID)));
                note.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                note.setContent(cursor.getString(cursor.getColumnIndex(CONTENT)));
                note.setNoteCreated(cursor.getLong(cursor.getColumnIndex(NOTE_CREATED)));
                note.setNoteUpdated(cursor.getLong(cursor.getColumnIndex(NOTE_UPDATED)));
                note.setImagePath(cursor.getString(cursor.getColumnIndex(IMAGE_PATH)));
                note.setBackgroundColor(cursor.getString(cursor.getColumnIndex(BACKGROUND_COLOR)));
                notes.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return notes;
    }

    public ArrayList<Note> getNotesByFolderId(int folderId) {
        ArrayList<Note> notes = new ArrayList<>();
        String selectQuery;
        int sortType = sharePreferenceUtils.getIntData(Const.KEY_SHARE_SORT_TYPE);
        if (sortType == Const.SORT_BY_CREATED)
            selectQuery = "SELECT  * FROM " + TABLE_NOTE + "WHER " + FOLDER_ID + "=" + folderId + " ORDER BY " + NOTE_CREATED + " DESC";
        else
            selectQuery = "SELECT  * FROM " + TABLE_NOTE + "WHER " + FOLDER_ID + "=" + folderId + " ORDER BY " + NOTE_UPDATED + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(ID)));
                note.setFolderId(cursor.getInt(cursor.getColumnIndex(FOLDER_ID)));
                note.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                note.setContent(cursor.getString(cursor.getColumnIndex(CONTENT)));
                note.setNoteCreated(cursor.getLong(cursor.getColumnIndex(NOTE_CREATED)));
                note.setNoteUpdated(cursor.getLong(cursor.getColumnIndex(NOTE_UPDATED)));
                note.setImagePath(cursor.getString(cursor.getColumnIndex(IMAGE_PATH)));
                note.setBackgroundColor(cursor.getString(cursor.getColumnIndex(BACKGROUND_COLOR)));
                notes.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return notes;
    }


}

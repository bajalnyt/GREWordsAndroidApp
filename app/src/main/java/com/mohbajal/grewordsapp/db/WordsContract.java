package com.mohbajal.grewordsapp.db;

import android.provider.BaseColumns;

public class WordsContract {

    private WordsContract() {
    }

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "gre_words";
        public static final String COLUMN_NAME_WORD = "word";
        public static final String COLUMN_NAME_MEANING = "meaning";
        public static final String COLUMN_NAME_SENTENCE = "sentence";

    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_WORD + " TEXT," +
                    FeedEntry.COLUMN_NAME_MEANING + " TEXT," +
                    FeedEntry.COLUMN_NAME_SENTENCE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

}

package mr.rad.kg.kyrgyzstan.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mr.rad.kg.kyrgyzstan.data.RegionContract.RegionEntry;
import mr.rad.kg.kyrgyzstan.data.RegionDetailsContract.RegionDetailsEntry;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "kgstan_db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REGION_TABLE = "CREATE TABLE " + RegionEntry.TABLE_NAME + " ("
                + RegionEntry.COLUMN_ID +" int NOT NULL,"
                + RegionEntry.COLUMN_IMAGE + " TEXT NULL,"
                + RegionEntry.COLUMN_TITLE + " TEXT NULL)";

        db.execSQL(CREATE_REGION_TABLE);

        String CREATE_REGION_DETAILS_TABLE = "CREATE TABLE " + RegionDetailsEntry.TABLE_NAME + " ("
                + RegionDetailsEntry.COLUMN_ID + " int NOT NULL,"
                + RegionDetailsEntry.COLUMN_DESCRIPTION + " TEXT NULL,"
                + RegionDetailsEntry.COLUMN_REGIONID + " TEXT NULL," +
                "PRIMARY KEY (`_id`),\n" +
                "  INDEX `fk_region_details_region_idx` (`region_id` ASC),\n" +
                "  CONSTRAINT `fk_region_details_region`\n" +
                "    FOREIGN KEY (`region_id`)\n" +
                "    REFERENCES `mydb`.`region` (`_id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n)";

        db.execSQL(CREATE_REGION_DETAILS_TABLE);

        String query = "INSERT INTO region (_id, image, title) VALUES (0,'chui','Чуйская область'),"
                +"(1,'talas','Таласская область'),"
                +"(2,'naryn','Нарынская область'),"
                +"(3,'djal','Джалал-Абадская область'),"
                +"(4,'osh','Ошская область'),"
                +"(5,'batken','Баткенская область'),"
                +"(6,'ik','Иссык_кульская область')";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

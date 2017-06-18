package mr.rad.kg.kyrgyzstan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mr.rad.kg.kyrgyzstan.data.DBHelper;
import mr.rad.kg.kyrgyzstan.data.RegionDetailsContract;

public class OblastDetails extends AppCompatActivity {

    int regionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oblast_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String title = intent.getStringExtra("OBLAST_NAME");
        regionId = Integer.parseInt(intent.getStringExtra("OBLAST_ID"));
        setTitle(title);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM region_details WHERE region_id = "+regionId;
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        String desc = cursor.getString(
                cursor.getColumnIndexOrThrow(
                        RegionDetailsContract.RegionDetailsEntry.COLUMN_DESCRIPTION
                )
        );

        TextView text = (TextView) findViewById(R.id.regionText);
        text.setText(desc);

        String imageName = cursor.getString(
                cursor.getColumnIndexOrThrow(RegionDetailsContract.RegionDetailsEntry.COLUMN_IMAGE)
        );
        ImageView img = (ImageView) findViewById(R.id.regionImage);
        int resId = getResources().getIdentifier("ic_" + imageName, "drawable", this.getPackageName());
        img.setImageResource(resId);

        cursor.close();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

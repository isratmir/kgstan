package mr.rad.kg.kyrgyzstan;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import mr.rad.kg.kyrgyzstan.data.DBHelper;
import mr.rad.kg.kyrgyzstan.data.RegionContract.RegionEntry;


/**
 * A simple {@link Fragment} subclass.
 */
public class OblastFragment extends Fragment implements AdapterView.OnItemClickListener{

    View rootView;
    Cursor cursor;

    public OblastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_oblast, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DBHelper dbHelper = new DBHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM region", null);

        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        OblastAdapter adapter = new OblastAdapter(getContext(), cursor);
        lv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
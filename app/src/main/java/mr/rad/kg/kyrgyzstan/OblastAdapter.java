package mr.rad.kg.kyrgyzstan;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rad on 6/10/17.
 */

public class OblastAdapter extends CursorAdapter {
    public OblastAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.oblast_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);

        String imageName = cursor.getString(cursor.getColumnIndexOrThrow("image"));
        String titleName = cursor.getString(cursor.getColumnIndexOrThrow("title"));

        int resId = context.getResources().getIdentifier("ic_" + imageName, "drawable", context.getPackageName());

        image.setImageResource(resId);
        title.setText(titleName);
    }
}

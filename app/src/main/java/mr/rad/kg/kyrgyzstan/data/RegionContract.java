package mr.rad.kg.kyrgyzstan.data;

import android.provider.BaseColumns;

/**
 * Created by rad on 6/10/17.
 */

public final class RegionContract {

    private RegionContract() {}

    public static class RegionEntry implements BaseColumns{
        public static final String TABLE_NAME = "region";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_TITLE = "title";
    }
}

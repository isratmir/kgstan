package mr.rad.kg.kyrgyzstan.data;

import android.provider.BaseColumns;

/**
 * Created by rad on 6/14/17.
 */

public class RegionDetailsContract {

    private RegionDetailsContract(){}

    public static class RegionDetailsEntry implements BaseColumns{
        public static final String TABLE_NAME = "region_details";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_REGIONID = "region_id";
    }
}

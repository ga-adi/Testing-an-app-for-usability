package generalassembly.yuliyakaleda.usabilitytestingstartercode;

/**
 * Created by Ra on 2/19/16.
 */
public class Zodiac {
    private String mName;
    private String mBirthdayRange;

    public Zodiac(String zodiacName, String birthday){
        mName = zodiacName;
        mBirthdayRange = birthday;
    }

    public String getmName() {
        return mName;
    }

    public String getmBirthdayRange() {
        return mBirthdayRange;
    }
}

package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ra on 2/19/16.
 */
public class ZodiacArrayAdapter extends ArrayAdapter<Zodiac> {
    private ArrayList<Zodiac> zodiacList;
    private Context context;

    public ZodiacArrayAdapter(Context context, ArrayList<Zodiac> zodiacArrayList) {
        super(context, -1);
        zodiacList = zodiacArrayList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View zodiacLayout = layoutInflater.inflate(R.layout.zodiac_list_layout, parent, false);

        ImageView zodiacImage = (ImageView) zodiacLayout.findViewById(R.id.zodiac_image);
        TextView zodiacName = (TextView) zodiacLayout.findViewById(R.id.zodiac_name);
        TextView zodiacBirthday = (TextView) zodiacLayout.findViewById(R.id.birthday_range);

        String name = zodiacList.get(position).getmName();
        String birthday = zodiacList.get(position).getmBirthdayRange();



        switch (name) {
            case "aries":
                zodiacImage.setImageResource(R.drawable.aries);
                break;
            case "taurus":
                zodiacImage.setImageResource(R.drawable.taurus);
                break;
            case "gemini":
                zodiacImage.setImageResource(R.drawable.gemini);
                break;
            case "cancer":
                zodiacImage.setImageResource(R.drawable.cancer);
                break;
            case "leo":
                zodiacImage.setImageResource(R.drawable.leo);
                break;
            case "virgo":
                zodiacImage.setImageResource(R.drawable.virgo);
                break;
            case "libra":
                zodiacImage.setImageResource(R.drawable.libra);
                break;
            case "scorpio":
                zodiacImage.setImageResource(R.drawable.scorpio);
                break;
            case "sagittarius":
                zodiacImage.setImageResource(R.drawable.sagittarius);
                break;
            case "capricorn":
                zodiacImage.setImageResource(R.drawable.capricorn);
                break;
            case "aquarius":
                zodiacImage.setImageResource(R.drawable.aquarius);
                break;
            case "pisces":
                zodiacImage.setImageResource(R.drawable.pisces);
                break;
        }

        name = name.substring(0,1).toUpperCase() + name.substring(1);

        zodiacName.setText(name);
        zodiacBirthday.setText(birthday);
        return zodiacLayout;
    }

    @Override
    public int getCount() {
        return zodiacList.size();
    }
}
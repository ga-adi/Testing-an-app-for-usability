package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class DetailsFragment extends Fragment {

    private WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainActivity mainActivity = (MainActivity) getActivity();
        String url = "http://www.horoscopedates.com/zodiac-signs/" + mainActivity.getUrl() + "/";
        View view = inflater.inflate(R.layout.details_activity_layout, container, false);
        Log.i("URL", url);
        updateContent(view, url);
        return view;
    }

    public void updateContent(View view, String sign) {
        // TODO: Finish the method which will open a webview and redirect the user to the website
        // TODO: to read about the sign that was clicked in the ListView
        ((WebView) view.findViewById(R.id.webview)).loadUrl(sign);
    }
}

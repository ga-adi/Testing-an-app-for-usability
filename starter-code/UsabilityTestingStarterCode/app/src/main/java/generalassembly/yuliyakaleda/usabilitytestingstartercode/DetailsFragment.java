package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class DetailsFragment extends Fragment{
  WebView mWebView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.details_fragment_layout, container, false);
    mWebView = (WebView) view.findViewById(R.id.fragment_web_view);
    String[] values = getResources().getStringArray(R.array.signs);
    if (values.length > 0) {
      updateContent(values[0]);
    }
    return view;
  }

  public void updateContent(String sign) {
    mWebView.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
  }
}

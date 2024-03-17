package com.akashdipmahapatra.freecad;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private Context mContext;

    public MyWebViewClient(Context context) {
        mContext = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();

        // Check if the URL is a social media link
        if (isSocialMediaUrl(url)) {
            // Open the URL in the browser
            view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            return true; // Prevent the WebView from loading the URL
        }

        // Load the URL in the WebView
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if (!isNetworkAvailable()) {
            view.loadUrl("file:///android_asset/offline.html");
        }
    }

    private boolean isSocialMediaUrl(String url) {
        return url.startsWith("https://www.youtube.com/") ||
                url.startsWith("https://youtube.be") ||
                url.startsWith("https://m.youtube.com/") ||
                url.startsWith("https://youtube.com/") ||
                url.startsWith("https://www.youtube.com/channel/") ||
                url.startsWith("https://docs.google.com/forms/") ||
                url.startsWith("https://www.facebook.com/") ||
                url.startsWith("https://www.instagram.com/") ||
                url.startsWith("https://www.linkedin.com/") ||
                url.startsWith("https://linktr.ee/AkashdipMahapatra") ||
                url.startsWith("https://drive.google.com/") ||
                url.startsWith("https://rzp.io/") ||
                url.startsWith("http://freecadapp2.000.pe/signup.html") ||
                url.startsWith("http://freecadapp2.000.pe/signup.php") ||
                url.startsWith("https://wa.me/") ||
                url.startsWith("https://chat.whatsapp.com/")||
                url.startsWith("http://freecadapp2.000.pe/Contact/Contact-form-to-email.html") ||
                url.startsWith("http://freecadapp2.000.pe/login_firebase/after_login/contact/Contact-form-to-email.html") ||
                url.startsWith("https://abc2001.netlify.app/") ||
                url.startsWith("https://website-2-github.netlify.app") ||
                url.startsWith("https://akashdip2001.github.io/linktree/") ||
                url.startsWith("https://akashdip2001.github.io/website-2/") ||
                url.startsWith("http://bit.ly/xyz2001") ||
                url.startsWith("http://bit.ly/abc2001")||
                url.startsWith("https://github.com/")||
                url.startsWith("http://example");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Network network = connectivityManager.getActiveNetwork();
                if (network != null) {
                    NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
                    return capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
                }
            } else {
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
        }
        return false;
    }
}
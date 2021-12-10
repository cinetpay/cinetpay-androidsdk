package com.cinetpay.androidsdk;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CinetPayActivity extends AppCompatActivity {

    public static final String KEY_API_KEY = "api_key";
    public static final String KEY_SITE_ID = "site_id";
    public static final String KEY_TRANSACTION_ID = "transaction_id";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_CURRENCY = "currency";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CHANNELS = "channels";
    public static final String KEY_LANG = "lang";
    public static final String KEY_METADATA = "metadata";
    public static final String KEY_ALTERNATIVE_CURRENCY = "alternative_currency";
    public static final String KEY_CUSTOMER_ID = "customer_id";
    public static final String KEY_CUSTOMER_NAME = "customer_name";
    public static final String KEY_CUSTOMER_SURNAME = "customer_surname";
    public static final String KEY_CUSTOMER_EMAIL = "customer_email";
    public static final String KEY_CUSTOMER_ADDRESS = "customer_address";
    public static final String KEY_CUSTOMER_PHONE_NUMBER = "customer_phone_number";
    public static final String KEY_CUSTOMER_CITY = "customer_city";
    public static final String KEY_CUSTOMER_COUNTRY = "customer_country";
    public static final String KEY_CUSTOMER_STATE = "customer_state";
    public static final String KEY_CUSTOMER_ZIP_CODE = "customer_zip_code";
    public static final String KEY_NOTIFY_URL = "notify_url";

    protected WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cinetpay);

        mWebView = findViewById(R.id.webview);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        CookieManager cookieManager = CookieManager.getInstance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(mWebView,true);
        } else {
            cookieManager.setAcceptCookie(true);
        }

        mWebView.loadUrl("file:///android_asset/cinetpay.html");
    }

}
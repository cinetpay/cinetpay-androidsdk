package com.cinetpay.androidsdk;

import android.content.Context;
import android.webkit.JavascriptInterface;

public abstract class CinetPayWebAppInterface {

    private final Context context;
    private final String api_key;
    private final String site_id;
    private final String transaction_id;
    private final int amount;
    private final String currency;
    private final String description;
    private String channels;
    private String lang;
    private String metadata;
    private String alternative_currency;
    private String customer_id;
    private String customer_name;
    private String customer_surname;
    private String customer_email;
    private String customer_address;
    private String customer_phone_number;
    private String customer_city;
    private String customer_country;
    private String customer_state;
    private String customer_zip_code;
    private String notify_url;


    public CinetPayWebAppInterface(Context context,
                                   String api_key,
                                   String site_id,
                                   String transaction_id,
                                   int amount,
                                   String currency,
                                   String description) {
        this.context = context;
        this.api_key = api_key;
        this.site_id = site_id;
        this.transaction_id = transaction_id;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public CinetPayWebAppInterface setChannels(String channels) {
        this.channels = channels;
        return this;
    }

    public CinetPayWebAppInterface setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public CinetPayWebAppInterface setMetadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public CinetPayWebAppInterface setAlternativeCurrency(String alternative_currency) {
        this.alternative_currency = alternative_currency;
        return this;
    }

    public CinetPayWebAppInterface setCustomerId(String id) {
        this.customer_id = id;
        return this;
    }

    public CinetPayWebAppInterface setCustomerName(String name) {
        this.customer_name = name;
        return this;
    }

    public CinetPayWebAppInterface setCustomerSurname(String surname) {
        this.customer_surname = surname;
        return this;
    }

    public CinetPayWebAppInterface setCustomerEmail(String email) {
        this.customer_email = email;
        return this;
    }

    public CinetPayWebAppInterface setCustomerAddress(String address) {
        this.customer_address = address;
        return this;
    }

    public CinetPayWebAppInterface setCustomerPhoneNumber(String phone_number) {
        this.customer_phone_number = phone_number;
        return this;
    }

    public CinetPayWebAppInterface setCustomerCity(String city) {
        this.customer_city = city;
        return this;
    }

    public CinetPayWebAppInterface setCustomerCountry(String country) {
        this.customer_country = country;
        return this;
    }

    public CinetPayWebAppInterface setCustomerState(String state) {
        this.customer_state = state;
        return this;
    }

    public CinetPayWebAppInterface setCustomerZipCode(String zip_code) {
        this.customer_zip_code = zip_code;
        return this;
    }

    public CinetPayWebAppInterface setNotifyUrl(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public final Context getContext() {
        return context;
    }

    @JavascriptInterface
    public final String getApiKey() {
        return api_key;
    }

    @JavascriptInterface
    public final String getSiteId() {
        return site_id;
    }

    @JavascriptInterface
    public final String getTransactionId() {
        return transaction_id;
    }

    @JavascriptInterface
    public final int getAmount() {
        return amount;
    }

    @JavascriptInterface
    public final String getCurrency() {
        return currency;
    }

    @JavascriptInterface
    public final String getDescription() {
        return description;
    }

    @JavascriptInterface
    public final String getChannels() {
        return channels;
    }

    @JavascriptInterface
    public final String getLang() {
        return lang;
    }

    @JavascriptInterface
    public final String getMetadata() {
        return metadata;
    }

    @JavascriptInterface
    public final String getAlternativeCurrency() {
        return alternative_currency;
    }

    @JavascriptInterface
    public final String getCustomerId() {
        return customer_id;
    }

    @JavascriptInterface
    public final String getCustomerName() {
        return customer_name;
    }

    @JavascriptInterface
    public final String getCustomerSurname() {
        return customer_surname;
    }

    @JavascriptInterface
    public final String getCustomerEmail() {
        return customer_email;
    }

    @JavascriptInterface
    public final String getCustomerAddress() {
        return customer_address;
    }

    @JavascriptInterface
    public final String getCustomerPhoneNumber() {
        return customer_phone_number;
    }

    @JavascriptInterface
    public final String getCustomerCity() {
        return customer_city;
    }

    @JavascriptInterface
    public final String getCustomerCountry() {
        return customer_country;
    }

    @JavascriptInterface
    public final String getCustomerState() {
        return customer_state;
    }

    @JavascriptInterface
    public final String getCustomerZipCode() {
        return customer_zip_code;
    }

    @JavascriptInterface
    public final String getNotifyUrl() {
        return notify_url;
    }

    public abstract void onResponse(String data);

    public abstract void onError(String data);

}

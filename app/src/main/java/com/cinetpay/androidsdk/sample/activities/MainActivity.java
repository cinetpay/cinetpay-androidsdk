package com.cinetpay.androidsdk.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.cinetpay.androidsdk.CinetPayActivity;
import com.cinetpay.androidsdk.sample.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText mAmountView;
    private Button mPayView;
    private AutoCompleteTextView mCurrencyView;
    private View mCardView;
    private TextInputEditText mNameView;
    private TextInputEditText mSurnameView;
    private TextInputEditText mEmailView;
    private TextInputEditText mAddressView;
    private TextInputEditText mPhoneView;
    private TextInputEditText mCityView;
    private TextInputEditText mZipCodeView;

    private String mCurrency;

    private List<String> mChannels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAmountView = findViewById(R.id.amount);
        mPayView = findViewById(R.id.pay);
        mCurrencyView = findViewById(R.id.currency);
        mCardView = findViewById(R.id.card);
        mNameView = findViewById(R.id.name);
        mSurnameView = findViewById(R.id.surname);
        mEmailView = findViewById(R.id.email);
        mAddressView = findViewById(R.id.address);
        mPhoneView = findViewById(R.id.phone);
        mCityView = findViewById(R.id.city);
        mZipCodeView = findViewById(R.id.zip_code);

        mCurrency = "";

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency, R.layout.currency_item);

        mCurrencyView.setAdapter(adapter);

        mCurrencyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrency = String.valueOf(adapter.getItem(position));
            }
        });

        mPayView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String amount = mAmountView.getText().toString().replace(" ", "");

                String name = "";
                String surname = "";
                String email = "";
                String address = "";
                String phone = "";
                String city = "";
                String country = "CI"; // TODO
                String state = ""; // TODO
                String zip_code = "";

                if (amount.isEmpty() || mCurrency.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez saisir un montant et sélectionner la devise",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mChannels.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez sélectionner la méthode de paiement",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mChannels.contains("CREDIT_CARD")) {
                    name = mNameView.getText().toString();
                    if (name.isEmpty()) {
                        mNameView.setError(getString(R.string.required_field));
                        return;
                    }
                    surname = mSurnameView.getText().toString();
                    if (surname.isEmpty()) {
                        mSurnameView.setError(getString(R.string.required_field));
                        return;
                    }
                    email = mEmailView.getText().toString();
                    if (email.isEmpty()) {
                        mEmailView.setError(getString(R.string.required_field));
                        return;
                    }
                    address = mAddressView.getText().toString();
                    if (address.isEmpty()) {
                        mAddressView.setError(getString(R.string.required_field));
                        return;
                    }
                    phone = mPhoneView.getText().toString();
                    if (phone.isEmpty()) {
                        mPhoneView.setError(getString(R.string.required_field));
                        return;
                    }
                    city = mCityView.getText().toString();
                    if (city.isEmpty()) {
                        mCityView.setError(getString(R.string.required_field));
                        return;
                    }
                    zip_code = mZipCodeView.getText().toString();
                    if (zip_code.isEmpty()) {
                        mZipCodeView.setError(getString(R.string.required_field));
                        return;
                    }
                }

                String api_key = "XXXXXXXXX.XXXXXXX"; // TODO A remplacer par votre clé API
                String site_id = "XXXXXX"; // TODO A remplacer par votre Site ID

                String transaction_id = String.valueOf(new Date().getTime());
                String description = "Achat test";

                StringBuilder sb = new StringBuilder();

                int i = 0;

                for (String channel : mChannels) {
                    sb.append(channel);
                    if (i < mChannels.size() - 1) {
                        sb.append(',');
                    }
                    i++;
                }

                String channels = sb.toString();

                Intent intent = new Intent(MainActivity.this, MyCinetPayActivity.class);

                intent.putExtra(CinetPayActivity.KEY_API_KEY, api_key);
                intent.putExtra(CinetPayActivity.KEY_SITE_ID, site_id);
                intent.putExtra(CinetPayActivity.KEY_TRANSACTION_ID, transaction_id);
                intent.putExtra(CinetPayActivity.KEY_AMOUNT, Integer.valueOf(amount));
                intent.putExtra(CinetPayActivity.KEY_CURRENCY, mCurrency);
                intent.putExtra(CinetPayActivity.KEY_DESCRIPTION, description);
                intent.putExtra(CinetPayActivity.KEY_CHANNELS, channels);

                if (mChannels.contains("CREDIT_CARD")) {
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_NAME, name);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_SURNAME, surname);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_EMAIL, email);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_ADDRESS, address);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_PHONE_NUMBER, phone);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_CITY, city);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_COUNTRY, country);
                    intent.putExtra(CinetPayActivity.KEY_CUSTOMER_ZIP_CODE, zip_code);
                }

                startActivity(intent);

            }
        });

    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_mobile_money:
                if (checked) {
                    mChannels.add("MOBILE_MONEY");
                } else {
                    mChannels.remove("MOBILE_MONEY");
                }
                break;
            case R.id.checkbox_wallet:
                if (checked) {
                    mChannels.add("WALLET");
                } else {
                    mChannels.remove("WALLET");
                }
                break;
            case R.id.checkbox_card:
                if (checked) {
                    mChannels.add("CREDIT_CARD");
                    mCardView.setVisibility(View.VISIBLE);
                } else {
                    mChannels.remove("CREDIT_CARD");
                    mCardView.setVisibility(View.GONE);
                }
                break;
        }
    }
}

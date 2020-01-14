package org.miage.placesearcher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexmorel on 04/01/2018.
 */

public class PlaceDetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_address)
    TextView mDetailAddress;

    @BindView(R.id.goToMap)
    Button bGoToMap;
    @BindView(R.id.shareAddress)
    Button bShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_detail_activity);

        // Binding ButterKnife annotations now that content view has been set
        ButterKnife.bind(this);
        final String streetValue = getIntent().getStringExtra("street");
        final String cityValue = getIntent().getStringExtra("city");
        mDetailAddress.setText(streetValue);
        bGoToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("https://www.google.com/maps/place/"+cityValue);
                Intent launchBrowser = new Intent (Intent.ACTION_VIEW, url);
                startActivity(launchBrowser);
            }
        });
        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent sendIntent = new Intent();
               sendIntent.setAction(Intent.ACTION_SEND);
               sendIntent.putExtra(Intent.EXTRA_TEXT,streetValue);
               sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        // Do NOT forget to call super.onResume()
        super.onResume();

    }
}

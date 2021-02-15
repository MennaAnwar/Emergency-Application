package com.example.emergencyapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView emergency;
    private String[] text ={"POILCE" , "AMBULANCE" };
    private  int[] pictures = {R.drawable.police , R.drawable.ambulance};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        emergency = findViewById(R.id.emergency);

        setTitle("Emergency");


        CustomAdapter adapter = new CustomAdapter(this, text, pictures);

        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(Intent.ACTION_CALL);

                    if (index == 0) {
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:122")));
                    } else if (index == 1) {
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:123")));
                    }
                    startActivityForResult(i, 101);


                } else {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
    }
}

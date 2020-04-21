package com.example.avramescu.androidfundamentals.week7;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

public class PermisionsActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST_CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisions);

        checkCameraPermission();
    }

    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Cere userului permisiunea", Toast.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSION_REQUEST_CAMERA);
        } else {
            Toast.makeText(this, "Userul a acordat permisiunea anterior", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Userul a acordat permisiunea", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Userul NU a acordat permisiunea", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    }
}

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class SingletonSetData extends AppCompatActivity
{
    private EditText save_et;
    private Button save_btn;
    private VideoView videoView;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 123;
    private String videoPath;
    private LinearLayout bottomSheet;
    private BottomSheetBehavior sheetBehavior;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_set_data);

        Toolbar toolbar = findViewById(R.id.singletonToolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Singleton Set Data");


        save_et = findViewById(R.id.save_et);
        save_btn = findViewById(R.id.save_btn);
        videoView = findViewById(R.id.video_view);
        bottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottomSheet);




        save_btn.setOnClickListener(view ->
        {
            Intent intent = new Intent();

            intent.setType("video/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Video"),REQUEST_TAKE_GALLERY_VIDEO);

            String text = save_et.getText().toString();
            if (text.equals(""))
                Toast.makeText(this, "Empty Edit Text", Toast.LENGTH_SHORT).show();
            else
                {
                CustomApplication.getInstance().setUsername(text);
                startActivity(new Intent(this,SingletonGetData.class));
                this.finish();
            }
        });
        MediaController m = new MediaController(this);

        videoView.setMediaController(m);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i)
            {


            }

            @Override
            public void onSlide(@NonNull View view, float v)
            {

            }
        });

    }
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {

            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            if (requestCode == REQUEST_TAKE_GALLERY_VIDEO)
            {
                Uri selectedImageUri = data.getData();
                Log.i("yaar",selectedImageUri.getPath()+"");

                videoPath = getPath(selectedImageUri);

                videoView.setVideoURI(selectedImageUri);
                videoView.requestFocus();
                videoView.start();
                Log.i("yaar2",getPath(selectedImageUri)+"");

            }
        }
    }

}

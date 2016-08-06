package com.facci.camaravd;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivityVD extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    ImageView img, img2, img3;
    Intent intent;
    final static int cons = 0;
    Bitmap bmp, bmp2, bmp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_vd);

        Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camara, 1);
        init();

    }

    private void init() {
        btn = (Button)findViewById(R.id.btncaptura);
        btn.setOnClickListener(this);

        img = (ImageView)findViewById(R.id.pantalla);
        img2 = (ImageView)findViewById(R.id.pantalla1);
        img3 = (ImageView)findViewById(R.id.pantalla2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_vd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id;
        id = v.getId();

        switch (id){
            case R.id.btncaptura:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, cons);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {


            if(bmp== null)
            {
                Bundle ext = data.getExtras();
                bmp = (Bitmap) ext.get("data");
                img.setImageBitmap(bmp);
            }
            else
            {
                Bundle ext = data.getExtras();
                bmp2 = (Bitmap) ext.get("data");
                img2.setImageBitmap(bmp2);
            }

        }
    }
}

package com.example.pizza.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizza.R;


public class PickItemView extends AppCompatActivity {

    ImageView imageView;
    ImageButton back,minus,plus;
    TextView name,money,infor;
    EditText numbereach;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_item);
        initview();
        //handle button back
        back.setOnClickListener(handleback);

        //handle import data

    }
    public void initview(){
        imageView = findViewById(R.id.pickitem);
        back = findViewById(R.id.btback);
        minus = findViewById(R.id.btminus);
        plus = findViewById(R.id.btplus);
        name = findViewById(R.id.txnamepizza);
        money =  findViewById(R.id.txprice);
        infor = findViewById(R.id.txinfor);
        numbereach = findViewById(R.id.eachpizza);
    }
    View.OnClickListener handleback = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
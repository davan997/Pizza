package com.example.pizza.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizza.Model.Item;
import com.example.pizza.R;


public class PickItemView extends AppCompatActivity {

    ImageView imageView;
    ImageButton back,minus,plus;
    TextView name,money,infor,numbereach;
    int numbercurrent = 0;
    int numbermax = 99;
    int numbermin = 0;
    Bundle data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_item);
        initview();
        //handle button back
        back.setOnClickListener(handleback);


        //handle button minus and plus
        minus.setOnClickListener(handleminus);
        plus.setOnClickListener(handdleplus);

        //handle import data
        data = getIntent().getExtras();
        if (data != null){
            name.setText(data.getString("name"));
            imageView.setImageResource(data.getInt("image"));
            infor.setText(data.getString("infor"));
            money.setText(data.getString("price"));
        } else {
            return;
        }
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

    View.OnClickListener handleminus = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (numbercurrent <= numbermin) {
                numbercurrent = numbermin;
            } else {
                numbercurrent = numbercurrent - 1;
            }
            numbereach.setText(""+numbercurrent);
        }
    };

    View.OnClickListener handdleplus = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (numbercurrent >= numbermax) {
                numbercurrent = numbermax;
            } else {
                numbercurrent = numbercurrent + 1;
            }
            numbereach.setText("" + numbercurrent);
        }
    };
}
package com.example.explicitintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;

    final int ACTIVITY3_CONST = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);

        btnAct2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String firstName = etName.getText().toString().trim();

                    Intent intent_toActivity2 = new Intent(MainActivity.this, com.example.explicitintents.Activity2.class);
                    intent_toActivity2.putExtra("First name of the person", firstName);
                    startActivity(intent_toActivity2);

                }

            }
        });


        btnAct3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_toActivity3 = new Intent(MainActivity.this, com.example.explicitintents.Activity3.class);
                startActivityForResult(intent_toActivity3, ACTIVITY3_CONST);
//                Here we need ACTIVITY3_CONST b/c, if there are multiple activities returning, we need to identify them.


            }
        });

    }// End of onCreate method




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == ACTIVITY3_CONST )
        {
            if ( resultCode == RESULT_OK )
            {
                tvResults.setText( data.getStringExtra( "Surname of the person" ) );
            }

            if ( resultCode == RESULT_CANCELED )
            {
                tvResults.setText( "No data recived!" );
            }
        }




    }




}// End of class MainActivity

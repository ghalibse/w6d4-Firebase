package com.example.simplefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private static final String MY_FIREBAE_URL = "https://libufirebase.firebaseio.com/";
    private TextView mTextView;
    private EditText mEditText;
    private Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.main_txt_view);
        mEditText = (EditText) findViewById(R.id.main_edit_txt);

        //Firebase.setAndroidContext(this); is in appication class MyApp.java class
        ref = new Firebase(MY_FIREBAE_URL);
    }

    public void doWrite(View view) {

        String input = mEditText.getText().toString();

        ref.child("lasttName").setValue(input);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String str = (String) dataSnapshot.child("lasttName").getValue();

                mTextView.setText(str);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}

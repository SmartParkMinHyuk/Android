package com.example.kakaoincome;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SendActivity extends AppCompatActivity {

    EditText editTextNo;
    EditText editTextName;
    EditText editTextPhone;
    String TextNo;
    String TextName;
    String TextPhone;
    Button buttonSave;
    Button buttonClear;

    public static final String EEG_DB = "EEG_DB";
    public static final String EEG_TABLE = "EEG";
    public static SQLiteDatabase eegDB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        buttonSave= findViewById(R.id.buttonSave);
        buttonClear = findViewById(R.id.buttonClear);

        eegDB = this.openOrCreateDatabase(EEG_DB, MODE_PRIVATE,null);
        eegDB.execSQL("CREATE TABLE IF NOT EXISTS " + EEG_TABLE + "(id VARCHAR(50), name VARCHAR(50), phone VARCHAR(50));");
        // 만약 테이블이 없으면 만들어주세요.

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*                new AlertDialog.Builder(this)
                        .setTitle("회원정보 저장")
                        .setMessage("저장하시겠습까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // 확인시 로직 처리
                                Toast.makeText(SendActivity.this, "저장을 완료 했습니다.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 취소시 로직 처리
                                Toast.makeText(SendActivity.this, "취소하셨습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/
                    editTextNo = findViewById(R.id.editTextNo);
                    editTextName = findViewById(R.id.editTextName);
                    editTextPhone = findViewById(R.id.editTextPhone);

                    TextNo = editTextNo.getText().toString();
                    TextName = editTextName.getText().toString();
                    TextPhone = editTextPhone.getText().toString();

                    eegDB.execSQL("INSERT INTO EEG (id, name, phone) VALUES ('"+TextNo+"','"+TextName+"','"+TextPhone+"');");

                    editTextNo.getText().clear();
                    editTextName.getText().clear();
                    editTextPhone.getText().clear();

                Toast.makeText(SendActivity.this, "등록성공입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SendActivity.this, "값을 초기화합니다.", Toast.LENGTH_SHORT).show();

                editTextNo = findViewById(R.id.editTextNo);
                editTextName = findViewById(R.id.editTextName);
                editTextPhone = findViewById(R.id.editTextPhone);

                editTextNo.getText().clear();
                editTextName.getText().clear();
                editTextPhone.getText().clear();
            }
        });
    }
}
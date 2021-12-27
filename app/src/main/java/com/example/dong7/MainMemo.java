package com.example.dong7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainMemo extends AppCompatActivity {

    //버튼 객체
    private Button btn_Save;
    private Button btn_Load;
    private Button btn_Delete;
    //에디트 박스 객체
    private EditText editText_TextArea;
    //메모를 저장할 파일명 (파일 하나만 지원)
    private String fileName = "MyMemo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_memo);
        //버튼, 에디트박스 객체 가져오기
        btn_Save = findViewById(R.id.button_save);
        btn_Delete = findViewById(R.id.button_delete);
        editText_TextArea = findViewById(R.id.editText3);

        //버튼 객체에 클릭 리스너 함수 등록
        btn_Save.setOnClickListener(btnSaveListener);
        btn_Delete.setOnClickListener(btnDeleteListener);
        load();
    }
    //파일 로드 버튼 클릭처리
    public void load() {
        //Toast.makeText(getApplicationContext(), "로드 버튼 클릭 테스트", Toast.LENGTH_LONG).show();
        //파일 로드 시 이용할 파일 입력 스트림
        FileInputStream inputStream = null;

        try
        {
            inputStream = openFileInput(fileName);
            //바이트 단위로 스트림 데이터를 읽음
            byte[] data = new byte[inputStream.available()];
            while(inputStream.read(data) != -1) {}

            //현재 에디트 박스에 읽은 바이트 데이터를 세팅
            editText_TextArea.setText(new String(data));
            //화면 아래 간단한 알림 메시지 출력
            Toast.makeText(getApplicationContext(), "로드 성공", Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //파일 읽기 성공 여부 상관없이 반드시 스트림 닫기
                if(inputStream != null)
                    inputStream.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    //파일 저장 버튼 클릭처리
    View.OnClickListener btnSaveListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            //Toast.makeText(getApplicationContext(), "저장 버튼 클릭 테스트", Toast.LENGTH_LONG).show();
            //파일 저장 시 이용할 파일 출력 스트림
            FileOutputStream outputStream = null;

            try
            {
                outputStream = openFileOutput(fileName, MODE_PRIVATE);
                //에디트 박스에 저장된 스트링 데이터를 스트림에 기록함
                outputStream.write(editText_TextArea.getText().toString().getBytes());
                outputStream.close();

                Toast.makeText(getApplicationContext(), "저장 성공", Toast.LENGTH_LONG).show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    };

    //파일 삭제 버튼 클릭처리
    View.OnClickListener btnDeleteListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            //Toast.makeText(getApplicationContext(), "삭제 버튼 클릭 테스트", Toast.LENGTH_LONG).show();
            //해당 파일을 디스크 상에서 삭제, true 리턴 시 삭제 성공
            boolean bDel = deleteFile(fileName);
            if(bDel)
                Toast.makeText(getApplicationContext(), "메모 삭제 완료", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "메모 삭제 실패", Toast.LENGTH_LONG).show();
        }
    };



    }

package com.example.dong7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainCalculator extends AppCompatActivity {

    public EditText editText;
    public TextView text;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btnadd;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btnsub;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Button btnmul;
    public Button btndot;
    public Button btn0;
    public Button btnequal;
    public Button btndiv;
    public Button btnclear;

    String num;
    String num2;
    Double result;
    int symbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        editText = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btnadd = (Button) findViewById(R.id.btnAdd);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btnsub = (Button) findViewById(R.id.btnSub);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnmul = (Button) findViewById(R.id.btnMul);
        btndot = (Button) findViewById(R.id.btnDot);
        btn0 = (Button) findViewById(R.id.btn0);
        btnequal = (Button) findViewById(R.id.btnEqual);
        btndiv = (Button) findViewById(R.id.btnDiv);
        btnclear = (Button) findViewById(R.id.btnClear);


    }

    public void btn1Method(View view){
        editText.append("1");
    }
    public void btn2Method(View view){
        editText.append("2");
    }
    public void btn3Method(View view){
        editText.append("3");
    }
    public void btn4Method(View view){
        editText.append("4");
    }
    public void btn5Method(View view){
        editText.append("5");
    }
    public void btn6Method(View view){
        editText.append("6");
    }
    public void btn7Method(View view){
        editText.append("7");
    }
    public void btn8Method(View view){
        editText.append("8");
    }
    public void btn9Method(View view){
        editText.append("9");
    }
    public void btn0Method(View view){
        editText.append("0");
    }

    public void btnDotMethod(View view){
        editText.append(".");
    }

    public void btnPlusMethod(View view){
        num = editText.getText().toString();
        symbol = 0;
        editText.setText("");
    }
    public void btnSubMethod(View view){
        num = editText.getText().toString();
        symbol = 1;
        editText.setText("");
    }
    public void btnMulMethod(View view){
        num = editText.getText().toString();
        symbol = 2;
        editText.setText("");
    }
    public void btnDivMethod(View view){
        num = editText.getText().toString();
        symbol = 3;
        editText.setText("");
    }

    public void btnEqualMethod(View view){
        num2 = editText.getText().toString();
        double a = Double.valueOf(num);
        double b = Double.valueOf(num2);
        switch(symbol){
            case 0:
                result = a+b;
                text.setText("결과 : "+result);
                break;
            case 1:
                result = a-b;
                text.setText("결과 : "+result);
                break;
            case 2:
                result = a*b;
                text.setText("결과 : "+result);
                break;
            case 3:
                result = a/b;
                text.setText("결과 : "+result);
                break;
        }
    }

    public void btnClearMethod(View view){
        editText.setText("");
        text.setText("결과 : ");
        num = "";
        num2 = "";
        result = 0.0;
    }
}

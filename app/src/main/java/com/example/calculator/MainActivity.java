package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewHistory,textViewResult;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAc,btnDel,btnAdd,btnSub,btnMulti,btnDiv,btnEqual,btnDecimal;
    private String number=null;
    private double previousNumber =0;
    private int operator;
    private boolean equalClicked=false;
    DecimalFormat myFormat=new DecimalFormat("######.######");

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        btn0=findViewById(R.id.buttonZero);
        btn1=findViewById(R.id.buttonOne);
        btn2=findViewById(R.id.buttonTwo);
        btn3=findViewById(R.id.buttonThree);
        btn4=findViewById(R.id.buttonFour);
        btn5=findViewById(R.id.buttonFive);
        btn6=findViewById(R.id.buttonSix);
        btn7=findViewById(R.id.buttonSeven);
        btn8=findViewById(R.id.buttonEight);
        btn9=findViewById(R.id.buttonNine);

        btnAdd=findViewById(R.id.buttonAdd);
        btnSub=findViewById(R.id.buttonSub);
        btnMulti=findViewById(R.id.buttonMulti);
        btnDiv=findViewById(R.id.buttonDiv);

        btnAc=findViewById(R.id.buttonAc);
        btnDel=findViewById(R.id.buttonDel);
        btnEqual=findViewById(R.id.buttonEqual);
        btnDecimal=findViewById(R.id.buttonDecimal);


        TextViewCompat.setAutoSizeTextTypeWithDefaults(textViewResult,TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);



        btn0.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("0");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn1.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("1");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn2.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("2");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn3.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("3");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn4.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("4");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn5.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("5");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn6.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("6");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn7.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("7");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn8.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("8");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });
        btn9.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClickCheck();
            concatNumber("9");
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });

        btnDecimal.setOnClickListener(view -> {
            if(number.contains(".")){
                //should not take decimal if it is already typed in screen
            }
            else {
                setOperatorBtnClickable();
                equalClickCheck();
                concatNumber(".");
                textViewResult.setText(number);
            }
        });

        btnAdd.setOnClickListener(view -> {
            setOperatorBtnClickable();
            view.setSelected(true);
            btnAdd.setClickable(false);
            operator=1;
            transferNumber();
        });
        btnSub.setOnClickListener(view -> {
            setOperatorBtnClickable();
            view.setSelected(true);
            btnSub.setClickable(false);
            operator=2;
            transferNumber();
        });
        btnMulti.setOnClickListener(view -> {
            setOperatorBtnClickable();
            view.setSelected(true);
            btnMulti.setClickable(false);
            operator=3;
            transferNumber();
        });
        btnDiv.setOnClickListener(view -> {
            setOperatorBtnClickable();
            view.setSelected(true);
            btnDiv.setClickable(false);
            operator=4;
            transferNumber();
        });

        btnEqual.setOnClickListener(view -> {
            setOperatorBtnClickable();
            equalClicked=true;
            arithmetic();
            Log.i("Delete","number decimal:"+number);
        });

        btnAc.setOnClickListener(view -> {
            setOperatorBtnClickable();
            textViewResult.setText("0");
            number="0";
            previousNumber=0;
        });
        btnDel.setOnClickListener(view -> {
            setOperatorBtnClickable();
            delete();
            Log.i("Delete", "number decimal:" + myFormat.format(Double.parseDouble(number)));
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
        });

    }



    public void concatNumber(String newNum){
        if(number==null){
            number=newNum;
        }
        else{
            number=number+newNum;
        }
    }

    public void transferNumber(){
        try {
            if (number == null) {
                throw new NullPointerException("number is null");
            }
            previousNumber = Double.parseDouble(number);
            number = null;
        }
        catch (NullPointerException e){
            Log.i("transferNumber()",""+e.getMessage());
        }
    }

    public void arithmetic() {
        double numCopy;
        try {
            if (operator == 1) {
                numCopy = Double.parseDouble(number);
                numCopy = numCopy + previousNumber;
                number = Double.toString(numCopy);
                textViewResult.setText(myFormat.format(Double.parseDouble(number)));
            } else if (operator == 2) {
                numCopy = Double.parseDouble(number);
                numCopy = previousNumber - numCopy;
                number = Double.toString(numCopy);
                textViewResult.setText(myFormat.format(Double.parseDouble(number)));
            } else if (operator == 3) {
                numCopy = Double.parseDouble(number);
                numCopy = numCopy * previousNumber;
                number = Double.toString(numCopy);
                textViewResult.setText(myFormat.format(Double.parseDouble(number)));
            } else if (operator == 4) {
                numCopy = Double.parseDouble(number);
                if(numCopy==0){
                    throw new IllegalArgumentException("Divide by zero");
                }
                numCopy = previousNumber / numCopy;
                number = Double.toString(numCopy);
                textViewResult.setText(myFormat.format(Double.parseDouble(number)));
            }
        }
        catch (NullPointerException e){
            Toast.makeText(MainActivity.this,"Enter a valid number",Toast.LENGTH_LONG);
        }
        catch (IllegalArgumentException e){
            if(e.getMessage().equals("Divide by zero")){
                Toast.makeText(MainActivity.this,"Enter a valid number",Toast.LENGTH_LONG);
            }
        }
    }

    public void delete(){
        try {
            if(number==null){
                throw new NullPointerException("No number");
            }
            int length=myFormat.format(Double.parseDouble(number)).length();
            if (length <=1) {
                throw new NullPointerException("No number");
            }
            number = number.substring(0, length - 1);
        }
        catch (NullPointerException e){
            number="0";
            textViewResult.setText(myFormat.format(Double.parseDouble(number)));
            Log.i("delete()",""+e.getMessage());
        }
    }
    public void equalClickCheck(){
        if(equalClicked){
            number=null;
            equalClicked=false;
        }
    }

    public void setOperatorBtnClickable(){
            btnAdd.setClickable(true);
            btnAdd.setSelected(false);
            btnSub.setClickable(true);
            btnSub.setSelected(false);
            btnMulti.setClickable(true);
            btnMulti.setSelected(false);
            btnDiv.setClickable(true);
            btnDiv.setSelected(false);
    }


}
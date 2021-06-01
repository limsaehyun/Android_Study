package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_krw;
    Button btn_usd;
    Button btn_jpy;
    Button btn_eur;
    Button btn_cny;
    Button btn_gbp;
    Button btn_nation;
    TextView result;
    EditText et_num;
    double num1, num2;
    double num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num = (EditText)findViewById(R.id.et_num);
        result = (TextView)findViewById(R.id.result);

        btn_krw = (Button)findViewById(R.id.btn_krw);
        btn_krw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(et_num.getText().toString());
                if(TargetActivity.nation == 1) {
                    num = num1 * 1;
                }
                else if (TargetActivity.nation == 2) {
                    num = num1 * 1107.5;
                }
                else if (TargetActivity.nation == 3) {
                    num = num1 * 10.11;
                }
                else if (TargetActivity.nation == 4) {
                    num = num1 * 1353.75;
                }
                else if (TargetActivity.nation == 5) {
                    num = num1 * 173.72;
                }
                else if (TargetActivity.nation == 6) {
                    num = num1 * 1573.31;
                }


                result.setText(num + " KRW.");
            }
        });

        btn_usd = (Button)findViewById(R.id.btn_usd);
        btn_usd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Double.parseDouble(et_num.getText().toString());
                if(TargetActivity.nation == 1) {
                    num = num1 * 1107.5;
                }
                else if (TargetActivity.nation == 2) {
                    num = num1 * 1;
                }
                else if (TargetActivity.nation == 3) {
                    num = num1 * 109.59;
                }
                else if (TargetActivity.nation == 4) {
                    num = num1 * 0.82;
                }
                else if (TargetActivity.nation == 5) {
                    num = num1 * 6.38;
                }
                else if (TargetActivity.nation == 6) {
                    num = num1 * 0.70;
                }
                result.setText(num + " USD.");
            }
        });
        btn_jpy = (Button)findViewById(R.id.btn_jpy);
        btn_jpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Double.parseDouble(et_num.getText().toString());
                if(TargetActivity.nation == 1) {
                    num = num1 * 1107.5;
                }
                else if (TargetActivity.nation == 2) {
                    num = num1 * 1;
                }
                else if (TargetActivity.nation == 3) {
                    num = num1 * 109.59;
                }
                else if (TargetActivity.nation == 4) {
                    num = num1 * 0.82;
                }
                else if (TargetActivity.nation == 5) {
                    num = num1 * 6.38;
                }
                else if (TargetActivity.nation == 6) {
                    num = num1 * 0.70;
                }
                result.setText(num + " JPY.");
            }
        });

        btn_eur = (Button)findViewById(R.id.btn_eur);
        btn_eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Double.parseDouble(et_num.getText().toString());
                if(TargetActivity.nation == 1) {
                    num = num1 * 1354.41;
                }
                else if (TargetActivity.nation == 2) {
                    num = num1 * 1.22;
                }
                else if (TargetActivity.nation == 3) {
                    num = num1 * 134.06;
                }
                else if (TargetActivity.nation == 4) {
                    num = num1 * 1;
                }
                else if (TargetActivity.nation == 5) {
                    num = num1 * 7.80;
                }
                else if (TargetActivity.nation == 6) {
                    num = num1 * 0.86;
                }
                result.setText(num + " EUR.");
            }
        });
        btn_cny = (Button)findViewById(R.id.btn_cny);
        btn_cny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Double.parseDouble(et_num.getText().toString());
                if(TargetActivity.nation == 1) {
                    num = num1 * 173.66;
                }
                else if (TargetActivity.nation == 2) {
                    num = num1 * 0.16;
                }
                else if (TargetActivity.nation == 3) {
                    num = num1 * 17.19;
                }
                else if (TargetActivity.nation == 4) {
                    num = num1 * 0.13;
                }
                else if (TargetActivity.nation == 5) {
                    num = num1 * 1;
                }
                else if (TargetActivity.nation == 6) {
                    num = num1 * 0.11;
                }
                result.setText(num + " CNY.");
            }
        });
        btn_gbp = (Button)findViewById(R.id.btn_gbp);
        btn_gbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Double.parseDouble(et_num.getText().toString());
                if(TargetActivity.nation == 1) {
                    num = num1 * 1571.39;
                }
                else if (TargetActivity.nation == 2) {
                    num = num1 * 1.42;
                }
                else if (TargetActivity.nation == 3) {
                    num = num1 * 155.54;
                }
                else if (TargetActivity.nation == 4) {
                    num = num1 * 1.16;
                }
                else if (TargetActivity.nation == 5) {
                    num = num1 * 9.05;
                }
                else if (TargetActivity.nation == 6) {
                    num = num1 * 1;
                }
                result.setText(num + " GBP.");
            }
        });
        btn_nation = (Button)findViewById(R.id.btn_nation);
        btn_nation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() { // 재실행
        super.onResume();
        btn_nation = (Button)findViewById(R.id.btn_nation);
        if(TargetActivity.nation == 1) {
            btn_nation.setText("대상 : KRW.");
        }
        else if(TargetActivity.nation == 2) {
            btn_nation.setText("대상 : USD.");
        }
        else if(TargetActivity.nation == 3) {
            btn_nation.setText("대상 : JPY.");
        }
        else if(TargetActivity.nation == 4) {
            btn_nation.setText("대상 : EUR.");
        }
        else if(TargetActivity.nation == 5) {
            btn_nation.setText("대상 : CNY.");
        }
        else if(TargetActivity.nation == 6) {
            btn_nation.setText("대상 : GBP.");
        }
    }
}
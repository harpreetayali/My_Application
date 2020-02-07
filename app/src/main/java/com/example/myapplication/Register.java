package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class Register extends AppCompatActivity
{
    private EditText et_first_name,et_last_name,et_mobile,et_email,et_address,et_password,et__confirm_password;
    private Button register_btn;
    private AwesomeValidation awValidation;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        register_btn = findViewById(R.id.register_btn);
        awValidation = new AwesomeValidation(ValidationStyle.BASIC);

        et_first_name = findViewById(R.id.et_user_firstname);
        et_last_name = findViewById(R.id.et_user_lastname);
        et_mobile = findViewById(R.id.et_mobile);
        et_email = findViewById(R.id.et_email_register);
        et_address = findViewById(R.id.et_address);
        et_password = findViewById(R.id.et_password_register);
        et__confirm_password = findViewById(R.id.et_confirm_password);

        awValidation.addValidation(et_first_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$","Enter a valid first name");
        awValidation.addValidation(et_last_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$","Enter a valid last name");
        awValidation.addValidation(et_mobile,"^[2-9]{2}[0-9]{8}$","Enter a valid mobile number");
        awValidation.addValidation(et_email, Patterns.EMAIL_ADDRESS,"Enter a valid email");
        awValidation.addValidation(et_address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$","Enter a valid address");
        awValidation.addValidation(et_password, "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})","Enter a valid password");
        awValidation.addValidation(et__confirm_password, "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})","Enter a valid password");






        register_btn.setOnClickListener((View v)->  checkValidation()   );
    }

    public void checkValidation()
    {
        String pswd,confirm_password;
        Boolean valid = false;
        pswd = et_password.getText().toString();
        confirm_password = et__confirm_password.getText().toString();

        if (pswd.equals(confirm_password))
            valid = true;
        else
        {
            toast = new Toast(getApplicationContext());
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
            toast.setView(layout);
            TextView textView = layout.findViewById(R.id.tv1);
            textView.setText("Password doesn't matches");
            toast.setGravity(Gravity.CENTER,0,40);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
            // Toast.makeText(this, "Password doesn't matches", Toast.LENGTH_SHORT).show();
        }
        if (awValidation.validate()&&valid)
        {
            Toast.makeText(this, "Validation Success", Toast.LENGTH_SHORT).show();
        }

    }
}

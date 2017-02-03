package br.com.cpbr.perguntas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    boolean checkedFlag;

    private FirebaseAuth firebaseAuth;
    ProgressDialog progress;

    @BindView(R.id.editMail)
    EditText editMail;

    @BindView(R.id.editPass)
    EditText editPass;

    @BindView(R.id.recover_password)
    TextView textRecovery;

    @BindView(R.id.go_to_signin)
    TextView textRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void submit() {

        if (editMail.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Preencha o campo email...");
            builder.show();
            return;
        }
        if (editPass.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Preencha o campo senha...");
            builder.show();
            return;
        }

        progress = ProgressDialog.show(LoginActivity.this, "Carregando", "Por favor Aguarde...", true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(editMail.getText().toString(), editPass.getText().toString())
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            progress.dismiss();

                            if (checkedFlag) {

                                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                pref = getApplicationContext().getSharedPreferences("login.conf", Context.MODE_PRIVATE);
                                editor = pref.edit();
                                editor.putString("email", editMail.getText().toString());
                                editor.putString("senha", editPass.getText().toString());
                                editor.putString("id", uid);
                                editor.apply();
                            }

                            Intent abreInicio = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(abreInicio);

                        } else {
                            progress.dismiss();

                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setTitle("Atenção");
                            builder.setMessage("Email ou senha incorreta!!!");
                            builder.show();
                        }
                    }
                });
    }

    @OnClick(R.id.recover_password)
    public void submit(TextView textView) {

        Intent i = new Intent(this, ForgotActivity.class);
        startActivity(i);

    }

    @OnClick(R.id.go_to_signin)
    public void userClicked(TextView textView) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        checkedFlag = isChecked;
    }
}
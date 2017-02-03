package br.com.cpbr.perguntas;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    ProgressDialog progress;

    @BindView(R.id.editMail)
    EditText editMail;

    @BindView(R.id.btnRec)
    Button btnRec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnRec)
    public void submit() {

        if(editMail.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(ForgotActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Preencha o campo email...");
            builder.show();
            return;
        }
        progress = ProgressDialog.show(ForgotActivity.this, "Carregando","Por favor Aguarde...", true);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(editMail.getText().toString())
                .addOnCompleteListener(ForgotActivity.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            progress.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(ForgotActivity.this);
                            builder.setTitle("Atenção");
                            builder.setMessage("Senha recuperada com sucesso acesse o email: "+ editMail.getText().toString()+" para mais informações!");
                            builder.show();
                            return;

                        }else{
                            progress.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(ForgotActivity.this);
                            builder.setTitle("Atenção");
                            builder.setMessage("Email não encontrado tente novamente ou cadastre um novo usuário!");
                            builder.show();
                            return;

                        }
                    }
                });
    }
}

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    ProgressDialog progress;

    @BindView(R.id.editMail)
    EditText editMail;

    @BindView(R.id.editConfPass)
    EditText editConfPass;

    @BindView(R.id.editPass)
    EditText editPass;

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnRegister)
    public void submit() {

        if(editMail.getText().toString().isEmpty()){

            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Preencha o campo email...");
            builder.show();
            return;

        }
        if(editPass.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Preencha o campo password...");
            builder.show();
            return;
        }

        if(editConfPass.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Preencha o campo confirme seu password...");
            builder.show();
            return;
        }

        if(!editPass.getText().toString().equals(editConfPass.getText().toString())){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Atenção!");
            builder.setMessage("As senhas não conferem digite novamente...");
            builder.show();
            return;
        }

        if(editPass.getText().toString().trim().length()<6){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Por favor");
            builder.setMessage("Digite uma senha com no mínimo 6 digitos...");
            builder.show();
            return;
        }

        progress = ProgressDialog.show(RegisterActivity.this, "Carregando","Por favor Aguarde...", true);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(editMail.getText().toString(),editPass.getText().toString())
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progress.dismiss();

                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            builder.setTitle("Atenção");
                            builder.setMessage("Usuário cadastrado com sucesso...");
                            builder.show();
                            return;

                        }else{
                            progress.dismiss();

                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            builder.setTitle("Atenção");
                            builder.setMessage("Erro ao cadastrar usuário...");
                            builder.show();
                            return;
                        }
                    }
                });

    }
}

package com.esgi.virtualclassroom.modules.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.esgi.virtualclassroom.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

class LoginPresenter {
    private LoginView view;
    private FirebaseAuth firebaseAuth;


    LoginPresenter(LoginView view) {
        this.view = view;
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    void onRegisterButtonClick() {
        view.goToRegisterActivity();
    }

    void onLoginAttempt(String email, String password) {
        view.resetErrors();

        boolean valid = isFormValid(email, password);
        if (!valid) {
            return;
        }

        view.closeKeyboard();
        view.showProgressDialog();
        signInWithEmailAndPassword(email, password);
    }

    private boolean isFormValid(String email, String password) {
        boolean valid = true;

        if (TextUtils.isEmpty(password) || password.length() < 5) {
            view.showPasswordError("Invalid password");
            valid = false;
        }

        if (TextUtils.isEmpty(email) || email.length() < 5 || !email.contains("@")) {
            view.showEmailError("Invalid e-mail");
            valid = false;
        }

        return valid;
    }

    private void signInWithEmailAndPassword(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                view.hideProgressDialog();
                view.goToHomeActivity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                view.showLoginError("An error has occurred during the Email authentication process.");
                firebaseAuth.signOut();
                view.hideProgressDialog();
            }
        });
    }
}
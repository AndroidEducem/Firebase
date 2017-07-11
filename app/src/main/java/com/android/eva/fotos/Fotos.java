package com.android.eva.fotos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Fotos extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);

        /* Inicialitzar Firebase.
        Seguint els passos del asistent a Tools-> Firebase */

        /* Attach the listener to your FirebaseAuth instance in the
            onStart() method   and remove it on onStop() .
        */


        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("Firebase", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("Firebase", "onAuthStateChanged:signed_out");
                }
                // ...

/*??????????????
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
/* ????????????????????
        FirebaseOptions options = new FirebaseOptions().Builder().setCredential(FirebaseCredentials.fromCertificate(serviceAccount));
        options.setDatabaseUrl("https://fotos-be6d5.firebaseio.com");
         options.build();

        FirebaseApp.initializeApp(options);
*/
            }
        };
    }
}

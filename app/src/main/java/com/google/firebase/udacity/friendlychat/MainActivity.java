/**
 * Copyright Google Inc. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.firebase.udacity.friendlychat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;



import static android.media.CamcorderProfile.get;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String ANONYMOUS = "anonymous";
    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;

    public static final int RC_SIGN_IN = 1;
    private static final int RC_PHOTO_PICKER =  2;

    private ListView mMessageListView;
    private MessageAdapter mMessageAdapter;
    private ProgressBar mProgressBar;
//    private ImageButton mPhotoPickerButton;
    private EditText mMessageEditText;
    private Button mSendButton;

    private String mUsername;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;
//    private FirebaseStorage mFirebaseStorage;
//    private StorageReference mChatPhotosStorageReference;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_list);

//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mFirebaseAuth = FirebaseAuth.getInstance();
//
//        //        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("subjects").child("Robotica");
//        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("subjects");


// usuario por defecto
//        mUsername = ANONYMOUS;


        final ArrayList<Subject> subjects= new ArrayList<Subject>();
        subjects.add(new Subject("Historia de las ideas politicas"));
        subjects.add(new Subject("Catedra Julio Garavito Armero"));
        subjects.add(new Subject("Catedra Colombia"));
        subjects.add(new Subject("Grafica Interactiva"));
        subjects.add(new Subject("Catedra de Derecho para estudientes de otras carreras"));
        subjects.add(new Subject("Espacio y Poder en America Latina"));
        subjects.add(new Subject("Perspectivas respecto al exito o fracaso de la Paz"));
        subjects.add(new Subject("Deporte Clase"));
        subjects.add(new Subject("Huellas que inspiran"));
        subjects.add(new Subject("Bogota Musical Internacional"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        SubjectAdapter adapter = new SubjectAdapter(this, subjects,R.color.category_subject);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_list.xmlt file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intentSubjectComments = new Intent(MainActivity.this , SubjectCommentsActivity.class);

                Subject subject = subjects.get(position);
                intentSubjectComments.putExtra("name",subject.getName());
                startActivity(intentSubjectComments);

            }
        });


    }

}
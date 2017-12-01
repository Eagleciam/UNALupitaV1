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
        subjects.add(new Subject("Historia de las ideas políticas"));
        subjects.add(new Subject("Gráfica Interactiva"));
        subjects.add(new Subject("Espacio y Poder en America Latina"));
        subjects.add(new Subject("Perspectivas respecto al exito o fracaso de la Paz"));
        subjects.add(new Subject("Deporte Clase"));
        subjects.add(new Subject("Huellas que inspiran"));
        subjects.add(new Subject("Agujeros negros y máquinas del tiempo"));
        subjects.add(new Subject("Amazonia y otras selvas ecuatoriales"));
        subjects.add(new Subject("Amenaza, riesgo y desarrollo"));
        subjects.add(new Subject("Analisis y procesamiento de imagenes"));
        subjects.add(new Subject("Animación"));
        subjects.add(new Subject("Antonio Gramsci: Subalternidad, hegemonia y autonomia"));
        subjects.add(new Subject("Apreciación e historia del arte"));
        subjects.add(new Subject("Apreciación musical"));
        subjects.add(new Subject("Arte rupestre muisca"));
        subjects.add(new Subject("Astronomía para todos"));
        subjects.add(new Subject("Beatles y algo más: música, cultura y sociedad(1960-75)"));
        subjects.add(new Subject("Bioinvasiones"));
        subjects.add(new Subject("Biologia de reptiles escamados"));
        subjects.add(new Subject("Biomecánica articular y de movimiento complejo"));
        subjects.add(new Subject("Biomecanica de tejidos"));
        subjects.add(new Subject("Biotecnología para no biotecnólogos"));
        subjects.add(new Subject("Bogotá musical internacional"));
        subjects.add(new Subject("Café y su contexto productivo"));
        subjects.add(new Subject("Cátedra Colombia"));
        subjects.add(new Subject("Cátedra de Derecho para estudiantes de otras carreras"));
        subjects.add(new Subject("Cátedra Julio Garavito Armero"));
        subjects.add(new Subject("Cátedra de inducción UN: Conoce, vive y comparte la vida universitaria"));
        subjects.add(new Subject("Cátedra Ingenio, Ciecia, Tecnología y Sociedad"));
        subjects.add(new Subject("Cátedra Muisca"));
        subjects.add(new Subject("Cátedra Turca: Historia y Cultura"));
        subjects.add(new Subject("Cerámica Artística"));
        subjects.add(new Subject("Ciencia, tecnología y desarrollo"));
        subjects.add(new Subject("Ciencias forenses y medicina veterinaria legal"));
        subjects.add(new Subject("Cine y video experimental"));
        subjects.add(new Subject("Ciudad, hábitat y vivienda"));
        subjects.add(new Subject("Ciudad, territorio y complejidad"));
        subjects.add(new Subject("Ciudad y medio ambiente sustentable"));
        subjects.add(new Subject("Ciudades, geopolítica y relaciones internacionales"));
        subjects.add(new Subject("Clima y arquitectura"));
        subjects.add(new Subject("Clima y diversidad de clima de colombia"));
        subjects.add(new Subject("Computación gráfica"));
        subjects.add(new Subject("Comunicación animal"));
        subjects.add(new Subject("Comunicación, arte y educación"));
        subjects.add(new Subject("Contexto Bioseguridad"));
        subjects.add(new Subject("Cuántica para todos y para todo"));
        subjects.add(new Subject("Cultivos transgénicos: Frankenstein o Prometeo? "));
        subjects.add(new Subject("Curso de contexto: El sistema de salud en Colombia, historia y prospectiva"));
        subjects.add(new Subject("Curso de lengua Embera"));
        subjects.add(new Subject("Deporte Clase"));
        subjects.add(new Subject("Desarrollo de habilidades gerenciales para negociación y liderazgo"));
        subjects.add(new Subject("Desarrollo de la Ingeniería en Colombia"));
        subjects.add(new Subject("Dinamica de fluidos computacional"));
        subjects.add(new Subject("Diseño, arte e ideología"));
        subjects.add(new Subject("Diseño de elementos de máquinas"));
        subjects.add(new Subject("El habitat, el entorno de lo urbano, la salud y la vivienda"));
        subjects.add(new Subject("El Yo, el Doble y otros monstruos"));
        subjects.add(new Subject("Electrónica Digital II"));
        subjects.add(new Subject("Electrónica en la Agricultura"));
        subjects.add(new Subject("Elementos de Computadores"));
        subjects.add(new Subject("Epistemología de las ciencias socilaes"));
        subjects.add(new Subject("Estética"));
        subjects.add(new Subject("Estudios de casos en anfibios"));
        subjects.add(new Subject("Etnobotánica"));
        subjects.add(new Subject("Evaluación de servicios de alimentación"));
        subjects.add(new Subject("Fiestas populares, carnaval, sociedad y arte popular"));
        subjects.add(new Subject("Filosofía contemporánea I"));
        subjects.add(new Subject("Filosofía de la mente"));
        subjects.add(new Subject("Filosofía de la psicología"));
        subjects.add(new Subject("Física de las grandes ideas que cambiaron al mundo"));
        subjects.add(new Subject("Florística y fitogeografía"));
        subjects.add(new Subject("Fundamentación en código para web"));
        subjects.add(new Subject("Fundamentos de ecología del paisaje"));
        subjects.add(new Subject("Fundamentos de gobierno urbano"));
        subjects.add(new Subject("Fundamentos de palinología básica y aplicada"));
        subjects.add(new Subject("Fundamentos de transferencia de calor"));
        subjects.add(new Subject("Galileo"));
        subjects.add(new Subject("Geografía de suelos en Colombia"));
        subjects.add(new Subject("Gestación adolescente II"));
        subjects.add(new Subject("Gráfica interactiva"));
        subjects.add(new Subject("Herramientas modernas para la administración"));
        subjects.add(new Subject("Historia e identidad de la Medicina y las profesiones de la salud"));
        subjects.add(new Subject("Iniciación a estudios feministas y de género"));
        subjects.add(new Subject("Instalacione frigoríficas"));
        subjects.add(new Subject("Inteligencia artificial y Mini robots"));
        subjects.add(new Subject("Introducción a la Astronomía"));
        subjects.add(new Subject("Introducción a la Biofísica"));
        subjects.add(new Subject("Introducción a la Cultura Coreana"));
        subjects.add(new Subject("Introducción a la Ingeniería Química"));
        subjects.add(new Subject("Introducción a la vegetación de Colombia"));
        subjects.add(new Subject("Introducción a los estudios urbanos"));
        subjects.add(new Subject("Introducción a los indicadores económicos sociales"));
        subjects.add(new Subject("La clínica del caso"));
        subjects.add(new Subject("La cuestión femenina"));
        subjects.add(new Subject("La Esquizofrenia: Del trastorno a la estructura"));
        subjects.add(new Subject("La satisfaccipon pulsional"));
        subjects.add(new Subject("La voz en los lazos sociales"));
        subjects.add(new Subject("Lengua de señas Colombiana, nivel básico"));
        subjects.add(new Subject("Lengua Inga"));
        subjects.add(new Subject("Lengua y cultura Wayuu I"));
        subjects.add(new Subject("Liderazgo emocional"));
        subjects.add(new Subject("Materiales de Ingeniería"));
        subjects.add(new Subject("Mecánica Celeste"));
        subjects.add(new Subject("Mecanismos"));
        subjects.add(new Subject("Medio ambiente, toxicología y salud"));
        subjects.add(new Subject("Mejoramiento vegetal asistido por marcadores moleculares"));
        subjects.add(new Subject("Mercadeo agrario y alimentario"));
        subjects.add(new Subject("Microeconomía Financiera"));
        subjects.add(new Subject("Movilidad y transporte urbano"));
        subjects.add(new Subject("Muerte, duelo y venganza"));
        subjects.add(new Subject("Museos"));
        subjects.add(new Subject("Museos: Academia y Sociedad"));
        subjects.add(new Subject("Mpusica y Política"));
        subjects.add(new Subject("Música y Sociedad en Colombia"));
        subjects.add(new Subject("Nasa Yuwe y pensamiento Nasa"));
        subjects.add(new Subject("Negociación, Trabajo en equipo y liderazgo"));
        subjects.add(new Subject("Neurobiología y fisiopatología del comportamiento humano"));
        subjects.add(new Subject("Neurofisiología del desarrollo"));
        subjects.add(new Subject("Objetos Astrofísicos"));
        subjects.add(new Subject("Ornitología"));
        subjects.add(new Subject("Pas, todo un camino por hacer"));
        subjects.add(new Subject("Pensamiento fotográfico"));
        subjects.add(new Subject("Perspectivas respecto al posible éxito o fracaso de la paz en Colombia"));
        subjects.add(new Subject("Política Agraria"));
        subjects.add(new Subject("Principios de mecánica de fluidos"));
        subjects.add(new Subject("Problemas ambientales urbanos"));
        subjects.add(new Subject("Problemas de Estética"));
        subjects.add(new Subject("Procesos del Fuego"));
        subjects.add(new Subject("Programas salón Cano"));
        subjects.add(new Subject("Promoción de la vida frente al uso indebido de drogas"));
        subjects.add(new Subject("Proyccto de plantas térmicas y de proceso"));
        subjects.add(new Subject("Psicoanálisis y Cultura"));
        subjects.add(new Subject("Raíces grigas y latinas del Español"));
        subjects.add(new Subject("Recursos genéticos: Aspectos técnicos y jurídicos"));
        subjects.add(new Subject("Reflexiones en torno al proceso de envejecimiento"));
        subjects.add(new Subject("Relaciones internacionales para no politólogos"));
        subjects.add(new Subject("Semanálisi - Relación entre Semióticay Psicoanálisis"));
        subjects.add(new Subject("Semillero, Compuestos bioactivos de los alimentos, impacto en la salud humana"));
        subjects.add(new Subject("Seminario: Ciudades, Industrias y Cadenas mercantiles globales"));
        subjects.add(new Subject("Seminario de Arquitectura Latinoamericana"));
        subjects.add(new Subject("Seminario de arte contemporáneo"));
        subjects.add(new Subject("Seminario de cultura Portuguesa"));
        subjects.add(new Subject("Seminario del sector eléctrico Colombiano"));
        subjects.add(new Subject("Sensibilidad y pensamiento cinematográfico"));
        subjects.add(new Subject("Sexualidad, goce y deseo"));
        subjects.add(new Subject("Shakespeare and the english renaissance"));
        subjects.add(new Subject("Siglo Veinte: Pensamiento arte poéticas"));
        subjects.add(new Subject("Situación del derecho a la seguridad alimentaria y nutricional en Colombia"));
        subjects.add(new Subject("Taller de matemáticas y ciencias"));
        subjects.add(new Subject("Técnicas de caracterización"));
        subjects.add(new Subject("Temas especiales en Ingeniería Química"));
        subjects.add(new Subject("Teoría de Control"));
        subjects.add(new Subject("Teoría de la información y sistemas de comunicación"));
        subjects.add(new Subject("Teoría funcional de campos cuánticos"));
        subjects.add(new Subject("Termodinámica técnica"));
        subjects.add(new Subject("Tribología"));
        subjects.add(new Subject("Uitoto"));
        subjects.add(new Subject("Ventilación y aire acondicionado"));
        subjects.add(new Subject("Visión de Máquina"));














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
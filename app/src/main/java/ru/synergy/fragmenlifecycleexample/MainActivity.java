package ru.synergy.fragmenlifecycleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.synergy.fragmenlifecycleexample.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {

    Button fragmentButton1, fragmentButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentButton1 = (Button) findViewById(R.id.buttonFragment1);
        fragmentButton2 = (Button) findViewById(R.id.buttonFragment2);

        // Fragment specific
        // получение фрагмент менеджера, чтобы работать с фрагментами
        FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //добавляем фрагмент на экран
        FirstFragment firstFragment = FirstFragment.newInstance("1", "2");
        fragmentTransaction.add(R.id.container, firstFragment);
        fragmentTransaction.commit();


        fragmentButton1.setOnClickListener(onButtonClickListner);
        fragmentButton2.setOnClickListener(onButtonClickListner);
    }

    Button.OnClickListener onButtonClickListner = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {

            Fragment newFragment = null;

            if(v == fragmentButton1){
                newFragment = new FirstFragment();
            }else {
                newFragment = SecondFragment();
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }

    }
}
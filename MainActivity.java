package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editNatNum.setText("896");
            editNam.setText("Glastrier");
            editSpec.setText("Wild Horse Pokemon");
            editHeight.setText("2.2");
            editWeight.setText("800");
            editHP.setText("0");
            editAttack.setText("0");
            editDefense.setText("0");
            spin_gender.setSelection(0);
            spin_lvl.setSelection(0);
        }
    };


    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            counter = 0;
            natNum = editNatNum.getText().toString();
            name = editNam.getText().toString();
            species = editSpec.getText().toString();
            height = editHeight.getText().toString();
            weight = editWeight.getText().toString();
            hp = editHP.getText().toString();
            attack = editAttack.getText().toString();
            defense = editDefense.getText().toString();

            System.out.println(isEmpty(editNatNum));
            if(isEmpty(editNatNum)){
                text_national_Num.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set National Number", Toast.LENGTH_SHORT).show();
            }
            else{
                text_national_Num.setTextColor(Color.parseColor("#000000"));
                boolean numCheck = isNumber(natNum);
                if (numCheck == true){
                    Float nationalNumber = Float.valueOf(natNum);
                    if (nationalNumber > 0 && nationalNumber < 1010){
                        counter++;
                    }
                    else{
                        text_national_Num.setTextColor(Color.parseColor("#ff0000"));
                        Toast.makeText(getApplicationContext(), "National number does not meet criteria", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    text_national_Num.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "National Number is not a Number", Toast.LENGTH_SHORT).show();
                }

            }

            if(isEmpty(editNam)){
                text_name.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Name", Toast.LENGTH_SHORT).show();
            }
            else{
                text_name.setTextColor(Color.parseColor("#000000"));
                if(ifNumAppear(name)){
                    text_name.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "Name does not meet Criteria", Toast.LENGTH_SHORT).show();
                }
                else{
                    text_name.setTextColor(Color.parseColor("#000000"));
                    counter++;
                }
            }

            if(isEmpty(editSpec)){
                text_species.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Species", Toast.LENGTH_SHORT).show();
            }
            else{
                text_species.setTextColor(Color.parseColor("#000000"));
                if(ifNumAppear(species)){
                    text_species.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "Species does not meet Criteria", Toast.LENGTH_SHORT).show();
                }
                else{
                    text_name.setTextColor(Color.parseColor("#000000"));
                    counter++;
                }
            }

            if(isEmpty(editHeight)){
                text_height.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Height", Toast.LENGTH_SHORT).show();
            }
            else{
                text_height.setTextColor(Color.parseColor("#000000"));
                boolean numCheck = isNumber(height);
                if (numCheck == true){
                    Float heightF = Float.valueOf(height);
                    if (heightF > 0.3 && heightF < 19.99){
                        counter++;
                    }
                    else{
                        text_height.setTextColor(Color.parseColor("#ff0000"));
                        Toast.makeText(getApplicationContext(), "Height does not meet criteria", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    text_height.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "Height is not a Number", Toast.LENGTH_SHORT).show();
                }
            }

            if(isEmpty(editWeight)){
                text_weight.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Weight", Toast.LENGTH_SHORT).show();
            }
            else{
                text_weight.setTextColor(Color.parseColor("#000000"));
                boolean numCheck = isNumber(weight);
                if (numCheck == true){
                    Float weightF = Float.valueOf(weight);
                    if (weightF > 0.1 && weightF < 820.0){
                        counter++;
                    }
                    else{
                        text_weight.setTextColor(Color.parseColor("#ff0000"));
                        Toast.makeText(getApplicationContext(), "Weight does not meet criteria", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    text_weight.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "Weight is not a Number", Toast.LENGTH_SHORT).show();
                }
            }

            if(isEmpty(editHP)){
                text_hp.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set HP", Toast.LENGTH_SHORT).show();
            }
            else{
                text_hp.setTextColor(Color.parseColor("#000000"));
                boolean numCheck = isNumber(hp);
                if (numCheck == true){
                    Float hpF = Float.valueOf(hp);
                    if (hpF > 1 && hpF < 362){
                        counter++;
                    }
                    else{
                        text_hp.setTextColor(Color.parseColor("#ff0000"));
                        Toast.makeText(getApplicationContext(), "HP does not meet Criteria", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    text_hp.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "HP is not a Number", Toast.LENGTH_SHORT).show();
                }
            }

            if(isEmpty(editAttack)){
                text_attack.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Attack", Toast.LENGTH_SHORT).show();
            }
            else{
                text_attack.setTextColor(Color.parseColor("#000000"));
                boolean numCheck = isNumber(attack);
                if (numCheck == true){
                    Float attackF = Float.valueOf(attack);
                    if (attackF > 5 && attackF < 526){
                        counter++;
                    }
                    else {
                        text_attack.setTextColor(Color.parseColor("#ff0000"));
                        Toast.makeText(getApplicationContext(), "Defense does not meet criteria", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    text_attack.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "Attack is not a Number", Toast.LENGTH_SHORT).show();
                }
            }

            if(isEmpty(editDefense)){
                text_defense.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Defense", Toast.LENGTH_SHORT).show();
            }
            else{
                text_defense.setTextColor(Color.parseColor("#000000"));
                boolean numCheck = isNumber(defense);
                if (numCheck == true){
                    Float defenseF = Float.valueOf(defense);
                    if (defenseF > 5 && defenseF < 614){
                        counter++;
                    }
                    else{
                        text_defense.setTextColor(Color.parseColor("#ff0000"));
                        Toast.makeText(getApplicationContext(), "Defense does not meet criteria", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    text_defense.setTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(getApplicationContext(), "Defense is not a Number", Toast.LENGTH_SHORT).show();
                }
            }
            String itemText = (String) spin_gender.getSelectedItem();
            if(itemText.equals("N/A")){
                text_gender.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Gender", Toast.LENGTH_SHORT).show();
            }
            else{
                text_gender.setTextColor(Color.parseColor("#000000"));
                counter++;
            }
            String itemText2 = (String) spin_lvl.getSelectedItem();
            if(itemText.equals("N/A")){
                text_level.setTextColor(Color.parseColor("#ff0000"));
                Toast.makeText(getApplicationContext(), "Set Level", Toast.LENGTH_SHORT).show();
            }
            else{
                text_level.setTextColor(Color.parseColor("#000000"));
                counter++;
            }
            if (counter == 10){
                Toast.makeText(getApplicationContext(), "Your Pokemon is in the Database", Toast.LENGTH_SHORT).show();
            }
        }
    };


    TextView text_national_Num;
    TextView text_name;
    TextView text_species;
    TextView text_gender;
    TextView text_height;
    TextView text_weight;
    TextView text_level;
    TextView text_hp;
    TextView text_attack;
    TextView text_defense;
    TextView text_poke_tracker;
    TextView text_register;
    TextView text_base;
    Button butt_reset;
    Button butt_submit;
    Button butt_switch;
    Spinner spin_gender;
    Spinner spin_lvl;
    EditText editNatNum;
    EditText editNam;
    EditText editSpec;
    EditText editHeight;
    EditText editWeight;
    EditText editHP;
    EditText editAttack;
    EditText editDefense;
    String natNum = "896";
    String name = "Glastrier";
    String species = "Wild Horse Pokemon";
    String height = "2.2";
    String weight ="800";
    String hp = "0";
    String attack = "0";
    String defense = "0";
    int counter = 0;

    @SuppressLint("MissingInflatedId")
    AdapterView.OnItemSelectedListener genderSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String message = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    AdapterView.OnItemSelectedListener levelSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String message = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_main);

        text_national_Num = findViewById(R.id.pokeNum);
        text_name = findViewById(R.id.pokeName);
        text_species = findViewById(R.id.pokeSpecies);
        text_gender = findViewById(R.id.pokeGender);
        text_height = findViewById(R.id.pokeHeight);
        text_weight = findViewById(R.id.pokeWeight);
        text_level = findViewById(R.id.pokeLevel);
        text_hp = findViewById(R.id.pokeHP);
        text_attack = findViewById(R.id.pokeAttack);
        text_defense = findViewById(R.id.pokeDefense);
        text_poke_tracker = findViewById(R.id.pokeTitle);
        text_register = findViewById(R.id.pokeSubTitle);
        text_base = findViewById(R.id.pokeStats);

        butt_reset = findViewById(R.id.resetButton);
        butt_submit = findViewById(R.id.submitButton);


        editNatNum = findViewById(R.id.NatNumEdit);
        editNam = findViewById(R.id.EditName);
        editSpec = findViewById(R.id.editSpecies);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.EditWeight);
        editHP = findViewById(R.id.editHP);
        editAttack = findViewById(R.id.editAttack);
        editDefense = findViewById(R.id.editDefense);

        spin_gender = findViewById(R.id.genSpin);
        spin_gender.setOnItemSelectedListener(genderSpinnerListener);
        ArrayList<String> genList = new ArrayList<>();
        genList.add("N/A");
        genList.add("Male");
        genList.add("Female");
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genList);
        spin_gender.setAdapter(typeAdapter);

        spin_lvl = findViewById(R.id.levelSpin);
        spin_lvl.setOnItemSelectedListener(levelSpinnerListener);
        ArrayList<String> lvlList = new ArrayList<>();

        lvlList.add(String.valueOf("N/A"));
        for(int i = 1; i < 51; i++){
            lvlList.add(String.valueOf(i));
        }
        ArrayAdapter<String> lvlAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lvlList);
        spin_lvl.setAdapter(lvlAdapter);

        butt_reset.setOnClickListener(resetListener);
        butt_submit.setOnClickListener(submitListener);

    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        }
        return true;
    }
    public static boolean isNumber(String num){
        if (num == null){
            return false;
        }
        try {
            float f = Float.parseFloat(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean ifNumAppear(String s){
        char[] chars = s.toCharArray();
        for (char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
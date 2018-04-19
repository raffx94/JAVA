package com.example.rafa.statisticletterapp.controller;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.rafa.statisticletterapp.R;
import com.example.rafa.statisticletterapp.model.LetterModel;
import com.example.rafa.statisticletterapp.model.WrongArgumentsException;

import java.io.IOException;

/**
 *  class MainActivity to initialize my apps
 *  the application has been tested on android 7.0 with Huawei P9 lite
 *  @author Rafal Miasko
 *  @version 3.0
 */
public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;


    /**
     * Method onCreate to create my instance
     * @param savedInstanceState param class Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * button class Button
         */
        button = (Button) findViewById(R.id.button);
        /**
         * editText class EditText
         */
        editText = (EditText) findViewById(R.id.editText);
        /**
         * textView class TextView
         */
        textView = (TextView) findViewById(R.id.text);
       initBtnOnClickListeners();



    }

    /**
     * method initBtnOnClickListeners when button is clicked
     *
     *
     */
    private void initBtnOnClickListeners() {
        button.setOnClickListener(v -> changeTextInView(String.valueOf(editText.getText())));
    }


    /**
     * method chaneTextInView show the result of calculate in textView
     * @param text data string
     */
        protected void changeTextInView(String text)
    {
       LetterModel letter = new LetterModel();
        try {
            String data = text.toUpperCase().replace(" ","");
            letter.hashmap(data);
            letter.resultOfSum(data);
            Double texts = letter.getSumResult();

            textView.setText( texts.toString());

        } catch (WrongArgumentsException e) {
           textView.setText(R.string.error);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    }


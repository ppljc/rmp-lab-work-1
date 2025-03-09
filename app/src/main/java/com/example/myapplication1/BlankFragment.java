package com.example.myapplication1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlankFragment extends Fragment {
    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.button1)
    Button button1;

    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.button3)
    Button button3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button1)
    void onButton1Click() {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(getActivity(), "Введите текст!", Toast.LENGTH_SHORT).show();
        } else {
            String reversedText = new StringBuilder(text).reverse().toString();
            Toast.makeText(getActivity(), "Развернутый текст: " + reversedText, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.button2)
    void onButton2Click() {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(getActivity(), "Введите текст!", Toast.LENGTH_SHORT).show();
        } else {
            String shuffledText = shuffleText(text);
            Toast.makeText(getActivity(), "Перемешанный текст: " + shuffledText, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.button3)
    void onButton3Click() {
        editText.setText("");
        Toast.makeText(getActivity(), "Поле очищено", Toast.LENGTH_SHORT).show();
    }

    private String shuffleText(String text) {
        List<Character> letters = new ArrayList<>();
        for (char c : text.toCharArray()) {
            letters.add(c);
        }
        Collections.shuffle(letters);
        StringBuilder shuffledText = new StringBuilder();
        for (char c : letters) {
            shuffledText.append(c);
        }
        return shuffledText.toString();
    }
}
package com.example.android.programmingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private int score = 0;
    private String name = "";
    private CheckBox CheckBox1_1;
    private CheckBox CheckBox1_2;
    private CheckBox CheckBox1_3;
    private CheckBox CheckBox2_1;
    private CheckBox CheckBox2_2;
    private CheckBox CheckBox2_3;
    private CheckBox CheckBox3_1;
    private CheckBox CheckBox3_2;
    private CheckBox CheckBox3_3;
    private CheckBox CheckBox6_1;
    private CheckBox CheckBox6_2;
    private CheckBox CheckBox6_3;
    private RadioGroup RadioGroup4;
    private int RadioButton4_correct;
    private RadioGroup RadioGroup5;
    private int RadioButton5_correct;
    private RadioGroup RadioGroup7;
    private int RadioButton7_correct;
    private RadioGroup RadioGroup8;
    private int RadioButton8_correct;
    private Button scoreButton;
    private EditText nameTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CheckBox1_1 = (CheckBox) findViewById(R.id.question_one_answer_one);
        CheckBox1_2 = (CheckBox) findViewById(R.id.question_one_answer_two);
        CheckBox1_3 = (CheckBox) findViewById(R.id.question_one_answer_three);
        CheckBox2_1 = (CheckBox) findViewById(R.id.question_two_answer_one);
        CheckBox2_2 = (CheckBox) findViewById(R.id.question_two_answer_two);
        CheckBox2_3 = (CheckBox) findViewById(R.id.question_two_answer_three);
        CheckBox3_1 = (CheckBox) findViewById(R.id.question_three_answer_one);
        CheckBox3_2 = (CheckBox) findViewById(R.id.question_three_answer_two);
        CheckBox3_3 = (CheckBox) findViewById(R.id.question_three_answer_three);
        CheckBox6_1 = (CheckBox) findViewById(R.id.question_six_answer_one);
        CheckBox6_2 = (CheckBox) findViewById(R.id.question_six_answer_two);
        CheckBox6_3 = (CheckBox) findViewById(R.id.question_six_answer_three);

        RadioGroup4 = (RadioGroup) findViewById(R.id.question_four_answer);
        RadioButton4_correct = R.id.question_four_answer_one;

        RadioGroup5 = (RadioGroup) findViewById(R.id.question_five_answer);
        RadioButton5_correct = R.id.question_five_answer_two;

        RadioGroup7 = (RadioGroup) findViewById(R.id.question_seven_answer);
        RadioButton7_correct = R.id.question_seven_answer_one;

        RadioGroup8 = (RadioGroup) findViewById(R.id.question_eight_answer);
        RadioButton8_correct = R.id.question_eight_answer_three;

        scoreButton = (Button) findViewById(R.id.score_button);
        nameTextInput = (EditText) findViewById(R.id.name_text_input);
    }

    /**
     * This method is called when the score button is clicked.
     */
    public void scoreButton(View view) {
        submitButton(scoreButton);
        nameTextInput(nameTextInput);
        score += answerCheckBox(CheckBox1_1, true);
        score += answerCheckBox(CheckBox1_2, false);
        score += answerCheckBox(CheckBox1_3, true);
        score += answerCheckBox(CheckBox2_1, true);
        score += answerCheckBox(CheckBox2_2, true);
        score += answerCheckBox(CheckBox2_3, false);
        score += answerCheckBox(CheckBox3_1, false);
        score += answerCheckBox(CheckBox3_2, true);
        score += answerCheckBox(CheckBox3_3, true);
        score += answerRadioGroup(RadioGroup4, RadioButton4_correct);
        score += answerRadioGroup(RadioGroup5, RadioButton5_correct);
        score += answerCheckBox(CheckBox6_1, true);
        score += answerCheckBox(CheckBox6_2, true);
        score += answerCheckBox(CheckBox6_3, false);
        score += answerRadioGroup(RadioGroup7, RadioButton7_correct);
        score += answerRadioGroup(RadioGroup8, RadioButton8_correct);
        String scoreMessage = createScoreMessage();
        displayMessage(scoreMessage);
    }

    /**
     * This method check status submit button
     */
    private void submitButton(Button button) {
        button.setEnabled(false);
    }

    /**
     * This method check status edit text.
     */
    private void nameTextInput(EditText editText) {
        if (editText.getText().length() > 0) {
            name = editText.getText().toString();
        } else {
            Toast.makeText(this, "The field with the name should be completed!", Toast.LENGTH_SHORT).show();
        }
        // disable edit text
        editText.setEnabled(false);
    }

    /**
     * This method check status checkbox.
     *
     * @return one points if the checkbox is checked
     */
    private int answerCheckBox(CheckBox checkBox, boolean isCorrect) {

        int i = 0;
        if (checkBox.isChecked() && isCorrect) {
            i = 1;
        }
        checkBox.setEnabled(false);
        return i;
    }

    /**
     * This method check status radio group.
     *
     * @return one points if the correct radio button is checked
     */
    private int answerRadioGroup(RadioGroup radioGroup, int correctRadioButtonID) {
        int i = 0;
        int checkedAnswerRadioGroup = radioGroup.getCheckedRadioButtonId();
        for (int k = 0; k < radioGroup.getChildCount(); k++) {
            // disable radio group
            (radioGroup.getChildAt(k)).setEnabled(false);
        }
        if (checkedAnswerRadioGroup != 0 && checkedAnswerRadioGroup == correctRadioButtonID) {
            i = 1;
        }
        return i;
    }

    /**
     * Takes the points of CheckBoxes and RadioGroups.
     *
     * @return text summary
     */
    private String createScoreMessage() {
        String scoreMessage = name;
        scoreMessage += "\n You have " + score + " out of 12 Points.";
        return scoreMessage;
    }

    /**
     * This method is called when the reset button is clicked.
     */
    public void resetButton(View view) {
        resetScoreButton(scoreButton);
        resetTextInput(nameTextInput);
        resetCheckBox(CheckBox1_1);
        resetCheckBox(CheckBox1_2);
        resetCheckBox(CheckBox1_3);
        resetCheckBox(CheckBox2_1);
        resetCheckBox(CheckBox2_2);
        resetCheckBox(CheckBox2_3);
        resetCheckBox(CheckBox3_1);
        resetCheckBox(CheckBox3_2);
        resetCheckBox(CheckBox3_3);
        resetRadioGroup(RadioGroup4);
        resetRadioGroup(RadioGroup5);
        resetCheckBox(CheckBox6_1);
        resetCheckBox(CheckBox6_2);
        resetCheckBox(CheckBox6_3);
        resetRadioGroup(RadioGroup7);
        resetRadioGroup(RadioGroup8);
        name = "";
        score = 0;
    }

    /**
     * This method reset score button.
     */
    private void resetScoreButton(Button button) {
        button.setEnabled(true);
    }

    /**
     * This method reset edit text.
     */
    private void resetTextInput(EditText editText) {
        // clear edit text
        editText.setText("");
        // enable edit text
        editText.setEnabled(true);
    }

    /**
     * This method reset checkbox.
     */
    private void resetCheckBox(CheckBox checkBox) {
        // uncheck checkbox
        checkBox.setChecked(false);
        // enable checkbox
        checkBox.setEnabled(true);
    }

    /**
     * This method reset radio group.
     */
    private void resetRadioGroup(RadioGroup radioGroup) {
        // clear radio group
        radioGroup.clearCheck();
        // enable radio group
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            (radioGroup.getChildAt(i)).setEnabled(true);
        }
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String scoreMessage) {
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
    }
}


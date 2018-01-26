package com.example.android.programmingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private int score = 0;
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * This method is called when the score button is clicked.
     */
    public void scoreButton(View view) {
        submitButton(R.id.score_button);
        nameTextInput(R.id.name_text_input);
        score += answerCheckBox(R.id.question_one_answer_one, true);
        score += answerCheckBox(R.id.question_one_answer_two, false);
        score += answerCheckBox(R.id.question_one_answer_three, true);
        score += answerCheckBox(R.id.question_two_answer_one, true);
        score += answerCheckBox(R.id.question_two_answer_two, true);
        score += answerCheckBox(R.id.question_two_answer_three, false);
        score += answerCheckBox(R.id.question_three_answer_one, false);
        score += answerCheckBox(R.id.question_three_answer_two, true);
        score += answerCheckBox(R.id.question_three_answer_three, true);
        score += answerRadioGroup(R.id.question_four_answer, R.id.question_four_answer_one);
        score += answerRadioGroup(R.id.question_five_answer, R.id.question_five_answer_two);
        score += answerCheckBox(R.id.question_six_answer_one, true);
        score += answerCheckBox(R.id.question_six_answer_two, true);
        score += answerCheckBox(R.id.question_six_answer_three, false);
        score += answerRadioGroup(R.id.question_seven_answer, R.id.question_seven_answer_one);
        score += answerRadioGroup(R.id.question_eight_answer, R.id.question_eight_answer_three);
        String scoreMessage = createScoreMessage();
        displayMessage(scoreMessage);
    }

    /**
     * This method check status submit button
     */
    private void submitButton(int submitButtonID) {
        Button hasSubmitButton = findViewById(submitButtonID);
        hasSubmitButton.setEnabled(false);
    }

    /**
     * This method check status edit text.
     */
    private void nameTextInput(int editTextID) {
        EditText hasNameTextInput = findViewById(editTextID);
        if (hasNameTextInput.getText().length() > 0) {
            name = hasNameTextInput.getText().toString();
        } else {
            Toast.makeText(this, "The field with the name should be completed!", Toast.LENGTH_SHORT).show();
        }
        // disable edit text
        hasNameTextInput.setEnabled(false);
    }

    /**
     * This method check status checkbox.
     *
     * @return one points if the checkbox is checked
     */
    private int answerCheckBox(int checkBoxID, boolean isCorrect) {
        CheckBox hasAnswerCheckbox = findViewById(checkBoxID);
        int i = 0;
        if (hasAnswerCheckbox.isChecked() && isCorrect) {
            i = 1;
        }
        hasAnswerCheckbox.setEnabled(false);
        return i;
    }

    /**
     * This method check status radio group.
     *
     * @return one points if the correct radio button is checked
     */
    private int answerRadioGroup(int radioGroupID, int correctRadioButtonID) {
        RadioGroup hasAnswerRadioGroup = findViewById(radioGroupID);
        int i = 0;
        int checkedAnswerRadioGroup = hasAnswerRadioGroup.getCheckedRadioButtonId();
        for (int k = 0; k < hasAnswerRadioGroup.getChildCount(); k++) {
            // disable radio group
            (hasAnswerRadioGroup.getChildAt(k)).setEnabled(false);
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
        resetScoreButton(R.id.score_button);
        resetTextInput(R.id.name_text_input);
        resetCheckBox(R.id.question_one_answer_one);
        resetCheckBox(R.id.question_one_answer_two);
        resetCheckBox(R.id.question_one_answer_three);
        resetCheckBox(R.id.question_two_answer_one);
        resetCheckBox(R.id.question_two_answer_two);
        resetCheckBox(R.id.question_two_answer_three);
        resetCheckBox(R.id.question_three_answer_one);
        resetCheckBox(R.id.question_three_answer_two);
        resetCheckBox(R.id.question_three_answer_three);
        resetRadioGroup(R.id.question_four_answer);
        resetRadioGroup(R.id.question_five_answer);
        resetCheckBox(R.id.question_six_answer_one);
        resetCheckBox(R.id.question_six_answer_two);
        resetCheckBox(R.id.question_six_answer_three);
        resetRadioGroup(R.id.question_seven_answer);
        resetRadioGroup(R.id.question_eight_answer);
        displayMessage("");
        name = "";
        score = 0;
    }

    /**
     * This method reset score button.
     */
    private void resetScoreButton(int resetScoreButtonID) {
        Button hasResetScoreButton = findViewById(resetScoreButtonID);
        hasResetScoreButton.setEnabled(true);
    }

    /**
     * This method reset edit text.
     */
    private void resetTextInput(int editTextID) {
        EditText hasNameTextInput = findViewById(editTextID);
        // clear edit text
        hasNameTextInput.setText("");
        // enable edit text
        hasNameTextInput.setEnabled(true);
    }

    /**
     * This method reset checkbox.
     */
    private void resetCheckBox(int checkBoxID) {
        CheckBox hasAnswerCheckbox = findViewById(checkBoxID);
        // uncheck checkbox
        hasAnswerCheckbox.setChecked(false);
        // enable checkbox
        hasAnswerCheckbox.setEnabled(true);
    }

    /**
     * This method reset radio group.
     */
    private void resetRadioGroup(int radioGroupID) {
        RadioGroup hasAnswerRadioGroup = findViewById(radioGroupID);
        // clear radio group
        hasAnswerRadioGroup.clearCheck();
        // enable radio group
        for (int i = 0; i < hasAnswerRadioGroup.getChildCount(); i++) {
            (hasAnswerRadioGroup.getChildAt(i)).setEnabled(true);
        }
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String scoreMessage) {
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(scoreMessage);
        if (scoreTextView.getText().length() > 0 && score >= 0) {
            scoreTextView.setVisibility(View.VISIBLE);
        }
    }
}
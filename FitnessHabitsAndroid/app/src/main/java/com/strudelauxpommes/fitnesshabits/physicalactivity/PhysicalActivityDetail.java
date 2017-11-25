package com.strudelauxpommes.fitnesshabits.physicalactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.strudelauxpommes.fitnesshabits.R;

public class PhysicalActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout tableActivity = (LinearLayout) findViewById(R.id.table);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        for(int i = 0; i < 3; i++){


            final EditText et = new EditText(this);
            et.setText("");
            final EditText dure = new EditText(this);
            dure.setText("");
            EditText intensive = new EditText(this);
            intensive.setText("");
            Button b = new Button(this);
            b.setText("Dynamic Button");

            TableLayout tl = (TableLayout) findViewById(R.id.table);
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            

            b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            et.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            dure.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            intensive.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            et.setInputType(InputType.TYPE_CLASS_TEXT);
            et.setEms(7);
            et.setImeOptions(EditorInfo.IME_ACTION_DONE);
            et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView view, int actionId, KeyEvent keyEvent) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        return true;
                    }
                    return false;
                }
            });
            et.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    et.getText().clear();
                    return false;
                }
            });

            dure.setInputType(InputType.TYPE_CLASS_NUMBER);
            dure.setEms(4);
            dure.setImeOptions(EditorInfo.IME_ACTION_DONE);
            dure.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView view, int actionId, KeyEvent keyEvent) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        String input = dure.getText().toString();
                        if (input.length() == 1) {
                            String mins = input.substring(0, 1);
                            dure.setText("0:0" + mins);
                            Toast.makeText(getApplicationContext(), "Input = " + input, Toast.LENGTH_SHORT).show();
                        }
                        if (input.length() == 2) {
                            String mins = input.substring(0, 2);
                            dure.setText("0:" + mins);
                            Toast.makeText(getApplicationContext(), "Input = " + input, Toast.LENGTH_SHORT).show();
                        }
                        else if (input.length() == 3) {
                            String hour = input.substring(0, 1);
                            String mins = input.substring(1, 3);
                            dure.setText(hour + ":" + mins);
                            Toast.makeText(getApplicationContext(), "Input = " + input, Toast.LENGTH_SHORT).show();
                        }
                        hideKeyboard(view);
                        return true;
                    }
                    return false;
                }
            });
            dure.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    dure.getText().clear();
                    return false;
                }
            });

            intensive.setEms(2);
            b.setEms(2);


            tr.addView(et);
            tr.addView(dure);
            tr.addView(intensive);
            tr.addView(b);

            /* Add row to TableLayout. */
            //tr.setBackgroundResource(R.drawable.sf_gradient_03);
            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}

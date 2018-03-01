package com.example.owner.homework1318;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=(LinearLayout) (findViewById(R.id.linLayout));
    }

    public void frameOnClick(View view){
        int length=3;
        //tableLayout.dest();
        clearTableFromLinearLayout();
        tableLayout=new TableLayout(this);
        TableLayout.LayoutParams layoutParams=new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        tableLayout.setColumnCollapsed(length,false);
        //setContentView(tableLayout,layoutParams);

        Button [][] buttons=new Button[length][length];
        Resources resources=getResources();
            for (int row=0;row<buttons.length;row++){
                TableRow tableRow = new TableRow(this);
                for(int col=0;col<buttons.length;col++){
                    buttons[row][col]=new Button(this);
                    if(row==0||row==buttons.length-1||col==0||col==buttons.length-1){

                    buttons[row][col].setBackgroundColor(resources.getColor(R.color.red));
                    }
                    buttons[row][col].setText("["+row+"],["+col+"]");
                    tableRow.addView(buttons[row][col]);
                }
                tableLayout.addView(tableRow);
            }
        linearLayout.addView(tableLayout);
    }
    public void diagonalOnClick(View view){
        int length=3;
        clearTableFromLinearLayout();
        tableLayout=new TableLayout(this);
        TableLayout.LayoutParams layoutParams=new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        tableLayout.setColumnCollapsed(length,false);
        //setContentView(tableLayout,layoutParams);

        Button [][] buttons=new Button[length][length];
        Resources resources=getResources();
        for (int row=0;row<buttons.length;row++){
            TableRow tableRow = new TableRow(this);
            for(int col=0;col<buttons.length;col++){
                buttons[row][col]=new Button(this);
                if(row==col || row+col==length-1){

                    buttons[row][col].setBackgroundColor(resources.getColor(R.color.red));
                }
                buttons[row][col].setText("["+row+"],["+col+"]");
                tableRow.addView(buttons[row][col]);
            }
            tableLayout.addView(tableRow);
        }
        linearLayout.addView(tableLayout);
    }
    public void upperTriangleOnClick(View view){
        int length=3;
        clearTableFromLinearLayout();
        tableLayout=new TableLayout(this);
        TableLayout.LayoutParams layoutParams=new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        tableLayout.setColumnCollapsed(length,false);
        //setContentView(tableLayout,layoutParams);

        Button [][] buttons=new Button[length][length];
        Resources resources=getResources();
        for (int row=0;row<buttons.length;row++){
            TableRow tableRow = new TableRow(this);
            for(int col=0;col<buttons.length;col++){
                buttons[row][col]=new Button(this);
                if(row==col || col>row){

                    buttons[row][col].setBackgroundColor(resources.getColor(R.color.red));
                }
                buttons[row][col].setText("["+row+"],["+col+"]");
                tableRow.addView(buttons[row][col]);
            }
            tableLayout.addView(tableRow);

        }
        linearLayout.addView(tableLayout);
    }
    public void lowerTriangleOnClick(View view){
        int length=3;
        clearTableFromLinearLayout();
        tableLayout=new TableLayout(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tableLayout.setColumnCollapsed(length,false);
       // setContentView(tableLayout,layoutParams);

        Button [][] buttons=new Button[length][length];
        Resources resources=getResources();
        for (int row=0;row<buttons.length;row++){
            TableRow tableRow = new TableRow(this);
            for(int col=0;col<buttons.length;col++){
                buttons[row][col]=new Button(this);
                if(row==col || col<row){

                    buttons[row][col].setBackgroundColor(resources.getColor(R.color.red));
                }
                buttons[row][col].setText("["+row+"],["+col+"]");
                tableRow.addView(buttons[row][col]);
            }
            tableLayout.addView(tableRow);
        }
        linearLayout.addView(tableLayout);
    }
    public void clearTableFromLinearLayout(){
        int childCounter=linearLayout.getChildCount();
        for (int i = 0; i < childCounter; i++) {
            View v = linearLayout.getChildAt(i);
            if(v instanceof TableLayout){
                linearLayout.removeView(v);
            }
        }
    }
}

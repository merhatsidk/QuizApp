package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nike = findViewById<CheckBox>(R.id.nike);
        val adidas = findViewById<CheckBox>(R.id.adidas);
        val audi = findViewById<CheckBox>(R.id.audi);

        val rg = findViewById<RadioGroup>(R.id.rg);
        val sub = findViewById<Button>(R.id.btnSub);
        val cancel = findViewById<Button>(R.id.cancel);

        var totalMark = 0;


        cancel.setOnClickListener {
            rg.clearCheck();
            nike.isChecked = false
            adidas.isChecked = false
            audi.isChecked = false
            totalMark = 0;

        }


        sub.setOnClickListener {
            val selectedOption: Int = rg!!.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedOption)
            var year: String = radioButton.text.toString();
            if (year.equals("1969")) {
                totalMark += 50;
            }

            if (nike!!.isChecked) {
                totalMark += 25;
            }
            if (adidas.isChecked) {
                totalMark += 25;
            }
            if (audi.isChecked) {
                totalMark += 0;
            }

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Quiz Results as at " + LocalDate.now().toString())
            builder.setMessage("Congratulations you scored $totalMark %")


            builder.setPositiveButton("Yes") { dialogInterface, _ ->
                dialogInterface.dismiss()
                totalMark = 0;
                finish()
            }

            builder.setNegativeButton("Cancel") { dialogInterface, _ ->
                totalMark = 0;
                dialogInterface.dismiss()
            }

            val dialog: AlertDialog = builder.create();
            dialog.show();
        }
    }
}
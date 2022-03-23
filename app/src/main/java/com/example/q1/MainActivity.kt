package com.example.q1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    if (r1.isChecked == false && r2.isChecked == false && r3.isChecked == false && r4.isChecked == false && r5.isChecked == false) {
        Toast.makeText(this, "กรุณาเลือกกิจกรรม", Toast.LENGTH_SHORT).show()
    } else if (rW.isChecked == false && rM.isChecked == false) {
        Toast.makeText(this, "กรุณาเลือกเพศ", Toast.LENGTH_SHORT).show()
    } else if (eH.text.toString() == "" || eA.text.toString() == "" || eW.text.toString() == "") {
        Toast.makeText(this, "กรุณาใส่ข้อมูลให้ถูกต้อง", Toast.LENGTH_SHORT).show()
    } else {
        var txt1 = eW.text.toString().toDouble()
        var txt2 = (eH.text.toString().toDouble() * 0.01)
        var txt3 = (txt1.toDouble() / Math.pow(txt2.toDouble(), 2.0))
        var txt4 = eA.text.toString().toDouble()

        var m: Double = 0.0
        var n = 0.0
        if (rM.isChecked) {
            m = (66 + (13.7 * rW.text.toString()
                .toDouble()) + (5 * eH.text.toString().toDouble()) - (6.8 * txt4))
        } else if (rW.isChecked) {
            m = (665 + (9.6 * eW.text.toString()
                .toDouble()) + (1.8 * eH.text.toString().toDouble()) - (4.7 * txt4))
        }

        if (r1.isChecked) {
            n = (m.toDouble() * 1.2)
        } else if (r2.isChecked) {
            n = (m.toDouble() * 1.375)
        } else if (r3.isChecked) {
            n = (m.toDouble() * 1.55)
        } else if (r4.isChecked) {
            n = (m.toDouble() * 1.725)
        } else if (r5.isChecked) {
            n = (m.toDouble() * 1.9)
        }

        val i = Intent(this, cal::class.java)
        i.putExtra("txt1", txt3.toString())
        i.putExtra("txt2", m.toInt().toString())
        i.putExtra("txt3", n.toInt().toString())
        startActivity(i)
    }
}
}
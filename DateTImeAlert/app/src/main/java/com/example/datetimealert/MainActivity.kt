package com.example.datetimealert

import androidx.appcompat.app.AppCompatActivity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etJam: EditText
    private lateinit var etTanggal: EditText
    private lateinit var btnJam: ImageButton
    private lateinit var btnTanggal: ImageButton

    private var jam = 0
    private var menit = 0
    private var jam2 = 0
    private var menit2 = 0

    private var tahun = 0
    private var bulan = 0
    private var tanggal = 0
    private var tahun2 = 0
    private var bulan2 = 0
    private var tanggal2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etJam = findViewById(R.id.etJam)
        etTanggal = findViewById(R.id.etTanggal)
        btnJam = findViewById(R.id.btnJam)
        btnTanggal = findViewById(R.id.btnTanggal)

        btnJam.setOnClickListener {
            val calendar = Calendar.getInstance()
            jam = calendar.get(Calendar.HOUR_OF_DAY)
            menit = calendar.get(Calendar.MINUTE)

            val dialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    jam = hourOfDay
                    menit = minute

                    etJam.setText(
                        String.format(
                            Locale.getDefault(),
                            "%d:%d %s",
                            if (jam <= 12) jam else jam - 12,
                            menit,
                            if (jam < 12) "am" else "pm"
                        )
                    )
                },
                jam,
                menit,
                true
            )
            dialog.show()
        }

        etJam.setOnClickListener {
            val calendar = Calendar.getInstance()
            jam2 = calendar.get(Calendar.HOUR_OF_DAY)
            menit2 = calendar.get(Calendar.MINUTE)

            val dialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    jam2 = hourOfDay
                    menit2 = minute

                    etJam.setText(
                        String.format(
                            Locale.getDefault(),
                            "%d:%d %s",
                            if (jam2 <= 12) jam2 else jam2 - 12,
                            menit2,
                            if (jam2 < 12) "am" else "pm"
                        )
                    )
                },
                jam2,
                menit2,
                true
            )
            dialog.show()
        }

        btnTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            tahun = calendar.get(Calendar.YEAR)
            bulan = calendar.get(Calendar.MONTH)
            tanggal = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    tahun = year
                    bulan = month
                    tanggal = dayOfMonth

                    etTanggal.setText("$tanggal - ${bulan + 1} - $tahun")
                },
                tahun,
                bulan,
                tanggal
            )
            dialog.show()
        }

        etTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            tahun2 = calendar.get(Calendar.YEAR)
            bulan2 = calendar.get(Calendar.MONTH)
            tanggal2 = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    tahun2 = year
                    bulan2 = month
                    tanggal2 = dayOfMonth

                    etTanggal.setText("$tanggal2 - ${bulan2 + 1} - $tahun2")
                },
                tahun2,
                bulan2,
                tanggal2
            )
            dialog.show()
        }

        val btnExit: Button = findViewById(R.id.btnExit)

        btnExit.setOnClickListener {
            finish() // Menutup activity saat tombol "exit" ditekan
        }

        btnExit.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Konfirmasi")
            alertDialogBuilder.setMessage("Anda yakin ingin keluar?")
            alertDialogBuilder.setPositiveButton("Ya") { _, _ ->
                finish()
            }
            alertDialogBuilder.setNegativeButton("Tidak") { _, _ ->
                // Do nothing
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}



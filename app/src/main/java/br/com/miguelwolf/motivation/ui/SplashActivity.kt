package br.com.miguelwolf.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.miguelwolf.motivation.R
import br.com.miguelwolf.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        splash_btn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id) {

            R.id.splash_btn -> {

                val name = splash_tv.text.toString()

                if (name != "") {
                    mSecurityPreferences.storeString(SecurityPreferences.NAME, name)
                    startActivity(Intent(this, MainActivity::class.java))

                } else {
                    Toast.makeText(this, getString(R.string.informe_nome), Toast.LENGTH_LONG).show()
                }

            }

        }

    }
}
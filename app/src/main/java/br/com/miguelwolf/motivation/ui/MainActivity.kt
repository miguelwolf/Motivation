package br.com.miguelwolf.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.miguelwolf.motivation.R
import br.com.miguelwolf.motivation.infra.MotivationConstants
import br.com.miguelwolf.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSharedPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSharedPreferences = SecurityPreferences(this)
        main_tv_nome.text = getString(R.string.ola_valor, mSharedPreferences.getString(MotivationConstants.KEY.PERSON_NAME))

        main_btn.setOnClickListener(this)
        main_iv_emoticon.setOnClickListener(this)
        main_iv_loop.setOnClickListener(this)
        main_iv_sunny.setOnClickListener(this)

    }


    private fun handleNewFrase() {


    }

    private fun handleFilter(id: Int) {

        main_iv_emoticon.setColorFilter(resources.getColor(R.color.whiteAA))
        main_iv_loop.setColorFilter(resources.getColor(R.color.whiteAA))
        main_iv_sunny.setColorFilter(resources.getColor(R.color.whiteAA))

        when (id) {

            R.id.main_iv_loop -> {
                main_iv_loop.setColorFilter(resources.getColor(R.color.white))
            }

            R.id.main_iv_emoticon -> {
                main_iv_emoticon.setColorFilter(resources.getColor(R.color.white))
            }

            R.id.main_iv_sunny -> {
                main_iv_sunny.setColorFilter(resources.getColor(R.color.white))
            }

        }
    }

    override fun onClick(v: View) {

        val id = v.id
        val listFilter = listOf(R.id.main_iv_emoticon, R.id.main_iv_loop, R.id.main_iv_sunny)

        if (id == R.id.main_btn) {

        } else if (id in listFilter) {
            handleFilter(id)
        }

    }
}
package com.alejandro.tiendakotlin

import ViewModels.LoginViewModels
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.alejandro.tiendakotlin.databinding.ActivityVerificarPasswordBinding

class VerificarPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_verificar_password)

        val binding = DataBindingUtil.setContentView<ActivityVerificarPasswordBinding>(this, R.layout.activity_verificar_password)

        binding.passwordModel = LoginViewModels(this, null, binding)


        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.colorPrimaryDark)
    }
}
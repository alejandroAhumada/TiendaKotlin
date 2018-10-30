package ViewModels

import Interface.IonClick
import Models.LoginModels
import android.app.Activity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.alejandro.tiendakotlin.R
import com.alejandro.tiendakotlin.databinding.ActivityVerificarEmailBinding

class LoginViewModels(activity : Activity, bindingEmail : ActivityVerificarEmailBinding) : LoginModels(), IonClick {

    private var _activity : Activity? = null
    private var _bindingEmail : ActivityVerificarEmailBinding? = null

    init {
        _activity = activity;
        _bindingEmail = bindingEmail
    }

    override fun onClick(view: View) {
        verificarEmail()
    }

    private fun verificarEmail(){

        var cancel = false
        var focusView: View? = null

        _bindingEmail!!.email.error = null

        if(TextUtils.isEmpty(emailUI.getValue())){
            _bindingEmail!!.email.error = _activity!!.getString(R.string.error_field_required)
            focusView = _bindingEmail!!.email
            cancel = true
        }else if(!isEmailvalid(emailUI.getValue())){
            _bindingEmail!!.email.error = _activity!!.getString(R.string.error_invalid_email)
            focusView = _bindingEmail!!.email
            cancel = true
        }
        if(cancel){
            focusView!!.requestFocus()
        }else{
            Toast.makeText(_activity, emailUI.getValue(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun isEmailvalid(email : String) : Boolean {

        return true
    }
}
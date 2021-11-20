package com.example.digitalfoods.Login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.isVisible
import com.example.digitalfoods.R
import com.example.digitalfoods.Restaurantes.RestaurantesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nomeTV: TextView
    private lateinit var nomeET: EditText

    private lateinit var emailTV: TextView
    private lateinit var emailET: EditText

    private lateinit var senhaTV: TextView
    private lateinit var senhaET: EditText

    private lateinit var confSenhaTV: TextView
    private lateinit var confSenhaET: EditText

    private lateinit var entrar: TextView
    private lateinit var cadastrar: TextView
    private lateinit var title: TextView

    private lateinit var emailError: TextView
    private lateinit var senhaError: TextView

    private lateinit var loginButton: Button

    var loginStatus = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nomeTV = findViewById(R.id.nomeTag)
        nomeET = findViewById(R.id.editTextNome)

        emailTV = findViewById(R.id.emailTag)
        emailET = findViewById(R.id.editTextEmail)

        senhaTV = findViewById(R.id.senhaTag)
        senhaET = findViewById(R.id.editTextSenha)

        confSenhaTV = findViewById(R.id.senha2Tag)
        confSenhaET = findViewById(R.id.editTextSenha2)

        entrar = findViewById(R.id.login)
        cadastrar = findViewById(R.id.cadastrar)
        title = findViewById(R.id.loginTitle)

        emailError = findViewById(R.id.emailError)
        senhaError = findViewById(R.id.senhaError)

        loginButton = findViewById(R.id.loginButton)

        nomeTV.isVisible = false
        nomeET.isVisible = false

        confSenhaTV.isVisible = false
        confSenhaET.isVisible = false

        emailError.isVisible = false
        senhaError.isVisible = false


        entrar.setOnClickListener {
            loginMode(true)
            loginStatus = true
        }

        cadastrar.setOnClickListener {
            loginMode(false)
            loginStatus = false
        }

        loginButton.setOnClickListener{
            validateForm()
        }

        loginMode(true)

    }


    private fun loginMode(loginMode: Boolean){

        entrar.setTextColor(getColor(applicationContext, if(loginMode) R.color.teal_700 else R.color.grey))
        cadastrar.setTextColor(getColor(applicationContext, if(loginMode) R.color.grey else R.color.teal_700))
        loginButton.text = if(loginMode) "Entrar" else "Cadastrar"
        title.text = if(loginMode) "Login" else "Cadastrar"
        nomeTV.isVisible = !loginMode
        nomeET.isVisible = !loginMode
        confSenhaTV.isVisible = !loginMode
        confSenhaET.isVisible = !loginMode

    }


    private fun validateForm(){

        val emailOk: Boolean
        var senhaOK = false
        val confSenhaOK: Boolean

        if(!emailET.text.contains("@") || !emailET.text.contains(".")){
            emailError.isVisible = true
            emailOk = false
        }else{
            emailError.isVisible = false
            emailOk = true
        }

        if(loginStatus){  //Login

            if(senhaET.text.toString() == ""){
                senhaError.isVisible = true
            }else{
                senhaError.isVisible = false
                senhaOK = true
            }

            if(senhaOK && emailOk){
                val intent = Intent(this, RestaurantesActivity::class.java)
                startActivity(intent)
                //this.finish()
            }


        }else{ //Cadastro

            if((senhaET.text.toString() != confSenhaET.text.toString()) || senhaET.text.toString() == ""){
                senhaError.isVisible = true
                senhaOK = false
                confSenhaOK = false
            }else{
                senhaError.isVisible = false
                senhaOK = true
                confSenhaOK = true
            }

            if(senhaOK && emailOk && confSenhaOK){
                val intent = Intent(this, RestaurantesActivity::class.java)
                startActivity(intent)
                //this.finish()
            }

        }

    }


}
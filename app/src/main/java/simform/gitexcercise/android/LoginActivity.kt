package simform.gitexcercise.android

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import simform.gitexcercise.android.databinding.ActivityLoginBinding
import simform.gitexcercise.android.utils.Validator
import simform.gitexcercise.android.utils.ValidityType

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() = with(binding) {
        tvSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegistrationActivity::class.java))
        }
        tvForgotPass.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }
        buttonLogin.setOnClickListener {
            val validityType = Validator.isLoginCredentialValid(
                etUserName.text.toString(),
                etUserPassword.text.toString()
            )
            if (validityType is ValidityType.Valid) {
                val intent = Intent(this@LoginActivity, ProfileActivity::class.java).apply {
                    putExtra(IntentKeys.KEY_USER_NAME.name, etUserName.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    resources.getString(validityType.resId),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
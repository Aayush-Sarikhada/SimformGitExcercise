package simform.gitexcercise.android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import simform.gitexcercise.android.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        setupOnClickListeners()
    }

    private fun setupViews() = with(binding) {
        etUserGreeting.setText(ProfileActivity.greeting)
    }

    private fun setupOnClickListeners() = with(binding) {
        buttonSave.setOnClickListener {
            val newGreeting = etUserGreeting.text.toString()
            val toastMsg = if (validate(newGreeting)) {
                ProfileActivity.greeting = newGreeting
                finish()
                getString(R.string.msg_greeting_saved)
            } else {
                getString(R.string.err_invalid_greeting)
            }
            Toast.makeText(
                this@EditProfileActivity,
                toastMsg,
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    private fun validate(newGreeting: String) = with(newGreeting) {
        isNotBlank() && isNotEmpty()
    }

}
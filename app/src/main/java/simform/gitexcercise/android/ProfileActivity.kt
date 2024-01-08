package simform.gitexcercise.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import simform.gitexcercise.android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupOnClickListener()
    }

    override fun onStart() {
        super.onStart()
        setupGreeting()
    }

    @SuppressLint("SetTextI18n")
    private fun setupGreeting() = with(binding) {
        val greetingMsg =
            greeting + intent.getStringExtra(IntentKeys.KEY_USER_NAME.name)
        tvUserGreet.text = greetingMsg
    }

    private fun setupOnClickListener() = with(binding) {
        buttonSave.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, EditProfileActivity::class.java))
        }
    }

    companion object {
        var greeting = "Welcome, "
    }
}
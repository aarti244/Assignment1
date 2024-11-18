package com.example.signupform


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.signupform.R

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameField: EditText = findViewById(R.id.editTextName)
        val contactField: EditText = findViewById(R.id.editTextContact)
        val emailField: EditText = findViewById(R.id.editTextEmail)
        val passwordField: EditText = findViewById(R.id.editTextPassword)
        val addressField: EditText = findViewById(R.id.editTextAddress)
        val submitButton: Button = findViewById(R.id.buttonSubmit)

        submitButton.setOnClickListener {
            var isValid = true

            // Validate Name
            if (TextUtils.isEmpty(nameField.text.toString())) {
                nameField.error = "Name cannot be empty"
                isValid = false
            }

            // Validate Contact
            val contact = contactField.text.toString()
            if (TextUtils.isEmpty(contact)) {
                contactField.error = "Contact cannot be empty"
                isValid = false
            } else if (contact.length != 10 || !TextUtils.isDigitsOnly(contact)) {
                contactField.error = "Enter a valid 10-digit phone number"
                isValid = false
            }

            // Validate Email
            val email = emailField.text.toString()
            if (TextUtils.isEmpty(email)) {
                emailField.error = "Email cannot be empty"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.error = "Enter a valid email address"
                isValid = false
            }

            // Validate Password
            if (TextUtils.isEmpty(passwordField.text.toString())) {
                passwordField.error = "Password cannot be empty"
                isValid = false
            }

            // Validate Address
            if (TextUtils.isEmpty(addressField.text.toString())) {
                addressField.error = "Address cannot be empty"
                isValid = false
            }

            // Show success message
            if (isValid) {
                // Proceed with form submission
                // For now, just show a success message
                passwordField.error = null
                // For simplicity, you can show a Toast or navigate to another activity
            }
        }
    }
}

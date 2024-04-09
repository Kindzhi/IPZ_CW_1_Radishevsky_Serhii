import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null
    var textViewResult: TextView? = null
    var buttonSignIn: Button? = null
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        textViewResult = findViewById(R.id.textViewResult)
        buttonSignIn = findViewById(R.id.buttonSignIn)
        buttonSignIn!!.setOnClickListener { signIn() }
    }

    private fun signIn() {
        val email = editTextEmail!!.getText().toString().trim { it <= ' ' }
        val password = editTextPassword!!.getText().toString().trim { it <= ' ' }
        if (email.isEmpty() || password.isEmpty()) {
            if (email.isEmpty()) {
                editTextEmail!!.error = "Email is required"
            }
            if (password.isEmpty()) {
                editTextPassword!!.error = "Password is required"
            }
            textViewResult!!.text = "Authorization Error"
        } else {
            textViewResult!!.text = "Successful authorization"
        }
    }
}
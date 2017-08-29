package io.github.adsuper.androido

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val notificationUtils = NotificationUtils()
//        notificationUtils.showNotification(this)
        val notificationOreo = NotificationOreo()
        notificationOreo.showNotification(this)

btn.setOnClickListener{
    view ->
    startActivity(Intent(this,PIPActivity::class.java))
}

    }


}

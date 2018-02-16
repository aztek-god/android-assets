package dv.serg.android_assets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dv.serg.lib.android.context.v4.toastLong

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastLong("toast")
    }
}

package dv.serg.lib.android.context

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast

// todo make version for v7, v4
fun Activity.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toastShort(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toastLong(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}

fun Activity.saveToPreferences(action: (SharedPreferences.Editor) -> Unit) {
    val editor: SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(this).edit()
    action.invoke(editor)
    editor.apply()
}

fun Fragment.saveToPreferences(action: (SharedPreferences.Editor) -> Unit) {
    val editor: SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(activity).edit()
    action.invoke(editor)
    editor.apply()
}

fun Activity.addFragment(fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager.beginTransaction().add(fragmentInstance, tag).commit()
}

fun Activity.addFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager.beginTransaction().add(containerId, fragmentInstance, tag).commit()
}

fun Activity.replaceFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager.beginTransaction().replace(containerId, fragmentInstance, tag).commit()
}

fun Fragment.addFragment(fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager.beginTransaction().add(fragmentInstance, tag).commit()
}

fun Fragment.addFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager.beginTransaction().add(containerId, fragmentInstance, tag).commit()
}

fun Fragment.replaceFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager.beginTransaction().replace(containerId, fragmentInstance, tag).commit()
}

fun Activity.startActivity(targetActivity: Class<Activity>, params: Pair<String, Bundle>) {
    val intent = Intent(this, targetActivity)
    intent.putExtra(params.first, params.second)
    startActivity(intent)
}

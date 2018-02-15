package dv.serg.lib.android.context.v4

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

fun AppCompatActivity.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toastShort(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toastLong(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.saveToPreferences(action: (SharedPreferences.Editor) -> Unit) {
    val editor: SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(this).edit()
    action.invoke(editor)
    editor.apply()
}

fun Fragment.saveToPreferences(action: (SharedPreferences.Editor) -> Unit) {
    val editor: SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(activity).edit()
    action.invoke(editor)
    editor.apply()
}

fun AppCompatActivity.addFragment(fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    supportFragmentManager.beginTransaction().add(fragmentInstance, tag).commit()
}

fun AppCompatActivity.addFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }

    supportFragmentManager.beginTransaction().add(containerId, fragmentInstance, tag).commit()
}

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    supportFragmentManager.beginTransaction().replace(containerId, fragmentInstance, tag).commit()
}

fun Fragment.addFragment(fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager?.beginTransaction()?.add(fragmentInstance, tag)?.commit()
}

fun Fragment.addFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager?.beginTransaction()?.add(containerId, fragmentInstance, tag)?.commit()
}

fun Fragment.replaceFragment(containerId: Int, fragment: Class<Fragment>, tag: String? = null, arguments: Bundle? = null) {
    val fragmentInstance: Fragment = fragment.newInstance()
    if (arguments != null) {
        fragmentInstance.arguments = arguments
    }
    fragmentManager?.beginTransaction()?.replace(containerId, fragmentInstance, tag)?.commit()
}
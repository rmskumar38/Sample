package com.example.androidassignment.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.example.androidassignment.R

open class BaseActivity :AppCompatActivity() {

    private var alertDialog: AppCompatDialog? = null
    protected fun showProgressBar() {
        if (alertDialog == null) {
            alertDialog = AppCompatDialog(this, R.style.ProgressBarStyle)
            alertDialog?.setContentView(R.layout.layout_progress_bar)
            alertDialog?.setCancelable(false)
        }

        if (alertDialog != null && !alertDialog!!.isShowing)
            alertDialog?.show()
    }

    fun hideProgressBar() {
        if (alertDialog != null && alertDialog!!.isShowing) alertDialog?.dismiss()
    }

    /**
     * Method for launching the new Activity
     * @param destActivity contains the activity which is to be launched
     * @param bundle contains the date which is to be sent
     * @param clearTop its a flag which specifies whether to clear activity stack or not
     * @param closeCallerActivity a flag which specifies whether to
     * finish the caller activity or not
     */
    protected fun launchActivity(
        destActivity: Class<*>,
        bundle: Bundle? = null,
        clearTop: Boolean = false,
        closeCallerActivity: Boolean = false
    ) {
        val intent = Intent(applicationContext, destActivity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        if (clearTop) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
        if (closeCallerActivity) {
            this.finish()
        }
    }

    protected fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
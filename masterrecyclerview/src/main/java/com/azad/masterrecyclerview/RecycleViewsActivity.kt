package com.azad.masterrecyclerview

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azad.masterrecyclerview.recyclerviewfragments.SimpleUserListFragment
import com.azad.networking.interfaces.ActionPerformer

class RecycleViewsActivity : AppCompatActivity(), ActionPerformer {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_views)
        startFragment()
        Toast.makeText( this@RecycleViewsActivity, "RecycleViewsActivity", Toast.LENGTH_SHORT).show()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun startFragment(){
        performActionFromNetwork()
        // Create an instance of the fragment you want to display
        val userListFragment = SimpleUserListFragment()

        // Get the FragmentManager and start a transaction
        supportFragmentManager.beginTransaction()
            // Replace any existing fragment in the 'fragment_container' with your new fragment
            // The first argument is the ID of the container in your layout
            // The second argument is the fragment instance
            .replace(R.id.fragment_container, userListFragment)
            // (Optional) Add the transaction to the back stack.
            // This allows the user to navigate back to the previous state (e.g., an empty container)
            // by pressing the back button.
            .addToBackStack(null) // 'null' means no specific name for this transaction
            // Commit the transaction to apply the changes
            .commit()
    }

    // Place this function inside your Fragment/Activity or in a utility object
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        } else {
            // For older Android versions
            @Suppress("DEPRECATION")
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            @Suppress("DEPRECATION")
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun performActionFromNetwork() {
        showToast("Action performed from Network")
    }

}
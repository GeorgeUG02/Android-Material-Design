package geekbrains.material.ui.picture

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import geekbrains.material.CircuitActivity
import geekbrains.material.R
import geekbrains.material.ui.recycler.RecyclerActivity
import geekbrains.material.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, SettingsFragment())?.commitAllowingStateLoss()
                }
                R.id.navigation_two -> {
                    val intent = Intent(requireActivity(),CircuitActivity::class.java)
                    startActivity(intent)
                }
                R.id.navigation_three -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            RecyclerActivity::class.java
                        )
                    )
                }
            }
            dismiss()

            true
        }
    }
}

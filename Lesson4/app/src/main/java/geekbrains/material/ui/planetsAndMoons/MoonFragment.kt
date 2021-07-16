package geekbrains.material.ui.planetsAndMoons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import geekbrains.material.R
import kotlinx.android.synthetic.main.fragment_moon.*

class MoonFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_moon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val url="https://www.nasa.gov/sites/default/files/thumbnails/image/the-moon-near-side.en_.jpg"
        imageMoon.load(url){}
    }
}
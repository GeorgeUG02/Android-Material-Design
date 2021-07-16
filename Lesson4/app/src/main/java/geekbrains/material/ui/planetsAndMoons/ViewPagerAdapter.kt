package geekbrains.material.ui.planetsAndMoons

import geekbrains.material.ui.picture.PictureOfTheDayFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val PICTURE_OF_THE_DAY_FRAGMENT = 0
private const val EARTH_FRAGMENT = 1
private const val MOON_FRAGMENT = 2

class ViewPagerAdapter(private val fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(PictureOfTheDayFragment(), EarthFragment(), MoonFragment())

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> fragments[PICTURE_OF_THE_DAY_FRAGMENT]
            1 -> fragments[EARTH_FRAGMENT]
            2 -> fragments[MOON_FRAGMENT]
            else -> fragments[PICTURE_OF_THE_DAY_FRAGMENT]
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "Picture of the day"
            1->return "Earth"
            2->return "Moon"
            else -> return "Picture of the day"
        }
    }
}

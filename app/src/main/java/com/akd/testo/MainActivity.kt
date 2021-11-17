package com.akd.testo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


private lateinit var titleName:String;
private lateinit var tabNameCatalog:String;
private lateinit var tabNameFeed:String;
private lateinit var tabNameCamera:String;
private lateinit var tabNameAbout:String;



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleName = getString(R.string.title_name)
        supportActionBar?.title = titleName

        tabNameCatalog = getString(R.string.tab_catalog)
        tabNameFeed = getString(R.string.tab_feed)
        tabNameCamera = getString(R.string.tab_RGB_camera)
        tabNameAbout = getString(R.string.tab_about)


        val adapter = MyAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = adapter // устанавливаем адаптер
        viewPager.currentItem = 1 // выводим второй экран
        val tabs: TabLayout = findViewById(R.id.tabLayout)
        tabs.setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

    class MyAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val tabTitles = arrayOf(tabNameCatalog, tabNameFeed, tabNameCamera, tabNameAbout)
        override fun getCount(): Int {
            return 4
        }
        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles.get(position)
        }
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> FragmentCatalog()
                1 -> FragmentFeed()
                2 -> FragmentCamera()
                3 -> FragmentAbout()
                else -> FragmentFeed()
            }
        }

    }

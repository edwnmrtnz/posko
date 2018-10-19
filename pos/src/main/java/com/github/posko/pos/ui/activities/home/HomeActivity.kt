package com.github.posko.pos.ui.activities.home

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.github.posko.pos.R
import com.github.posko.pos.ui.activities.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var homeFragment: HomeFragment

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var tvAppVersion : AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupToolbar()

        bindView()

        initDrawer()

        loadFragment()
    }

    private fun bindView() {
        tvAppVersion = findViewById(R.id.tv_app_version)
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Home"
    }

    private fun loadFragment() {
        var fragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
        if(fragment == null) {
            fragment = homeFragment
            replaceFragmentInActivity(supportFragmentManager, fragment, R.id.contentFrame)
        }
    }

    private fun initDrawer() {
        drawerLayout                        = findViewById(R.id.drawer_layout)
        val navigationView : NavigationView = findViewById(R.id.nav_view)
        var hView : View = navigationView.getHeaderView(0)
        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()

        tvAppVersion.text = "v0.0.0.0"

        navigationView.setNavigationItemSelectedListener(this as NavigationView.OnNavigationItemSelectedListener)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }
}

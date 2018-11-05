package com.github.posko.pos.ui.activities.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.github.posko.core.domain.interactor.variant.FetchVariantsUseCase
import com.github.posko.core.domain.model.EmptyParam
import com.github.posko.pos.R
import com.github.posko.pos.tools.KeyboardTools
import com.github.posko.pos.ui.activities.BaseActivity
import com.google.android.material.navigation.NavigationView
import javax.inject.Inject

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var homeFragment: HomeFragment

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var tvAppVersion : AppCompatTextView
    lateinit var etSearchView : AppCompatEditText


    @Inject lateinit var fetchVariantsUseCase: FetchVariantsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupToolbar()

        initDrawer()

        bindView()

        loadFragment()

        fetchVariantsUseCase.execute(EmptyParam()) {

        }
    }

    private fun bindView() {
        etSearchView    = findViewById(R.id.et_search_view)

        etSearchView.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                KeyboardTools.hideKeyboard(this, etSearchView)
                etSearchView.clearFocus()
            }
            false
        }
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.requestFocus()
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

        tvAppVersion = findViewById(R.id.tv_app_version)

        tvAppVersion.text = "v0.0.0.0"

        navigationView.setNavigationItemSelectedListener(this as NavigationView.OnNavigationItemSelectedListener)
        drawerLayout.requestFocus()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

package com.ruiskas.jurassicworldtoy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ruiskas.jurassicworldtoy.ui.base.extensions.hideSystemUI
import com.ruiskas.jurassicworldtoy.viewmodel.RootViewModel
import com.ruiskas.jurassicworldtoy.R
import com.ruiskas.jurassicworldtoy.databinding.ActivityRootBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RootActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRootBinding

    private val rootViewModel by viewModel<RootViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideSystemUI()

        rootViewModel.loadConfiguration()
    }
}

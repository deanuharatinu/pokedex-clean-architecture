package com.deanuharatinu.favorite.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.deanuharatinu.favorite.databinding.FragmentFavoritePokemonBinding
import com.deanuharatinu.favorite.presentation.viewmodel.FavoritePokemonViewModel

class FavoritePokemonFragment : Fragment() {
    private var _binding: FragmentFavoritePokemonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this)[FavoritePokemonViewModel::class.java]

        _binding =
            FragmentFavoritePokemonBinding.inflate(
                inflater,
                container,
                false
            )
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavoritePokemonFragment()
    }
}
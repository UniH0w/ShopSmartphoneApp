package com.example.shopsmartphone.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentAccountBinding

class FragmentAccount: BaseFragment() {
    override val showBottomNavigationView = true
    private lateinit var binding: FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater,container,false)

        val preferencesStorage =PreferencesStorage(requireContext())
        binding.textViewFirstName.text = preferencesStorage.readFirstNamePreference()
        binding.textViewLastName.text = preferencesStorage.readLastNamePreference()
        binding.textViewLogin.text = preferencesStorage.readEmailPreference()

        binding.imageButtonToPassword.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentAccount2_to_fragmentChangePassword)
        }
        binding.imageButtonToUser.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentAccount2_to_fragmentChangeUser)
        }
        binding.exitButtonAccount.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentAccount2_to_fragmenLogin)
                preferencesStorage.deleteLoginPreference()
                preferencesStorage.deleteEmailPreference()
                preferencesStorage.deleteFirsNamePreference()
                preferencesStorage.deleteLastNamePreference()
        }
        return binding.root
    }
}
package com.example.fusha.fragments

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
   private val binding by lazy {FragmentLoginBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


          binding.btnMalumot.setOnClickListener {
              findNavController().navigate(R.id.action_loginFragment_to_infoFragment)
          }

        binding.ixtiyoriy.setOnClickListener {
            val phoneNumber = "+998 77 207 83 85"

            AlertDialog.Builder(requireContext())
                .setTitle("Meni Qollab quvvatlaganingiz uchun rahmat ")
                .setMessage(" Savol va Takliflar va Ixtiyoriy Yordam Puli yuborish uchun telefon raqamim:\n$phoneNumber")
                .setPositiveButton("Nusxalash") { _, _ ->
                    val clipboard = requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Phone Number", phoneNumber)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(requireContext(), "Telefon raqam nusxalandi 📋", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Yopish", null)
                .show()
        }



        return binding.root
    }

}
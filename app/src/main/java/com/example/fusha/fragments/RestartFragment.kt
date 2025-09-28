package com.example.fusha.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fusha.databinding.FragmentRestartBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class RestartFragment : Fragment() {

    private var _binding: FragmentRestartBinding? = null
    private val binding get() = _binding!!

    // --- API modeli ---
    data class LibreResponse(val translatedText: String)

    interface LibreApi {
        @FormUrlEncoded
        @POST("translate")
        fun translate(
            @Field("q") q: String,
            @Field("source") source: String,
            @Field("target") target: String,
            @Field("format") format: String = "text"
        ): Call<LibreResponse>
    }

    private val api by lazy {
        Retrofit.Builder()
            .baseUrl("https://libretranslate.de/") // public server
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibreApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestartBinding.inflate(inflater, container, false)

        binding.btnTranslate.setOnClickListener {
            val input = binding.editTextInput.text.toString()
            if (input.isNotEmpty()) {
                translateText(input, "uz", "ar") // Uzbek -> Arabic
            }
        }

        return binding.root
    }

    private fun translateText(text: String, source: String, target: String) {
        api.translate(text, source, target).enqueue(object : Callback<LibreResponse> {
            override fun onResponse(
                call: Call<LibreResponse>,
                response: Response<LibreResponse>
            ) {
                if (response.isSuccessful) {
                    binding.textViewResult.text = response.body()?.translatedText ?: "Natija yo‘q"
                } else {
                    binding.textViewResult.text = "Xato: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<LibreResponse>, t: Throwable) {
                binding.textViewResult.text = "Xatolik: ${t.message}"
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

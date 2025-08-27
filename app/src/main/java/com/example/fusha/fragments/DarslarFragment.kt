package com.example.fusha.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fusha.R
import com.example.fusha.R.id.action_darslarFragment_to_dalFragment
import com.example.fusha.R.id.action_darslarFragment_to_doodFragment
import com.example.fusha.R.id.action_darslarFragment_to_muammoTestFragment
import com.example.fusha.R.id.action_darslarFragment_to_test3Fragment
import com.example.fusha.R.id.action_darslarFragment_to_zaaalFragment
import com.example.fusha.R.id.action_darslarFragment_to_zooFragment
import com.example.fusha.adapter.MyAdapter
import com.example.fusha.databinding.Cardview2Binding
import com.example.fusha.databinding.Cardview3Binding
import com.example.fusha.databinding.CardviewBinding
import com.example.fusha.databinding.FragmentDarslarBinding
import com.example.fusha.models.Mydata

@Suppress("DUPLICATE_LABEL_IN_WHEN")
class DarslarFragment : Fragment() {

    private var _binding: FragmentDarslarBinding? = null
    private val binding get() = _binding!!
    private var currentSection = -1

    private val dataList = listOf(
        Mydata("Harflar", "10/10"), Mydata("Sinov", "10/10"), Mydata("Harf tuzilishi", "10/10"),
        Mydata("Alif-ا / Ro-ر", "10/10"), Mydata("Zay-ز", "10/10"), Mydata("Miym-م", "10/10"),
        Mydata("Taa-ت","10/10"),
        Mydata("Nuun-ن", "10/10"), Mydata("Yaa-ي", "10/10"), Mydata("Test", "10/10"),
        Mydata("Baa-ب", "10/10"), Mydata("Kaaf-ك", "10/10"),   Mydata("Laam-ل", "10/10"), Mydata("Waaw-و", "10/10"),
        Mydata("Ha-ه", "10/10"), Mydata("Faa-ف", "10/10"), Mydata("Test", "10/10"),
        Mydata("Qoof-ق","10/10"),
        Mydata("Shiyn-ش", "10/10"), Mydata("Siyn-س", "10/10"), Mydata("Tha-ث", "10/10"),
        Mydata("Sood-ص", "10/10"), Mydata("Too-ط","10/10"), Mydata("Test", "10/10"), Mydata("Jiym-ج", "10/10"),
        Mydata("Xoo-خ", "10/10"), Mydata("Haa-ح", "10/10"), Mydata("G’oo-غ", "10/10"),
        Mydata("Âyn-ع","10/10"),
        Mydata("Daal-د", "10/10"), Mydata("Test", "10/10"), Mydata("Ďood-ض", "10/10"),
        Mydata("Źaal-ذ", "10/10"), Mydata("Žoo-ظ", "10/10"),


    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDarslarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recycle.layoutManager = layoutManager

        val adapter = MyAdapter(dataList) { item, position ->
            markLessonAsSeen(position)
            updateProgressBar()

            when (position) {
                0 -> findNavController().navigate(R.id.action_darslarFragment_to_harflarFragment)
                1 -> findNavController().navigate(R.id.action_darslarFragment_to_sinovFragment)
                2 -> findNavController().navigate(R.id.action_darslarFragment_to_harflartuzilishi)
                3 -> findNavController().navigate(R.id.action_darslarFragment_to_sozlarningoqilishiFragment)
                4 -> findNavController().navigate(R.id.action_darslarFragment_to_ZAFragment)
                5 -> findNavController().navigate(R.id.action_darslarFragment_to_mimFragment)
                6 -> findNavController().navigate(R.id.action_darslarFragment_to_TAFragment)
                7 -> findNavController().navigate(R.id.action_darslarFragment_to_naFragment)
                8 -> findNavController().navigate(R.id.action_darslarFragment_to_yaFragment)
                9 -> findNavController().navigate(R.id.action_darslarFragment_to_boshlangichTestFragment)
                10 -> findNavController().navigate(R.id.action_darslarFragment_to_baFragment)
                11 -> findNavController().navigate(R.id.action_darslarFragment_to_kaFragment)
                12 -> findNavController().navigate(R.id.action_darslarFragment_to_lamFragment)
                13 -> findNavController().navigate(R.id.action_darslarFragment_to_wawFragment)
                14 -> findNavController().navigate(R.id.action_darslarFragment_to_ymHaFragment)
                15 -> findNavController().navigate(R.id.action_darslarFragment_to_faFragment)
                16 -> findNavController().navigate(action_darslarFragment_to_muammoTestFragment)
                17 -> findNavController().navigate(R.id.action_darslarFragment_to_qoFragment)
                18 -> findNavController().navigate(R.id.action_darslarFragment_to_shiynFragment)
                19 -> findNavController().navigate(R.id.action_darslarFragment_to_siynFragment)
                20 -> findNavController().navigate(R.id.action_darslarFragment_to_thinFragment)
                21 -> findNavController().navigate(R.id.action_darslarFragment_to_sodFragment)
                22 -> findNavController().navigate(R.id.action_darslarFragment_to_toFragment)
                23 -> findNavController().navigate(R.id.action_darslarFragment_to_ortaTestFragment)
                24 -> findNavController().navigate(R.id.action_darslarFragment_to_jimFragment)
                25 -> findNavController().navigate(R.id.action_darslarFragment_to_xooFragment)
                26 -> findNavController().navigate(R.id.action_darslarFragment_to_haaFragment)
                27 -> findNavController().navigate(R.id.action_darslarFragment_to_gooFragment)
                28 -> findNavController().navigate(R.id.action_darslarFragment_to_aynFragment)
                29 -> findNavController().navigate(action_darslarFragment_to_dalFragment)
                30 -> findNavController().navigate(action_darslarFragment_to_test3Fragment)
                31 -> findNavController().navigate(action_darslarFragment_to_doodFragment)
                32 -> findNavController().navigate(action_darslarFragment_to_zaaalFragment)
                33 -> findNavController().navigate(action_darslarFragment_to_zooFragment)

                else -> Toast.makeText(requireContext(), "${item.title} ochilmoqda...", Toast.LENGTH_SHORT).show()
            }
        }

        binding.recycle.adapter = adapter
        updateProgressBar()
        updateClassHeader(1)

        binding.recycle.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                val firstVisible = layoutManager.findFirstVisibleItemPosition()

                // Hozircha faqat mavjud bo'lgan section diapazonlarini ishlatamiz
                val section = when (firstVisible) {
                    in 0..33 -> 1
                    else -> 1 // boshqa hollarda default qiymat
                }

                // Section o'zgarganda updateClassHeader chaqiramiz
                if (section != currentSection) {
                    currentSection = section
                    // Adapterdagi header va purple type kodlari commentga olinganligi sababli,
                    // bu funksiya faqat ishlayotgan qismlarini yangilaydi
                    updateClassHeader(section)
                }
            }
        })

    }


    override fun onResume() {
        super.onResume()
        updateProgressBar()
    }


    private fun updateClassHeader(section: Int) {
        val container = binding.classContainer
        container.removeAllViews()

        val headerView = when (section) {
            1 -> {
                val headerBinding = CardviewBinding.inflate(layoutInflater, container, false)
                headerBinding.classTitle.text = "1-Bosqich"
                headerBinding.root
            }
            2 -> {
                val headerBinding = Cardview2Binding.inflate(layoutInflater, container, false)
                headerBinding.classTitle.text = "2-Bosqich"
                headerBinding.root
            }
            else -> {
                val headerBinding = Cardview3Binding.inflate(layoutInflater, container, false)
                headerBinding.classTitle.text = "3-Bosqich"
                headerBinding.root
            }
        }

        container.addView(headerView)
    }

    private fun markLessonAsSeen(id: Int) {
        val prefs = requireContext().getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        if (!prefs.getBoolean("lesson_$id", false)) {
            prefs.edit().putBoolean("lesson_$id", true).apply()
        }
    }

    private fun isLessonSeen(id: Int): Boolean {
        val prefs = requireContext().getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        return prefs.getBoolean("lesson_$id", false)
    }

    private fun getSeenLessonsCount(): Int {
        return dataList.indices.count { isLessonSeen(it) }
    }

    private fun updateProgressBar() {
        val total = dataList.size
        val seen = getSeenLessonsCount()
        val percent = if (total == 0) 0 else (seen * 100 / total)

        binding.progressBar.progress = percent
        binding.progressText.text = "$seen/$total"

        if (seen == total) {
            Toast.makeText(requireContext(), "Barcha darslar bajarildi! Progress 0 ga tushdi.", Toast.LENGTH_SHORT).show()
            resetProgress()
        }
    }

    private fun resetProgress() {
        val prefs = requireContext().getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        dataList.indices.forEach {
            editor.remove("lesson_$it")
        }
        editor.apply()

        // Progress bar and text reset
        binding.progressBar.progress = 0
        binding.progressText.text = "0/${dataList.size} dars bajarildi"
    }

    private fun showCompletionDialog() {
        val dialog = android.app.AlertDialog.Builder(requireContext())
            .setTitle("🎉 Tabriklaymiz!")
            .setMessage("Siz barcha darslarni o‘zlashtirdingiz.")
            .setPositiveButton("Yopish") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()
        dialog.show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

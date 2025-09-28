package com.example.fusha.mad_chozish

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSozlarBinding
import com.example.fusha.databinding.Mad2Binding
import com.example.fusha.databinding.MadTashdidBshBinding

@Suppress("DUPLICATE_LABEL_IN_WHEN")
class SozlarFragment : Fragment() {

    private var _binding: FragmentSozlarBinding? = null
    private val binding get() = _binding!!

    private var currentSection = -1

    // 🔹 Mad darslari (5 ta)
    private val madLessons = listOf(
        MyData2("1-Dars Madd Nima?", "10/10"),
        MyData2("2-Dars Madd Tabi'iy", "10/10"),
        MyData2("3-Dars Mad Muttasil va Mad Munfasil", "10/10"),
        MyData2("4-Dars Mad Badal", "10/10"),
        MyData2("5-Dars Madlar yozilishi", "10/10")
    )

    // 🔹 Tashdid darslari (3 ta)
    private val tashdidLessons = listOf(
        MyData2("1-Dars Tashdid Nima?", "10/10"),
        MyData2("2-Dars Tashdid", "10/10"),
        MyData2("3-Dars Tashdid", "10/10")
    )

    // 🔹 Umumiy ro‘yxat
    private val dataList = madLessons + tashdidLessons

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSozlarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recycle2.layoutManager = layoutManager

        val adapter = Adapter2(dataList) { _, position ->
            markLessonAsSeen(position)
            updateProgressBar()

            when (position) {
                // 🔹 Mad bo‘limi
                0 -> findNavController().navigate(R.id.action_sozlarFragment_to_birFragment)
                1 -> findNavController().navigate(R.id.action_sozlarFragment_to_ikkiFragment)
                2 -> findNavController().navigate(R.id.action_sozlarFragment_to_uchFragment)
                3 -> findNavController().navigate(R.id.action_sozlarFragment_to_tortFragment)
                4 -> findNavController().navigate(R.id.action_sozlarFragment_to_beshFragment)

                // 🔹 Tashdid bo‘limi
                5 -> findNavController().navigate(R.id.action_sozlarFragment_to_tashdid1Fragment)
                6 -> findNavController().navigate(R.id.action_sozlarFragment_to_tashdid2Fragment)
                7 -> findNavController().navigate(R.id.action_sozlarFragment_to_tashdid3Fragment)
            }
        }

        binding.recycle2.adapter = adapter
        updateProgressBar()
        updateClassHeader(1)

        // 🔹 Scroll paytida qaysi bo‘limda ekanini tekshirish
        binding.recycle2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                val firstVisible = layoutManager.findFirstVisibleItemPosition()
                val section = if (firstVisible in madLessons.indices) 1 else 2

                if (section != currentSection) {
                    currentSection = section
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
        val container = binding.classContainer2
        container.removeAllViews()

        val headerView: View = when (section) {
            1 -> {
                val headerBinding = Mad2Binding.inflate(layoutInflater, container, false)
                headerBinding.classTitle2.text = "Mad Darslari"
                headerBinding.root
            }
            2 -> {
                val headerBinding = MadTashdidBshBinding.inflate(layoutInflater, container, false)
                headerBinding.classTitle.text = "Tashdid Darslari"
                headerBinding.root
            }
            else -> throw IllegalArgumentException("Noto‘g‘ri section qiymati: $section")
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

        binding.progressBar2.progress = percent
        binding.progressText2.text = "$seen/$total"

        if (seen == total) {
            Toast.makeText(requireContext(), "🎉 Barcha darslar tugadi!", Toast.LENGTH_SHORT).show()
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

        binding.progressBar2.progress = 0
        binding.progressText2.text = "0/${dataList.size} dars bajarildi"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

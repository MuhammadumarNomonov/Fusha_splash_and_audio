package com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi

import android.content.Context
import androidx.core.content.edit

object LessonUtils {
    fun markLessonAsSeen(context: Context, id: Int) {
        val prefs = context.getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        if (!prefs.getBoolean("lesson_$id", false)) {
            prefs.edit { putBoolean("lesson_$id", true) }
        }
    }
}
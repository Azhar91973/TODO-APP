package com.example.todoapp.Activity

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.example.todoapp.R

object UpdateDialog {
    @SuppressLint("SuspiciousIndentation")
    fun showDialog(context: Context, prevText: String, onTextUpdated: (String) -> Unit) {
        val builder = AlertDialog.Builder(context)

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.update_dialog, null)

        val txttodo = dialogView.findViewById<EditText>(R.id.update_text)
        txttodo.setText(prevText)

        val discardButton = dialogView.findViewById<Button>(R.id.discard_btn)
        val addButton = dialogView.findViewById<Button>(R.id.add_btn)

        builder.setView(dialogView)

        val alertDialog = builder.create()
        alertDialog.show()

        addButton.setOnClickListener {
            val updatedText = txttodo.text.toString()
                onTextUpdated(updatedText)
            alertDialog.dismiss()
        }

        discardButton.setOnClickListener {
            alertDialog.dismiss()
        }
    }
}

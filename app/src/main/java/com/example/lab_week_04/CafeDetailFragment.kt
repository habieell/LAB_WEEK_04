package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.LinearLayout

private const val TAB_CONTENT = "TAB_CONTENT"
private const val TAB_ITEMS = "TAB_ITEMS"

class CafeDetailFragment : Fragment() {
    private var content: String? = null
    private var items: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(TAB_CONTENT)
            items = it.getStringArrayList(TAB_ITEMS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.content_description)?.text = content

        val itemsContainer = view.findViewById<LinearLayout>(R.id.items_container)
        items?.forEach { item ->
            val textView = TextView(context)
            textView.text = item
            itemsContainer.addView(textView)
        }
    }

    companion object {
        fun newInstance(content: String, items: List<String>) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_CONTENT, content)
                    putStringArrayList(TAB_ITEMS, ArrayList(items))
                }
            }
    }
}
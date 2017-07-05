package com.expedia.simplehotels

import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.RadioButton
import android.widget.RadioGroup

import com.expedia.simplehotels.adapters.HotelListAdapter
import com.expedia.simplehotels.model.Destination
import com.expedia.simplehotels.service.HotelService
import com.expedia.simplehotels.viewModel.HotelListViewModel
import com.expedia.simplehotels.viewModel.HotelViewModel

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var viewModel: HotelListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = HotelService()
        viewModel = HotelListViewModel(service, this)

        viewModel.didSelectHotelCallback = { hotelViewModel ->
            val intent = Intent(this, HotelDetailActivity::class.java)
            intent.putExtra("viewModel", hotelViewModel)

            startActivity(intent)
        }

        val adapter = HotelListAdapter(viewModel)

        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.adapter = adapter

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = manager

        val radioGroup = findViewById(R.id.radio_group) as RadioGroup

        configureRadioGroup(radioGroup)
    }

    private fun configureRadioGroup(radioGroup: RadioGroup) {
        val viewId: Int

        if (viewModel.destination === Destination.SAN_FRANCISCO) {
            viewId = R.id.san_francisco_radio_button
        } else {
            viewId = R.id.chicago_radio_button
        }

        val button = radioGroup.findViewById(viewId) as RadioButton
        button.isChecked = true

        radioGroup.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(group: RadioGroup, @IdRes checkedId: Int) {
        if (checkedId == R.id.san_francisco_radio_button) {
            viewModel.destination = Destination.SAN_FRANCISCO
        } else {
            viewModel.destination = Destination.CHICAGO
        }
    }
}

package com.example.openchallenge.model.repository

import com.example.openchallenge.model.network.Client
import com.example.openchallenge.model.network.State
import com.example.openchallenge.model.response.HolidaysModel
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class HolidaysRepository {

    fun getHolidaysInfo(): Flow<State<HolidaysModel>> = flow {
        emit(State.Loading)
        emit(Client.requestHolidayData())
    }.flowOn(Dispatchers.IO)
}


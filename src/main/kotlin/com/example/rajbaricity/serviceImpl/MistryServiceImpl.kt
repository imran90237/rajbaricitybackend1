package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Mistry
import com.example.rajbaricity.service.MistryService
import org.springframework.stereotype.Service

@Service
class MistryServiceImpl : MistryService {

    private val mistrys = mutableListOf<Mistry>()
    private var idCounter = 1L

    override fun getAll(): List<Mistry> = mistrys

    override fun getById(id: Long): Mistry? = mistrys.find { it.hashCode().toLong() == id }

    override fun save(mistry: Mistry): Mistry {
        mistrys.add(mistry)
        return mistry
    }

    override fun update(id: Long, mistry: Mistry): Mistry? {
        val index = mistrys.indexOfFirst { it.hashCode().toLong() == id }
        return if (index != -1) {
            mistrys[index] = mistry
            mistry
        } else null
    }

    override fun delete(id: Long): Boolean {
        return mistrys.removeIf { it.hashCode().toLong() == id }
    }
}

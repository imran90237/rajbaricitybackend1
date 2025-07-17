package com.example.rajbaricity.serviceImpl
import com.example.rajbaricity.model.TrainInfo
import com.example.rajbaricity.repository.TrainInfoRepository
import com.example.rajbaricity.service.TrainInfoService
import org.springframework.stereotype.Service

@Service
class TrainInfoServiceImpl(
    private val trainInfoRepository: TrainInfoRepository
) : TrainInfoService {

    override fun getAllTrains(): List<TrainInfo> = trainInfoRepository.findAll()

    override fun getTrainById(id: Long): TrainInfo? =
        trainInfoRepository.findById(id).orElse(null)

    override fun saveTrain(trainInfo: TrainInfo): TrainInfo =
        trainInfoRepository.save(trainInfo)

    override fun updateTrain(id: Long, trainInfo: TrainInfo): TrainInfo? {
        return if (trainInfoRepository.existsById(id)) {
            trainInfoRepository.save(trainInfo.copy(id = id))
        } else null
    }

    override fun deleteTrain(id: Long): Boolean {
        return if (trainInfoRepository.existsById(id)) {
            trainInfoRepository.deleteById(id)
            true
        } else false
    }
}

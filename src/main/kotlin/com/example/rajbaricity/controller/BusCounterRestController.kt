package com.example.rajbaricity.controller
import com.example.rajbaricity.model.BusCounter
import com.example.rajbaricity.repository.BusCounterRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bus_counter")
class BusCounterRestController(private val repository: BusCounterRepository) {

    @GetMapping
    fun getAll(): List<BusCounter> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<BusCounter> {
        val counter = repository.findById(id)
        return if (counter.isPresent) ResponseEntity.ok(counter.get())
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun save(@RequestBody counter: BusCounter): BusCounter = repository.save(counter)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: BusCounter): ResponseEntity<BusCounter> {
        return if (repository.existsById(id)) {
            ResponseEntity.ok(repository.save(updated.copy(id = id)))
        } else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            ResponseEntity.noContent().build()
        } else ResponseEntity.notFound().build()
    }
}

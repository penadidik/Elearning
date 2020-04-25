package org.lintaspena.elearning.base

import org.lintaspena.elearning.component.Authenticate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import java.util.*

abstract class BaseService<Model : BaseModel> {

    @Autowired
    private lateinit var auth: Authenticate

    protected abstract val repo: JpaRepository<Model, Long>

    private fun insert(entity: Model): Model {
        entity.id = null
        entity.createdBy = auth.getUserId()
        entity.createdDate = Date()
        return repo.save(entity)
    }

    private fun update(entity: Model): Model {
        val dbData = repo.findByIdOrNull(entity.id)
                ?: throw Exception("[UPDATE PROCESS] but ID = ${entity.id} not found !!!")
        entity.createdBy = dbData.createdBy
        entity.createdDate = dbData.createdDate
        entity.updatedBy = auth.getUserId()
        entity.updatedDate = Date()
        return repo.save(entity)
    }

    fun saveDb(entity: Model): Model {
        return if (entity.id != null && entity.id!! > 0) {
            update(entity)
        } else {
            insert(entity)
        }
    }
}
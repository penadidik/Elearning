package org.lintaspena.elearning.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.*
import com.google.gson.stream.JsonReader
import com.mysql.cj.fabric.Response
import org.apache.logging.log4j.Logger
import org.lintaspena.elearning.component.Utils
import org.springframework.stereotype.Component
import org.springframework.ui.Model
import java.io.StringReader

@Component
abstract class BaseController {

    private var gson = Gson()

    private val mapper = ObjectMapper()

    open fun initControl() = ""

    open fun initControl(model: Model) = ""

    fun responseToString(response: Response): String {
        return mapper.writeValueAsString(response)
    }

    fun convertResponseToJson(str: String, key: String?): Any? {
        val reader = JsonReader(StringReader(str))
        reader.isLenient = true
        var data: JsonElement? = null
        if (key != null) {
            data = JsonParser().parse(reader).asJsonObject.get(key)
        } else {
            data = JsonParser().parse(reader).asJsonObject
        }
        return data
    }

    fun <T> convertResponseToModel(str: String, key: String?, clazz: Class<T>): T {
        val data: Any
        return if (key != null) {
            data = convertResponseToJson(str, key) as JsonElement
            gson.fromJson(data, clazz)
        } else {
            data = convertResponseToJson(str, key) as JsonObject
            gson.fromJson(data, clazz)
        }
    }

    fun <T> convertResponseToModel(str: String, clazz: Class<T>): T {
        return gson.fromJson(str, clazz)
    }

    fun log(throwable: Throwable, logger: Logger) {
        val log = Utils().getStackTrace(throwable)
        logger.error(log)
        throwable.printStackTrace()
    }

}
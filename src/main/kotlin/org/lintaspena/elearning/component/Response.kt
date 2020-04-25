package org.lintaspena.elearning.component

import java.io.Serializable

class Response : Serializable {

    var success: Boolean? = null

    var message: String? = null

    var code: Int? = null

}
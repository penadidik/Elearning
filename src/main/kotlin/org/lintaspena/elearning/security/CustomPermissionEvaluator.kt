package org.lintaspena.elearning.security

import org.springframework.security.access.PermissionEvaluator
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.io.Serializable

@Component
open class CustomPermissionEvaluator : PermissionEvaluator {

    override fun hasPermission(auth: Authentication?, p1: Any?, p2: Any?): Boolean {
        if (auth == null || p1 == null || p2 == null) return false
        return false
    }

    override fun hasPermission(auth: Authentication?, p1: Serializable?, p2: String?, p3: Any?): Boolean {
        return false
    }

}